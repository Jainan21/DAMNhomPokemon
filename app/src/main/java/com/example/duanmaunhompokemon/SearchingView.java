package com.example.duanmaunhompokemon;

import static com.example.duanmaunhompokemon.Adapter.HeaderAdapter.setupHeader2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.SearchingAdapter;
import com.example.duanmaunhompokemon.Model.Book;

import java.util.ArrayList;

public class SearchingView extends Fragment {

    RecyclerView BookSearchingView;
    ArrayList<Book> listBook;
    SearchingAdapter adpSearching;

    @SuppressLint("WrongViewCast")

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_searching_view, container, false);



        BookSearchingView = v.findViewById(R.id.layout_searching);
        BookSearchingView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        BookSearchingView.setHasFixedSize(true);


        listBook = new ArrayList<>();
        listBook.add(new Book(1, "Chú chó ngậm giỏ hoa hồng", 150000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(1, "Mắt biếc", 130000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(1, "Chiến tranh tiền tệ", 200000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Mùa hè không tên", 170000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Cây cam ngọt của tôi", 110000,"20/1/2021" , "abc", 20));
        listBook.add(new Book(2, "Bố con cá gai", 90000,"20/1/2021" , "abc", 20));

        adpSearching = new SearchingAdapter(this, listBook);
        BookSearchingView.setAdapter(adpSearching);

        return v;
    }

}