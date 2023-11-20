package minhnqph38692.fpoly.du_an1_nhom10_doan.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class DoAn_DAO {
    MyDbHelper myDbHelper ;
    SQLiteDatabase db;

    public DoAn_DAO(Context context) {
        myDbHelper = new MyDbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }
    public long insertDoAn(DoAn_DTO doAn_dto){
        ContentValues values= new ContentValues();
        values.put("tendoan",doAn_dto.getTendoan());
        values.put("giadoan",doAn_dto.getGiadoan());
        values.put("maloai",doAn_dto.getMaloai());
        values.put("tenloai",doAn_dto.getTenloai());
        values.put("thongtin",doAn_dto.getThongtin());
         return db.insert("dt_doan",null,values);
    }
    public int Update_DoAn(DoAn_DTO doAn_dto){
        ContentValues values= new ContentValues();
        values.put("tendoan",doAn_dto.getTendoan());
        values.put("giadoan",doAn_dto.getGiadoan());
        values.put("maloai",doAn_dto.getMaloai());
        values.put("tenloai",doAn_dto.getTenloai());
        values.put("thongtin",doAn_dto.getThongtin());
        String[] dk = new String[]{String.valueOf(doAn_dto.getMadoan())};

        return db.update("dt_doan",values,"madoan=?",dk);
    }
    public int Delete_DoAn(DoAn_DTO doAn_dto){
        String[] dk = new String[]{String.valueOf(doAn_dto.getMadoan())};

        return db.delete("dt_doan","madoan=?",dk);

    }

    public ArrayList<DoAn_DTO> getAll(){
        String sql = "SELECT * FROM dt_doan";
        return getData(sql);
    }
    public DoAn_DTO getID(String id){
        String sql = "SELECT * FROM dt_doan WHERE madoan=?";
        List<DoAn_DTO> list = getData(sql,id);

        return list.get(0);
    }


    public ArrayList<DoAn_DTO> getData(String sql , String...selectionArgs){
        ArrayList<DoAn_DTO> list= new ArrayList<>();

        Cursor c=db.rawQuery(sql,selectionArgs);
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
