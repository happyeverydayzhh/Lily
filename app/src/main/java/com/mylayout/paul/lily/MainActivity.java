package com.mylayout.paul.lily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lily";
    private ListView lv;
    private Button buttonDetail;

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
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate ~~~");
        listItems = getListItems();
        lv = (ListView) findViewById(R.id.list);
        listViewAdapter = new ListViewAdapter(this, listItems);
        lv.setAdapter(listViewAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("~~~", "setOnItemClickListener click");
                Map<String, Object> map = listItems.get(i);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("mainKey", map.get("info").toString());
                startActivity(intent);
            }
        });

//        buttonDetail = (Button)findViewById(R.id.button);
//        buttonDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("~~~", "detailButton click");
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("mainKey", "我是MainActivity传过来的值!");
//                startActivity(intent);
//            }
//        });
    }

    private List<Map<String, Object>>getListItems() {
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart ~~~");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume ~~~");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause ~~~");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop ~~~");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy ~~~");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart ~~~");
    }
}