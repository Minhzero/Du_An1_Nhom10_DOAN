package minhnqph38692.fpoly.du_an1_nhom10_doan.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class HoaDon_DAO {
    MyDbHelper myDbHelper ;
    static SQLiteDatabase db;

    public HoaDon_DAO(Context context) {
        myDbHelper = new MyDbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }
    public List<HoaDon_DTO> getAll(){
        String sql = "SELECT * FROM dt_hoadon";
        return getData(sql);
    }
    public HoaDon_DTO getID(String id){
        String sql = "SELECT * FROM dt_hoadon WHERE Email=?";
        List <HoaDon_DTO> list = getData(sql,id);
        return list.get(0);
    }

    public static List<HoaDon_DTO> getData(String sql, String... selectionArgs){
        List<HoaDon_DTO> list= new ArrayList<>();
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
