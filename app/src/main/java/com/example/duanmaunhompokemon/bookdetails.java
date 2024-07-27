package com.example.duanmaunhompokemon;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bookdetails extends BaseActivity {

    Button btBefore, btMenu, btLike, btByBook, btPurchased;
    TextView tvIdBookName, tvAuthorName, tvContent, tvGenereContent, tvSumTellBook, tvAssess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.bookdetails, "Chi tiết sách");

        btBefore = findViewById(R.id.btnBefore);
        btMenu = findViewById(R.id.btnMenu);
        btLike = findViewById(R.id.btnHeart);
        btByBook = findViewById(R.id.btnBuyBook);
        tvIdBookName = findViewById(R.id.txtBookName);
        tvAuthorName = findViewById(R.id.txtAuthorName);
        tvContent = findViewById(R.id.txtContent);
        tvGenereContent = findViewById(R.id.txtGenereContent);
        tvAssess = findViewById(R.id.txtAssess);
    }


}