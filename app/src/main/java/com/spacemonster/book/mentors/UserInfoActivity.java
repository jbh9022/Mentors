package com.spacemonster.book.mentors;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //status bar 색상 녹색 변경
            getWindow().setStatusBarColor(getResources().getColor(R.color.mainColor));
            //status bar 색이 흰색일 경우 검은색으로 변경
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}
