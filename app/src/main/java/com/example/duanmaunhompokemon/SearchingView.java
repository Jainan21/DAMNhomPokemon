package com.example.duanmaunhompokemon;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.SearchingAdapter;
import com.example.duanmaunhompokemon.Model.Book;

import java.util.ArrayList;

public class SearchingView extends Fragment {

    RecyclerView BookSearchingView;
    ArrayList<Book> listBook;
    ImageView home;
    BaseActivity base;
    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_searching_view, container, false);

//        base.setupActionBarAndBack(R.layout.activity_searching_view);

        BookSearchingView = v.findViewById(R.id.layout_searching);
        BookSearchingView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        BookSearchingView.setHasFixedSize(true);

        home = v.findViewById(R.id.iconHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), BookView.class);

            }
        });


        listBook = new ArrayList<>();
        listBook.add(new Book(1, "Chú chó ngậm giỏ hoa hồng", 150000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(1, "Mắt biếc", 130000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(1, "Chiến tranh tiền tệ", 200000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Mùa hè không tên", 170000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Cây cam ngọt của tôi", 110000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Bố con cá gai", 90000,"20/1/2021" , "abc", 20));

        SearchingAdapter adp = new SearchingAdapter(this, listBook);
        BookSearchingView.setAdapter(adp);

        return v;
    }
}