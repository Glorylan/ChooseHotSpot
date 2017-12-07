package com.woker.choosehotspot.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.woker.choosehotspot.R;
import com.woker.choosehotspot.activity.model.ResonsibleModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanderer on 2016/12/20.
 * 城市选择适配器
 */

public class CityListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<ResonsibleModel.DataBean> cityModels;
    private List<ResonsibleModel.DataBean> hotData = new ArrayList<>();

    public CityListAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void setModels(List<ResonsibleModel.DataBean> cityModels) {
        this.cityModels = cityModels;
        for (ResonsibleModel.DataBean data : cityModels) {
            hotData.add(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return cityModels == null ? 0 : hotData.size();
    }

    @Override
    public ResonsibleModel.DataBean getItem(int position) {
        return hotData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityListAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new CityListAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.gridview_item_city, null);
            viewHolder.tvCity = (TextView) convertView.findViewById(R.id.tv_city);
            convertView.setTag(viewHolder);
        } else viewHolder = (CityListAdapter.ViewHolder) convertView.getTag();
        final ResonsibleModel.DataBean orderModel = getItem(position);

        viewHolder.tvCity.setText(orderModel.getName());

        return convertView;
    }

    class ViewHolder {
        private TextView tvCity;
    }
}
