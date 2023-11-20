package minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "duan_datdoan";
    static final int DB_VERSION=7;

    public MyDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_nguoidung = "CREATE TABLE dt_nguoidung (\n" +
                "    MaND    TEXT PRIMARY KEY\n" +
                "                 NOT NULL,\n" +
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
        String sql_Loai = "CREATE TABLE dt_loai (maloai integer primary key not null, tenloai text not null)";
        sqLiteDatabase.execSQL(sql_Loai);

        String sql_doan = "CREATE TABLE dt_doan(madoan text primary key not null ,tendoan text not null,giadoan integer not null, maloai integer references dt_loai(maloai)  not null,tenloai text not null,thongtin integer not null, anh text )";
        sqLiteDatabase.execSQL(sql_doan);
        String doan_1= "INSERT INTO dt_doan values('com_1','com rang',1000,001,'com','com rat ngon','anh')";
        sqLiteDatabase.execSQL(doan_1);

        String sql_doanphu="CREATE TABLE dt_doanphu (\n" +
                "    MaDoAnPhu  INTEGER PRIMARY KEY,\n" +
                "    TenDoAnPhu TEXT    NOT NULL\n" +
                ");\n";
        sqLiteDatabase.execSQL(sql_doanphu);
        String doanphu="INSERT INTO dt_doanphu(TenDoAnPhu) VALUES ('GIo'),('Cha')";
        sqLiteDatabase.execSQL(doanphu);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_nguoidung");
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_doan");
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_loai");
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_doanphu");
        onCreate(sqLiteDatabase);

    }
}
