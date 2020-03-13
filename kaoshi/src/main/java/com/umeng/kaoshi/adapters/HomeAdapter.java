package com.umeng.kaoshi.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.umeng.kaoshi.R;
import com.umeng.kaoshi.beans.Food;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    ArrayList<Food.DataBeanX> dataBeanXES;
    Context context;

    public HomeAdapter(ArrayList<Food.DataBeanX> dataBeanXES, Context context) {
        this.dataBeanXES = dataBeanXES;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(dataBeanXES.get(i).getData()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return dataBeanXES.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
        }
    }
}
