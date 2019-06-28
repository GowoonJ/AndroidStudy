package org.gowoon.androidstudy_2019.Activity.Activity;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.gowoon.androidstudy_2019.Activity.Adapter.AdapterRecyclerView;
import org.gowoon.androidstudy_2019.Activity.Fragment.SampleFragment;
import org.gowoon.androidstudy_2019.R;

import java.util.ArrayList;

public class Week3Java extends AppCompatActivity {
    RecyclerView recyclerView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3);

        listView = findViewById(R.id.list);
        String[] strings = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};

        ArrayAdapter lAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strings) ;
        listView.setAdapter(lAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),++i +"번째 아이템 클릭",Toast.LENGTH_LONG).show();
                final SampleFragment fragment = new SampleFragment();

                Bundle bundle = new Bundle();
                bundle.putString("key", String.format("%d번째 item 클릭", i));
                fragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.linearLayout,fragment).addToBackStack(null)
                        .commit();
            }
        });

        ArrayList arrayList = new ArrayList();
        recyclerView = findViewById(R.id.recycler);

        for (int i = 0 ; i<=20 ; i++){
            arrayList.add(i,"item"+i);
//            rAdapter.addItem("item"+i);
        }
        AdapterRecyclerView rAdapter = new AdapterRecyclerView(arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        rAdapter.setItemClick(new AdapterRecyclerView.ItemClick() {
            @Override
            public void onClick(View view, int position) {
//                final SampleFragment fragment = new SampleFragment();
//
//                Bundle bundle = new Bundle();
//                bundle.putString("key", String.format("%d번째 item 클릭", position));
//                fragment.setArguments(bundle);
//
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.linearLayout,fragment).addToBackStack(null)
//                        .commit();
            }
        });

        recyclerView.setAdapter(rAdapter);

    }
}
