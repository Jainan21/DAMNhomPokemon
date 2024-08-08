package com.example.duanmaunhompokemon.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(@Nullable Context context) {
        super(context, "dbBookPocket", null, 7);
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

        String insertAccount1 = "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('admin', 'adminpass', 'admin@gmail.com', 1, 1000000.0)";
        String insertAccount2 = "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('user1', 'user1pass', 'user1@gmail.com', 2, 500000.0)";
        String insertAccount3 = "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('user2', 'user2pass', 'author1@gmail.com', 3, 300000.0)";

        db.execSQL(insertAccount1);
        db.execSQL(insertAccount2);
        db.execSQL(insertAccount3);
        String[] insertUsersAndAuthors = {
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('john_doe', 'userpass1', 'johndoe@gmail.com', 2, 500000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('jane_smith', 'userpass2', 'janesmith@gmail.com', 2, 450000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('alice_wonder', 'userpass3', 'alicewonder@gmail.com', 2, 600000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('bob_builder', 'userpass4', 'bobbuilder@gmail.com', 2, 550000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('carol_writer', 'authorpass1', 'carolwriter@gmail.com', 3, 300000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('dave_poet', 'authorpass2', 'davepoet@gmail.com', 3, 350000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('eve_storyteller', 'authorpass3', 'evestoryteller@gmail.com', 3, 400000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('frank_novelist', 'authorpass4', 'franknovelist@gmail.com', 3, 380000.0)",

                // Additional users
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('george_mason', 'userpass5', 'georgemason@gmail.com', 2, 470000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('hannah_lee', 'userpass6', 'hannahlee@gmail.com', 2, 520000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('ian_miller', 'userpass7', 'ianmiller@gmail.com', 2, 550000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('julia_white', 'userpass8', 'juliawhite@gmail.com', 2, 580000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('kyle_adams', 'userpass9', 'kyleadams@gmail.com', 2, 600000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('lisa_jones', 'userpass10', 'lisajones@gmail.com', 2, 620000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('michael_davis', 'userpass11', 'michaeldavis@gmail.com', 2, 640000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('nora_garcia', 'userpass12', 'noragarcia@gmail.com', 2, 660000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('olivia_harris', 'userpass13', 'oliviaharris@gmail.com', 2, 680000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('paul_martin', 'userpass14', 'paulmartin@gmail.com', 2, 700000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('quinn_clark', 'userpass15', 'quinnclark@gmail.com', 2, 720000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('rachel_walker', 'userpass16', 'rachelwalker@gmail.com', 2, 740000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('samuel_lee', 'userpass17', 'samuellee@gmail.com', 2, 760000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('tina_smith', 'userpass18', 'tinasmith@gmail.com', 2, 780000.0)",

                // Additional authors
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('ursula_kay', 'authorpass5', 'ursulakay@gmail.com', 3, 320000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('victor_frank', 'authorpass6', 'victorfrank@gmail.com', 3, 340000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('wendy_king', 'authorpass7', 'wendyking@gmail.com', 3, 360000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('xander_wood', 'authorpass8', 'xanderwood@gmail.com', 3, 380000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('yvonne_smith', 'authorpass9', 'yvonesmith@gmail.com', 3, 400000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('zachary_brown', 'authorpass10', 'zacharybrown@gmail.com', 3, 420000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('amelia_wong', 'authorpass11', 'ameliawong@gmail.com', 3, 440000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('brian_carter', 'authorpass12', 'briancarter@gmail.com', 3, 460000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('claire_smith', 'authorpass13', 'clairesmith@gmail.com', 3, 480000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('daniel_johnson', 'authorpass14', 'danieljohnson@gmail.com', 3, 500000.0)",
                "INSERT INTO account (username, pass, email, id_role, budget) VALUES ('ella_green', 'authorpass15', 'ellagreen@gmail.com', 3, 520000.0)"
        };

        for (String sql : insertUsersAndAuthors) {
            db.execSQL(sql);
        }


        String[] insertCategories = {
                "INSERT INTO categories (namecate) VALUES ('Văn học cổ điển')",
                "INSERT INTO categories (namecate) VALUES ('Văn học hiện đại')",
                "INSERT INTO categories (namecate) VALUES ('Trinh thám')",
                "INSERT INTO categories (namecate) VALUES ('Tiểu thuyết tình cảm')",
                "INSERT INTO categories (namecate) VALUES ('Khoa học viễn tưởng')",
                "INSERT INTO categories (namecate) VALUES ('Kinh dị')",
                "INSERT INTO categories (namecate) VALUES ('Tâm lý học')",
                "INSERT INTO categories (namecate) VALUES ('Lịch sử')",
                "INSERT INTO categories (namecate) VALUES ('Tự truyện')",
                "INSERT INTO categories (namecate) VALUES ('Du ký')"
        };

        for (String sql : insertCategories) {
            db.execSQL(sql);
        }

        String insertBook1 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (8, 'Cuộc Phiêu Lưu Vĩ Đại', 79000, '2024-07-22', 'Tham gia cùng nhân vật chính trong một cuộc hành trình vĩ đại qua những vùng đất rộng lớn và chưa được khám phá. Khi đối mặt với nhiều thử thách và phát hiện những bí mật ẩn giấu, cuộc phiêu lưu tiết lộ sức mạnh thực sự của tinh thần con người. Đầy những cuộc gặp gỡ hồi hộp và những bất ngờ, cuốn sách này hứa hẹn sẽ giữ cho người đọc ở lề ghế.', 150)";
        String insertBook2 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (9, 'Học Java', 89000, '2024-07-22', 'Hướng dẫn toàn diện để làm chủ lập trình Java. Cuốn sách này bao gồm tất cả từ cú pháp cơ bản đến các tính năng nâng cao, bao gồm lập trình hướng đối tượng, cấu trúc dữ liệu và nhiều hơn nữa. Thích hợp cho cả người mới bắt đầu và lập trình viên có kinh nghiệm, nó cung cấp các ví dụ thực tiễn và giải thích rõ ràng để nâng cao kỹ năng lập trình của bạn.', 80)";
        String insertBook3 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (10, 'Khoa Học Về Mọi Thứ', 45000, '2024-07-20', 'Khám phá những kỳ quan của vũ trụ qua cái nhìn tổng quan về các nguyên lý khoa học. Từ mức độ lượng tử đến các hiện tượng vũ trụ, cuốn sách này cung cấp một cái nhìn toàn diện về thế giới tự nhiên, kết hợp các lý thuyết từ vật lý, hóa học, sinh học và thiên văn học thành một câu chuyện gắn kết.', 60)";
        String insertBook4 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (11, 'Huyền Bí Đại Dương', 105000, '2024-07-19', 'Lặn vào một bí ẩn cuốn hút dưới làn sóng đại dương. Khi một loạt các vụ mất tích bí ẩn xảy ra ở một thị trấn ven biển hẻo lánh, một thám tử quyết tâm khám phá một mạng lưới lừa dối và nguy hiểm. Tiểu thuyết này kết hợp sự hồi hộp và hấp dẫn, khám phá những bí mật đen tối ẩn giấu dưới đáy biển.', 120)";
        String insertBook5 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (8, 'Lịch Sử Được Xem Lại', 50000, '2024-07-18', 'Một cái nhìn chi tiết về những khoảnh khắc quan trọng trong lịch sử đã định hình thế giới hiện đại. Cuốn sách này đi sâu vào cuộc đời của những nhân vật có ảnh hưởng, các sự kiện chính và các sự thay đổi văn hóa đã định hình các thời kỳ khác nhau. Được minh họa phong phú và nghiên cứu kỹ lưỡng, nó cung cấp cho người đọc một sự hiểu biết toàn diện về các sự phát triển lịch sử.', 90)";
        String insertBook6 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (9, 'Những Đổi Mới Công Nghệ 2024', 55000, '2024-07-17', 'Giữ vị trí hàng đầu với cái nhìn sâu sắc về những tiến bộ công nghệ mới nhất. Từ những đột phá trong trí tuệ nhân tạo đến các xu hướng mới nổi trong năng lượng tái tạo, cuốn sách này bao gồm những đổi mới cắt đứt đang chuyển đổi các ngành công nghiệp và ảnh hưởng đến cuộc sống hàng ngày.', 70)";
        String insertBook7 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (10, 'Vùng Đất Huyền Bí', 90000, '2024-07-16', 'Những câu chuyện kỳ diệu đưa bạn vào các vương quốc ma thuật. Mỗi câu chuyện khám phá các thế giới độc đáo đầy những sinh vật huyền bí, những nhiệm vụ anh hùng và những lời tiên tri cổ xưa. Với kể chuyện sáng tạo và các bối cảnh chi tiết, cuốn sách này là một đọc cần thiết cho những người yêu thích văn học kỳ ảo.', 200)";

        db.execSQL(insertBook1);
        db.execSQL(insertBook2);
        db.execSQL(insertBook3);
        db.execSQL(insertBook4);
        db.execSQL(insertBook5);
        db.execSQL(insertBook6);
        db.execSQL(insertBook7);

        String insertBook8 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (30, 'Nghệ Thuật Quản Lý Thời Gian', 75000, '2024-07-15', 'Khám phá các kỹ thuật và chiến lược để tối ưu hóa việc quản lý thời gian của bạn. Cuốn sách này cung cấp các phương pháp thực tế và mẹo để giúp bạn tổ chức công việc, giảm căng thẳng và đạt được hiệu quả cao nhất trong cuộc sống hàng ngày.', 85)";
        String insertBook9 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (31, 'Tương Lai của Năng Lượng', 88000, '2024-07-14', 'Tìm hiểu về các nguồn năng lượng mới và tương lai của ngành công nghiệp năng lượng. Cuốn sách này xem xét các công nghệ mới, các dự báo về nhu cầu năng lượng và các giải pháp bền vững đang được phát triển để đáp ứng nhu cầu toàn cầu.', 95)";
        String insertBook10 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (32, 'Cẩm Nang Khởi Nghiệp', 67000, '2024-07-13', 'Một hướng dẫn chi tiết dành cho những người đang xem xét việc bắt đầu kinh doanh của riêng họ. Cuốn sách này bao gồm các bước quan trọng từ việc lập kế hoạch kinh doanh đến việc phát triển sản phẩm và tiếp thị, cùng với các mẹo từ các doanh nhân thành công.', 55)";
        String insertBook11 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (33, 'Sáng Tạo Không Biên Giới', 53000, '2024-07-12', 'Khám phá cách mà sự sáng tạo có thể được thúc đẩy trong môi trường làm việc và cuộc sống cá nhân. Cuốn sách này cung cấp các phương pháp để kích thích tư duy sáng tạo và vượt qua các rào cản, giúp bạn phát triển ý tưởng mới và đạt được thành công.', 65)";
        String insertBook12 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (34, 'Hành Trình Tinh Thần', 49000, '2024-07-11', 'Một nghiên cứu sâu về các khía cạnh tinh thần của con người và các phương pháp để phát triển sự tự nhận thức. Cuốn sách này cung cấp hướng dẫn và bài tập để giúp bạn kết nối với chính mình và tìm kiếm ý nghĩa sâu xa trong cuộc sống.', 75)";
        String insertBook13 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (35, 'Những Bí Ẩn Của Tâm Lý Học', 86000, '2024-07-10', 'Khám phá các lý thuyết và nghiên cứu về tâm lý học. Cuốn sách này trình bày các khái niệm chính trong tâm lý học, từ các rối loạn tâm lý đến các phương pháp điều trị, giúp bạn hiểu rõ hơn về hành vi và cảm xúc của con người.', 90)";
        String insertBook14 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (36, 'Kỹ Năng Giao Tiếp Hiệu Quả', 68000, '2024-07-09', 'Một hướng dẫn toàn diện về cách cải thiện kỹ năng giao tiếp của bạn. Cuốn sách này bao gồm các mẹo và kỹ thuật để giúp bạn giao tiếp rõ ràng, tự tin và hiệu quả trong cả môi trường cá nhân và chuyên nghiệp.', 85)";
        String insertBook15 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (37, 'Tìm Hiểu Về Xã Hội Học', 73000, '2024-07-08', 'Khám phá các khái niệm cơ bản trong xã hội học và cách mà các yếu tố xã hội ảnh hưởng đến hành vi và quan điểm của con người. Cuốn sách này cung cấp cái nhìn sâu sắc về cấu trúc xã hội và các vấn đề hiện đại.', 80)";
        String insertBook16 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (38, 'Tự Học Máy Học', 99000, '2024-07-07', 'Một hướng dẫn chi tiết để học máy và trí tuệ nhân tạo. Cuốn sách này bao gồm các khái niệm cơ bản, thuật toán và ứng dụng thực tiễn của học máy, giúp bạn xây dựng và triển khai các mô hình học máy.', 100)";
        String insertBook17 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (39, 'Khám Phá Các Nền Văn Hóa', 55000, '2024-07-06', 'Tìm hiểu về các nền văn hóa khác nhau trên thế giới. Cuốn sách này cung cấp cái nhìn sâu sắc về phong tục tập quán, lịch sử và các giá trị văn hóa khác nhau, giúp bạn hiểu rõ hơn về sự đa dạng văn hóa toàn cầu.', 85)";
        String insertBook18 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (40, 'Sức Khỏe Tinh Thần Và Thể Chất', 72000, '2024-07-05', 'Khám phá các yếu tố ảnh hưởng đến sức khỏe tinh thần và thể chất. Cuốn sách này cung cấp các hướng dẫn về lối sống lành mạnh, dinh dưỡng, tập luyện và các phương pháp để duy trì sức khỏe tổng thể.', 70)";
        String insertBook19 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (41, 'Học Máy Nâng Cao', 87000, '2024-07-04', 'Một hướng dẫn nâng cao về học máy, bao gồm các kỹ thuật và mô hình tiên tiến hơn. Cuốn sách này cung cấp cái nhìn sâu sắc về các phương pháp học máy phức tạp, từ học sâu đến các ứng dụng chuyên biệt.', 90)";
        String insertBook20 = "INSERT INTO book (id_acc, title, price, date, sum, bought) VALUES (30, 'Lịch Sử Văn Minh', 78000, '2024-07-03', 'Khám phá lịch sử của các nền văn minh lớn và ảnh hưởng của chúng đến thế giới hiện đại. Cuốn sách này cung cấp cái nhìn tổng quan về sự phát triển của các nền văn minh và các thành tựu văn hóa quan trọng.', 95)";

        db.execSQL(insertBook8);
        db.execSQL(insertBook9);
        db.execSQL(insertBook10);
        db.execSQL(insertBook11);
        db.execSQL(insertBook12);
        db.execSQL(insertBook13);
        db.execSQL(insertBook14);
        db.execSQL(insertBook15);
        db.execSQL(insertBook16);
        db.execSQL(insertBook17);
        db.execSQL(insertBook18);
        db.execSQL(insertBook19);
        db.execSQL(insertBook20);

        String insertChapter1 = "INSERT INTO chapter (id_book, chap_number, titlechap, content) VALUES" +
                "(1, 1, 'Giới thiệu', 'Chương giới thiệu cung cấp cái nhìn tổng quan về các chủ đề chính và mục tiêu của cuốn sách. Nó thiết lập nền tảng cho các chủ đề sẽ được đề cập và giải thích tầm quan trọng của việc hiểu sâu các khái niệm này.')," +
                "(1, 2, 'Chương Một', 'Trong chương đầu tiên, chúng ta sẽ đi sâu vào các khái niệm cơ bản quan trọng cho việc hiểu các tài liệu sau này. Chương này bao gồm các nguyên lý cơ bản và cung cấp giải thích chi tiết về các thuật ngữ chính.')," +
                "(1, 3, 'Chương Hai', 'Chương hai xây dựng trên những nền tảng đã được đặt ra trong chương trước. Nó khám phá các chủ đề nâng cao và cung cấp các ví dụ chi tiết để minh họa cách các khái niệm này được áp dụng trong các tình huống thực tế.')," +
                "(1, 4, 'Chương Ba', 'Chương này tập trung vào các ứng dụng thực tiễn của các lý thuyết đã được thảo luận trước đó. Nó bao gồm các nghiên cứu trường hợp và các bài tập thực hành được thiết kế để củng cố tài liệu và nâng cao hiểu biết của bạn.')," +
                "(1, 5, 'Chương Bốn', 'Chương bốn giới thiệu những quan điểm mới về chủ đề, cung cấp cái nhìn từ các chuyên gia và nhà tư tưởng khác nhau. Nó trình bày các quan điểm đa dạng và khuyến khích tư duy phản biện.')";
        String insertChapter3 = "INSERT INTO chapter (id_book, chap_number, titlechap, content) VALUES" +
                "(3, 1, 'Nhập Môn về Machine Learning', 'Machine Learning (Học máy) là một lĩnh vực quan trọng trong trí tuệ nhân tạo. Chương này cung cấp cái nhìn tổng quan về học máy và ứng dụng của nó trong các lĩnh vực khác nhau.')," +
                "(3, 2, 'Các Thuật Toán Cơ Bản', 'Chương này giới thiệu các thuật toán cơ bản trong học máy, bao gồm hồi quy, phân loại, và clustering. Nó cung cấp hướng dẫn về cách các thuật toán này hoạt động và cách áp dụng chúng.')," +
                "(3, 3, 'Tiền Xử Lý Dữ Liệu', 'Tiền xử lý dữ liệu là bước quan trọng trong quy trình học máy. Chương này giải thích các kỹ thuật tiền xử lý dữ liệu, bao gồm làm sạch dữ liệu, chuyển đổi và chọn lọc đặc trưng.')," +
                "(3, 4, 'Đánh Giá Mô Hình', 'Chương này tập trung vào việc đánh giá hiệu suất của các mô hình học máy. Nó giải thích các chỉ số đánh giá như độ chính xác, độ hồi phục và điểm F1.')," +
                "(3, 5, 'Ứng Dụng Học Máy', 'Chương này trình bày các ứng dụng thực tế của học máy trong các lĩnh vực như nhận diện hình ảnh, xử lý ngôn ngữ tự nhiên, và phân tích dự đoán.')," +

                "(4, 1, 'Giới thiệu về C++', 'C++ là một ngôn ngữ lập trình mạnh mẽ với nhiều tính năng. Chương này cung cấp cái nhìn tổng quan về C++ và những ứng dụng chính của nó trong phát triển phần mềm.')," +
                "(4, 2, 'Cấu Trúc Cơ Bản của C++', 'Chương này giới thiệu các cấu trúc cơ bản trong C++, bao gồm biến, kiểu dữ liệu, và toán tử. Nó cung cấp hướng dẫn chi tiết về cách sử dụng các cấu trúc này trong lập trình.')," +
                "(4, 3, 'Lập Trình Hướng Đối Tượng trong C++', 'Chương này đi sâu vào lập trình hướng đối tượng trong C++, giải thích các khái niệm như lớp, đối tượng, kế thừa và đa hình.')," +
                "(4, 4, 'Xử Lý Ngoại Lệ trong C++', 'Chương này giải thích về xử lý ngoại lệ trong C++, bao gồm cách sử dụng try-catch và các kỹ thuật xử lý lỗi khác để đảm bảo ứng dụng hoạt động ổn định.')," +
                "(4, 5, 'Tối Ưu Hóa Hiệu Suất', 'Chương này cung cấp các kỹ thuật tối ưu hóa hiệu suất trong C++, bao gồm cách cải thiện tốc độ thực thi và giảm thiểu sự tiêu tốn tài nguyên.')," +

                "(5, 1, 'Nhập Môn về Web Development', 'Web Development (Phát triển web) là một lĩnh vực rộng lớn với nhiều công nghệ khác nhau. Chương này cung cấp cái nhìn tổng quan về phát triển web và các công nghệ chính.')," +
                "(5, 2, 'HTML và CSS', 'Chương này giới thiệu HTML và CSS, hai công nghệ cơ bản trong phát triển web. Nó giải thích cách sử dụng chúng để xây dựng và thiết kế trang web.')," +
                "(5, 3, 'JavaScript và các Thư Viện', 'Chương này khám phá JavaScript và các thư viện phổ biến như jQuery. Nó cung cấp hướng dẫn về cách sử dụng JavaScript để thêm tính năng động vào trang web.')," +
                "(5, 4, 'Phát Triển Ứng Dụng Web với React', 'Chương này giới thiệu React, một thư viện JavaScript mạnh mẽ để phát triển giao diện người dùng. Nó cung cấp hướng dẫn về cách tạo và quản lý các thành phần trong React.')," +
                "(5, 5, 'Triển Khai và Bảo Trì', 'Chương cuối cùng tập trung vào triển khai và bảo trì ứng dụng web. Nó bao gồm các phương pháp triển khai ứng dụng và cách bảo trì và nâng cấp chúng trong quá trình sử dụng.')," +

                "(6, 1, 'Khám Phá Python', 'Python là một ngôn ngữ lập trình dễ học và mạnh mẽ. Chương này cung cấp cái nhìn tổng quan về Python và các ứng dụng chính của nó.')," +
                "(6, 2, 'Cấu Trúc Cơ Bản', 'Chương này giới thiệu cấu trúc cơ bản của Python, bao gồm biến, kiểu dữ liệu, và các cấu trúc điều khiển. Nó cung cấp hướng dẫn về cách sử dụng chúng trong lập trình.')," +
                "(6, 3, 'Lập Trình Hướng Đối Tượng', 'Chương này đi sâu vào lập trình hướng đối tượng trong Python, giải thích các khái niệm như lớp, đối tượng, kế thừa và đa hình.')," +
                "(6, 4, 'Xử Lý Ngoại Lệ', 'Chương này giải thích cách xử lý ngoại lệ trong Python để đảm bảo mã nguồn hoạt động ổn định và hiệu quả.')," +
                "(6, 5, 'Các Thư Viện và Công Cụ Python', 'Chương này khám phá các thư viện phổ biến trong Python và cách sử dụng chúng để phát triển các ứng dụng mạnh mẽ.')," +

                "(7, 1, 'Giới thiệu về Android', 'Android là hệ điều hành di động phổ biến. Chương này cung cấp cái nhìn tổng quan về Android và cách phát triển ứng dụng cho nền tảng này.')," +
                "(7, 2, 'Cấu Trúc Ứng Dụng Android', 'Chương này giới thiệu cấu trúc cơ bản của ứng dụng Android, bao gồm Activity, Fragment, và các thành phần khác.')," +
                "(7, 3, 'Thiết Kế Giao Diện Người Dùng', 'Chương này tập trung vào thiết kế giao diện người dùng trong Android, bao gồm cách sử dụng XML để tạo layout và các yếu tố giao diện khác.')," +
                "(7, 4, 'Quản Lý Dữ Liệu', 'Chương này giải thích cách quản lý dữ liệu trong ứng dụng Android, bao gồm việc sử dụng SQLite và các phương pháp lưu trữ dữ liệu khác.')," +
                "(7, 5, 'Triển Khai và Bảo Trì', 'Chương cuối cùng cung cấp các phương pháp triển khai ứng dụng Android và bảo trì ứng dụng sau khi phát hành.')," +

                "(8, 1, 'Nhập Môn về SQL', 'SQL (Structured Query Language) là ngôn ngữ quản lý cơ sở dữ liệu. Chương này cung cấp cái nhìn tổng quan về SQL và các lệnh cơ bản.')," +
                "(8, 2, 'Các Lệnh SQL Cơ Bản', 'Chương này giới thiệu các lệnh SQL cơ bản như SELECT, INSERT, UPDATE, và DELETE. Nó cung cấp hướng dẫn về cách sử dụng các lệnh này để quản lý dữ liệu.')," +
                "(8, 3, 'Xử Lý Dữ Liệu Nâng Cao', 'Chương này khám phá các kỹ thuật xử lý dữ liệu nâng cao trong SQL, bao gồm JOIN, GROUP BY, và các hàm phân tích.')," +
                "(8, 4, 'Tối Ưu Hóa Câu Truy Vấn', 'Chương này cung cấp các phương pháp tối ưu hóa câu truy vấn SQL để cải thiện hiệu suất cơ sở dữ liệu.')," +
                "(8, 5, 'Quản Lý Cơ Sở Dữ Liệu', 'Chương cuối cùng tập trung vào các kỹ thuật quản lý cơ sở dữ liệu, bao gồm sao lưu, phục hồi và bảo mật.')," +

                "(9, 1, 'Giới thiệu về DevOps', 'DevOps là một phương pháp tiếp cận mới trong phát triển phần mềm. Chương này cung cấp cái nhìn tổng quan về DevOps và các nguyên tắc chính.')," +
                "(9, 2, 'Quy Trình DevOps', 'Chương này giới thiệu quy trình DevOps, bao gồm các bước từ phát triển đến triển khai và bảo trì.')," +
                "(9, 3, 'Công Cụ DevOps', 'Chương này khám phá các công cụ phổ biến trong DevOps như Jenkins, Docker, và Kubernetes. Nó cung cấp hướng dẫn về cách sử dụng các công cụ này để cải thiện quy trình phát triển.')," +
                "(9, 4, 'Tự Động Hóa và Triển Khai Liên Tục', 'Chương này tập trung vào tự động hóa và triển khai liên tục trong DevOps, giải thích cách các kỹ thuật này giúp tăng tốc độ phát triển và cải thiện chất lượng sản phẩm.')," +
                "(9, 5, 'Theo Dõi và Phân Tích', 'Chương cuối cùng cung cấp các phương pháp theo dõi và phân tích trong DevOps để đảm bảo ứng dụng hoạt động hiệu quả và phát hiện sớm các vấn đề.')," +

                "(10, 1, 'Giới thiệu về Hệ Thống Đề Thao', 'Hệ thống đề thao là một lĩnh vực nghiên cứu quan trọng trong khoa học máy tính. Chương này cung cấp cái nhìn tổng quan về hệ thống đề thao và ứng dụng của nó.')," +
                "(10, 2, 'Các Thành Phần Của Hệ Thống Đề Thao', 'Chương này giới thiệu các thành phần chính của hệ thống đề thao, bao gồm phần mềm, phần cứng và các giao thức.')," +
                "(10, 3, 'Thiết Kế Hệ Thống Đề Thao', 'Chương này giải thích các nguyên tắc thiết kế hệ thống đề thao, bao gồm các kỹ thuật và phương pháp để phát triển hệ thống hiệu quả.')," +
                "(10, 4, 'Triển Khai và Quản Lý', 'Chương này tập trung vào việc triển khai và quản lý hệ thống đề thao, bao gồm các kỹ thuật bảo trì và nâng cấp hệ thống.')," +
                "(10, 5, 'Tương Lai và Xu Hướng Mới', 'Chương cuối cùng thảo luận về tương lai của hệ thống đề thao và các xu hướng mới nổi trong lĩnh vực này.')," +

                "(11, 1, 'Nhập Môn về Thực Tế Ảo', 'Thực tế ảo là một công nghệ đang phát triển nhanh chóng. Chương này cung cấp cái nhìn tổng quan về thực tế ảo và các ứng dụng của nó.')," +
                "(11, 2, 'Công Nghệ Thực Tế Ảo', 'Chương này giới thiệu các công nghệ cơ bản trong thực tế ảo, bao gồm phần mềm, phần cứng và các giao thức.')," +
                "(11, 3, 'Phát Triển Ứng Dụng Thực Tế Ảo', 'Chương này giải thích cách phát triển ứng dụng thực tế ảo, bao gồm các công cụ và kỹ thuật để xây dựng các trải nghiệm VR hấp dẫn.')," +
                "(11, 4, 'Thiết Kế Trải Nghiệm VR', 'Chương này tập trung vào thiết kế trải nghiệm thực tế ảo, bao gồm các yếu tố thiết kế cần cân nhắc để tạo ra trải nghiệm hấp dẫn và dễ sử dụng.')," +
                "(11, 5, 'Tương Lai của Thực Tế Ảo', 'Chương cuối cùng thảo luận về tương lai của thực tế ảo và các xu hướng mới trong công nghệ này.')," +

                "(12, 1, 'Giới thiệu về Blockchain', 'Blockchain là công nghệ nền tảng cho các loại tiền tệ kỹ thuật số như Bitcoin. Chương này cung cấp cái nhìn tổng quan về blockchain và các ứng dụng của nó.')," +
                "(12, 2, 'Nguyên Tắc Hoạt Động của Blockchain', 'Chương này giải thích các nguyên tắc hoạt động cơ bản của blockchain, bao gồm các khối, chuỗi khối và giao thức đồng thuận.')," +
                "(12, 3, 'Ứng Dụng Blockchain', 'Chương này khám phá các ứng dụng thực tế của blockchain ngoài tiền tệ kỹ thuật số, bao gồm các hợp đồng thông minh và ứng dụng phi tập trung.')," +
                "(12, 4, 'Bảo Mật trong Blockchain', 'Chương này tập trung vào các vấn đề bảo mật trong blockchain, bao gồm các kỹ thuật mã hóa và cách bảo vệ dữ liệu.')," +
                "(12, 5, 'Tương Lai của Blockchain', 'Chương cuối cùng thảo luận về tương lai của blockchain và các xu hướng mới trong công nghệ này.')," +

                "(13, 1, 'Nhập Môn về Data Science', 'Data Science là một lĩnh vực quan trọng trong phân tích dữ liệu. Chương này cung cấp cái nhìn tổng quan về data science và các công cụ chính.')," +
                "(13, 2, 'Kỹ Thuật Phân Tích Dữ Liệu', 'Chương này giới thiệu các kỹ thuật phân tích dữ liệu cơ bản, bao gồm thống kê, học máy và phân tích dữ liệu lớn.')," +
                "(13, 3, 'Xử Lý Dữ Liệu', 'Chương này giải thích các kỹ thuật xử lý dữ liệu, bao gồm làm sạch dữ liệu, biến đổi dữ liệu và kỹ thuật tiền xử lý.')," +
                "(13, 4, 'Trực Quan Hóa Dữ Liệu', 'Chương này tập trung vào các kỹ thuật trực quan hóa dữ liệu, bao gồm các công cụ và kỹ thuật để tạo ra các biểu đồ và báo cáo dữ liệu.')," +
                "(13, 5, 'Ứng Dụng Data Science', 'Chương cuối cùng thảo luận về các ứng dụng thực tế của data science trong các lĩnh vực khác nhau, từ phân tích kinh doanh đến nghiên cứu khoa học.')," +

                "(14, 1, 'Giới thiệu về Internet of Things', 'Internet of Things (IoT) là một công nghệ quan trọng trong kết nối thiết bị. Chương này cung cấp cái nhìn tổng quan về IoT và các ứng dụng của nó.')," +
                "(14, 2, 'Các Thành Phần của IoT', 'Chương này giới thiệu các thành phần chính của hệ thống IoT, bao gồm cảm biến, thiết bị và nền tảng kết nối.')," +
                "(14, 3, 'Phát Triển Ứng Dụng IoT', 'Chương này giải thích cách phát triển ứng dụng IoT, bao gồm các công cụ và kỹ thuật để xây dựng và quản lý hệ thống IoT.')," +
                "(14, 4, 'Bảo Mật trong IoT', 'Chương này tập trung vào các vấn đề bảo mật trong IoT, bao gồm các nguy cơ và các biện pháp bảo vệ dữ liệu và thiết bị.')," +
                "(14, 5, 'Tương Lai của IoT', 'Chương cuối cùng thảo luận về tương lai của IoT và các xu hướng mới trong công nghệ kết nối thiết bị.')," +

                "(15, 1, 'Giới thiệu về UX Design', 'UX Design (Thiết kế trải nghiệm người dùng) là một lĩnh vực quan trọng trong thiết kế sản phẩm. Chương này cung cấp cái nhìn tổng quan về UX Design và các yếu tố chính.')," +
                "(15, 2, 'Nguyên Tắc Thiết Kế UX', 'Chương này giới thiệu các nguyên tắc thiết kế UX, bao gồm khả năng sử dụng, tính khả thi và khả năng tiếp cận.')," +
                "(15, 3, 'Nghiên Cứu Người Dùng', 'Chương này giải thích các phương pháp nghiên cứu người dùng, bao gồm khảo sát, phỏng vấn và thử nghiệm người dùng.')," +
                "(15, 4, 'Thiết Kế và Kiểm Tra', 'Chương này tập trung vào quy trình thiết kế và kiểm tra UX, bao gồm tạo wireframes, prototypes và kiểm tra khả năng sử dụng.')," +
                "(15, 5, 'Tương Lai của UX Design', 'Chương cuối cùng thảo luận về tương lai của UX Design và các xu hướng mới trong lĩnh vực này.')," +

                "(16, 1, 'Nhập Môn về Big Data', 'Big Data là một lĩnh vực quan trọng trong phân tích dữ liệu. Chương này cung cấp cái nhìn tổng quan về Big Data và các công cụ chính.')," +
                "(16, 2, 'Kỹ Thuật Phân Tích Big Data', 'Chương này giới thiệu các kỹ thuật phân tích Big Data, bao gồm các công cụ và phương pháp để xử lý dữ liệu lớn.')," +
                "(16, 3, 'Hệ Thống Quản Lý Big Data', 'Chương này giải thích các hệ thống quản lý Big Data, bao gồm Hadoop, Spark và các công nghệ tương tự.')," +
                "(16, 4, 'Trực Quan Hóa Big Data', 'Chương này tập trung vào các kỹ thuật trực quan hóa Big Data, bao gồm các công cụ và kỹ thuật để tạo ra các biểu đồ và báo cáo dữ liệu.')," +
                "(16, 5, 'Ứng Dụng Big Data', 'Chương cuối cùng thảo luận về các ứng dụng thực tế của Big Data trong các lĩnh vực khác nhau, từ phân tích kinh doanh đến nghiên cứu khoa học.')," +

                "(17, 1, 'Giới thiệu về Cyber Security', 'Cyber Security (Bảo mật mạng) là một lĩnh vực quan trọng trong bảo vệ hệ thống máy tính. Chương này cung cấp cái nhìn tổng quan về Cyber Security và các kỹ thuật chính.')," +
                "(17, 2, 'Các Nguy Cơ và Tấn Công', 'Chương này giới thiệu các nguy cơ và các loại tấn công mạng phổ biến, bao gồm virus, malware và tấn công DDoS.')," +
                "(17, 3, 'Kỹ Thuật Bảo Mật', 'Chương này giải thích các kỹ thuật bảo mật, bao gồm mã hóa, kiểm soát truy cập và các phương pháp phòng chống tấn công.')," +
                "(17, 4, 'Đánh Giá và Quản Lý Rủi Ro', 'Chương này tập trung vào việc đánh giá và quản lý rủi ro trong bảo mật mạng, bao gồm phân tích rủi ro và các phương pháp giảm thiểu rủi ro.')," +
                "(17, 5, 'Tương Lai của Cyber Security', 'Chương cuối cùng thảo luận về tương lai của Cyber Security và các xu hướng mới trong lĩnh vực bảo mật mạng.')," +

                "(18, 1, 'Giới thiệu về Game Development', 'Game Development (Phát triển trò chơi) là một lĩnh vực rộng lớn và sáng tạo. Chương này cung cấp cái nhìn tổng quan về phát triển trò chơi và các công cụ chính.')," +
                "(18, 2, 'Các Kỹ Thuật Lập Trình Game', 'Chương này giới thiệu các kỹ thuật lập trình game, bao gồm các công cụ và ngôn ngữ lập trình phổ biến trong phát triển trò chơi.')," +
                "(18, 3, 'Thiết Kế và Đồ Họa', 'Chương này giải thích các nguyên tắc thiết kế trò chơi và đồ họa, bao gồm cách tạo ra các hình ảnh và hiệu ứng trong trò chơi.')," +
                "(18, 4, 'Phát Triển và Kiểm Tra Game', 'Chương này tập trung vào quy trình phát triển và kiểm tra trò chơi, bao gồm các bước từ lập kế hoạch đến triển khai và kiểm tra trò chơi.')," +
                "(18, 5, 'Tương Lai của Game Development', 'Chương cuối cùng thảo luận về tương lai của phát triển trò chơi và các xu hướng mới trong công nghệ game.')," +

                "(19, 1, 'Giới thiệu về Cloud Computing', 'Cloud Computing (Điện toán đám mây) là một công nghệ quan trọng trong phát triển ứng dụng. Chương này cung cấp cái nhìn tổng quan về điện toán đám mây và các dịch vụ chính.')," +
                "(19, 2, 'Các Dịch Vụ Cloud', 'Chương này giới thiệu các dịch vụ điện toán đám mây phổ biến, bao gồm IaaS, PaaS và SaaS.')," +
                "(19, 3, 'Quản Lý Dữ Liệu trên Cloud', 'Chương này giải thích cách quản lý dữ liệu trên điện toán đám mây, bao gồm các kỹ thuật lưu trữ và bảo mật dữ liệu.')," +
                "(19, 4, 'Triển Khai và Quản Lý Ứng Dụng trên Cloud', 'Chương này tập trung vào việc triển khai và quản lý ứng dụng trên điện toán đám mây, bao gồm các công cụ và phương pháp để đảm bảo hiệu suất và bảo mật.')," +
                "(19, 5, 'Tương Lai của Cloud Computing', 'Chương cuối cùng thảo luận về tương lai của điện toán đám mây và các xu hướng mới trong công nghệ này.')," +

                "(20, 1, 'Nhập Môn về Artificial Intelligence', 'Artificial Intelligence (Trí tuệ nhân tạo) là một lĩnh vực quan trọng trong công nghệ. Chương này cung cấp cái nhìn tổng quan về trí tuệ nhân tạo và các ứng dụng của nó.')," +
                "(20, 2, 'Các Thuật Toán AI', 'Chương này giới thiệu các thuật toán AI cơ bản, bao gồm học máy, học sâu và các phương pháp khác.')," +
                "(20, 3, 'Xử Lý Dữ Liệu AI', 'Chương này giải thích cách xử lý dữ liệu trong trí tuệ nhân tạo, bao gồm các kỹ thuật tiền xử lý và phân tích dữ liệu.')," +
                "(20, 4, 'Ứng Dụng AI', 'Chương này tập trung vào các ứng dụng thực tế của trí tuệ nhân tạo trong các lĩnh vực như nhận diện hình ảnh, xử lý ngôn ngữ tự nhiên và tự động hóa.')," +
                "(20, 5, 'Tương Lai của AI', 'Chương cuối cùng thảo luận về tương lai của trí tuệ nhân tạo và các xu hướng mới trong công nghệ này.')";

        String insertChapter2 = "INSERT INTO chapter (id_book, chap_number, titlechap, content) VALUES " +
                "(2, 1, 'Introduction', 'Java is an important developed language. It is one of the first language appeared.')," +
                "(2, 2, 'Welcome to Java', 'Java is used to develop many app as well as game, especialy is Minecraft.')," +
                "(2, 3, 'Decasia: The State of Decay', 'Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.')," +
                "(2, 4, 'Tales from the Golden Age (Amintiri din epoca de aur)', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum.')";


        db.execSQL(insertChapter1);
        db.execSQL(insertChapter2);
        db.execSQL(insertChapter3);

        String[] insertBookCategories = {
                "INSERT INTO bookcate (id_book, id_cate) VALUES (1, 1)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (1, 2)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (2, 3)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (2, 4)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (3, 5)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (3, 6)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (4, 7)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (4, 8)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (5, 9)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (5, 10)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (6, 1)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (6, 2)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (7, 3)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (7, 4)"
        };

        for (String sql : insertBookCategories) {
            db.execSQL(sql);
        }

        String[] insertBookCategoriesExtended = {
                // Book ID 8
                "INSERT INTO bookcate (id_book, id_cate) VALUES (8, 1)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (8, 3)",

                // Book ID 9
                "INSERT INTO bookcate (id_book, id_cate) VALUES (9, 2)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (9, 4)",

                // Book ID 10
                "INSERT INTO bookcate (id_book, id_cate) VALUES (10, 5)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (10, 6)",

                // Book ID 11
                "INSERT INTO bookcate (id_book, id_cate) VALUES (11, 7)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (11, 8)",

                // Book ID 12
                "INSERT INTO bookcate (id_book, id_cate) VALUES (12, 9)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (12, 10)",

                // Book ID 13
                "INSERT INTO bookcate (id_book, id_cate) VALUES (13, 1)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (13, 2)",

                // Book ID 14
                "INSERT INTO bookcate (id_book, id_cate) VALUES (14, 3)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (14, 4)",

                // Book ID 15
                "INSERT INTO bookcate (id_book, id_cate) VALUES (15, 5)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (15, 6)",

                // Book ID 16
                "INSERT INTO bookcate (id_book, id_cate) VALUES (16, 7)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (16, 8)",

                // Book ID 17
                "INSERT INTO bookcate (id_book, id_cate) VALUES (17, 9)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (17, 10)",

                // Book ID 18
                "INSERT INTO bookcate (id_book, id_cate) VALUES (18, 1)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (18, 3)",

                // Book ID 19
                "INSERT INTO bookcate (id_book, id_cate) VALUES (19, 2)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (19, 4)",

                // Book ID 20
                "INSERT INTO bookcate (id_book, id_cate) VALUES (20, 5)",
                "INSERT INTO bookcate (id_book, id_cate) VALUES (20, 6)"
        };

        for (String sql : insertBookCategoriesExtended) {
            db.execSQL(sql);
        }

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
