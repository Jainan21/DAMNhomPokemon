package com.example.duanmaunhompokemon.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.duanmaunhompokemon.BookView;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    private final Context c;
    private final ArrayList<Book> list;

    public BookAdapter(Context c, ArrayList<Book> list) {
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
        view = inf.inflate(R.layout.spinner_book, null);
        dbDAO dbDAO = new dbDAO(c);

        TextView sp_txtTitle = view.findViewById(R.id.spin_txtTitle);
        TextView sp_txtAuthor = view.findViewById(R.id.spin_txtAuthor);
        TextView sp_txtPrice = view.findViewById(R.id.spin_txtPrice);
        TextView sp_txtRate = view.findViewById(R.id.spin_txtRate);

        sp_txtTitle.setText(list.get(i).getTitle());
        sp_txtAuthor.setText(dbDAO.getAuthorNameByBookId(list.get(i).getId_book()));
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        sp_txtPrice.setText(formatter.format(list.get(i).getPrice()) + " VND");
        sp_txtRate.setText(String.valueOf(list.get(i).getBought()));

        return view;
    }
}
