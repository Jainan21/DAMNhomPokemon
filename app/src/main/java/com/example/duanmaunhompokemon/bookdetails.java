package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Book;

public class bookdetails extends BaseActivity {

    Button btBefore, btMenu, btLike, btByBook;
    dbDAO dao = new dbDAO(bookdetails.this);
    Integer user_id;
    Integer book_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.bookdetails);

        btBefore = findViewById(R.id.btnBefore);
        btMenu = findViewById(R.id.btnMenu);
        btLike = findViewById(R.id.btnHeart);
        btByBook = findViewById(R.id.btnBuyBook);
    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }

    public void getBookID(){
        Intent i = getIntent();
        book_id = i.getIntExtra("id_book", -1);
    }

    public void loadBookDetails(int id_book){
        Book book = dao.getBookById(id_book);

    }
}