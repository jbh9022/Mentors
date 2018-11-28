package com.spacemonster.book.mentors.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.spacemonster.book.mentors.R;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private int pos;
    private String banner1 = "http://jbh9022.cafe24.com/img/banner03.jpg";
    private String banner2 = "http://jbh9022.cafe24.com/img/banner02.jpg";
    private ArrayList<Object> arrayList = new ArrayList<>();
    public BannerAdapter(Context context) {
        this.context = context;
        arrayList.add(banner1);
        arrayList.add(banner2);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_banner, null);
        ImageView banner = (ImageView) view.findViewById(R.id.banner_img);
        RequestOptions options = new RequestOptions().fitCenter();

            Glide.with(context).load(arrayList.get(position)).apply(options).into(banner);
            banner.setScaleType(ImageView.ScaleType.FIT_XY);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);

        //배너 클릭시-웹뷰랑 연결 예정
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "배너 페이지", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
