package com.example.hariswedira.vo2max;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Word> listItem;
    private int mColorResId;

    public MyAdapter(Context context, ArrayList<Word> listItem, int colorResId) {
        this.context = context;
        this.listItem = listItem;
        this.mColorResId = colorResId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,parent,false);
        v.setBackgroundColor(ResourcesCompat.getColor(context.getResources(),mColorResId,context.getTheme()));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word data = listItem.get(position);
        holder.defaultMiwok.setText(data.getMiwokWord());
        holder.defaultWord.setText(data.getDefaultWord());
        if(data.hasImage()) {
            holder.imageView.setVisibility(View.VISIBLE);
            holder.imageView.setImageResource(data.getImageResId());
        }else{
            holder.imageView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView defaultMiwok;
        final TextView defaultWord;
        final ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            defaultMiwok = (TextView) itemView.findViewById(R.id.tv_judul);
            defaultWord = (TextView) itemView.findViewById(R.id.tv_sub);
            imageView = (ImageView) itemView.findViewById(R.id.iv_gbr);
        }
    }
}
