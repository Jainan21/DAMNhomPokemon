package com.example.duanmaunhompokemon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.R;

import java.util.ArrayList;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {

    private Context c;
    private ArrayList<Account> listAuthor;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public AuthorAdapter(Context c, ArrayList<Account> listAuthor) {
        this.c = c;
        this.listAuthor = listAuthor;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(c);
        View view = inflate.inflate(R.layout.spinner_author, parent, false);
        return new AuthorViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int i) {
        holder.txtAuthorName.setText(listAuthor.get(i).getUser());
        holder.imgAuthor.setImageResource(R.drawable.avata);
    }

    @Override
    public int getItemCount() {
        return listAuthor.size();
    }

    public static class AuthorViewHolder extends RecyclerView.ViewHolder {
        TextView txtAuthorName;
        ImageView imgAuthor;

        public AuthorViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            txtAuthorName = itemView.findViewById(R.id.sp_txtAuthorName);
            imgAuthor = itemView.findViewById(R.id.sp_imgAuthor);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}