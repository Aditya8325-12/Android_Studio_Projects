package com.example.gridlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class gridadapter extends BaseAdapter {

    Context con;
    private final int Image[];


    public gridadapter(int[] image, Context con) {
        this.Image = image;
        this.con = con;
    }

    @Override
    public int getCount() {
        return Image.length;
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater  li= (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vi =li.inflate(R.layout.singlelayout,null);

        ImageView img = (ImageView)vi.findViewById(R.id.imageiew);

        img.setImageResource(Image[i]);

        return vi;
    }

}