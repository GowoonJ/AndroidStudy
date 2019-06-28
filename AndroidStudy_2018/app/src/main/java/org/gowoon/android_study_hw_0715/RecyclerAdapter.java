package org.gowoon.android_study_hw_0715;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class ViewHolder extends RecyclerView.ViewHolder{
    TextView titleText, aurthorText;


    public ViewHolder(View itemView){
        super(itemView);
        titleText=itemView.findViewById(R.id.title_txt);
        aurthorText=itemView.findViewById(R.id.aurthorText);
    }

}

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private int resourceId;
    private List<RecyclerModel> dataList;

    public RecyclerAdapter(Context context,int resourceId,List<RecyclerModel>dataList){
        this.context=context;
        this.resourceId=resourceId;
        this.dataList=dataList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(resourceId,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclerModel recyclerModel = dataList.get(position);
        holder.titleText.setText(recyclerModel.getTitle());
        holder.aurthorText.setText(recyclerModel.getAurthor());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
