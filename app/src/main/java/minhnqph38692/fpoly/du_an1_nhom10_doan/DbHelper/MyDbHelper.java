package minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "duan_datdoan";
    static final int DB_VERSION=14;

    public MyDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_nguoidung = "CREATE TABLE dt_nguoidung (\n" +
                "    maTV INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    MaND    TEXT NOT NULL,\n" +
                "    HoTen   TEXT NOT NULL,\n" +
                "    MatKhau TEXT NOT NULL,\n" +
                "    Email   TEXT NOT NULL,\n" +
                "    NamSinh TEXT ,\n" +
                "    SDT     TEXT,\n" +
                "    LoaiTaiKhoan TEXT\n" +
                ");\n";

        sqLiteDatabase.execSQL(sql_nguoidung);
        String mauUSer ="INSERT INTO dt_nguoidung " +
                "VALUES (1,'admin','Quản lý','admin','helo@gmail.com','2004','012345678','admin')," +
                "(2,'nguoidung01','Người dùng','nguoidung01','nguoidung@gmail.com','2005','123456789','user')";
        sqLiteDatabase.execSQL(mauUSer);
        String sql_Loai = "CREATE TABLE dt_loai (maloai integer primary key not null, tenloai text not null)";
        sqLiteDatabase.execSQL(sql_Loai);
        String mauLoai = "INSERT INTO dt_loai values('1','com'),('2','bun')";
        sqLiteDatabase.execSQL(mauLoai);

        String sql_doan = "CREATE TABLE dt_doan(madoan integer primary key not null ,tendoan text not null,giadoan integer not null, maloai integer references dt_loai(maloai)  not null,thongtin integer not null,anh text )";
        sqLiteDatabase.execSQL(sql_doan);
        String doan_1= "INSERT INTO dt_doan values('1','com rang',1000,1,'com rat ngon','https://lh3.googleusercontent.com/CB-FFqhq6t5UbEnTKo0Rw6fX1gtO89k4ZPDZLHDNW09Gv9JH89xeaqohwsq6xzfuEHAooiFLhMbDgl_zkKrRP8fBLZk=w622')";
        sqLiteDatabase.execSQL(doan_1);
        String doan_2= "INSERT INTO dt_doan values('2','bun cha ',1000,2,'bun rat ngon','https://bizweb.dktcdn.net/100/442/328/products/bun-cha-ha-noi.jpg?v=1644892472637')";
        sqLiteDatabase.execSQL(doan_2);
        String sql_doanphu="CREATE TABLE dt_doanphu (\n" +
                "    MaDoAnPhu  INTEGER PRIMARY KEY,\n" +
                "    TenDoAnPhu TEXT    NOT NULL\n" +
                ");\n";
        sqLiteDatabase.execSQL(sql_doanphu);
        String doanphu="INSERT INTO dt_doanphu(TenDoAnPhu) VALUES ('GIo'),('Cha')";
        sqLiteDatabase.execSQL(doanphu);
String sql_hoadon="CREATE TABLE dt_hoadon(mahoadon integer primary key,Email text not null,hoten text,SDT text not null,diachinhan text not null, thucdon text ,ngaydathang text,tongtien integer ,thanhtoan text,trangthai integer)";
sqLiteDatabase.execSQL(sql_hoadon);
        String mauhoadon = "INSERT INTO dt_hoadon values('1','nguoidung@gmail.com','Người dùng','123456789','ha noi','com rang','22/2/2002',12000,'tien mat',1)";
        sqLiteDatabase.execSQL(mauhoadon);

        String giohang = "CREATE TABLE dt_giohang(masp integer primary key not null ,tensp text not null,tendoanphu text," +
                "giasp integer not null,soluong integer,anhsp text )";
        sqLiteDatabase.execSQL(giohang);
        String maugh = "INSERT INTO dt_giohang(tensp,tendoanphu,giasp,soluong,anhsp) VALUES ('com rang','gio',12000,2,'https://lh3.googleusercontent.com/CB-FFqhq6t5UbEnTKo0Rw6fX1gtO89k4ZPDZLHDNW09Gv9JH89xeaqohwsq6xzfuEHAooiFLhMbDgl_zkKrRP8fBLZk=w622')," +
                "('bun cha','cha',13000,3,'https://bizweb.dktcdn.net/100/442/328/products/bun-cha-ha-noi.jpg?v=1644892472637')";
        sqLiteDatabase.execSQL(maugh);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_nguoidung");
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_doan");
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_loai");
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_doanphu");
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_hoadon");
        sqLiteDatabase.execSQL("DROP TABLE if exists dt_giohang");

        onCreate(sqLiteDatabase);

    }
}
