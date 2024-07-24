package com.example.duanmaunhompokemon.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmaunhompokemon.Database.dbHelper;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.AddDraw;
import com.example.duanmaunhompokemon.Model.Book;
import com.example.duanmaunhompokemon.Model.BookCate;
import com.example.duanmaunhompokemon.Model.Chapter;
import com.example.duanmaunhompokemon.Model.Favorite;
import com.example.duanmaunhompokemon.Model.Ratings;
import com.example.duanmaunhompokemon.Model.Trade;

import java.util.ArrayList;

public class dbDAO {
    public dbHelper helper;

    public dbDAO(Context c){
        helper = new dbHelper(c);
    }

    public boolean insertAccount(Account acc){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", acc.getUser());
        values.put("pass", acc.getPass());
        values.put("email", acc.getEmail());
        values.put("id_role", acc.getId_role());
        values.put("budget", acc.getBudget());
        long result = db.insert("account", null, values);
        return result != -1;
    }

    public boolean insertBook(Book book){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_acc", book.getId_acc());
        values.put("title", book.getTitle());
        values.put("price", book.getPrice());
        values.put("date", book.getDate());
        values.put("sum", book.getSum());
        values.put("bought", book.getBought());
        long result = db.insert("book", null, values);
        return result != -1;
    }

    public boolean insertRating(Ratings ratings){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("point", ratings.getPoint());
        values.put("id_book", ratings.getId_book());
        values.put("id_acc", ratings.getId_acc());
        long result = db.insert("ratings", null, values);
        return result != -1;
    }

    public boolean insertRole(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        long result = db.insert("role", null, values);
        return result != -1;
    }

    public boolean insertCategory(String namecate){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("namecate", namecate);
        long result = db.insert("categories", null, values);
        return result != -1;
    }

    public boolean insertChapter(Chapter chapter){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_book", chapter.getId_book());
        values.put("chap_number", chapter.getChap_number());
        values.put("titlechap", chapter.getTitlechap());
        values.put("content", chapter.getContent());
        long result = db.insert("chapter", null, values);
        return result != -1;
    }

    public boolean insertBookCate(BookCate bc) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_book", bc.getId_book());
        values.put("id_cate", bc.getId_cate());
        long result = db.insert("bookcate", null, values);
        return result != -1;
    }

    public boolean insertFavorite(Favorite favo) {
        SQLiteDatabase db =  helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_book", favo.getId_book());
        values.put("id_acc", favo.getId_acc());
        long result = db.insert("favorite", null, values);
        return result != -1;
    }

    public boolean insertAddDraw(AddDraw ad) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date_ad", ad.getDate_ad());
        values.put("price_ad", ad.getPrice_ad());
        values.put("type", ad.getType());
        values.put("id_acc", ad.getId_acc());
        long result = db.insert("adddraw", null, values);
        return result != -1;
    }

    public boolean insertTrade(Trade trade) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_book", trade.getId_book());
        values.put("id_acc", trade.getId_acc());
        values.put("price_trade", trade.getPrice_trade());
        values.put("date_trade", trade.getDate_trade());
        values.put("vat", trade.getVat());
        long result = db.insert("trade", null, values);
        return result != -1;
    }


    public ArrayList<Account> getAllAccount(){
        ArrayList<Account> list = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from account", null);

        if (cursor.moveToFirst()){
            do{
                Integer id = cursor.getInt(0);
                String username = cursor.getString(1);
                String  pass = cursor.getString(2);
                String email = cursor.getString(3);
                Integer id_role = cursor.getInt(4);
                Double budget = cursor.getDouble(5);
                Account account = new Account(id, username, pass, email, id_role, budget);
                list.add(account);
            }while (cursor.moveToNext());
        }

        return list;
    }
}
