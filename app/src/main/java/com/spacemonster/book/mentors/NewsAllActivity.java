package com.spacemonster.book.mentors;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spacemonster.book.mentors.Adapter.NewsAll_Adapter;
import com.spacemonster.book.mentors.Model.Notice;
import com.spacemonster.book.mentors.Network.Api;
import com.spacemonster.book.mentors.databinding.ActivityNewsAllBinding;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NewsAllActivity extends AppCompatActivity {

    private ActivityNewsAllBinding binding;
    private NewsAll_Adapter adapter;
    private ArrayList<Notice> noticelist;
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
        noticelist = new ArrayList<>();
        binding.newsReView.setLayoutManager(new LinearLayoutManager(this));
        GetNewslist1 getNewslist1 = new GetNewslist1();
        getNewslist1.execute();
    }

    public class GetNewslist1 extends AsyncTask<String, Void, Notice[]> {

        @Override
        protected Notice[] doInBackground(String... strings) {
            String url = Api.NEWS_ALL;
            RequestBody formBody = new FormBody.Builder().build();

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            try {
                Response responses = client.newCall(request).execute();

                Gson gson = new Gson();
                JsonParser parser = new JsonParser();
                JsonElement rootObject = parser.parse(responses.body().charStream()).getAsJsonObject().get("newsViewALL");

                Notice[] posts = gson.fromJson(rootObject, Notice[].class);

                return posts;
            } catch (IOException e) {
                Log.d("FetchPostsTask", e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(Notice[] notices) {
            super.onPostExecute(notices);
            if(notices.length > 0 ) {
                for (Notice notice : notices) {
                    noticelist.add(notice);
                    adapter = new NewsAll_Adapter(NewsAllActivity.this, noticelist);
                    binding.newsReView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

}
