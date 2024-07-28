package com.example.duanmaunhompokemon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.CategoryAdapter;
import com.example.duanmaunhompokemon.Model.Categories;

import java.util.ArrayList;

public class CategoryView extends BaseActivity {

    RecyclerView CategoryView;
    ArrayList<Categories> editCategory;
    CategoryAdapter adpcate;

    Button btAddCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.activity_category_view, "Quan ly the loai");

//        btAddCategory.findViewById(R.id.btAddCategory);

        CategoryView = findViewById(R.id.layout_category);
        CategoryView.setLayoutManager(new GridLayoutManager(this,2));
        CategoryView.setHasFixedSize(true);

        editCategory = new ArrayList<>();
        editCategory.add(new Categories("Tiểu thuyết"));
        editCategory.add(new Categories("Tiểu thuyết"));
        editCategory.add(new Categories("Tiểu thuyết"));
        editCategory.add(new Categories("Tiểu thuyết"));



        adpcate = new CategoryAdapter(editCategory, this);
        CategoryView.setAdapter(adpcate);

//        btAddCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

}