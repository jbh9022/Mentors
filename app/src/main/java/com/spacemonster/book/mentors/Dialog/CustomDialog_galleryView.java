package com.spacemonster.book.mentors.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.spacemonster.book.mentors.R;

public class CustomDialog_galleryView {
    private Context context;
    private String imgurl;

    public CustomDialog_galleryView(Context context, String imgurl) {
        this.context = context;
        this.imgurl = imgurl;
    }

    public void ViewDialog(){
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.custom_galleryview);
        dlg.show();
        ImageView cancelbtn = (ImageView) dlg.findViewById(R.id.gallery_back);
        ImageView gallery = (ImageView) dlg.findViewById(R.id.gallery_Img);
        RequestOptions options = new RequestOptions().fitCenter();
        Glide.with(context).load(imgurl).apply(options).into(gallery);
        gallery.setScaleType(ImageView.ScaleType.FIT_XY);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });
    }
}
