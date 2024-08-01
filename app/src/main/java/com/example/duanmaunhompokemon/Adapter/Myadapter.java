package com.example.duanmaunhompokemon.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.R;
import com.example.duanmaunhompokemon.UserManage;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private List<Account> listAccount;
    public Myadapter(List<Account> list){
        this.listAccount = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item,parent,false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Account rose = listAccount.get(position);
        holder.imageView.setImageResource(R.drawable.avata);
        holder.txtUser.setText(rose.getUser());
        holder.txtID.setText( rose.getId().toString());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listAccount.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView txtUser, txtID;
        private Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgbear);
            txtUser = itemView.findViewById(R.id.user_Username);
            txtID = itemView.findViewById(R.id.user_idUser);
            button = itemView.findViewById(R.id.user_Delbtn);

        }
    }
}
