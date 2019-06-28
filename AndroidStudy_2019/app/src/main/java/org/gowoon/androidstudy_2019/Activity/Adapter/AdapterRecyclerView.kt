package org.gowoon.androidstudy_2019.Activity.Adapter;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.gowoon.androidstudy_2019.R
import java.util.ArrayList

class AdaterRecyclerView : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = ArrayList<String>()
    internal var inflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View? = null

        inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = inflater!!.inflate(R.layout.item_recyclerview_myproduct, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sdata = data[position]
        val listholder = holder as ListViewHolder
        listholder.product_name.text = sdata
    }

    override fun getItemCount(): Int {
        Log.d("리스트부유으ㅡ유", data.size.toString())
        return data.size
    }

    private class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var product_name: TextView
        var productId: String? = null

        init {
            product_name = itemView.findViewById<View>(R.id.tv_item_myproduct_name) as TextView
        }
    }

    fun addItem(Data: String) {
        data.add(Data)
    }
}