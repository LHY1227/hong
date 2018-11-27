package com.example.cela;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private DrawerLayout dly;
    String urlString = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private MyAdapter myAdapter;
    private ArrayList<String> list = new ArrayList<String>();
    private ImageView iv;
    private FrameLayout fly;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        iv = findViewById(R.id.iv);



       // myAdapter = new MyAdapter(MainActivity.this,list);
        lv.setAdapter(myAdapter);
        dly.addDrawerListener(new DrawerLayout.DrawerListener() {
           @Override
           public void onDrawerSlide(@NonNull View view, float v) {
           }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Toast.makeText(MainActivity.this, "侧拉已打开", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                Toast.makeText(MainActivity.this, "侧拉已关闭", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        //initData();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fly,MFragmet.getInstace(list.get(position))).commit();
                dly.closeDrawer(lv);
            }
        });

    }

    private void initData() {
        for (int i=0;i<10;i++){
            list.add("哈哈"+i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(arrayAdapter);
    }
}
