package com.example.duanmaunhompokemon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duanmaunhompokemon.BookView;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.R;

import java.util.ArrayList;

public class AuthorAdapter extends BaseAdapter {
    private final Context c;
    private final ArrayList<Account> list;

    public AuthorAdapter(Context c, ArrayList<Account> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inf = ((BookView)c).getLayoutInflater();
        view = inf.inflate(R.layout.spinner_author, null);

        ImageView img = view.findViewById(R.id.sp_imgAuthor);
        TextView txtAuthorName = view.findViewById(R.id.sp_txtAuthorName);

        txtAuthorName.setText("Nguyen Pham Bao Lam");

        return view;
    }
}
