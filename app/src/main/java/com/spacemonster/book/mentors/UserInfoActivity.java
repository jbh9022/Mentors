package com.spacemonster.book.mentors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.spacemonster.book.mentors.ChangeSeat.Change_Busan_Geoje_Activity;
import com.spacemonster.book.mentors.databinding.ActivityUserInfoBinding;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class UserInfoActivity extends AppCompatActivity {
    private ActivityUserInfoBinding binding;
    String id;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //status bar 색상 녹색 변경
            getWindow().setStatusBarColor(getResources().getColor(R.color.mainColor));
            //status bar 색이 흰색일 경우 검은색으로 변경
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        username = intent.getStringExtra("username");
        binding.testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(binding.testimg.getVisibility() == VISIBLE){
                binding.testimg.setVisibility(INVISIBLE);
            }
            else {
                binding.testimg.setVisibility(VISIBLE);
            }

            }
        });
//        binding.userName2.setText(username);
        //홈버튼
        Backbtn();
        //로그아웃
        Logout();
        //좌석 변경
        SeatChange();
        //외출
        Outting();
        //복귀
        Comback();
        //퇴실
        Checkout();
    }
    //외출
    private void Outting() {
        binding.userOutting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.userNow.setText("외출");

            }
        });
    }
    //복귀
    private void Comback() {
        binding.userComback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.userNow.setText("입실");

            }
        });
    }
    //퇴실
    private void Checkout(){
        binding.userCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.userNow.setText("퇴실");

            }
        });
    }

    private void Backbtn(){
        binding.userBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfoActivity.this, MainActivity.class);
                intent.putExtra("ID", id);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        });
    }
    private void Logout(){
        binding.userLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("loginSave", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("pass_save");
                editor.remove("chk_Save");
                editor.commit();
                Intent intent = new Intent(UserInfoActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
//뒤로가기 버튼
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(UserInfoActivity.this, MainActivity.class);
        intent.putExtra("ID", id);
        intent.putExtra("username", username);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }
    private void SeatChange(){
        binding.userSeatChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfoActivity.this, Change_Busan_Geoje_Activity.class);
                startActivity(intent);
//                Toast.makeText(UserInfoActivity.this,"좌석변경", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
