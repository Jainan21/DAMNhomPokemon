package com.example.duanmaunhompokemon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.duanmaunhompokemon.Adapter.AuthorAdapter;
import com.example.duanmaunhompokemon.Adapter.BookAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Book;

import java.util.ArrayList;

public class BookView extends BaseActivity {
    View hb;
    LinearLayout  hb_layout;
    ListView lv_Book_Famous;
    BookAdapter adpBook;
    AuthorAdapter adpAuthor;
    RecyclerView lv_Author_Famous;
    ArrayList <Account> listAuthor;
    ArrayList <Book> listBook;
    dbDAO dao;
    Integer user_id;
    LinearLayoutManager lmanager= new LinearLayoutManager(BookView.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndDrawer(R.layout.activity_book_view);

        getUserID();
      
        lv_Book_Famous = findViewById(R.id.lvBook_Famous);
        lv_Author_Famous = findViewById(R.id.lvAuthor_Famous);
        dao= new dbDAO(BookView.this);

        listBook = dao.getBooksOrderedByBought();

        hb_layout = findViewById(R.id.hb_view);
        LayoutInflater inf2 = getLayoutInflater();
        hb = inf2.inflate(R.layout.hot_book, null);
        hb_layout.addView(hb);

        updateHotBook(listBook.get(0));

        adpBook = new BookAdapter(this, listBook);
        lv_Book_Famous.setAdapter(adpBook);

        lv_Book_Famous.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book selectedBook = listBook.get(position);
                boolean check = dao.hasTradeBook(user_id, selectedBook.getId_book());
                if (check) {
                    Intent intent = new Intent(BookView.this, boughtbook.class);
                    intent.putExtra("id_book", selectedBook.getId_book());
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(BookView.this, bookdetails.class);
                    intent.putExtra("id_book", selectedBook.getId_book());
                    startActivity(intent);
                }
            }
        });

        listAuthor = dao.getAuthorsSortedByBooksPurchased();

        adpAuthor = new AuthorAdapter(BookView.this, listAuthor);
        lmanager.setOrientation(RecyclerView.HORIZONTAL);
        lv_Author_Famous.setLayoutManager(lmanager);
        lv_Author_Famous.setAdapter(adpAuthor);

        hb_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book selectedBook = listBook.get(0);
                boolean check = dao.hasTradeBook(user_id, selectedBook.getId_book());
                if (check) {
                    Intent intent = new Intent(BookView.this, boughtbook.class);
                    intent.putExtra("id_book", selectedBook.getId_book());
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(BookView.this, bookdetails.class);
                    intent.putExtra("id_book", selectedBook.getId_book());
                    startActivity(intent);
                }
            }
        });
    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }

    private void updateHotBook(Book book) {
        TextView hb_txtTitle = hb.findViewById(R.id.hb_txtTitle);
        TextView hb_txtAuthor = hb.findViewById(R.id.hb_txtAuthor);
        TextView hb_txtContent = hb.findViewById(R.id.hb_txtContent);
        TextView hb_txtPrice = hb.findViewById(R.id.hb_txtPrice);
        TextView hb_txtRate = hb.findViewById(R.id.hb_txtRate);

        hb_txtTitle.setText(book.getTitle());
        hb_txtAuthor.setText("Tác giả: " + dao.getAuthorNameByBookId(book.getId_acc()));
        hb_txtContent.setText(book.getSum());
        hb_txtPrice.setText(book.getPrice() + " VND");
        hb_txtRate.setText("4.5/5");
    }
}