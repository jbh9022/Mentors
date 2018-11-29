package com.spacemonster.book.mentors.Fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spacemonster.book.mentors.Adapter.BannerAdapter;
import com.spacemonster.book.mentors.Adapter.NewsAdapter;
import com.spacemonster.book.mentors.Adapter.SnsViewAdapter;
import com.spacemonster.book.mentors.Model.Notice;
import com.spacemonster.book.mentors.NewsAllActivity;
import com.spacemonster.book.mentors.R;
import com.spacemonster.book.mentors.databinding.Fragment1Binding;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class FirstFragment extends Fragment {
    private Fragment1Binding binding;
    Timer timer;
    private NewsAdapter newsAdapter;
    private SnsViewAdapter snsAdapter;
    ArrayList<Notice> newsView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment1, container, false);

        AddDisplay();
        //배너
        BannerAdd();
        //dot 변화
        IndicatorChange();
        //멘토즈 소식 스피너
        NewsGet();
        //SNS
        SNSView();
        Allclick();
        return binding.getRoot();
    }
    //전체보기 클릭
    private void Allclick() {
        binding.freg1NewsAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent first_Intent = new Intent(getActivity(), NewsAllActivity.class);
                startActivity(first_Intent);
//                Toast.makeText(getContext(), "전체보기", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void AddDisplay(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new ImgTimer(), 10000, 10000);
    }

    private void BannerAdd(){
        BannerAdapter bannerAdapter = new BannerAdapter(getContext());
        binding.freg1Banner.setAdapter(bannerAdapter);

    }
    private void IndicatorChange() {
        //카운터 점 숫자
        binding.mainIndincatorView.setCount(2);
        binding.freg1Banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.mainIndincatorView.setSelected(binding.freg1Banner.getCurrentItem());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //SNS 리사이클러뷰
    private void SNSView(){
        binding.freg1SnsView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        snsAdapter = new SnsViewAdapter(getContext());
        binding.freg1SnsView.setAdapter(snsAdapter);
    }
    //타이머-배너 자동 전환
    public class ImgTimer extends TimerTask {

        @Override
        public void run() {
            if(getActivity() != null){
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("pager", String.valueOf(binding.freg1Banner.getCurrentItem() + 1));
                        binding.freg1Banner.setCurrentItem(binding.freg1Banner.getCurrentItem() + 1, true);
                    }
                });
            }
            else{
                return;
            }

        }
    }
    public void NewsGet(){
        newsView = new ArrayList<>();
        binding.freg1NewsView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        GetJsonNews getJsonNews = new GetJsonNews();
        getJsonNews.execute();
    }

    public class GetJsonNews extends AsyncTask<String, Void, Notice[]> {
        @Override
        protected Notice[] doInBackground(String... strings) {
            String url = Notice.URL;
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
                JsonElement rootObject = parser.parse(responses.body().charStream()).getAsJsonObject().get("newsVIew");

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
            if(notices.length > 0 ){
                for(Notice notice : notices){
                    newsView.add(notice);
                    newsAdapter = new NewsAdapter(getContext(), R.layout.review_notice, newsView);
                    binding.freg1NewsView.setAdapter(newsAdapter);
                    newsAdapter.notifyDataSetChanged();
                }

            }
        }
    }
}
