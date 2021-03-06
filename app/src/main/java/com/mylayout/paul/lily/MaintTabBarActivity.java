package com.mylayout.paul.lily;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mylayout.paul.lily.utils.StateBarTranslucentUtils;

/**
 * Created by paul on 2017/2/21.
 */

public class MaintTabBarActivity extends BaseActivity {
    private TaskListFG taskListFG;
    protected FragmentManager fgMgr = null;
    private int currentSelected;
    protected Fragment[] fragments;
    private int[] tabBarNormalIcons = {
            R.mipmap.tabbar_tasks_normal,
            R.mipmap.tabbar_workbench_normal,
            R.mipmap.tabbar_faxian_off,
            R.mipmap.tabbar_messages_normal
    };
    private int[][] tabbarIds = {
        {R.id.main_tab_home_img, R.id.main_tab_work_img, R.id.main_tab_find_img, R.id.main_tab_msg_img},
        {R.id.main_tab_home_txt, R.id.main_tab_work_txt, R.id.main_tab_find_txt, R.id.main_tab_msg_txt},
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_bar);
        super.setNavEvents();
        setSwipeBackEnable(false);
        fragments = new Fragment[4];
        fgMgr = getSupportFragmentManager();
        navBack.setVisibility(View.GONE);
        setSelectedTabbar(0);
        setListener();
        StateBarTranslucentUtils.setStateBarTranslucent(this);
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //将擦边栏延伸至status bar
            drawer.setFitsSystemWindows(true);
            //将主页顶部延伸至status bar, 虽然为false，但经测试，DrawerLayout需显示设置
            drawer.setClipToPadding(false);
        }
    }

    private void setListener() {
        final int[] tabs = {R.id.main_tab_home, R.id.main_tab_work, R.id.main_tab_find, R.id.main_tab_msg};
        for(int i = 0; i < tabs.length; i ++) {
            final int which = i;
            findViewById(tabs[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelectedTabbar(which);
                }
            });
        }
    }

    private void setSelectedTabbar(int position) {

        for(int j = 0; j < tabbarIds[0].length; j ++) {
            ImageView ivTabs = (ImageView)findViewById(tabbarIds[0][j]);
            ivTabs.setSelected(position == j);
            TextView tvTabs = (TextView)findViewById(tabbarIds[1][j]);
            tvTabs.setSelected(position == j);
        }

        setNavTitle(position);

        if (position == currentSelected) {
            if (fragments[position] != null && fragments[position].isVisible()) {
                return;
            }
        }

        if (fragments[position] == null) {
            fragments[position] = getFragments(position);
        }

        FragmentTransaction fgTransation = fgMgr.beginTransaction();
        fgTransation.hide(fragments[currentSelected]);
        if (fragments[position].isAdded() == false) {
            fgTransation.add(R.id.fgContainer, fragments[position]);
        }
        fgTransation.show(fragments[position]).commit();

        this.currentSelected = position;
    }

    public Fragment getFragments(int position) {
        switch (position) {
            case 0:
                return TaskListFG.createInstance();

            case 1:
                return WorkFG.createInstance();

            case 2:
                return FindFG.createInstance();

            case 3:
                return MessageFG.createInstance();

            default:
                return null;
        }
    }

    public void setNavTitle(int position) {
        String title = "";
        if (position == 0) {
            title = "待办";
        }
        else if (position == 1) {
            title = "工作台";
        }
        else if (position == 2) {
            title = "发现";
        }
        else if (position == 3) {
            title = "消息";
        }
        navTitle.setText(title);
    }
}
