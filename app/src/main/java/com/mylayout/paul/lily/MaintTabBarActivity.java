package com.mylayout.paul.lily;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by paul on 2017/2/21.
 */

public class MaintTabBarActivity extends BaseActivity {
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
        setSelectedTabbar();
        Log.e("hello ------------> ", "create .....................");
        Log.e("hello", "onCreate ~~~");
    }

    private void setSelectedTabbar() {
        final int[] tabs = {R.id.main_tab_home, R.id.main_tab_work, R.id.main_tab_find, R.id.main_tab_msg};
        for(int i = 0; i < tabs.length; i ++) {
            final int which = i;
            Log.e("hello ------------> ", String.valueOf(i));
            Toast.makeText(MaintTabBarActivity.this, "hello_____" + i, Toast.LENGTH_SHORT).show();
            findViewById(tabs[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentSelected = which;
                    for(int j = 0; j < tabs.length; j ++) {
                        ((ImageView)findViewById(tabbarIds[0][which])).setSelected(which == j);
                    }
                }
            });
        }
    }
}
