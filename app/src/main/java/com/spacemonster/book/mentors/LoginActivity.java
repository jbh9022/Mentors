package com.spacemonster.book.mentors;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spacemonster.book.mentors.Model.User;
import com.spacemonster.book.mentors.Network.Api;
import com.spacemonster.book.mentors.databinding.ActivityLoginBinding;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    String loginID;
    String loginPass;
    ArrayList<User> userArray = new ArrayList<>();
    String checkUserID;
    String checkUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //status bar 색상 녹색 변경
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            //status bar 색이 흰색일 경우 검은색으로 변경
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        Backbtn();
        LayoutClick();
        //체크시 데이터 불러오기
        binding.loginID.requestFocus();
        SharedPreferences pref = getSharedPreferences("loginSave", Activity.MODE_PRIVATE);
        String id = pref.getString("id_save","");
        Boolean chk1 = pref.getBoolean("chk_id", false);
        if(chk1 == true){
            binding.loginID.setText(id);
            binding.loginCheck1.setChecked(chk1);
        }

        //로그인 버튼
        login();
    }
    private void LayoutClick(){
        binding.loginParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(binding.loginID.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(binding.loginPass.getWindowToken(), 0);
            }
        });
    }
    private void Backbtn(){
        binding.loginBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("ID","");
                intent.putExtra("username", "");
                startActivity(intent);
                finish();
            }
        });
    }
    //뒤로가기 버튼
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("ID","");
        intent.putExtra("username", "");
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);

    }
    //종료시 아이디저장 체크시 아이디 저장
    public void onStop() {
        super.onStop();
        SharedPreferences pref = getSharedPreferences("loginSave", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id_save", binding.loginID.getText().toString());
        editor.putBoolean("chk_id", binding.loginCheck1.isChecked());
        editor.putString("pass_save", binding.loginPass.getText().toString());
        editor.putBoolean("chk_Save", binding.loginCheck2.isChecked());

        editor.commit();
    }


    private void login(){

        binding.loginLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginID = binding.loginID.getText().toString();
                loginPass = binding.loginPass.getText().toString();
                if(loginID.equals("") || loginID == null){
                    Toast.makeText(LoginActivity.this, "잘못된 입력입니다.",Toast.LENGTH_SHORT).show();
                }
                else {
                    loginUser();
                }
            }
        });
    }
    public void loginUser(){
        GetUser user = new GetUser();
        user.execute(loginID,loginPass);
    }
    public class GetUser extends AsyncTask<String, Void, User[]>{
        @Override
        protected User[] doInBackground(String... strings) {
            String id = strings[0];
            String pass = strings[1];
            String url = Api.CHECK_USER;
            RequestBody body = new FormBody.Builder()
                    .add("ID", id)
                    .add("PASSWORD", pass)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Request request =new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            try{
                Response response = client.newCall(request).execute();

                Gson gson = new Gson();
                JsonParser parser = new JsonParser();
                JsonElement rootObject = parser.parse(response.body().charStream()).getAsJsonObject().get("checkUser");

                User[] users = gson.fromJson(rootObject, User[].class);
                return  users;
            }catch (IOException e){
                Log.d("GetUser", e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(User[] users) {
            super.onPostExecute(users);
            if(users.length > 0){
                for(User user : users){
                    userArray.add(user);
                }
                binding.loginHidden1.setText(userArray.get(0).getUserName());
                binding.loginHidden2.setText(userArray.get(0).getUserCheck());
                userArray.clear();
            }
            else {
                binding.loginHidden1.setText("");
                binding.loginHidden2.setText("");
            }
            checkUserID = binding.loginHidden1.getText().toString();
            checkUser = binding.loginHidden2.getText().toString();
            if(checkUser.equals("일치") || checkUser == "일치"){
                Intent intent_main = new Intent(LoginActivity.this, UserInfoActivity.class);
                intent_main.putExtra("ID", checkUserID);
                intent_main.putExtra("username", checkUser);
                startActivity(intent_main);
                finish();
            }
            else {
                Toast.makeText(LoginActivity.this, "아이디, 비밀번호를 확인해주시기바랍니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
