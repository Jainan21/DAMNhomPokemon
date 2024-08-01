package com.example.duanmaunhompokemon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.R;

import java.util.List;

public class ListAuthorAdapter extends RecyclerView.Adapter<ListAuthorAdapter.ViewHolder> {
    private List<Account> data;
    private Context c;
    private ListAuthorAdapter.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public ListAuthorAdapter(Context c, List<Account> data) {
        this.c = c;
        this.data = data;
    }
    public void setOnItemClickListener(ListAuthorAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(c);
        View view = inflate.inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view, listener);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Account item = data.get(position);
        holder.itemText.setText(item.getUser());

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

        public ViewHolder(View itemView, final ListAuthorAdapter.OnItemClickListener listener) {
            super(itemView);
            itemText = itemView.findViewById(R.id.item_text);
            itemNumber = itemView.findViewById(R.id.item_number);
            itemImage = itemView.findViewById(R.id.item_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
