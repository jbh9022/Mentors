package com.spacemonster.book.mentors;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spacemonster.book.mentors.databinding.ActivitySnsViewBinding;

public class SnsViewActivity extends AppCompatActivity {
    private ActivitySnsViewBinding binding;
    String snsUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns_view);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sns_view);

        Intent intent_SNS = getIntent();
        snsUrl = intent_SNS.getStringExtra("Url");

        binding.snsWebView.loadUrl(snsUrl);
    }
}
