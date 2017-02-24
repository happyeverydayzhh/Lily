package com.mylayout.paul.lily;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by paul on 2017/2/21.
 */

public class MaintTabBarActivity extends BaseActivity {
    private TaskListFG taskListFG;
    private int currentSelected;
    private int[] tabBarNormalIcons = {
            R.mipmap.tabbar_tasks_normal,
            R.mipmap.tabbar_workbench_normal,
            R.mipmap.tabbar_faxian_off,
            R.mipmap.tabbar_messages_normal
    };
    private String[] tabBarSelectedIcons = {
            "tabbar_tasks_selected",
            "tabbar_workbench_selected",
            "tabbar_faxian_on",
            "tabbar_messages_selected"
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
        navBack.setVisibility(View.GONE);
        setSelectedTabbar(0);
        setListener();
    }

    private void setListener() {
        final int[] tabs = {R.id.main_tab_home, R.id.main_tab_work, R.id.main_tab_find, R.id.main_tab_msg};
        for(int i = 0; i < tabs.length; i ++) {
            final int which = i;
            Toast.makeText(MaintTabBarActivity.this, "hello_____" + i, Toast.LENGTH_SHORT).show();
            findViewById(tabs[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentSelected = which;
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
            if (position == j) {
                FragmentManager fgMgr = getSupportFragmentManager();
                taskListFG = (TaskListFG)fgMgr.findFragmentById(R.id.fgContainer);
                if (taskListFG == null) {
                    taskListFG = new TaskListFG();
                    fgMgr.beginTransaction().add(R.id.fgContainer, taskListFG).commit();
                }
            }
        }
    }
}
