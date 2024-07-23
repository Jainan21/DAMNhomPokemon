package com.example.duanmaunhompokemon;

import static com.example.duanmaunhompokemon.Adapter.HeaderAdapter.setupHeader;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.AuthorAdapter;
import com.example.duanmaunhompokemon.Adapter.BookAdapter;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Book;

import java.util.ArrayList;

public class BookView extends AppCompatActivity {
    View  hb;
    LinearLayout  hb_layout;
    ListView lv_Book_Famous;
    BookAdapter adpBook;
    AuthorAdapter adpAuthor;
    RecyclerView lv_Author_Famous;
    ArrayList <Account> listAuthor;
    ArrayList <Book> listBook;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);

        setupHeader(BookView.this);

        hb_layout = findViewById(R.id.hb_view);
        LayoutInflater inf2 = getLayoutInflater();
        hb = inf2.inflate(R.layout.hot_book, null);
        hb_layout.addView(hb);

        lv_Book_Famous = findViewById(R.id.lvBook_Famous);
        listBook = new ArrayList<>();
        Book a = new Book(1,1, "Lũ trẻ đường tàu", 1200, "23/10/2023", "Cuốn sách này là 1 cuốn sách rất bình thường", 45000);
        Book b = new Book(2,3, "Lũ trẻ đườg tàu", 1200, "22/10/2023", "Cuốn sách này là 1 cuốn0 sách rất bình thường", 400);
        Book c = new Book(3,4, "Lũ trẻ đường tu", 1000, "23/10/2024", "Cuốn sách3 này là 1 cuốn sách rất bình thường", 400);

        listBook.add(a);
        listBook.add(b);
        listBook.add(c);

        adpBook = new BookAdapter(this, listBook);
        lv_Book_Famous.setAdapter(adpBook);

        lv_Author_Famous = findViewById(R.id.lvAuthor_Famous);
        listAuthor = new ArrayList<>();
        listAuthor.add(new Account(1, "Tac gia 1", "123", "bl@gmail.com", 2, 100.2));
        listAuthor.add(new Account(2, "Tac gia 2", "123", "bl@gmail.com", 2, 100.2));
        listAuthor.add(new Account(3, "Tac gia 3", "123", "bl@gmail.com", 2, 100.2));

        adpAuthor = new AuthorAdapter(BookView.this, listAuthor);
        LinearLayoutManager lmanager = new LinearLayoutManager(BookView.this);
        lmanager.setOrientation(RecyclerView.HORIZONTAL);
        lv_Author_Famous.setLayoutManager(lmanager);
        lv_Author_Famous.setAdapter(adpAuthor);

        hb_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(BookView.this, bookdetails.class);
                startActivity(i);
                finish();
            }
        });

    }



}