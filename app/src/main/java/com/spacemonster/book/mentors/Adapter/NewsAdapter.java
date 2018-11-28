package com.spacemonster.book.mentors.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.spacemonster.book.mentors.Model.Notice;
import com.spacemonster.book.mentors.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    Context context;
    int layout;

    ArrayList<Notice> notices = new ArrayList<Notice>();
    String a = "공지~~~~~~~~~~~~";
    String banner1 = "http://jbh9022.cafe24.com/img/banner03.jpg";
    String banner2 = "http://jbh9022.cafe24.com/img/banner02.jpg";
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<Object> list2 = new ArrayList<>();

    public NewsAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
        list1.add("공지1~~~~~~~~");
        list1.add("공지2~~~~~~~~");
        list1.add("공지3~~~~~~~~");
        list1.add("공지4~~~~~~~~");
        list2.add(banner1);
        list2.add(banner2);
        list2.add(banner1);
        list2.add(banner2);
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
        Glide.with(context).load(list2.get(position)).apply(options).into(holder.imgview);
        holder.imgview.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.text1.setText(list1.get(position));
        final int a = position +1;
        //공지 클릭 -> 공지 내용
        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "소식!!!" + a, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgview;
        TextView text1;

        public ViewHolder(View view) {
            super(view);
            imgview = (ImageView)view.findViewById(R.id.view_Img);
            text1 = (TextView) view.findViewById(R.id.view_Text2);
        }
    }
}
