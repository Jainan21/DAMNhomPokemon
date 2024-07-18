package com.example.duanmaunhompokemon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BookView extends AppCompatActivity {
    View header, hb;
    LinearLayout header_layout, hb_layout;
    ListView lv_Book_Famous;
    Adapter adpBook;
    ArrayList <String> listBook;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);
        header_layout = findViewById(R.id.header_view);

        LayoutInflater inf1 = getLayoutInflater();
        header = inf1.inflate(R.layout.header, null);
        header_layout.addView(header);

        hb_layout = findViewById(R.id.hb_view);
        LayoutInflater inf2 = getLayoutInflater();
        hb = inf2.inflate(R.layout.hot_book, null);
        hb_layout.addView(hb);

        lv_Book_Famous = findViewById(R.id.lvBook_Famous);
        
    }
}