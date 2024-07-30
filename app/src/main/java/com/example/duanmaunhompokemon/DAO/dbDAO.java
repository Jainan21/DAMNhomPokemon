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
import com.example.duanmaunhompokemon.Model.Categories;
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

    public boolean hasTradeBook(int userID, int bookID){
        boolean check = false;
        String query = "SELECT COUNT(*) FROM trade WHERE id_acc = ? AND id_book = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(userID), String.valueOf(bookID)});

        if(cursor != null && cursor.moveToFirst()){
            int count = cursor.getInt(0);
            check = (count > 0);
        }

        return check;
    }

    public Account getAccountById(int id_acc){
        Account acc = null;
        String query = "SELECT * FROM account WHERE id_acc = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id_acc)});
        if (cursor != null && cursor.moveToFirst()){
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            String password = cursor.getString(2);
            String email = cursor.getString(3);
            int roleId = cursor.getInt(4);
            double budget = cursor.getDouble(5);

            acc = new Account(id, username, password, email, roleId, budget);
        }
        cursor.close();
        db.close();
        return acc;
    }

    public Book getBookById(int id_book){
        Book book = null;
        String query = "SELECT * FROM book WHERE id_book = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id_book)});
        if (cursor != null && cursor.moveToFirst()){
            int id = cursor.getInt(0);
            int idAcc = cursor.getInt(1);
            String title = cursor.getString(2);
            int price = cursor.getInt(3);
            String date = cursor.getString(4);
            String summary = cursor.getString(5);
            int bought = cursor.getInt(6);

            book = new Book(id, idAcc, title, price, date, summary, bought);
        }
        cursor.close();
        db.close();
        return book;
    }

    public String getAuthorNameByBookId(int id_book){
        String authorname = null;
        String query = "SELECT account.username FROM account INNER JOIN book ON account.id_acc = book.id_acc WHERE book.id_book = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id_book)});
        if (cursor != null && cursor.moveToFirst()){
            authorname = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return authorname;
    }

    public ArrayList<Book> searchBookByTitle(String title){
        ArrayList<Book> list = new ArrayList<>();
        String query = "SELECT * FROM book WHERE title LIKE ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{"%" + title + "%"});

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                int accId = cursor.getInt(1);
                String bookTitle = cursor.getString(2);
                int price = cursor.getInt(3);
                String date = cursor.getString(4);
                String summary = cursor.getString(5);
                int bought = cursor.getInt(6);

                Book book = new Book(id, accId, bookTitle, price, date, summary, bought);
                list.add(book);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public void addToBudget(int id_acc, double amount){
        SQLiteDatabase db = helper.getWritableDatabase();
        String updateQuery = "UPDATE account SET budget = budget + ? WHERE id_acc = ?";
        db.execSQL(updateQuery, new Object[]{amount, id_acc});
    }

    public void subtractFromBudget(int id_acc, double amount){
        SQLiteDatabase db = helper.getWritableDatabase();
        String updateQuery = "UPDATE account SET budget = budget - ? WHERE id_acc = ?";
        db.execSQL(updateQuery, new Object[]{amount, id_acc});
    }

    public ArrayList<Book> getBooksOrderedByBought(){
        ArrayList<Book> list = new ArrayList<>();
        String query = "SELECT * FROM book ORDER BY bought DESC";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                int accId = cursor.getInt(1);
                String bookTitle = cursor.getString(2);
                int price = cursor.getInt(3);
                String date = cursor.getString(4);
                String summary = cursor.getString(5);
                int bought = cursor.getInt(6);

                Book book = new Book(id, accId, bookTitle, price, date, summary, bought);
                list.add(book);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<Account> getAuthorsSortedByBooksPurchased(){
        ArrayList<Account> list = new ArrayList<>();
        String query = "SELECT account.id_acc, account.username, account.pass, account.email, account.id_role, account.budget, COUNT(book.id_book) as book_count " +
                "FROM account " +
                "LEFT JOIN book ON account.id_acc = book.id_acc " +
                "GROUP BY account.id_acc " +
                "ORDER BY book_count DESC";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do{
                Integer id = cursor.getInt(0);
                String username = cursor.getString(1);
                String password = cursor.getString(2);
                String email = cursor.getString(3);
                Integer roleId = cursor.getInt(4);
                Double budget = cursor.getDouble(5);

                Account author = new Account(id, username, password, email, roleId, budget);
                list.add(author);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public boolean deleteCategoryById(int id_cate) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("bookcate", "id_cate = ?", new String[]{String.valueOf(id_cate)});
        int rowsAffected = db.delete("categories", "id_cate = ?", new String[]{String.valueOf(id_cate)});
        db.close();
        return rowsAffected > 0;
    }

    public boolean deleteAccountById(int id_acc) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("favorite", "id_acc = ?", new String[]{String.valueOf(id_acc)});
        db.delete("adddraw", "id_acc = ?", new String[]{String.valueOf(id_acc)});
        db.delete("book", "id_acc = ?", new String[]{String.valueOf(id_acc)});
        int rowsAffected = db.delete("account", "id_acc = ?", new String[]{String.valueOf(id_acc)});

        db.close();
        return rowsAffected > 0;
    }

    public ArrayList<Book> getFavorieBook(int id_acc){
        ArrayList<Book> list = new ArrayList<>();
        String query = "SELECT book.* FROM book " +
                "INNER JOIN favorite ON book.id_book = favorite.id_book " +
                "WHERE favorite.id_acc = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id_acc)});

        if (cursor.moveToFirst()){
            do{
                int idBook = cursor.getInt(0);
                int idAcc = cursor.getInt(1);
                String title = cursor.getString(2);
                int price = cursor.getInt(3);
                String date = cursor.getString(4);
                String summary = cursor.getString(5);
                int bought = cursor.getInt(6);

                // Tạo đối tượng Book và thêm vào danh sách
                Book book = new Book(idBook, idAcc, title, price, date, summary, bought);
                list.add(book);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<Book> getPurchasedBooksByAccountId(int id_acc){
        ArrayList<Book> list = new ArrayList<>();
        String query = "SELECT book.* FROM book " +
                "INNER JOIN trade ON book.id_book = trade.id_book " +
                "WHERE trade.id_acc = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id_acc)});

        if (cursor.moveToFirst()){
            do{
                int idBook = cursor.getInt(0);
                int idAcc = cursor.getInt(1);
                String title = cursor.getString(2);
                int price = cursor.getInt(3);
                String date = cursor.getString(4);
                String summary = cursor.getString(5);
                int bought = cursor.getInt(6);

                // Tạo đối tượng Book và thêm vào danh sách
                Book book = new Book(idBook, idAcc, title, price, date, summary, bought);
                list.add(book);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public ArrayList<Chapter> getChapterByBookId(int id_book){
        ArrayList<Chapter> list = new ArrayList<>();
        String query = "SELECT * FROM chapter WHERE id_book = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new  String[]{String.valueOf(id_book)});

        if(cursor.moveToFirst()){
            do {
                int idChap = cursor.getInt(0);
                int chapNumber = cursor.getInt(2);
                String titleChap = cursor.getString(3);
                String content = cursor.getString(4);

                Chapter chapter = new Chapter(idChap, id_book, chapNumber, titleChap, content);
                list.add(chapter);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public Chapter getChapterByBookIdAndChapterNumber(int bookId, int chapNumber) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT * FROM chapter WHERE id_book = ? AND chap_number = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(bookId), String.valueOf(chapNumber)});

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idChap = cursor.getInt(cursor.getColumnIndexOrThrow("id_chap"));
                String titleChap = cursor.getString(cursor.getColumnIndexOrThrow("titlechap"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));

                cursor.close();
                return new Chapter(idChap, bookId, chapNumber, titleChap, content);
            }
            cursor.close();
        }
        return null;
    }

    public boolean updateAccount(int accountId, String newUsername, String newEmail) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", newUsername);
        contentValues.put("email", newEmail);

        int result = db.update("account", contentValues, "id_acc = ?", new String[]{String.valueOf(accountId)});
        return result > 0;
    }

    public String getBookCategoryById(int bookId) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String category = "";

        String query = "SELECT c.namecate " +
                "FROM bookcate bc " +
                "JOIN categories c ON bc.id_cate = c.id_cate " +
                "WHERE bc.id_book = ?";

        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(bookId)});

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                category = category + cursor.getString(0);
                cursor.close();
                return category;
            }
            cursor.close();
        }
        return null;
    }

    public boolean updatePassword(int accountId, String newPass) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pass", newPass);

        int result = db.update("account", contentValues, "id_acc = ?", new String[]{String.valueOf(accountId)});
        return result > 0;
    }

    public ArrayList<Trade> getTradesByUserId(int id_acc) {
        ArrayList<Trade> tradeList = new ArrayList<>();
        String query = "SELECT * FROM trade WHERE id_acc = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id_acc)});

        if (cursor.moveToFirst()) {
            do {
                int idTrade = cursor.getInt(0);
                int idBook = cursor.getInt(1);
                int idAcc = cursor.getInt(2);
                int priceTrade = cursor.getInt(3);
                String dateTrade = cursor.getString(4);
                double vat = cursor.getDouble(5);

                // Tạo đối tượng Trade và thêm vào danh sách
                Trade trade = new Trade(idTrade, idBook, idAcc, priceTrade, dateTrade, vat);
                tradeList.add(trade);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tradeList;
    }

    public ArrayList<Categories> getAllCategories() {
        ArrayList<Categories> categories = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String selectQuery = "SELECT * FROM categories";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int idCate = cursor.getInt(0);
                String nameCate = cursor.getString(1);
                Categories category = new Categories(idCate, nameCate);
                categories.add(category);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return categories;
    }

    public boolean updateCate(int Id, String newName) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("namecate", newName);

        int result = db.update("categories", contentValues, "id_cate = ?", new String[]{String.valueOf(Id)});
        return result > 0;
    }
    public ArrayList<Book> getBookByAuthorID(Integer id_acc){
        ArrayList<Book> list = new ArrayList<>();
        String query = "SELECT book.* FROM book " +
                "INNER JOIN account ON book.id_acc = account.id_acc " +
                "WHERE account.id_acc = ?";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id_acc)});

        if (cursor.moveToFirst()){
            do{
                int idBook = cursor.getInt(0);
                int idAcc = cursor.getInt(1);
                String title = cursor.getString(2);
                int price = cursor.getInt(3);
                String date = cursor.getString(4);
                String summary = cursor.getString(5);
                int bought = cursor.getInt(6);

                // Tạo đối tượng Book và thêm vào danh sách
                Book book = new Book(idBook, idAcc, title, price, date, summary, bought);
                list.add(book);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public boolean deleteFavorite(int idBook, int idAcc) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int result = db.delete("favorite", "id_book = ? AND id_acc = ?", new String[]{String.valueOf(idBook), String.valueOf(idAcc)});
        db.close();
        return result > 0;
    }
}