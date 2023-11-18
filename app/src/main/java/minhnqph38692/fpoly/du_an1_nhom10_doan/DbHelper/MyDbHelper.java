package minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "duan_datdoan";
    static final int DB_VERSION=5;

    public MyDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_nguoidung = "CREATE TABLE dt_nguoidung (\n" +
                "    MaND    TEXT PRIMARY KEY\n" +
                "                 ,\n" +
                "    HoTen   TEXT NOT NULL,\n" +
                "    MatKhau TEXT NOT NULL,\n" +
                "    Email   TEXT NOT NULL,\n" +
                "    NamSinh TEXT ,\n" +
                "    SDT     TEXT\n" +
                ");\n";
        sqLiteDatabase.execSQL(sql_nguoidung);
        String mauUSer ="INSERT INTO dt_nguoidung " +
                "VALUES ('admin','Quản lý','admin','helo@gmail.com','2004','012345678')," +
                "('nguoidung01','Người dùng','nguoidung01','nguoidung@gmail.com','2005','123456789')";
        sqLiteDatabase.execSQL(mauUSer);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_nguoidung");
        onCreate(sqLiteDatabase);

    }
}
