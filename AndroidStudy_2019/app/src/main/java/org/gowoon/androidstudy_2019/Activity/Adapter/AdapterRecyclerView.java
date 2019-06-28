package org.gowoon.androidstudy_2019.Activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.gowoon.androidstudy_2019.R;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> data = new ArrayList<>();
    LayoutInflater inflater;
    public ItemClick itemClick;

    public AdapterRecyclerView(ArrayList<String> myData) {
        this.data.addAll(myData);
    }
    public AdapterRecyclerView(){}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_recyclerview_myproduct, parent, false);
        ListViewHolder holder = new ListViewHolder(view);

        return holder;
    }

    public interface ItemClick{
        public void onClick(View view, int position);
    }

    public void setItemClick(ItemClick itemClick){
        this.itemClick = itemClick;
    }


    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final String sdata = data.get(position);
        final ListViewHolder listholder = (ListViewHolder) holder;
        listholder.product_name.setText(sdata);
//        Glide.with(listholder.product_img).load(Config.serverUrl + "imgload/" + data.get(position).getProductImg().get(0)).into(listholder.product_img);

//        listholder.Rclayout.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//            //    Intent intent = new Intent(v.getContext(), ProductDetail.class);
//            //    v.getContext().startActivity(intent);
//
//            }
//        });
//        listholder.more_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Adapter_dialog_product_menu dialogProductMenu = new Adapter_dialog_product_menu(inflater.getContext(),sdata.getProductId());
//                dialogProductMenu.setProductName(listholder.product_name.getText().toString());
//                dialogProductMenu.show();
//            }
        }

    @Override
    public int getItemCount() {
        Log.d("리스트부유으ㅡ유", String.valueOf(data.size()));
        return data.size();
    }

    private static class ListViewHolder extends RecyclerView.ViewHolder {
        public TextView product_name;
        //        public ImageView product_img;
        //        public ViewGroup Rclayout;
//        public ImageView more_btn;
        public String productId;

        public ListViewHolder(View itemView) {
            super(itemView);
            product_name = (TextView) itemView.findViewById(R.id.tv_item_myproduct_name);
//            product_img = (ImageView) itemView.findViewById(R.id.iv_item_myproduct_image);
            //   Rclayout = (ViewGroup) itemView.findViewById(R.id.my_product_rv_item);
//            more_btn = itemView.findViewById(R.id.iv_item_myproduct_option);
        }
    }

    public void addItem(String Data) {
        data.add(Data);
    }
//    public ArrayList<String> mDataset = new ArrayList<>();
//
//
//    public AdapterRecyclerView(){
//
//    }
//    public AdapterRecyclerView(ArrayList<String> myData) {
//        this.mDataset = myData;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        public ImageView productimg;
//        public TextView name, price;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            name = itemView.findViewById(R.id.tv_item_myproduct_name);
//        }
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_recyclerview_myproduct,parent,false);
//        return new AdapterRecyclerView.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if (itemClick != null){
//                    itemClick.onClick(v,position);
//                }
//            }
//        });
//    }
//
//    public ItemClick itemClick;
//
//    public interface ItemClick{
//        void onClick(View view, int position);
//    }
//
//    public void setItemClick(AdapterRecyclerView.ItemClick itemClick){
//        this.itemClick = itemClick;
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDataset.size();
//    }

}