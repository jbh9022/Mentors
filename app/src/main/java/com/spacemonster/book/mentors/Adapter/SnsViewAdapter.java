package com.spacemonster.book.mentors.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.spacemonster.book.mentors.R;

import java.util.ArrayList;

public class SnsViewAdapter extends RecyclerView.Adapter<SnsViewAdapter.ViewHolder> {
    Context context;
    String banner1 = "http://jbh9022.cafe24.com/img/banner03.jpg";
    String banner2 = "http://jbh9022.cafe24.com/img/banner02.jpg";
    ArrayList<Object> aa = new ArrayList<>();
    public SnsViewAdapter(Context context) {
        this.context = context;
        aa.add(banner1);
        aa.add(banner2);
        aa.add(banner1);
        aa.add(banner2);
        aa.add(banner1);
        aa.add(banner2);
        aa.add(banner1);
        aa.add(banner2);
        aa.add(banner1);
        aa.add(banner2);
        aa.add(banner1);
        aa.add(banner2);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_sns,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions options = new RequestOptions().fitCenter();
        Glide.with(context).load(aa.get(position)).apply(options).into(holder.img1);
        holder.img1.setScaleType(ImageView.ScaleType.FIT_XY);
        final int a = position+1;
        //이미지 클릭 -> SNS 연결
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "SNS!!!"+ a, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return aa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img1;
        public ViewHolder(View view) {
            super(view);
            img1 = (ImageView)view.findViewById(R.id.sns_Img);
        }
    }
}
