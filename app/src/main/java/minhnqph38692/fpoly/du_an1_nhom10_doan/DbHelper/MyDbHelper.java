package minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "duan_datdoan";
    static final int DB_VERSION=9;

    public MyDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_nguoidung = "CREATE TABLE dt_nguoidung (\n" +
                "    maTV INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    MaND    TEXT NOT NULL\n" +
                "                 NOT NULL,\n" +
                "    HoTen   TEXT NOT NULL,\n" +
                "    MatKhau TEXT NOT NULL,\n" +
                "    Email   TEXT NOT NULL,\n" +
                "    NamSinh TEXT ,\n" +
                "    SDT     TEXT\n" +
                ");\n";

        sqLiteDatabase.execSQL(sql_nguoidung);
        String mauUSer ="INSERT INTO dt_nguoidung " +
                "VALUES (1,'admin','Quản lý','admin','helo@gmail.com','2004','012345678')," +
                "(2,'nguoidung01','Người dùng','nguoidung01','nguoidung@gmail.com','2005','123456789')";
        sqLiteDatabase.execSQL(mauUSer);
        String sql_Loai = "CREATE TABLE dt_loai (maloai integer primary key not null, tenloai text not null)";
        sqLiteDatabase.execSQL(sql_Loai);
        String mauLoai = "INSERT INTO dt_loai values('1','com'),('2','bun')";
        sqLiteDatabase.execSQL(mauLoai);

        String sql_doan = "CREATE TABLE dt_doan(madoan integer primary key not null ,tendoan text not null,giadoan integer not null, maloai integer references dt_loai(maloai)  not null,tenloai text not null,thongtin integer not null )";
        sqLiteDatabase.execSQL(sql_doan);
        String doan_1= "INSERT INTO dt_doan values('1','com rang',1000,1,'com','com rat ngon')";
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
