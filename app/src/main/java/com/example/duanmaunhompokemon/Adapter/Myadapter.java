package com.example.duanmaunhompokemon.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Model.Rose;
import com.example.duanmaunhompokemon.R;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private List<Rose> listRose;
    public Myadapter(List<Rose> list){
        this.listRose = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Rose rose = listRose.get(position);
        holder.imageView.setImageResource(rose.getImageID());
        holder.textView.setText(rose.getName());
    }

    @Override
    public int getItemCount() {
        return listRose.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private ImageView imageView;
        private TextView textView;
        private Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            imageView = itemView.findViewById(R.id.imgbear);
            textView = itemView.findViewById(R.id.item_text);

            button = itemView.findViewById(R.id.button);
        }
    }
}
