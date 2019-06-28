package org.gowoon.android_study_hw_0715;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class recyclerview_practice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_practice);

        String[] list = {"리스트 1", "2","3","4","5","6","7","8","9","10","11","12","13","14"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        // context 는 뷰 관련
        //텍스트로만 이루어진 리스트 형식임을 알려줌
        //ctrl + B 누르면 정의된 곳으로 이동
        ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(adapter);

        RecyclerView rcv = (RecyclerView)findViewById(R.id.recyclerview);

    }
}
