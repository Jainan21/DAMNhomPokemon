package com.example.duanmaunhompokemon;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class boughtbook extends AppCompatActivity {
    Button btBefore, btMenu, btReadBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boughtbook);

        btBefore = findViewById(R.id.btnBefore);
        btMenu = findViewById(R.id.btnMenu);
        btReadBook = findViewById(R.id.btnReadBook);
    }
}