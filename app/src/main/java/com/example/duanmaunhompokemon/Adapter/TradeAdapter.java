package com.example.duanmaunhompokemon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.Model.Trade;
import com.example.duanmaunhompokemon.R;

import java.util.ArrayList;

public class TradeAdapter extends RecyclerView.Adapter<TradeAdapter.TradeViewHolder> {

    private Context c;
    private ArrayList<Trade> listTrade;
    private AuthorAdapter.OnItemClickListener listener;
    dbDAO dao = new dbDAO(c);

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public TradeAdapter(Context c, ArrayList<Trade> listAuthor) {
        this.c = c;
        this.listTrade = listAuthor;
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
        holder.tvAmount.setText(trade.getPrice_trade() + "00 VND");
        holder.tvDate.setText(trade.getDate_trade());
    }

    @Override
    public int getItemCount() {
        return listTrade.size();
    }

    public static class TradeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAuthor, tvAmount, tvDate, tvVat;

        public TradeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}
