package com.example.user.animationdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.animationdemo.R;

/**
 * Created by user on 23/04/17.
 */

public class GridViewAdapter extends BaseAdapter {


    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public GridViewAdapter(Context mContext, String[] web, int[] imageid) {

        this.mContext = mContext;
        this.web = web;
        Imageid = imageid;

    }

    @Override
    public int getCount() {
        return web.length;
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

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        TextView textView;
        ImageView imageView;



        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);

        } else {
            grid = (View) convertView;
        }

        textView = (TextView) grid.findViewById(R.id.grid_text);
        imageView = (ImageView)grid.findViewById(R.id.grid_image);
        textView.setText(web[position]);
        imageView.setImageResource(Imageid[position]);
        return grid;

    }
}
