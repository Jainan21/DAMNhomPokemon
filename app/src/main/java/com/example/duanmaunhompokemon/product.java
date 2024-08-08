package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.duanmaunhompokemon.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class product extends BaseActivity {
    private RecyclerView recyclerView;
    private ListBookAdapter listBookAdapter;
    private ArrayList<com.example.duanmaunhompokemon.Model.Book> bookList;
    TextView txtName, txtEmail;
    Integer author_id;
    Account abc;
    Integer user_id;
    dbDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.activity_product, "Tác phẩm");

        txtName=findViewById(R.id.txtname_acc);
        txtEmail= findViewById(R.id.txtemail_acc);

        getUserID();
        dao = new dbDAO(product.this);
        Intent i = getIntent();
        author_id = i.getIntExtra("id_author", -1);
        if (author_id == -1){
            Toast.makeText(this, "Tác giả không tồn tại", Toast.LENGTH_SHORT).show();
        }
        else{
            abc = dao.getAccountById(author_id);
            txtName.setText(abc.getUser());
            txtEmail.setText(abc.getEmail());

            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            bookList = dao.getBookByAuthorID(author_id);

            listBookAdapter = new ListBookAdapter(bookList, product.this);
            recyclerView.setAdapter(listBookAdapter);

            listBookAdapter.setOnItemClickListener(new ListBookAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Book selectedBook = bookList.get(position);
                    boolean check = dao.hasTradeBook(user_id, selectedBook.getId_book());
                    if (check) {
                        Intent intent = new Intent(product.this, boughtbook.class);
                        intent.putExtra("id_book", selectedBook.getId_book());
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(product.this, bookdetails.class);
                        intent.putExtra("id_book", selectedBook.getId_book());
                        startActivity(intent);
                    }
                }
            });
        }

    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }
}