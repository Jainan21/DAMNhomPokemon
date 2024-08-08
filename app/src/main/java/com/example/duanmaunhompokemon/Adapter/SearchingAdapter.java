package com.example.duanmaunhompokemon.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.R;
import com.example.duanmaunhompokemon.SearchingView;
import com.example.duanmaunhompokemon.bookdetails;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SearchingAdapter extends RecyclerView.Adapter<SearchingAdapter.SearchingViewHolder> {

    private ArrayList<Book> listBook;
    private Context context;
    private OnItemClickListener listener;
    private dbDAO dao;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public SearchingAdapter(Context context, ArrayList<Book> listBook) {
        this.context = context;
        this.listBook = listBook;
        this.dao = new dbDAO(context);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SearchingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.booksearching, parent, false);
        return new SearchingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchingViewHolder holder, int i) {
        Book book = listBook.get(i);

        holder.txtAuthorName.setText(dao.getAuthorNameByBookId(book.getId_book()));
        holder.txtBookName.setText(book.getTitle());
        holder.imgBook.setImageResource(R.drawable.nhagiakim);
        DecimalFormat formater = new DecimalFormat("#,###,###");
        holder.txtPrice.setText(formater.format(book.getPrice())+" VND");
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public class SearchingViewHolder extends RecyclerView.ViewHolder {
        TextView txtBookName, txtAuthorName, txtPrice;
        ImageView imgBook;

        @SuppressLint("ResourceType")
        public SearchingViewHolder(View itemView) {
            super(itemView);
            txtAuthorName = itemView.findViewById(R.id.search_txtAuthorName);
            txtBookName = itemView.findViewById(R.id.search_txtBookName);
            imgBook = itemView.findViewById(R.id.search_imgBook);
            txtPrice = itemView.findViewById(R.id.search_txtPrice);
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