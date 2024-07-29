package com.example.duanmaunhompokemon.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.CategoryView;
import com.example.duanmaunhompokemon.Model.Categories;
import com.example.duanmaunhompokemon.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Categories> editCategory;
    CategoryView cate;

    public CategoryAdapter(ArrayList<Categories> editCategory, CategoryView cate) {
        this.editCategory = editCategory;
        this.cate = cate;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = cate.getLayoutInflater();
        View v = inflate.inflate(R.layout.category,parent,false);
        return new CategoryViewHolder(v);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        Categories categories = editCategory.get(position);
        holder.categoryTitle.setText(categories.getName());

        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog(categories, position);
            }
        });

        holder.btDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteDialog(categories, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return editCategory.size();
    }

    private void showEditDialog(Categories category, int potision){
        AlertDialog.Builder builder = new AlertDialog.Builder(cate);
        LayoutInflater inflater = LayoutInflater.from(cate);
        View view = inflater.inflate(R.layout.change_category, null);
        builder.setView(view);

        EditText edNameCategory = view.findViewById(R.id.edNameCategory);
        EditText edCategorDescription = view.findViewById(R.id.edCategorDescription);
        Button btBack1 = view.findViewById(R.id.btBack1);
        Button btAdd = view.findViewById(R.id.btAdd);

        edNameCategory.setText(category.getName());
        edCategorDescription.setText(category.getName());

        AlertDialog dialog = builder.create();

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edNameCategory.getText().toString().isEmpty()){
                    Toast.makeText(cate, "Không đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    cate.update(potision, edNameCategory.getText().toString());
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

    private void showDeleteDialog(Categories categories, int potision){
        AlertDialog.Builder bd = new AlertDialog.Builder(cate);
        bd.setTitle("Xác nhận xóa");
        bd.setMessage("Bạn có chắc chắn xóa thể loại này không?");
        bd.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cate.xoaCate(potision);
            }
        });

        bd.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = bd.create();
        dialog.show();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle;
        Button btEdit, btDelete1;

        @SuppressLint("ResourceType")
        public CategoryViewHolder(View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
            btEdit = itemView.findViewById(R.id.btEdit);
            btDelete1 = itemView.findViewById(R.id.btDelete1);
        }
    }


}
