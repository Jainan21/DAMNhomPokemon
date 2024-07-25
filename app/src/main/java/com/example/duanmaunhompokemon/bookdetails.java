package com.example.duanmaunhompokemon;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bookdetails extends BaseActivity {

    Button btBefore, btMenu, btLike, btByBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.bookdetails);

        btBefore = findViewById(R.id.btnBefore);
        btMenu = findViewById(R.id.btnMenu);
        btLike = findViewById(R.id.btnHeart);
        btByBook = findViewById(R.id.btnBuyBook);
    }
}