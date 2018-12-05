package com.spacemonster.book.mentors.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.spacemonster.book.mentors.R;

import java.util.ArrayList;

public class Frag3_VpAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> frag3_Img;
    private LayoutInflater layoutInflater;

    public Frag3_VpAdapter(Context context, ArrayList<Integer> frag3_Img) {
        this.context = context;
        this.frag3_Img = frag3_Img;
    }

    @Override
    public int getCount() {
        return frag3_Img.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.frag3_img, null);
        ImageView img = (ImageView) view.findViewById(R.id.frag3_VpImgview);
        RequestOptions options = new RequestOptions().fitCenter();
        Glide.with(context).load(frag3_Img.get(position)).apply(options).into(img);
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);

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
