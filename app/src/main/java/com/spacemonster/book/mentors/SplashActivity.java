package com.spacemonster.book.mentors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spacemonster.book.mentors.Model.User;
import com.spacemonster.book.mentors.Network.Api;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SplashActivity extends AppCompatActivity {
    ArrayList<User> userSp_List;
    TextView sp_text1;
    TextView sp_text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sp_text1 = (TextView)findViewById(R.id.splash_txt1);
        sp_text2 = (TextView)findViewById(R.id.splash_txt2);

        //네트워크 연결안되었을경우
        if(NetworkConnection() == false){
            NotConnected_showAlert();
        }
        else {
            Handler handler = new Handler();
            handler.postDelayed(new splashhandler(), 3000);
        }

    }
    private class splashhandler implements Runnable{
        private String id;
        private String pass;
        public void run(){
            SharedPreferences pref = getSharedPreferences("loginSave", MODE_PRIVATE);
            id =  pref.getString("id_save","");
            pass =  pref.getString("pass_save", "");
            boolean chk = pref.getBoolean("chk_Save",false);
            if (chk == true) {
                LoginSplash();
            }
            else {
                startActivity(new Intent(getApplication(), MainActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
                SplashActivity.this.finish(); // 로딩페이지 Activity stack에서 제거
            }
        }
        private void LoginSplash(){
            userSp_List = new ArrayList<>();
            Splashlogin splashlogin = new Splashlogin();
            splashlogin.execute(id, pass);
        }

    }

    public class Splashlogin extends AsyncTask<String, Void, User[]>{

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
                    userSp_List.add(user);
                }
                sp_text1.setText(userSp_List.get(0).getUserName());
                sp_text2.setText(userSp_List.get(0).getUserCheck());
                userSp_List.clear();
            }
            else {
                sp_text1.setText("");
                sp_text2.setText("");
            }
            String hidden_id = sp_text1.getText().toString();
            String hidden_User = sp_text2.getText().toString();
            if(hidden_User.equals("일치") || hidden_User == "일치"){
                Intent intent = new Intent(SplashActivity.this, UserInfoActivity.class);
                intent.putExtra("ID", hidden_id);
                intent.putExtra("username", hidden_User);
                startActivity(intent);
                finish();
            }
            else {
                startActivity(new Intent(getApplication(), MainActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
                SplashActivity.this.finish(); // 로딩페이지 Activity stack에서 제거
            }
        }
    }
    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }
    //네트워크 연결 상태확인
    private boolean NetworkConnection(){
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isMobileAvailable = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isAvailable();
        boolean isMobileConnect = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        boolean isWifiAvailable = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isAvailable();
        boolean isWifiConnect = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();

        if((isWifiAvailable && isWifiConnect) || (isMobileAvailable && isMobileConnect)){
            return true;
        }
        else {
            return false;
        }
    }

    //네트워크 연결 안될경우 다이얼로그 띄우기 -> 앱종료
    private void NotConnected_showAlert(){
     AlertDialog.Builder builder = new AlertDialog.Builder(this);
     builder.setTitle("네트워크 연결 오류");
     builder.setMessage("사용 가능한 무선네트워크가 없습니다.\n" + "먼저 무선네트워크 연결상태를 확인해 주세요")
             .setCancelable(false)
             .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                     finish();
                     android.os.Process.killProcess(android.os.Process.myPid());
                 }
             });
     AlertDialog alert = builder.create();
     alert.show();

    }

}
