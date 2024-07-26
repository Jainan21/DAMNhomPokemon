package com.example.duanmaunhompokemon;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.duanmaunhompokemon.Adapter.BookCaseAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class BookCaseView extends BaseActivity {
    ViewPager2 vpBookCase;
    TabLayout tlBookCase;
    String mang[] = new String[]{"Yêu thích", "Đã mua"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupActionBarAndBack(R.layout.activity_book_case_view, "Tu sach");
        vpBookCase = findViewById(R.id.vpBookCase);
        tlBookCase = findViewById(R.id.tlBookCase);

        BookCaseAdapter adt = new BookCaseAdapter(BookCaseView.this, mang);
        vpBookCase.setAdapter(adt);

        new TabLayoutMediator(tlBookCase, vpBookCase, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(mang[position]);
            }
        }).attach();

    }
}