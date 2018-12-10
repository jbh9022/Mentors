package com.spacemonster.book.mentors.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.spacemonster.book.mentors.R;

public class CustomDialog_GeojeSeatIMG {
    private Context context;
    private int color;

    public CustomDialog_GeojeSeatIMG(Context context, int color) {
        this.context = context;
        this.color = color;
    }

    public void CallDialog(){
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.busan_geoje_dialog);
        dlg.show();
        ImageView backBtn = dlg.findViewById(R.id.geoje_Dialog_cancle);
        ImageView img = dlg.findViewById(R.id.geoje_Dialog_Img);
        img.setImageResource(color);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });
    }
}
