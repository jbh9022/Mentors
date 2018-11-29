package com.spacemonster.book.mentors.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.spacemonster.book.mentors.Model.Notice;
import com.spacemonster.book.mentors.NewsViewActivity;
import com.spacemonster.book.mentors.R;

import java.util.ArrayList;

public class NewsAll_Adapter extends RecyclerView.Adapter<NewsAll_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Notice> noticelist;

    public NewsAll_Adapter(Context context, ArrayList<Notice> noticelist) {
        this.context = context;
        this.noticelist = noticelist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_news,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        RequestOptions options = new RequestOptions().fitCenter();
        final Notice notice = noticelist.get(position);
        Glide.with(context).load(notice.getImg()).apply(options).into(holder.img);
        holder.img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        holder.text1.setText(notice.getNotice());
        holder.text2.setText(notice.getTitle());
        holder.text2.setSingleLine();
        holder.text2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        holder.text2.setSelected(true);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newsViewIntent = new Intent(context, NewsViewActivity.class);
                newsViewIntent.putExtra("News", notice.getWebAdd());
                context.startActivity(newsViewIntent);
//                Toast.makeText(context,"클릭!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return noticelist.size();
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
