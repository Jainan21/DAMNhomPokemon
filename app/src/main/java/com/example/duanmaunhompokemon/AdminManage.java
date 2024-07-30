package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminManage extends BaseActivity {
    Button btNguoiDung, btAuthor, btTheLoai, btMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndDrawer(R.layout.activity_admin_manage);

        btNguoiDung = findViewById(R.id.btNguoiDung);
        btAuthor = findViewById(R.id.btAuthor);
        btTheLoai = findViewById(R.id.btTheLoai);
        btMoney = findViewById(R.id.btMoney);

        btNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminManage.this, CategoryView.class));
            }
        });

        btMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}