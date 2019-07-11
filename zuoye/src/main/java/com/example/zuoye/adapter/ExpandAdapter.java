package com.example.zuoye.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.zuoye.R;
import com.example.zuoye.bean.ShiBean;

import java.util.ArrayList;

/**
 * Created by LENOVO on 2019/7/4.
 */

public class ExpandAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<ShiBean.BodyBean.ResultBean> groupList;
    private ArrayList<ShiBean.BodyBean.ResultBean.ChildrenBean> childList;

    public ExpandAdapter(Context context, ArrayList<ShiBean.BodyBean.ResultBean> groupList, ArrayList<ShiBean.BodyBean.ResultBean.ChildrenBean> childList) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view =View.inflate(context, R.layout.group_item,null);
        TextView name = view.findViewById(R.id.name);
        name.setText(groupList.get(groupPosition).getName());
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view =View.inflate(context, R.layout.child_item,null);
        TextView names = view.findViewById(R.id.names);
        names.setText(childList.get(childPosition).getName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
