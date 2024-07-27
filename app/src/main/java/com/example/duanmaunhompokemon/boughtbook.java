package com.example.duanmaunhompokemon;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class boughtbook extends BaseActivity {
    Button btBefore, btMenu, btReadBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.boughtbook, "Chi tiết sách");

        btBefore = findViewById(R.id.btnBefore);
        btMenu = findViewById(R.id.btnMenu);
        btReadBook = findViewById(R.id.btnReadBook);
    }
}