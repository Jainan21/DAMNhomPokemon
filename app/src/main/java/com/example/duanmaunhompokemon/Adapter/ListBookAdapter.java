package com.example.duanmaunhompokemon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.BookViewHolder> {

    private ArrayList<Book> bookList;
    private dbDAO dao;
    private Context c;

    public ListBookAdapter(ArrayList<Book> bookList, Context c) {
        this.bookList = bookList;
        this.dao = new dbDAO(c);
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(dao.getAuthorNameByBookId(book.getId_book()));
        holder.bookPrice.setText(book.getPrice()+"");
        holder.bookImage.setImageResource(R.drawable.nhagiakim);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        public TextView bookTitle, bookAuthor, bookPrice;
        public ImageView bookImage;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.book_title);
            bookAuthor = itemView.findViewById(R.id.book_author);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookImage = itemView.findViewById(R.id.book_image);
        }
    }
}
