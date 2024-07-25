package com.example.duanmaunhompokemon;

import static com.example.duanmaunhompokemon.Adapter.HeaderAdapter.setupHeader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.AuthorAdapter;
import com.example.duanmaunhompokemon.Adapter.BookAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Book;
import com.google.android.material.navigation.NavigationView;

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
    Integer user_id;
    NavigationView nav_menu;
    LinearLayoutManager lmanager= new LinearLayoutManager(BookView.this);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);

        setupHeader(BookView.this);

        getUserID();

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

        lv_Book_Famous.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book selectedBook = listBook.get(position);
                dbDAO dao = new dbDAO(BookView.this);
                boolean check =  dao.hasTradeBook(user_id, selectedBook.getId_book());
                if(check){
                    Intent intent = new Intent(BookView.this, boughtbook.class);
                    intent.putExtra("id_book", selectedBook.getId_book());
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(BookView.this, bookdetails.class);
                    intent.putExtra("id_book", selectedBook.getId_book());
                    startActivity(intent);
                }
            }
        });

        lv_Author_Famous = findViewById(R.id.lvAuthor_Famous);
        listAuthor = new ArrayList<>();
        listAuthor.add(new Account(1, "Tac gia 1", "123", "bl@gmail.com", 2, 100.2));
        listAuthor.add(new Account(2, "Tac gia 2", "123", "bl@gmail.com", 2, 100.2));
        listAuthor.add(new Account(3, "Tac gia 3", "123", "bl@gmail.com", 2, 100.2));

        adpAuthor = new AuthorAdapter(BookView.this, listAuthor);
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

        nav_menu = findViewById(R.id.Nav_bar);
        nav_menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.item_home){
                    startActivity(new Intent(BookView.this, BookView.class));
                }
                if (item.getItemId()==R.id.item_account){
                    startActivity(new Intent(BookView.this, useractivity.class));
                }
                if (item.getItemId()==R.id.item_search){
                    startActivity(new Intent(BookView.this, SearchingView.class));
                }
                if (item.getItemId()==R.id.item_bookshelf){
                    startActivity(new Intent(BookView.this, BookView.class));
                }
                if (item.getItemId()==R.id.item_logout){
                    startActivity(new Intent(BookView.this, login.class));
                }return true;
            }

        });
    }

    public void getUserID(){
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }



}