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

public class BtLike extends Fragment {
    TextView tvAuthor, tvTheLoai;
    Button btDelete, btBuy;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.likebookcase, container, false);
        tvAuthor = v.findViewById(R.id.tvAuthor);
        tvTheLoai = v.findViewById(R.id.tvTheLoai);
        btDelete = v.findViewById(R.id.btDelete);
        btBuy = v.findViewById(R.id.btBuyBook);

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;
    }
}
