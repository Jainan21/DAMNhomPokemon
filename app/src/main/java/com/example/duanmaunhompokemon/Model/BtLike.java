package com.example.duanmaunhompokemon.Model;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.LikeBookAdapter;
import com.example.duanmaunhompokemon.BookView;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.R;
import com.example.duanmaunhompokemon.authoractivity;
import com.example.duanmaunhompokemon.bookdetails;
import com.example.duanmaunhompokemon.boughtbook;

import java.util.ArrayList;

public class BtLike extends Fragment {
    RecyclerView rvLikeBook;
    dbDAO dao;
    ArrayList<Book> list;
    Integer user_id;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.likebookcase, container, false);
        rvLikeBook = v.findViewById(R.id.rvLikeBook);
        getUserID();

        rvLikeBook.setLayoutManager(new LinearLayoutManager(getContext()));
        dao = new dbDAO(v.getContext());
        loadLike();
        return v;
    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }

    public void loadLike()
    {
        list = dao.getFavorieBook(user_id);
        if (list == null || list.isEmpty()) {
            // Hiển thị thông báo nếu không có sách yêu thích
            Toast.makeText(getContext(), "Không có sách yêu thích nào", Toast.LENGTH_SHORT).show();
        } else {
            LikeBookAdapter adapter = new LikeBookAdapter(getContext(), list);
            rvLikeBook.setAdapter(adapter);

            adapter.setOnItemClickListener(new LikeBookAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Book select = list.get(position);
                    Intent intent = new Intent(getContext(), bookdetails.class);
                    intent.putExtra("id_book", select.getId_book());
                    startActivity(intent);
                }

                @Override
                public void onDeleteClick(int position) {
                    Book select = list.get(position);
                    boolean check = dao.deleteFavorite(select.getId_book(), user_id);
                    if (check){
                        loadLike();
                        Toast.makeText(getContext(), "Xoá thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Xoá thất bại", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onBuyClick(int position) {
                    Book select = list.get(position);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Thông báo");
                    builder.setMessage("Bạn có chắc chắn muốn mua không ?");

                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {dialog.dismiss();
                        }
                    });

                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Account account = dao.getAccountById(user_id);
                            if(account.getBudget() < select.getPrice()){
                                Toast.makeText(getContext(), "Tài khoản không đủ !!!", Toast.LENGTH_SHORT).show();
                            }else {
                                //                            LocalDate currentDate = LocalDate.now();
                                //                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                //                            String formattedDate = currentDate.format(formatter);
                                dao.insertTrade(new Trade(select.getId_book(), account.getId(), select.getPrice(), "'28-07-2024'", 0.1));
                                dao.addToBudget(0, select.getPrice()*0.1);
                                dao.addToBudget(select.getId_acc(), select.getPrice()*0.9);
                                dao.subtractFromBudget(account.getId(),Double.valueOf(select.getPrice()));
                                dao.adddcountBoughtBookById(select.getId_book());

                                dao.deleteFavorite(select.getId_book(), user_id);
                                loadLike();
                                Toast.makeText(getContext(), "Mua thành công", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
        }
    }
}
