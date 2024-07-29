package com.example.duanmaunhompokemon;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.CategoryAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Categories;

import java.util.ArrayList;

public class CategoryView extends BaseActivity {

    RecyclerView CategoryView;
    ArrayList<Categories> editCategory;
    CategoryAdapter adpcate;
    dbDAO dao = new dbDAO(com.example.duanmaunhompokemon.CategoryView.this);

    Button btAddCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.activity_category_view, "Quan ly the loai");

        btAddCategory = findViewById(R.id.btAddCategory);

        CategoryView = findViewById(R.id.layout_category);
        CategoryView.setLayoutManager(new GridLayoutManager(this,2));
        CategoryView.setHasFixedSize(true);

        loadCate();

        btAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CategoryView.getContext());
                LayoutInflater inflater = LayoutInflater.from(CategoryView.getContext());
                View view = inflater.inflate(R.layout.change_category, null);
                builder.setView(view);

                EditText edNameCategory = view.findViewById(R.id.edNameCategory);
                EditText edCategorDescription = view.findViewById(R.id.edCategorDescription);
                Button btBack1 = view.findViewById(R.id.btBack1);
                Button btAdd = view.findViewById(R.id.btAdd);

                AlertDialog dialog = builder.create();

                btAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edNameCategory.getText().toString().isEmpty()){
                            Toast.makeText(CategoryView.getContext(), "Không đủ thông tin", Toast.LENGTH_SHORT).show();
                        }else {
                            dao.insertCategory(edNameCategory.getText().toString());
                            loadCate();
                            dialog.dismiss();
                        }
                    }
                });

                btBack1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }

    public void loadCate(){
        editCategory = dao.getAllCategories();
        adpcate = new CategoryAdapter(editCategory, this);
        CategoryView.setAdapter(adpcate);
    }

    public void xoaCate(int index){
        int id_cate = editCategory.get(index).getId();
        boolean ch = dao.deleteCategoryById(id_cate);
        if (ch){
            loadCate();
            Toast.makeText(com.example.duanmaunhompokemon.CategoryView.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(com.example.duanmaunhompokemon.CategoryView.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }
    }

    public void update(int index, String newName){
        int id_cate = editCategory.get(index).getId();
        boolean ch = dao.updateCate(id_cate, newName);
        if (ch){
            loadCate();
            Toast.makeText(com.example.duanmaunhompokemon.CategoryView.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(com.example.duanmaunhompokemon.CategoryView.this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
        }
    }

}