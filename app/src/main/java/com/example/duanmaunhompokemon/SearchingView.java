package com.example.duanmaunhompokemon;

import static com.example.duanmaunhompokemon.Adapter.HeaderAdapter.setupHeader2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.SearchingAdapter;
import com.example.duanmaunhompokemon.Model.Book;

import java.util.ArrayList;

public class SearchingView extends AppCompatActivity {

    RecyclerView BookSearchingView;
    ArrayList<Book> listBook;
    SearchingAdapter adpSearching;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching_view);

        setupHeader2(SearchingView.this, "Tìm kiếm");


        BookSearchingView = findViewById(R.id.layout_searching);
        BookSearchingView.setLayoutManager(new GridLayoutManager(this, 2));
        BookSearchingView.setHasFixedSize(true);


        listBook = new ArrayList<>();
        listBook.add(new Book(1, "Chú chó ngậm giỏ hoa hồng", 150000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(1, "Mắt biếc", 130000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(1, "Chiến tranh tiền tệ", 200000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Mùa hè không tên", 170000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Cây cam ngọt của tôi", 110000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Bố con cá gai", 90000,"20/1/2021" , "abc", 20));

        adpSearching = new SearchingAdapter(this, listBook);
        BookSearchingView.setAdapter(adpSearching);
    }
}