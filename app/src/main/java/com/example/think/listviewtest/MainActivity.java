package com.example.think.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    List<DataType> datas=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        listview=(ListView)findViewById(R.id.listView);
        StringAdapter adapter=new StringAdapter(MainActivity.this,R.layout.child_title,datas);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DataType data=datas.get(i);
                Toast.makeText(MainActivity.this,"YOU CLICKED: "+data.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initData() {
        for(int i=0;i<30;++i) {
            DataType data=new DataType(""+i);
            datas.add(data);
        }
    }
}
