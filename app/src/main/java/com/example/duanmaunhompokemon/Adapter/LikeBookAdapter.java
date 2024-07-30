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

public class LikeBookAdapter extends RecyclerView.Adapter<LikeBookAdapter.LikeBookViewHolder> {

    private Context c;
    private ArrayList<Book> listBook;
    private OnItemClickListener listener;
    private dbDAO dao;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
        void onBuyClick(int position);
    }

    public LikeBookAdapter(Context c, ArrayList<Book> listBook) {
        this.c = c;
        this.listBook = listBook;
        this.dao = new dbDAO(c);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public LikeBookAdapter.LikeBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(c);
        View view = inflate.inflate(R.layout.recycle_item_like_book, parent, false);
        return new LikeBookAdapter.LikeBookViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeBookViewHolder holder, int position) {
        Book book = listBook.get(position);
        holder.tvNameBook.setText(book.getTitle());
        holder.tvAuthor.setText(dao.getAuthorNameByBookId(book.getId_book()));
        holder.tvTheLoai.setText(dao.getBookCategoryById(book.getId_book()));

        holder.btBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onBuyClick(position);
                    }
                }
            }
        });

        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onDeleteClick(position);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public static class LikeBookViewHolder extends RecyclerView.ViewHolder {
        TextView tvAuthor, tvTheLoai, tvNameBook;
        Button btDelete, btBuy;

        public LikeBookViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvTheLoai = itemView.findViewById(R.id.tvTheLoai);
            btDelete = itemView.findViewById(R.id.btDelete);
            btBuy = itemView.findViewById(R.id.btBuyBook);
            tvNameBook = itemView.findViewById(R.id.tvNameBook);

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
