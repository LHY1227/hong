package com.example.cela;

import android.content.Context;
import android.media.ImageReader;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class MyAdapter2 extends BaseAdapter {
    private Context context;
    private ArrayList<String> list;
    private ImageView iv;
    private TextView tv;

    public MyAdapter2(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
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

        convertView = View.inflate(context,R.layout.item,null);
//        iv = convertView.findViewById(R.id.miv);
        tv = convertView.findViewById(R.id.mtv);

//        ImageLoader instance = ImageLoader.getInstance();
//        instance.displayImage(list.get(position).toString(),iv);

        tv.setText(list.get(position).toString());

        return convertView;
    }
}
