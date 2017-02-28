package com.mylayout.paul.lily;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2017/2/24.
 */

public class TaskListFG extends Fragment implements ListViewAdapter.ClickCallBack{
    protected ListView listView;
    protected ListViewAdapter listViewAdapter;
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

    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < goodsNames.length; i ++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageIds[i]);
            map.put("title", "物品名称");
            map.put("info", goodsNames[i]);
            map.put("detail", goodsDetails[i]);
            listItems.add(map);
        }
        return  listItems;
    }

    public static TaskListFG createInstance() {
        return new TaskListFG();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.task_list_fg, null);
        listView = (ListView)v.findViewById(R.id.listBase);
        listItems = getListItems();

        listViewAdapter = new ListViewAdapter(getActivity(), listItems, this);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("~~~", "setOnItemClickListener click");
                Map<String, Object> map = listItems.get(i);
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("mainKey", map.get("info").toString());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right, R.anim.hold);
            }
        });
        return v;
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
                .Builder(getActivity())
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
