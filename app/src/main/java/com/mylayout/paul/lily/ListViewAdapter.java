package com.mylayout.paul.lily;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2017/2/8.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> listItems;
    private LayoutInflater listContainer;
    private boolean[] hasChecked;
    public final class ListItemView {
        public ImageView image;
        public TextView title;
        public TextView info;
        public CheckBox checkBox;
        public Button detail;
    }
    public ListViewAdapter(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItems = listItems;
        hasChecked = new boolean[getCount()];
    }

    public int getCount() {
        return listItems.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final int selectedId = position;
        ListItemView listItemView = null;
        if (convertView == null) {
            listItemView = new ListItemView();
            convertView = listContainer.inflate(R.layout.listitem, null);
            listItemView.image = (ImageView)convertView.findViewById(R.id.imageItem);
            listItemView.title = (TextView)convertView.findViewById(R.id.itemTitle);
            listItemView.info = (TextView)convertView.findViewById(R.id.itemInfo);
            listItemView.checkBox = (CheckBox)convertView.findViewById(R.id.checkItem);
            listItemView.detail = (Button)convertView.findViewById(R.id.detailButton);
            convertView.setTag(listItemView);
        }
        else  {
            listItemView = (ListItemView)convertView.getTag();
        }

        listItemView.image.setBackgroundResource((Integer)listItems.get(position).get("image"));
        listItemView.title.setText((String)listItems.get(position).get("title"));
        listItemView.info.setText((String)listItems.get(position).get("info"));
        listItemView.detail.setText("商品详情");
        listItemView.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetailAlert(selectedId);
            }
        });

        listItemView.checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkedChange(selectedId);
            }
        });

        return convertView;
    }

    /**
     * 点击详情弹出对话框
     */
    private void showDetailAlert(int clickId) {
        new AlertDialog.Builder(context)
                .setTitle("物品详情" + listItems.get(clickId).get("info"))
                .setMessage(listItems.get(clickId).get("detail").toString())
                .setPositiveButton("确定", null)
                .show();
    }

    /**
     *
     * @param checkedId
     */
    private boolean hasChecked(int checkedId) {
        return hasChecked[checkedId];
    }

    private void checkedChange(int checkedId) {
        hasChecked[checkedId] = !hasChecked[checkedId];
    }
}
