package com.example.duanmaunhompokemon.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(@Nullable Context context) {
        super(context, "dbBookPocket", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "create table role(" +
                "id_role integer primary key autoincrement," +
                "name text not null" +
                ")";

        String sql2="create table account(" +
                "id_acc integer primary key autoincrement," +
                "username text not null," +
                "pass text not null," +
                "email text not null," +
                "id_role integer not null," +
                "budget real," +
                "foreign key (role) references role(id))";

        String sql3 = "create table categories(" +
                "id_cate integer primary key autoincrement," +
                "namecate text not null" +
                ")";

        String sql4 = "create table book(" +
                "id_book integer primary key autoincrement," +
                "id_acc integer not null," +
                "title text not null," +
                "price integer not null," +
                "date text," +
                "sum text not null," +
                "bought integer," +
                "foreign key (id_acc) references account(id_acc)" +
                ")";

        String sql5 = "create table chapter(" +
                "id_chap integer primary key autoincrement," +
                "id_book integer not null," +
                "chap_number integer not null," +
                "titlechap text," +
                "content text not null," +
                "foreign key (id_book) references book(id_book)," +
                "unique(id_book, chap_number)" +
                ")";

        String sql6 = "create table bookcate(" +
                "id_bcate integer primary key autoincrement," +
                "id_book integer not null," +
                "id_cate integer not null," +
                "foreign key (id_book) references book(id_book)," +
                "foreign key (id_cate) references categories(id_cate)" +
                ")";

        String sql7 = "create table favorite(" +
                "id_favo integer primary key autoincrement," +
                "id_book integer not null," +
                "id_acc integer not null," +
                "foreign key (id_book) references book(id_book)," +
                "foreign key (id_acc) references account(id_acc)" +
                ")";

        String sql8 = "create table adddraw(" +
                "id_ad integer primary key autoincrement," +
                "date_ad text not null," +
                "price_ad integer not null," +
                "type text not null," +
                "id_acc integer not null," +
                "foreign key (id_acc) references account(id_acc)" +
                ")";

        String sql9 = "create table trade(" +
                "id_trade integer primary key autoincrement," +
                "id_book integer not null," +
                "id_acc integer not null," +
                "price_trade integer not null," +
                "date_trade text not null," +
                "vat real," +
                "foreign key (id_book) references book(id_book)," +
                "foreign key (id_acc) references account(id_acc)" +
                ")";

        String sql10 = "create table ratings(" +
                "id_rating integer primary key autoincrement," +
                "point integer check(point >=1 and point <=5)," +
                "id_book integer not null," +
                "id_acc integer not null," +
                "foreign key (id_book) references book(id_book)," +
                "foreign key (id_acc) references account(id_acc)" +
                ")";

        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
        db.execSQL(sql9);
        db.execSQL(sql10);

        String insertRole1 = "INSERT INTO role (name) VALUES ('Admin')";
        String insertRole2 = "INSERT INTO role (name) VALUES ('User')";
        String insertRole3 = "INSERT INTO role (name) VALUES ('Author')";

        db.execSQL(insertRole1);
        db.execSQL(insertRole2);
        db.execSQL(insertRole3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS role");
        db.execSQL("DROP TABLE IF EXISTS account");
        db.execSQL("DROP TABLE IF EXISTS categories");
        db.execSQL("DROP TABLE IF EXISTS book");
        db.execSQL("DROP TABLE IF EXISTS chapter");
        db.execSQL("DROP TABLE IF EXISTS bookcate");
        db.execSQL("DROP TABLE IF EXISTS favorite");
        db.execSQL("DROP TABLE IF EXISTS adddraw");
        db.execSQL("DROP TABLE IF EXISTS trade");
        db.execSQL("DROP TABLE IF EXISTS ratings");

        onCreate(db);
    }
}
