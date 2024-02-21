package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6

    };
    public ImageAdapter(Context context,int[] images) {
        this.context = context;
        this.images = images;
    }
    @Override
    public int getCount() {
        return images.length;
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
        ImageView imgview;
        if(convertView == null) {
            imgview = new ImageView(context);
            imgview.setLayoutParams(new GridView.LayoutParams(350,350));
            imgview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else {
            imgview = (ImageView) convertView;
        }

        imgview.setImageResource(images[position]);
        return imgview;
    }
}
