package com.ksbk.listview_pro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ExampleActivity extends AppCompatActivity {
    ListView listView;
    ClassifyAdapter adapter;
    ArrayList<AbstractItem> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        listView= (ListView) findViewById(R.id.listview);
        list = new ArrayList<AbstractItem>();
        list.add(new TextItem("aaa"));
        list.add(new TextItem("1332fd"));
        list.add(new TextItem("测试"));
        list.add(new TextItem("看看"));
        list.add(new TextItem("te"));
        list.add(new TextItem("不"));
        list.add(new TextItem("德尔"));
        list.add(new TextItem("差"));
        adapter=new ClassifyAdapter(list,this);
        listView.setAdapter(adapter);
    }
}
