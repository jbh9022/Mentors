package com.spacemonster.book.mentors.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spacemonster.book.mentors.Model.Notice;
import com.spacemonster.book.mentors.NewsViewActivity;
import com.spacemonster.book.mentors.R;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    Context context;
    int layout;
    ArrayList<Notice> newsView = new ArrayList<Notice>();

    public NewsAdapter(Context context, int layout, ArrayList<Notice> newsView) {
        this.context = context;
        this.layout = layout;
        this.newsView = newsView;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_notice,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, final int position) {
        RequestOptions options = new RequestOptions().fitCenter();
        final Notice notice = newsView.get(position);
        Glide.with(context).load(notice.getImg()).apply(options).into(holder.imgview);
        holder.imgview.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.text1.setText(notice.getNotice());
        holder.text2.setText(notice.getTitle());
        final int a = position +1;
        //공지 클릭 -> 공지 내용
        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newsView = new Intent(context, NewsViewActivity.class);
                newsView.putExtra("News", notice.getWebAdd());
                context.startActivity(newsView);
//                Toast.makeText(context, "소식!!!" + a, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsView.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgview;
        TextView text1;
        TextView text2;

        public ViewHolder(View view) {
            super(view);
            imgview = (ImageView)view.findViewById(R.id.view_Img);
            text1 = (TextView) view.findViewById(R.id.view_Text1);
            text2 = (TextView) view.findViewById(R.id.view_Text2);
        }
    }


}
