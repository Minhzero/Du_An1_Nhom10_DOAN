package minhnqph38692.fpoly.du_an1_nhom10_doan.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class User_DAO {
    MyDbHelper myDbHelper ;
    SQLiteDatabase db;
    public User_DAO(Context context){
        myDbHelper = new MyDbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }

    public long Insert_User(User_DTO userDto){
        ContentValues values = new ContentValues();
        values.put("MaND",userDto.getMaND());
        values.put("HoTen",userDto.getHoTen());
        values.put("MatKhau",userDto.getMatKhau());
        values.put("Email",userDto.getEmail());
        values.put("NamSinh",userDto.getNamSinh());
        values.put("SDT",userDto.getSDT());

        return db.insert("dt_nguoidung",null,values);

    }
    public int Update_User(User_DTO userDto){
        ContentValues values = new ContentValues();
        values.put("MaND",userDto.getMaND());
        values.put("HoTen",userDto.getHoTen());
        values.put("MatKhau",userDto.getMatKhau());
        values.put("Email",userDto.getEmail());
        values.put("NamSinh",userDto.getNamSinh());
        values.put("SDT",userDto.getSDT());
        String[] dk = new String[]{userDto.getMaND()};

        return db.update("dt_nguoidung",values,"MaND=?",dk);

    }

    public int Delete_User(User_DTO userDto){
        String[] dk = new String[]{userDto.getMaND()};

        return db.delete("dt_nguoidung","MaND=?",dk);

    }

    public List<User_DTO> getData(String sql, String...selectionArgs){
        List<User_DTO> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        if(c!= null && c.getCount()>0){
            c.moveToFirst();
            do {
                User_DTO userDto = new User_DTO();
                userDto.setMaND(c.getString(0));
                userDto.setHoTen(c.getString(1));
                userDto.setMatKhau(c.getString(2));
                userDto.setEmail(c.getString(3));
                userDto.setNamSinh(c.getString(4));
                userDto.setSDT(c.getString(5));

                list.add(userDto);

            }while (c.moveToNext());
        }
        return list;
    }

    public List<User_DTO> getAll(){
        String sql = "SELECT * FROM dt_nguoidung";
        return getData(sql);
    }

    public User_DTO getID(String id){
        String sql = "SELECT * FROM dt_nguoidung WHERE MaND=?";
        List<User_DTO> list = getData(sql,id);

        return list.get(0);
    }

    public boolean checkLogin(String user , String pass){
        Cursor c = db.rawQuery("SELECT * FROM dt_nguoidung WHERE MaND=? AND MatKhau=?",new String[]{user,pass});
        if(c.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}
