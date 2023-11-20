package minhnqph38692.fpoly.du_an1_nhom10_doan.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class DoAn_DAO {
    MyDbHelper myDbHelper ;
    SQLiteDatabase db;

    public DoAn_DAO(MyDbHelper myDbHelper, SQLiteDatabase db) {
        this.myDbHelper = myDbHelper;
        this.db = db;
    }
    public long insertDoAn(DoAn_DTO doAn_dto){
        ContentValues values= new ContentValues();
        values.put("madoan",doAn_dto.getMadoan());
        values.put("tendoan",doAn_dto.getTendoan());
        values.put("giadoan",doAn_dto.getGiadoan());
        values.put("maloai",doAn_dto.getMaloai());
        values.put("tenloai",doAn_dto.getTenloai());
        values.put("thongtin",doAn_dto.getThongtin());
         return db.insert("dt_doan",null,values);
    }

    public List<DoAn_DTO> getAll(){
        List<DoAn_DTO> list= new ArrayList<>();
        SQLiteDatabase db = myDbHelper.getWritableDatabase();

        Cursor c=db.rawQuery("SELECT * FROM dt_doan",null);
if (c!=null && c.getCount()>0){
c.moveToFirst();
do {
    String ma=c.getString(0);
    String ten=c.getString(1);
    int gia=c.getInt(2);
    int maloai=c.getInt(3);
    String tenloai=c.getString(4);
    String thongtin=c.getString(5);

DoAn_DTO doAn_dto= new DoAn_DTO();

doAn_dto.setMadoan(ma);
doAn_dto.setTendoan(ten);
doAn_dto.setGiadoan(gia);
doAn_dto.setMaloai(maloai);
doAn_dto.setTenloai(tenloai);
doAn_dto.setThongtin(thongtin);
list.add(doAn_dto);


}while (c.moveToNext());
}
return list;
    }
}
