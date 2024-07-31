package com.example.duanmaunhompokemon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.Model.Trade;
import com.example.duanmaunhompokemon.R;

import java.util.ArrayList;

public class TradeAdapter extends RecyclerView.Adapter<TradeAdapter.TradeViewHolder> {

    private Context context;
    private ArrayList<Trade> listTrade;
    private dbDAO dao;

    public TradeAdapter(Context context, ArrayList<Trade> listTrade) {
        this.context = context;
        this.listTrade = listTrade;
        this.dao = new dbDAO(context); // Khởi tạo dao sau khi context được gán giá trị
    }

    @NonNull
    @Override
    public TradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_trade, parent, false);
        return new TradeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TradeViewHolder holder, int position) {
        Trade trade = listTrade.get(position);
        Book book = dao.getBookById(trade.getId_book());
        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(dao.getAuthorNameByBookId(book.getId_book()));
        holder.tvAmount.setText(trade.getPrice_trade() + " VND");
        holder.tvDate.setText(trade.getDate_trade());
    }

    @Override
    public int getItemCount() {
        return listTrade.size();
    }

    public static class TradeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAuthor, tvAmount, tvDate;

        public TradeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}

