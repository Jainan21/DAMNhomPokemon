package com.example.duanmaunhompokemon.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duanmaunhompokemon.Model.BtBought;
import com.example.duanmaunhompokemon.Model.BtLike;

public class BookCaseAdapter extends FragmentStateAdapter {
    String mang[];
    public BookCaseAdapter(@NonNull FragmentActivity fragmentActivity, String mang[]) {
        super(fragmentActivity);
        this.mang = mang;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new BtLike();
        }

        if (position == 1)
            return new BtBought();

        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
