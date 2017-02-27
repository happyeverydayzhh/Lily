package com.mylayout.paul.lily;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2017/2/9.
 */

public class SecondActivity extends BaseActivity implements ListViewAdapter.ClickCallBack {
    private TextView tvDetail;
    private ListViewAdapter listViewAdapter;
    private List<Map<String, Object>> listItems;

    private Integer[] imageIds = {
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello,
            R.mipmap.hello
    };

    private String[] goodsNames = {
            "蛋糕",
            "礼物",
            "邮票",
            "爱心",
            "鼠标",
            "键盘",
            "显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器显示器",
            "鲜花",
            "玫瑰",
            "音乐CD",
            "笔记本",
            "自行车",
            "轮船",
            "轿车",
            "大巴",
            "飞机",
            "玫瑰",
            "音乐CD",
            "笔记本",
            "自行车",
            "轮船",
            "轿车",
            "大巴",
            "飞机"
    };

    private String[] goodsDetails = {
            "蛋糕: 好好吃",
            "礼物: 礼轻情意重",
            "邮票: 环游世界",
            "爱心: 世界都有爱",
            "鼠标: 反应敏捷",
            "音乐CD: 酷我音乐",
            "鲜花: 我爱玫瑰",
            "自行车: 我爱玫瑰",
            "蛋糕: 好好吃",
            "礼物: 礼轻情意重",
            "邮票: 环游世界",
            "爱心: 世界都有爱",
            "鼠标: 反应敏捷",
            "音乐CD: 酷我音乐",
            "鲜花: 我爱玫瑰",
            "自行车: 我爱玫瑰",
            "玫瑰",
            "音乐CD",
            "笔记本",
            "自行车",
            "轮船",
            "轿车",
            "大巴",
            "飞机"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);
        super.setNavEvents();
//        tvDetail = (TextView)findViewById(R.id.tvDetail);
//        setDetail();
        listItems = getListItems();
        Log.e("size = %ld", listItems.size() + "");
//        listView = (ListView) findViewById(R.id.list);
        listViewAdapter = new ListViewAdapter(this, listItems, this);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("~~~", "setOnItemClickListener click");
//                Map<String, Object> map = listItems.get(i);
//                Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
//                intent.putExtra("mainKey", map.get("info").toString());
//                startActivity(intent);
            }
        });
    }

    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < goodsNames.length; i ++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imageIds[i]);
            map.put("title", "物品名称");
            map.put("info", goodsNames[i]);
            map.put("detail", goodsDetails[i]);
            listItems.add(map);
        }
        return  listItems;
    }

    private void setDetail() {
        final Intent intent = getIntent();
        tvDetail.setText(intent.getStringExtra("mainKey"));
    }

    @Override
    public void navBackAction() {
        SecondActivity.this.finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_to_right);
    }


    @Override
    public void click(String string) {
        showDetailAlert(string);
    }

    /**
     * 点击详情弹出对话框
     */
    private void showDetailAlert(String string) {
        new CustomDialog
                .Builder(this)
                .setMessage(string)
                .setTitle("提示")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}
