package com.mylayout.paul.lily.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.mylayout.paul.lily.R;

import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2017/3/10.
 */

public class WorkListAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> listItems;
    private LayoutInflater listContainer;
    public final class ListItemView {
        TextView tvTitle;
        EditText etContent;
        View line;
    }

    public WorkListAdapter(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        this.listItems = listItems;
        listContainer = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView listItemView = null;
        if (convertView == null) {
            listItemView = new ListItemView();
            convertView = listContainer.inflate(R.layout.work_list_item, null);
            listItemView.tvTitle = (TextView)convertView.findViewById(R.id.work_list_item_title);
            listItemView.etContent = (EditText)convertView.findViewById(R.id.work_list_item_edit);
//            listItemView.line = convertView.findViewById(R.id.work_list_item_line);
            convertView.setTag(listItemView);
        }
        else {
            listItemView = (ListItemView) convertView.getTag();
        }

        listItemView.tvTitle.setText(this.listItems.get(position).get("title").toString());
        listItemView.etContent.setText(this.listItems.get(position).get("content").toString());

        return convertView;
    }
}
