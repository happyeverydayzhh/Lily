package com.mylayout.paul.lily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by paul on 2017/2/9.
 */

public class SecondActivity extends AppCompatActivity {
    private TextView tvDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);
        tvDetail = (TextView)findViewById(R.id.tvDetail);
        setDetail();
    }

    private void setDetail() {
        final Intent intent = getIntent();
        tvDetail.setText(intent.getStringExtra("mainKey"));
    }
}
