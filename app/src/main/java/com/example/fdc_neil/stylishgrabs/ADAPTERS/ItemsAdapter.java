package com.example.fdc_neil.stylishgrabs.ADAPTERS;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fdc_neil.stylishgrabs.MODELS.Items;
import com.example.fdc_neil.stylishgrabs.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private ArrayList<Items> items;
    private Context context;


    public ItemsAdapter(ArrayList<Items> items, Context context){
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lists, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Items item = items.get(position);
        Glide.with(context).load(item.getImage()).into(holder.imageView);
        holder.textView.setText(item.getImageTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public ItemViewHolder(View view){
            super(view);
                imageView = view.findViewById(R.id.ivItems);
                textView = view.findViewById(R.id.tvItemsTitle);
        }

    }



}
