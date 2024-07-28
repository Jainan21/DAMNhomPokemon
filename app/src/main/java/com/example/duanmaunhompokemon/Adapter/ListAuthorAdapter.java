package com.example.duanmaunhompokemon.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.R;

import java.util.List;

public class ListAuthorAdapter extends RecyclerView.Adapter<ListAuthorAdapter.ViewHolder> {
    private List<String> data;

    public ListAuthorAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = data.get(position);
        holder.itemText.setText(item);

        holder.itemNumber.setText(String.valueOf(position + 4));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemText;
        public TextView itemNumber;
        public ImageView itemImage;

        public ViewHolder(View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.item_text);
            itemNumber = itemView.findViewById(R.id.item_number);
            itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}
