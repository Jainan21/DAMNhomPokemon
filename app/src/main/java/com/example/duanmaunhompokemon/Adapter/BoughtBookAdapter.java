package com.example.duanmaunhompokemon.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.Model.Trade;
import com.example.duanmaunhompokemon.R;

import java.util.ArrayList;

public class BoughtBookAdapter extends RecyclerView.Adapter<BoughtBookAdapter.BoughtBookViewHolder> {

    private Context c;
    private ArrayList<Book> listBook;
    private OnItemClickListener listener;
    private dbDAO dao;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onReadNowClick(int position);
    }

    public BoughtBookAdapter(Context c, ArrayList<Book> listBook) {
        this.c = c;
        this.listBook = listBook;
        this.dao = new dbDAO(c);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BoughtBookAdapter.BoughtBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(c);
        View view = inflate.inflate(R.layout.recycle_item_bought_book, parent, false);
        return new BoughtBookAdapter.BoughtBookViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BoughtBookViewHolder holder, int position) {
        Book book = listBook.get(position);
        holder.tvNameBookBought.setText(book.getTitle());
        holder.tvAuthor1.setText(dao.getAuthorNameByBookId(book.getId_book()));
        holder.tvTheLoai1.setText(dao.getBookCategoryById(book.getId_book()));

        holder.btReadNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onReadNowClick(position);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public static class BoughtBookViewHolder extends RecyclerView.ViewHolder {
        TextView tvAuthor1, tvTheLoai1, tvNameBookBought;
        Button btReadNow;

        public BoughtBookViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvAuthor1 = itemView.findViewById(R.id.tvAuthor1);
            tvTheLoai1 = itemView.findViewById(R.id.tvTheLoai1);
            btReadNow = itemView.findViewById(R.id.btReadNow);
            tvNameBookBought = itemView.findViewById(R.id.tvNameBookBought);

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

