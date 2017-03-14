package com.mylayout.paul.lily;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mylayout.paul.lily.Adapter.ListViewAdapter;
import com.mylayout.paul.lily.Adapter.WorkListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2017/2/27.
 */

public class WorkFG extends Fragment {
    private ListView listView;
    protected WorkListAdapter listViewAdapter;
    private List<Map<String, Object>> listItems;
    private String[] titles = {
            "单价",
            "答交数量",
            "交期"
    };

    private String[] contents = {
            "￥2000.0/个",
            "999/个",
            "2017-04-20"};

    public static WorkFG createInstance() {
        return new WorkFG();
    }

    public List<Map<String, Object>>getListems() {
        List<Map<String, Object>>list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < titles.length; i ++) {
            Map<String, Object>map = new HashMap<String, Object>();
            map.put("title", titles[i]);
            map.put("content", contents[i]);
            list.add(map);
        }
        return list;
    }

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        listItems = getListems();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View header = (View)LayoutInflater.from(getActivity()).inflate(R.layout.work_list_head, null);
        View footer = (View)LayoutInflater.from(getActivity()).inflate(R.layout.work_list_foot, null);
        View v = inflater.inflate(R.layout.work_fg, null);
        listView = (ListView)v.findViewById(R.id.listBase);
        listView.addHeaderView(header);
        listView.addFooterView(footer);

        //先添加foot head才能设置适配器
        listViewAdapter = new WorkListAdapter(getActivity(), listItems);
        listView.setAdapter(listViewAdapter);
        return v;
    }
}
