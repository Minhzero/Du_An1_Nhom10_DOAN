package minhnqph38692.fpoly.du_an1_nhom10_doan.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class HoaDon_DAO {
    MyDbHelper myDbHelper ;
    SQLiteDatabase db;

    public HoaDon_DAO(Context context) {
        myDbHelper = new MyDbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }
    public static ArrayList<HoaDon_DTO> getAll(){
        String sql = "SELECT * FROM dt_hoadon";
        return getData(sql);
    }
    public ArrayList<HoaDon_DTO> getData(String sql,String...selectionArgs){
        ArrayList<HoaDon_DTO> list= new ArrayList<>();
        Cursor c=db.rawQuery(sql,selectionArgs);
        if (c!=null && c.getCount()>0){
            c.moveToFirst();
            do {
                int madon=c.getInt(0);
                String Email=c.getString(1);
                String hoten=c.getString(2);
                String sdt=c.getString(3);
                String diachi=c.getString(4);
                String thucdon =c.getString(5);
                String ngaydat=c.getString(6);
                int tongtien=c.getInt(7);
                String thanhtoan=c.getString(8);
                int trangthai=c.getInt(9);

                HoaDon_DTO hoaDon_dto=new HoaDon_DTO();

                hoaDon_dto.setMahoadon(madon);
                hoaDon_dto.setEmail(Email);
                hoaDon_dto.setHoten(hoten);
                hoaDon_dto.setSDT(sdt);
                hoaDon_dto.setDiachinhan(diachi);
                hoaDon_dto.setThucdon(thucdon);
                hoaDon_dto.setNgaydathang(ngaydat);
                hoaDon_dto.setTongtien(tongtien);
                hoaDon_dto.setThanhtoan(thanhtoan);
                hoaDon_dto.setTrangthai(trangthai);
                list.add(hoaDon_dto);


            }while (c.moveToNext());
        }
        return list;
    }


}
