package com.example.duanmaunhompokemon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.BookView;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.R;

import java.util.ArrayList;


public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {

    private Context c;
    private ArrayList<Account> listAuthor;

    public AuthorAdapter(Context c, ArrayList<Account> listAuthor) {
        this.c = c;
        this.listAuthor = listAuthor;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = ((BookView) c).getLayoutInflater();
        View view = inflate.inflate(R.layout.spinner_author,parent,false);
        return new AuthorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorAdapter.AuthorViewHolder holder, int i) {
        holder.txtAuthorName.setText(listAuthor.get(i).getUser());
        holder.imgAuthor.setImageResource(R.drawable.avata);

    }


    @Override
    public int getItemCount() {
        return 0;
    }
    public static class AuthorViewHolder extends RecyclerView.ViewHolder {
        TextView txtAuthorName;
        ImageView imgAuthor;

        public AuthorViewHolder(View itemView) {
            super(itemView);
            txtAuthorName = itemView.findViewById(R.id.sp_txtAuthorName);
            imgAuthor = itemView.findViewById(R.id.sp_imgAuthor);
        }
    }
}