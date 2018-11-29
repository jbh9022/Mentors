package com.spacemonster.book.mentors.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.spacemonster.book.mentors.MainActivity;
import com.spacemonster.book.mentors.R;

public class CustomDialog_Finish {
    private Context context;

    public CustomDialog_Finish(Context context) {
        this.context = context;
    }
    public void CallDialog(){
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.custom_finish);

        dlg.show();

        LinearLayout okbtn = (LinearLayout) dlg.findViewById(R.id.finish_ok);
        LinearLayout cancelbtn = (LinearLayout) dlg.findViewById(R.id.finish_cancel);

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)MainActivity.main;
                mainActivity.finish();
                dlg.dismiss();
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });
    }
}
