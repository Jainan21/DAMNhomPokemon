package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.ListBookAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;

import java.util.ArrayList;
import java.util.List;

public class product extends BaseActivity {
    private RecyclerView recyclerView;
    private ListBookAdapter listBookAdapter;
    private ArrayList<com.example.duanmaunhompokemon.Model.Book> bookList;
    TextView txtName, txtEmail;
    dbDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.activity_product, "Tác phẩm");

        txtName=findViewById(R.id.txtname_acc);
        txtEmail= findViewById(R.id.txtemail_acc);

        dao = new dbDAO(product.this);
        Intent i = getIntent();

        Integer author_id = i.getIntExtra("author_id", -1);
        if (author_id == -1){
            Toast.makeText(this, "Khong co userid", Toast.LENGTH_SHORT).show();
        }
        else{
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            bookList = dao.getBookByAuthorID(author_id);

            listBookAdapter = new ListBookAdapter(bookList, product.this);
            recyclerView.setAdapter(listBookAdapter);
        }
        Account abc = dao.getAccountById(author_id);
        txtName.setText(abc.getUser());
        txtEmail.setText(abc.getEmail());

    }
}