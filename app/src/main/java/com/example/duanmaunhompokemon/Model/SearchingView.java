package com.example.duanmaunhompokemon.Model;

import static com.example.duanmaunhompokemon.Adapter.HeaderAdapter.setupHeader2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duanmaunhompokemon.BookView;
import com.example.duanmaunhompokemon.R;

public class SearchingView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching_view);

        setupHeader2(SearchingView.this, "Tìm kiếm");

    }
}