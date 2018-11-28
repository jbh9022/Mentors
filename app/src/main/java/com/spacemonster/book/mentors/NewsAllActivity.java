package com.spacemonster.book.mentors;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.spacemonster.book.mentors.Adapter.NewsAll_Adapter;
import com.spacemonster.book.mentors.databinding.ActivityNewsAllBinding;

public class NewsAllActivity extends AppCompatActivity {

    private ActivityNewsAllBinding binding;
    private NewsAll_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_all);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_all);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ////satausbar의 색상 변경
            getWindow().setStatusBarColor(Color.WHITE);
            //satausbar의 색상이 흰색일 경우 글자 검은색으로
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        //뒤로가기 버튼
        HomeBtn();
        NewsReview();
    }
    private void HomeBtn(){
        binding.newsHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void NewsReview(){
        binding.newsReView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsAll_Adapter(NewsAllActivity.this);
        binding.newsReView.setAdapter(adapter);
    }
}
