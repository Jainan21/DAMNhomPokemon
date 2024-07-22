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
                "foreign key (id_role) references role(id_role))";

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

        String insertAccount1 = "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('admin', 'adminpass', 'admin@gmail.com', 1, 1000.0)";
        String insertAccount2 = "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('user1', 'user1pass', 'user1@gmail.com', 2, 500.0)";
        String insertAccount3 = "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('author1', 'author1pass', 'author1@gmail.com', 3, 300.0)";

        db.execSQL(insertAccount1);
        db.execSQL(insertAccount2);
        db.execSQL(insertAccount3);

        String insertCategory1 = "INSERT INTO categories (namecate) VALUES ('Fiction')";
        String insertCategory2 = "INSERT INTO categories (namecate) VALUES ('Non-Fiction')";
        String insertCategory3 = "INSERT INTO categories (namecate) VALUES ('Science')";

        db.execSQL(insertCategory1);
        db.execSQL(insertCategory2);
        db.execSQL(insertCategory3);

        String insertBook1 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (1, 'The Great Adventure', 29, '2024-07-22', 'An exciting journey', 1)";
        String insertBook2 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (2, 'Learning Java', 39, '2024-07-22', 'A comprehensive guide to Java programming', 0)";

        db.execSQL(insertBook1);
        db.execSQL(insertBook2);

        String insertChapter1 = "INSERT INTO chapter (id_book, chap_number, titlechap, content) VALUES (1, 1, 'Introduction', 'This is the introduction chapter of the book.')";
        String insertChapter2 = "INSERT INTO chapter (id_book, chap_number, titlechap, content) VALUES (1, 2, 'Chapter One', 'This is the first chapter of the book.')";

        db.execSQL(insertChapter1);
        db.execSQL(insertChapter2);

        String insertBookCate1 = "INSERT INTO bookcate (id_book, id_cate) VALUES (1, 1)";
        String insertBookCate2 = "INSERT INTO bookcate (id_book, id_cate) VALUES (2, 2)";

        db.execSQL(insertBookCate1);
        db.execSQL(insertBookCate2);

        String insertFavorite1 = "INSERT INTO favorite (id_book, id_acc) VALUES (1, 2)";
        String insertFavorite2 = "INSERT INTO favorite (id_book, id_acc) VALUES (2, 1)";

        db.execSQL(insertFavorite1);
        db.execSQL(insertFavorite2);

        String insertAddDraw1 = "INSERT INTO adddraw (date_ad, price_ad, type, id_acc) VALUES ('2024-07-22', 100, 'Deposit', 1)";
        String insertAddDraw2 = "INSERT INTO adddraw (date_ad, price_ad, type, id_acc) VALUES ('2024-07-22', 50, 'Withdraw', 2)";

        db.execSQL(insertAddDraw1);
        db.execSQL(insertAddDraw2);

        String insertTrade1 = "INSERT INTO trade (id_book, id_acc, price_trade, date_trade, vat) VALUES (1, 2, 29, '2024-07-22', 2.9)";
        String insertTrade2 = "INSERT INTO trade (id_book, id_acc, price_trade, date_trade, vat) VALUES (2, 1, 39, '2024-07-22', 3.9)";

        db.execSQL(insertTrade1);
        db.execSQL(insertTrade2);

        String insertRating1 = "INSERT INTO ratings (point, id_book, id_acc) VALUES (5, 1, 2)";
        String insertRating2 = "INSERT INTO ratings (point, id_book, id_acc) VALUES (4, 2, 3)";

        db.execSQL(insertRating1);
        db.execSQL(insertRating2);

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
