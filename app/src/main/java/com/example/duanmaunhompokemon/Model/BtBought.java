package com.example.duanmaunhompokemon.Model;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.BoughtBookAdapter;
import com.example.duanmaunhompokemon.Adapter.LikeBookAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.R;
import com.example.duanmaunhompokemon.ReadingBookView;
import com.example.duanmaunhompokemon.bookdetails;
import com.example.duanmaunhompokemon.boughtbook;


import java.util.ArrayList;

public class BtBought extends Fragment {
    TextView tvAuthor1, tvTheloai1;
    Button btReadNow;


public class BtBought extends Fragment {
    RecyclerView rvBoughtBook;
    dbDAO dao;
    ArrayList<Book> list;
    Integer user_id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.boughtbookcase, container, false);

        rvBoughtBook = v.findViewById(R.id.rvBoughtBook);

        getUserID();

        rvBoughtBook.setLayoutManager(new LinearLayoutManager(getContext()));
        dao = new dbDAO(v.getContext());
        loadBought();


        tvAuthor1 = v.findViewById(R.id.tvAuthor1);
        tvTheloai1 = v.findViewById(R.id.tvTheLoai1);
        btReadNow = v.findViewById(R.id.btReadNow);

        return v;
    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }

    public void loadBought()
    {
        list = dao.getPurchasedBooksByAccountId(user_id);
        if (list == null || list.isEmpty()) {
            // Hiển thị thông báo nếu không có sách yêu thích
            Toast.makeText(getContext(), "Không có sách đã mua nào", Toast.LENGTH_SHORT).show();
        } else {
            BoughtBookAdapter adapter = new BoughtBookAdapter(getContext(), list);
            rvBoughtBook.setAdapter(adapter);

            adapter.setOnItemClickListener(new BoughtBookAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Book select = list.get(position);
                    Intent intent = new Intent(getContext(), boughtbook.class);
                    intent.putExtra("id_book", select.getId_book());
                    startActivity(intent);
                }

                @Override
                public void onReadNowClick(int position) {
                    Book select = list.get(position);
                    Intent intent = new Intent(getContext(), ReadingBookView.class);
                    intent.putExtra("id_book", select.getId_book());
                    startActivity(intent);
                }
            });

        }
    }
}
