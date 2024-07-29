package com.example.duanmaunhompokemon;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.AuthorAdapter;
import com.example.duanmaunhompokemon.Adapter.ListAuthorAdapter;

import java.util.Arrays;
import java.util.List;

public class Listauthor extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListAuthorAdapter LAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listauthor);
        List<String> data = Arrays.asList("De nít xu", "De nít xu", "De nít xu", "De nít xu", "De nít xu");

        recyclerView = findViewById(R.id.recyclerView_listauthor);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LAdapter = new ListAuthorAdapter(data);
        recyclerView.setAdapter(LAdapter);
    }
}