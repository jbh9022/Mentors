package com.spacemonster.book.mentors.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.spacemonster.book.mentors.Dialog.CustomDialog_galleryView;
import com.spacemonster.book.mentors.Model.Sns;
import com.spacemonster.book.mentors.R;
import com.spacemonster.book.mentors.SnsViewActivity;

import java.util.ArrayList;

public class SnsViewAdapter extends RecyclerView.Adapter<SnsViewAdapter.ViewHolder> {
    Context context;
    String banner1 = "http://jbh9022.cafe24.com/img/banner03.jpg";
    String banner2 = "http://jbh9022.cafe24.com/img/banner02.jpg";
    ArrayList<Object> aa = new ArrayList<>();
    ArrayList<Sns> snsView;
    String imgurl;
    public SnsViewAdapter(Context context, ArrayList<Sns> snsView) {
        this.context = context;
        this.snsView = snsView;
        snsView = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_sns,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final Sns snsview = snsView.get(position);
        RequestOptions options = new RequestOptions().fitCenter();
        Glide.with(context).load(snsview.getSnsImg()).apply(options).into(holder.snsImg);

        holder.sns_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgurl = snsview.getSnsImg();
                CustomDialog_galleryView galleryView = new CustomDialog_galleryView(context , imgurl);

                galleryView.ViewDialog();
            }
        });
    }

    @Override
    public int getItemCount() {
        return snsView.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView snsImg;
        ConstraintLayout sns_Layout;
        public ViewHolder(View view) {
            super(view);
            snsImg = (ImageView) view.findViewById(R.id.sns_Img);
            sns_Layout = (ConstraintLayout)view.findViewById(R.id.sns_layout);
        }
    }
}
