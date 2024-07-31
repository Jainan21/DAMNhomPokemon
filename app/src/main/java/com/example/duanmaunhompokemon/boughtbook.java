package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Book;

public class boughtbook extends BaseActivity {
    Button btBefore, btMenu, btReadBook;
    TextView tvIdBookName, tvAuthorName, tvContent, tvGenereContent, tvBought, tvAssess, tvPrice, tvSum;
    dbDAO dao = new dbDAO(boughtbook.this);
    Integer id_book;
    Book book;
    Integer user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.boughtbook, "Chi tiết sách");

        btBefore = findViewById(R.id.btnBefore);
        btMenu = findViewById(R.id.btnMenu);
        btReadBook = findViewById(R.id.btnReadBook);
        tvIdBookName = findViewById(R.id.txtBookNameBought);
        tvAuthorName = findViewById(R.id.txtAuthorNameBought);
        tvContent = findViewById(R.id.txtContentBought);
        tvGenereContent = findViewById(R.id.txtGenereContentBought);
        tvPrice = findViewById(R.id.txtPriceBought);
        tvBought = findViewById(R.id.txtPurchasedBought);
        tvSum = findViewById(R.id.textViewBought);

        getUserID();

        Intent intent = getIntent();
        id_book = intent.getIntExtra("id_book", -1);
        book = dao.getBookById(id_book);
        loadBookBought(book);
        boolean purchaseSuccess = intent.getBooleanExtra("purchase_success", false);
        if (purchaseSuccess) {
            Toast.makeText(this, "Thanh toán thành công!", Toast.LENGTH_LONG).show();
        }

        btReadBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(boughtbook.this, ReadingBookView.class);
                intent1.putExtra("id_book", id_book);
                startActivity(intent1);
            }
        });
    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }

    public void loadBookBought(Book book){
        tvIdBookName.setText(book.getTitle());
        tvAuthorName.setText(dao.getAuthorNameByBookId(book.getId_book()));
        tvContent.setText(book.getSum());
        tvPrice.setText(book.getPrice() + " VND");
        tvBought.setText("ĐÃ MUA" + String.valueOf(book.getBought()));
        tvGenereContent.setText(dao.getBookCategoryById(book.getId_book()));
        tvSum.setText(book.getSum());
    }
}