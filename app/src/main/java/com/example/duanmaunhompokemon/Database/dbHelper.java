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
                "foreign key (id_acc) references account(id_acc)," +
                "unique (id_book, id_acc)" +
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


        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
        db.execSQL(sql9);

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

        String insertBook1 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (1, 'Cuộc Phiêu Lưu Vĩ Đại', 29, '2024-07-22', 'Tham gia cùng nhân vật chính trong một cuộc hành trình vĩ đại qua những vùng đất rộng lớn và chưa được khám phá. Khi đối mặt với nhiều thử thách và phát hiện những bí mật ẩn giấu, cuộc phiêu lưu tiết lộ sức mạnh thực sự của tinh thần con người. Đầy những cuộc gặp gỡ hồi hộp và những bất ngờ, cuốn sách này hứa hẹn sẽ giữ cho người đọc ở lề ghế.', 150)";
        String insertBook2 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (2, 'Học Java', 39, '2024-07-22', 'Hướng dẫn toàn diện để làm chủ lập trình Java. Cuốn sách này bao gồm tất cả từ cú pháp cơ bản đến các tính năng nâng cao, bao gồm lập trình hướng đối tượng, cấu trúc dữ liệu và nhiều hơn nữa. Thích hợp cho cả người mới bắt đầu và lập trình viên có kinh nghiệm, nó cung cấp các ví dụ thực tiễn và giải thích rõ ràng để nâng cao kỹ năng lập trình của bạn.', 80)";
        String insertBook3 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (3, 'Khoa Học Về Mọi Thứ', 45, '2024-07-20', 'Khám phá những kỳ quan của vũ trụ qua cái nhìn tổng quan về các nguyên lý khoa học. Từ mức độ lượng tử đến các hiện tượng vũ trụ, cuốn sách này cung cấp một cái nhìn toàn diện về thế giới tự nhiên, kết hợp các lý thuyết từ vật lý, hóa học, sinh học và thiên văn học thành một câu chuyện gắn kết.', 60)";
        String insertBook4 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (1, 'Huyền Bí Đại Dương', 35, '2024-07-19', 'Lặn vào một bí ẩn cuốn hút dưới làn sóng đại dương. Khi một loạt các vụ mất tích bí ẩn xảy ra ở một thị trấn ven biển hẻo lánh, một thám tử quyết tâm khám phá một mạng lưới lừa dối và nguy hiểm. Tiểu thuyết này kết hợp sự hồi hộp và hấp dẫn, khám phá những bí mật đen tối ẩn giấu dưới đáy biển.', 120)";
        String insertBook5 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (2, 'Lịch Sử Được Xem Lại', 50, '2024-07-18', 'Một cái nhìn chi tiết về những khoảnh khắc quan trọng trong lịch sử đã định hình thế giới hiện đại. Cuốn sách này đi sâu vào cuộc đời của những nhân vật có ảnh hưởng, các sự kiện chính và các sự thay đổi văn hóa đã định hình các thời kỳ khác nhau. Được minh họa phong phú và nghiên cứu kỹ lưỡng, nó cung cấp cho người đọc một sự hiểu biết toàn diện về các sự phát triển lịch sử.', 90)";
        String insertBook6 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (3, 'Những Đổi Mới Công Nghệ 2024', 55, '2024-07-17', 'Giữ vị trí hàng đầu với cái nhìn sâu sắc về những tiến bộ công nghệ mới nhất. Từ những đột phá trong trí tuệ nhân tạo đến các xu hướng mới nổi trong năng lượng tái tạo, cuốn sách này bao gồm những đổi mới cắt đứt đang chuyển đổi các ngành công nghiệp và ảnh hưởng đến cuộc sống hàng ngày.', 70)";
        String insertBook7 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (1, 'Vùng Đất Huyền Bí', 40, '2024-07-16', 'Những câu chuyện kỳ diệu đưa bạn vào các vương quốc ma thuật. Mỗi câu chuyện khám phá các thế giới độc đáo đầy những sinh vật huyền bí, những nhiệm vụ anh hùng và những lời tiên tri cổ xưa. Với kể chuyện sáng tạo và các bối cảnh chi tiết, cuốn sách này là một đọc cần thiết cho những người yêu thích văn học kỳ ảo.', 200)";

        db.execSQL(insertBook1);
        db.execSQL(insertBook2);
        db.execSQL(insertBook3);
        db.execSQL(insertBook4);
        db.execSQL(insertBook5);
        db.execSQL(insertBook6);
        db.execSQL(insertBook7);

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
        String insertTrade2 = "INSERT INTO trade (id_book, id_acc, price_trade, date_trade, vat) VALUES (2, 3, 39, '2024-07-22', 3.9)";

        db.execSQL(insertTrade1);
        db.execSQL(insertTrade2);

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
