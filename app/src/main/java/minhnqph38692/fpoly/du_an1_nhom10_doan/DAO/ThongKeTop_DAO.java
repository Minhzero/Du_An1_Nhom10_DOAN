package minhnqph38692.fpoly.du_an1_nhom10_doan.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.ThongkeTop_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class ThongKeTop_DAO {

    SQLiteDatabase db;
    MyDbHelper myDbHelper;

    public ThongKeTop_DAO(Context context){
        myDbHelper = new MyDbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }

    //thong ke top 10
    public List<ThongkeTop_DTO> getTop(){
        String sqlTop= "SELECT hd.thucdon, COUNT(hd.thucdon)\n" +
                "FROM dt_hoadon hd \n" +
                "WHERE hd.thucdon \n" +
                "GROUP By hd.thucdon\n" +
                "ORDER by COUNT (hd.thucdon) DESC \n" +
                "LIMIT 10";
        List<ThongkeTop_DTO> list = new ArrayList<>();
        Cursor c = db.rawQuery(sqlTop,null);
        if(c.getCount()>0){
            while (c.moveToNext()){
                ThongkeTop_DTO thongkeTopDto = new ThongkeTop_DTO();
                thongkeTopDto.setTenmonan(c.getString(0));
                thongkeTopDto.setSoluong(c.getInt(1));
                list.add(thongkeTopDto);
            }
        }
        return list;
    }

    public  int getDoanhThu(String tuNgay , String denNgay){
        String sqlDoanhThu = "SELECT SUM(tongtien) FROM dt_hoadon where ngaydathang BETWEEN ? AND ?";
        List<Integer> list = new ArrayList<>();
        Cursor c = db.rawQuery(sqlDoanhThu, new String[]{tuNgay,denNgay});

        while (c.moveToNext()){
            try {
                list.add(c.getInt(0));

            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }
}
