package com.example.duanmaunhompokemon;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.Model.Chapter;

import java.util.ArrayList;

public class ReadingBookView extends BaseActivity {

    TextView txtTitle, txtAuthorName, txtReadArea, txtChapterNumber;
    dbDAO dao;
    ArrayList<Chapter> listChapter;
    Spinner spinnerChapter;
    Book book;
    Chapter chap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndDrawer(R.layout.activity_reading_book_view);
        txtTitle = findViewById(R.id.reading_txtTitle);
        txtAuthorName = findViewById(R.id.reading_txtAuthor);
        txtReadArea = findViewById(R.id.reading_txtReadArea);
        txtChapterNumber = findViewById(R.id.reading_txtChapterNumber);
        spinnerChapter = findViewById(R.id.reading_ChooseChapter);
        dao = new dbDAO(ReadingBookView.this);
        listChapter = new ArrayList<>();
        Intent i = getIntent();
        Integer id_book = i.getIntExtra("id_book", -1);
        book = dao.getBookById(id_book);

        // đổ chương lên giao diện
        listChapter = dao.getChapterByBookId(id_book);
        ArrayList<String> listChapterNumber = new ArrayList<>();
        int a=0;
        while (a<listChapter.size()) {
            listChapterNumber.add("Chương " + listChapter.get(a).getChap_number());
            a++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listChapterNumber);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChapter.setAdapter(adapter);

        txtTitle.setText(book.getTitle());
        txtAuthorName.setText(dao.getAuthorNameByBookId(id_book));

        chap = dao.getChapterByBookIdAndChapterNumber(id_book, 1);
        txtReadArea.setText(chap.getContent());
        spinnerChapter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chap = dao.getChapterByBookIdAndChapterNumber(id_book, position+1);
                txtChapterNumber.setText("Chương "+ chap.getChap_number().toString());
                txtReadArea.setText(chap.getContent());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}