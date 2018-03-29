package com.example.ngumeniuk.newtest.zipFragment.widgets.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GridImageAdapter extends BaseAdapter {

    private Context context;
    private List<File> list = new ArrayList<>();

    public void setList(List<File> files){
        list.clear();
        list.addAll(files);
        notifyDataSetChanged();
    }

    public GridImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(130, 130));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        Glide.with(context).load(list.get(position))
                .into(imageView);

        return imageView;
    }
}
