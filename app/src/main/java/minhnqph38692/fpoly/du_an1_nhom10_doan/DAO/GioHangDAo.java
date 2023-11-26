package minhnqph38692.fpoly.du_an1_nhom10_doan.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.GioHangDTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class GioHangDAo {
    MyDbHelper myDbHelper;
    SQLiteDatabase db;

    public GioHangDAo(Context context){
        myDbHelper = new MyDbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }

    public long InsertGH(GioHangDTO gioHangDTO){
        ContentValues values = new ContentValues();
        values.put("tensp",gioHangDTO.getTensp());
        values.put("tendoanphu",gioHangDTO.getTendoanphu());
        values.put("giasp",gioHangDTO.getGiasp());
        values.put("soluong",gioHangDTO.getSoluongsp());
        values.put("anhsp",gioHangDTO.getAnhsp());
        return db.insert("dt_giohang",null,values);

    }
    public int DeleteGH(GioHangDTO gioHangDTO){
        String[] dk = new String[]{String.valueOf(gioHangDTO.getMasp())};
        return db.delete("dt_giohang","masp=?",dk);


    }
    public List<GioHangDTO> getAll(){
        String sql = "SELECT * FROM dt_giohang ";
        return getData(sql);
    }
    public List<GioHangDTO> getData(String sql , String...selectionArgs){
        List<GioHangDTO> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);

        if (c!=null && c.getCount()>0){
            c.moveToFirst();
            do {
                GioHangDTO gioHangDTO = new GioHangDTO();
                gioHangDTO.setMasp(c.getInt(0));
                gioHangDTO.setTensp(c.getString(1));
                gioHangDTO.setTendoanphu(c.getString(2));
                gioHangDTO.setGiasp(c.getInt(3));
                gioHangDTO.setSoluongsp(c.getInt(4));
                gioHangDTO.setAnhsp(c.getString(5));

                list.add(gioHangDTO);
            }while (c.moveToNext());

        }
        return list;
    }
}
