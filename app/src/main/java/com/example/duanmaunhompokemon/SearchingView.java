package com.example.duanmaunhompokemon;

import static com.example.duanmaunhompokemon.Adapter.HeaderAdapter.setupHeader2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.AuthorAdapter;
import com.example.duanmaunhompokemon.Adapter.SearchingAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Book;

import java.util.ArrayList;

public class SearchingView extends BaseActivity {

    EditText txtTitle;
    RecyclerView BookSearchingView;
    ArrayList<Book> listBook;
    SearchingAdapter adpSearching;
    Integer user_id;
    ImageView btnSearch;
    dbDAO dao;
    @SuppressLint("WrongViewCast")

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.activity_searching_view, "Tìm kiếm");


        btnSearch = findViewById(R.id.btnSearch);
        txtTitle = findViewById(R.id.search_txtTitle);

        BookSearchingView = findViewById(R.id.layout_searching);
        BookSearchingView.setLayoutManager(new GridLayoutManager(this, 2));
        BookSearchingView.setHasFixedSize(true);

        dao = new dbDAO(SearchingView.this);
        listBook = new ArrayList<>();
        listBook = dao.getBooksOrderedByBought();
        adpSearching = new SearchingAdapter(this, listBook);
        BookSearchingView.setAdapter(adpSearching);
        getUserID();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBook = new ArrayList<>();
                listBook = dao.searchBookByTitle(txtTitle.getText().toString());
                if (listBook.isEmpty()) {
                    Toast.makeText(SearchingView.this, "Không có sách cần tìm", Toast.LENGTH_SHORT).show();
                } else {
                    adpSearching = new SearchingAdapter(SearchingView.this, listBook);
                    BookSearchingView.setAdapter(adpSearching);
                }
            }
        });

        adpSearching.setOnItemClickListener(new SearchingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Book selectedBook = listBook.get(position);
                boolean check = dao.hasTradeBook(user_id, selectedBook.getId_book());
                if (check) {
                    Intent intent = new Intent(SearchingView.this, boughtbook.class);
                    intent.putExtra("id_book", selectedBook.getId_book());
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SearchingView.this, bookdetails.class);
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

    public boolean onSupportNavigateUp() {
        // Handle the toolbar back button click event
        Intent intent = new Intent(SearchingView.this, BookView.class);
        startActivity(intent);
        finish();
        return true;
    }

}