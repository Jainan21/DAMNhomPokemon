package com.example.duanmaunhompokemon.Model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duanmaunhompokemon.R;

public class BtBought extends Fragment {
    TextView tvAuthor1, tvTheloai1;
    Button btLike, btReadNow;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.boughtbookcase, container, false);
        tvAuthor1 = v.findViewById(R.id.tvAuthor1);
        tvTheloai1 = v.findViewById(R.id.tvTheLoai1);
        btLike = v.findViewById(R.id.btLike);
        btReadNow = v.findViewById(R.id.btReadNow);
        return v;
    }
}
