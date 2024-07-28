package com.example.duanmaunhompokemon.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.R;

import java.util.List;

public class ListAuthorAdapter extends RecyclerView.Adapter<ListAuthorAdapter.MyViewHolder> {
    private List<String> mData;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public MyViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.item_image);
            textView = v.findViewById(R.id.item_text);
        }
    }
    public ListAuthorAdapter(List<String> data) {
        mData = data;
    }
    @NonNull
    @Override
    public ListAuthorAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAuthorAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
