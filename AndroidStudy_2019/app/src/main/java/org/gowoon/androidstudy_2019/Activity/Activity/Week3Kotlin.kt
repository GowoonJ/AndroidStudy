package org.gowoon.androidstudy_2019.Activity.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_week3.*
import org.gowoon.androidstudy_2019.Activity.Adapter.AdapterRecyclerView
import org.gowoon.androidstudy_2019.R
import java.util.ArrayList

class Week3Kotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week3)

        val strings = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","16","17","18","19","20")

        val lAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, strings)

        list.adapter = lAdapter
        list.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l -> Toast.makeText(applicationContext, i.toString() + "번째 아이템 클릭", Toast.LENGTH_LONG).show() }

        val rAdapter = AdapterRecyclerView()
        for (i in 0..20) {

            rAdapter.addItem("item$i")
        }
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.layoutManager = linearLayoutManager

        recycler.adapter = rAdapter

    }
}
