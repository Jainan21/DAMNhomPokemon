package com.example.duanmaunhompokemon;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.ListBookAdapter;

import java.util.ArrayList;
import java.util.List;

public class product extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListBookAdapter listBookAdapter;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookList = new ArrayList<>();
        bookList.add(new Book("Lũ trẻ đường tàu", "Edith Nesbit", "120.000 VND", R.drawable.nhagiakim));
        bookList.add(new Book("Lũ trẻ đường tàu", "Edith Nesbit", "120.000 VND", R.drawable.nhagiakim));
        bookList.add(new Book("Lũ trẻ đường tàu", "Edith Nesbit", "120.000 VND", R.drawable.nhagiakim));

        listBookAdapter = new ListBookAdapter(bookList);
        recyclerView.setAdapter(listBookAdapter);

    }
}