package com.mylayout.paul.lily;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by paul on 2017/2/16.
 */

public class BaseActivity extends SwipeBackActivity {
    public TextView navTitle;
    public ImageView navBack;
    public ListView listView;
    private SwipeBackLayout mSwipeBackLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    public void navBackAction() {

    }

    public void setNavEvents() {
        LinearLayout titleBar = (LinearLayout)findViewById(R.id.title_bar);
        navBack = (ImageView)titleBar.findViewById(R.id.nav_back);
        navBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navBackAction();
            }
        });

        navTitle = (TextView)titleBar.findViewById(R.id.nav_title);
        listView = (ListView)findViewById(R.id.listBase);

//        mSwipeBackLayout = getSwipeBackLayout();
//        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }
}