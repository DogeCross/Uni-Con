package com.example.mma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EquationAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Equation> equations;

    public EquationAdapter(Context context, ArrayList<Equation> equations) {
        this.context = context;
        this.equations = equations;
    }

    @Override
    public int getCount() {
        return equations.size();
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
        convertView  = layoutInflater.inflate(R.layout.list_item,null);
        TextView t = (TextView) convertView.findViewById(R.id.tv_type);
        TextView f = (TextView) convertView.findViewById(R.id.tv_form);
        t.setText(equations.get(position).getType());
        f.setText(equations.get(position).getForm());
        return convertView;
    }
}

