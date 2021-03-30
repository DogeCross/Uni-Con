package com.example.mma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class gridAdapter extends BaseAdapter {
    private String name[];
    private int icon[];
    Context context;

    public gridAdapter(String[] name, int[] icon, Context context) {
        this.name = name;
        this.icon = icon;
        this.context = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView  = layoutInflater.inflate(R.layout.card_layout,null);
        ImageView img = (ImageView) convertView.findViewById(R.id.img_icon);
        TextView type = (TextView) convertView.findViewById(R.id.tv_type);
        img.setImageResource(icon[position]);
        type.setText(name[position]);

        return convertView;
    }
}
