package com.spacemonster.book.mentors;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spacemonster.book.mentors.Adapter.NewsAdapter;
import com.spacemonster.book.mentors.Model.Notice;
import com.spacemonster.book.mentors.databinding.ActivityNewsViewBinding;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NewsViewActivity extends AppCompatActivity {
    private ActivityNewsViewBinding binding;
    String newAdd;
    private WebSettings settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ////satausbar의 색상 변경
            getWindow().setStatusBarColor(Color.WHITE);
            //satausbar의 색상이 흰색일 경우 글자 검은색으로
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        Intent intent = getIntent();
        newAdd = intent.getStringExtra("News");

        settings = binding.newsViewWeb.getSettings();

        binding.newsViewWeb.loadUrl(newAdd);
        binding.newsViewWeb.setWebViewClient(new NewsViewActivity.NoticeWebViewClient());
        Webset();

        backBtn();
    }
    private void backBtn(){
        binding.newsViewBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void Webset(){
        settings.setJavaScriptEnabled(true);

        binding.newsViewWeb.setHorizontalScrollBarEnabled(false);
        binding.newsViewWeb.setVerticalScrollBarEnabled(false);

        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(false);
        settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);

        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        binding.newsViewWeb.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
    }
    //같은뷰에서 화면전환(새로고침시)
    class  NoticeWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String request) {
//            return super.shouldOverrideUrlLoading(view, request);
            view.loadUrl(request);
            return true;
        }
    }

}
