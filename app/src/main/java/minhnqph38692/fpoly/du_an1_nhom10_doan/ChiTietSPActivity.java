package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.User_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class ChiTietSPActivity extends AppCompatActivity {
private TextView txt_ten, txt_gia,txt_thongtin;
private Button btn_muahang;
private ImageView img_anhchitiet;
private Spinner spn_doanphu;
private EditText edt_soluong;

private int tongtien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sp);
        Button back=findViewById(R.id.back);
        img_anhchitiet= findViewById(R.id.img_anhchitiet);
        btn_muahang=findViewById(R.id.btn_muahang);
        txt_gia=findViewById(R.id.txt_gia);
        txt_ten=findViewById(R.id.txt_ten);
        txt_thongtin=findViewById(R.id.txt_thongtin);
        spn_doanphu=findViewById(R.id.spn_doanphu);
        edt_soluong=findViewById(R.id.edt_soluong);
btn_muahang=findViewById(R.id.btn_muahang);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String anh = intent.getStringExtra("anh");
            String tenMon = intent.getStringExtra("tenmon");
            int donGia = intent.getIntExtra("giadoan", 0);
            String thongTin = intent.getStringExtra("thongtin");
            String soLuong = edt_soluong.getText().toString();
            if (!soLuong.isEmpty()) {
                int soluong = Integer.parseInt(soLuong);
                tongtien= soluong*donGia;
            } else {
                     }



            txt_ten.setText(tenMon);
            txt_gia.setText(String.valueOf(donGia));
            txt_thongtin.setText(thongTin);
            Picasso.get().load(anh).into(img_anhchitiet);

            ArrayList<String> doanPhuList = getDoanPhuData();

            MyDbHelper dbHelper = new MyDbHelper(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM dt_doanphu", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String tenDoanPhu = cursor.getString(1);
                    doanPhuList.add(tenDoanPhu);
                } while (cursor.moveToNext());
                cursor.close();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, doanPhuList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spn_doanphu.setAdapter(adapter);

        }

        btn_muahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User_DAO userDAO = new User_DAO(ChiTietSPActivity.this);
                User_DTO loggedInUser = userDAO.getCurrentLoggedInUser();

                Intent intent = new Intent(ChiTietSPActivity.this, DatDoAnActivity.class);
                String tenMon = txt_ten.getText().toString();
                int tongtien = Integer.parseInt(txt_gia.getText().toString());
                String thongTin = txt_thongtin.getText().toString();
                String doanPhu = spn_doanphu.getSelectedItem().toString();


                // mon an
                intent.putExtra("TenMon", tenMon);
                intent.putExtra("TongTien", tongtien);
                intent.putExtra("ThongTin", thongTin);
                intent.putExtra("DoanPhu", doanPhu);

                // nguoi dung
                intent.putExtra("Email", loggedInUser.getEmail());
                intent.putExtra("HoTen", loggedInUser.getHoTen());
                intent.putExtra("SDT", loggedInUser.getSDT());

                Log.d("ChiTietSPActivity", "tenMon: " + tenMon);
                Log.d("ChiTietSPActivity", "tongtien: " + tongtien);
                Log.d("ChiTietSPActivity", "thongTin: " + thongTin);
                Log.d("ChiTietSPActivity", "doanPhu: " + doanPhu);
                Log.d("ChiTietSPActivity", "Email: " + loggedInUser.getEmail());
                Log.d("ChiTietSPActivity", "HoTen: " + loggedInUser.getHoTen());
                Log.d("ChiTietSPActivity", "SDT: " + loggedInUser.getSDT());

                startActivity(intent);
            }
        });

    }

    private ArrayList<String> getDoanPhuData() {
        ArrayList<String> doanPhuList = new ArrayList<>();

        return doanPhuList;
    }
}