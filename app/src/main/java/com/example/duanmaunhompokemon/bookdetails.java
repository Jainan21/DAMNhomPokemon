package com.example.duanmaunhompokemon;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.Model.Favorite;
import com.example.duanmaunhompokemon.Model.Trade;

public class bookdetails extends BaseActivity {
    dbDAO dao = new dbDAO(bookdetails.this);
    Integer id_book;
    Book book;
    Integer user_id;
    Button btBefore, btMenu, btLike, btByBook, btPurchased;
    TextView tvIdBookName, tvAuthorName, tvContent, tvGenereContent, tvBought, tvAssess, tvPrice, tvSum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.bookdetails, "Chi tiết sách");

        btBefore = findViewById(R.id.btnBefore);
        btMenu = findViewById(R.id.btnMenu);
        btLike = findViewById(R.id.btnFavorite);
        btByBook = findViewById(R.id.btnBuyBook);
        tvIdBookName = findViewById(R.id.txtBookName);
        tvAuthorName = findViewById(R.id.txtAuthorName);
        tvContent = findViewById(R.id.txtContent);
        tvGenereContent = findViewById(R.id.txtGenereContent);
        tvAssess = findViewById(R.id.txtAssess);
        tvPrice = findViewById(R.id.txtPrice);
        tvBought = findViewById(R.id.txtPurchased);
        tvSum = findViewById(R.id.textView);

        getUserID();

        Intent intent = getIntent();
        id_book = intent.getIntExtra("id_book", -1);
        book = dao.getBookById(id_book);
        loadBookDetaila(book);

        btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = dao.insertFavorite(new Favorite(id_book, user_id));

                if (check){
                    Toast.makeText(bookdetails.this, "Đã thêm vào yêu thích", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(bookdetails.this, "Bạn đã có trong mục yêu thích", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btByBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(bookdetails.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có chắc chắn muốn mua không ?");

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Account account = dao.getAccountById(user_id);
                        if(account.getBudget() < book.getPrice()){
                            Toast.makeText(bookdetails.this, "Tài khoản không đủ !!!", Toast.LENGTH_SHORT).show();
                        }else {
//                            LocalDate currentDate = LocalDate.now();
//                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                            String formattedDate = currentDate.format(formatter);
                            dao.insertTrade(new Trade(book.getId_book(), account.getId(), book.getPrice(), "'28-07-2024'", 0.1));
                            dao.addToBudget(0, book.getPrice()*0.1);
                            dao.addToBudget(book.getId_acc(), book.getPrice()*0.9);
                            dao.subtractFromBudget(account.getId(),Double.valueOf(book.getPrice()));

                            Intent intent1 = new Intent(bookdetails.this, boughtbook.class);
                            intent1.putExtra("purchase_success", true);
                            intent1.putExtra("id_book", book.getId_book());
                            startActivity(intent1);
                        }
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    public void loadBookDetaila(Book book){
        tvIdBookName.setText(book.getTitle());
        tvAuthorName.setText(dao.getAuthorNameByBookId(book.getId_book()));
        tvContent.setText(book.getSum());
        tvPrice.setText(book.getPrice() + ".000 VND");
        tvBought.setText("ĐÃ MUA" + String.valueOf(book.getBought()));
        tvGenereContent.setText(dao.getBookCategoryById(book.getId_book()));
        tvSum.setText(book.getSum());
    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }


}