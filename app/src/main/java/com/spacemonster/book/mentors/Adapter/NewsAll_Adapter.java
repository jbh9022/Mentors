package com.spacemonster.book.mentors.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.spacemonster.book.mentors.R;

import java.util.ArrayList;

public class NewsAll_Adapter extends RecyclerView.Adapter<NewsAll_Adapter.ViewHolder> {
    private Context context;
    String a = "공지~~~~~~~~~~~~";
    String banner1 = "http://jbh9022.cafe24.com/img/banner03.jpg";
    String banner2 = "http://jbh9022.cafe24.com/img/banner02.jpg";
    ArrayList<String> text2add = new ArrayList<>();
    ArrayList<Object> bannradd = new ArrayList<>();

    public NewsAll_Adapter(Context context) {
        this.context = context;
        text2add.add(a);
        bannradd.add(banner1);
        text2add.add("공지사항입니다.~~~~~~~~~");
        bannradd.add(banner2);
        text2add.add("공지사항입니다.~~~~~~~~~");
        bannradd.add(banner1);
        text2add.add("공지사항입니다.~~~~~~~~~");
        bannradd.add(banner2);
        text2add.add("공지사항입니다.~~~~~~~~~");
        bannradd.add(banner1);
        text2add.add("공지사항입니다.~~~~~~~~~");
        bannradd.add(banner2);
        text2add.add("공지사항입니다.~~~~~~~~~");
        bannradd.add(banner1);
        text2add.add("공지사항입니다.~~~~~~~~~");
        bannradd.add(banner2);
        text2add.add("공지사항입니다.~~~~~~~~~");
        bannradd.add(banner1);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_news,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions options = new RequestOptions().fitCenter();
        Glide.with(context).load(bannradd.get(position)).apply(options).into(holder.img);
        holder.img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        holder.text2.setText(text2add.get(position));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"클릭!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bannradd.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView text1;
        TextView text2;
        ConstraintLayout layout;
        public ViewHolder(View view) {
            super(view);
            //이미지
            img = (ImageView)view.findViewById(R.id.news_ReImg);
            //공지사항
            text1 = (TextView)view.findViewById(R.id.news_ReTxt1);
            //글제목
            text2 = (TextView)view.findViewById(R.id.news_ReTxt2);
            //레이아웃
            layout = (ConstraintLayout)view.findViewById(R.id.news_Relayout);
        }
    }
}
