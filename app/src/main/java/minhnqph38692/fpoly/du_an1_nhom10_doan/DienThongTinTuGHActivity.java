package minhnqph38692.fpoly.du_an1_nhom10_doan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.HoaDon_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.User_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;

public class DienThongTinTuGHActivity extends AppCompatActivity {
    Button mua,back;
    String tenMon;
    String donGia;
    String doanPhu;
    String email;
    String hoTen;
    String sdt;
    User_DAO userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thong_tin_tugh);
        mua = findViewById(R.id.muagh);
        back = findViewById(R.id.backgh);
        Bundle bundle = getIntent().getExtras();
         tenMon = bundle.getString("TenMon");
         donGia = bundle.getString("TongTien");
         email = bundle.getString("Email");
         hoTen = bundle.getString("HoTen");
        sdt = bundle.getString("SDT");

        TextInputEditText txtTenMon = findViewById(R.id.txt_thucdon3);
        TextInputEditText txtDonGia = findViewById(R.id.txt_tongtien3);
        TextInputEditText txtEmail = findViewById(R.id.txt_email3);
//        TextInputEditText txtHoTen = findViewById(R.id.txt_hoten3);
//        TextInputEditText txtSDT = findViewById(R.id.txt_SDT3);
        TextInputEditText edt_diachi=findViewById(R.id.edt_diachi3);


        txtTenMon.setText(tenMon);
        txtDonGia.setText(donGia);
        txtEmail.setText(email);
//        txtHoTen.setText(hoTen);
//        txtSDT.setText(sdt);
        mua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tenMon = bundle.getString("TenMon");
                donGia = bundle.getString("TongTien");
                email = bundle.getString("Email");
                hoTen = bundle.getString("HoTen");
                sdt = bundle.getString("SDT");
                String diachi = edt_diachi.getText().toString();
                Date ate = new Date();
                CharSequence h = DateFormat.format("d/MM /yyyy",ate.getTime());


                HoaDon_DAO hoaDonDao = new HoaDon_DAO(DienThongTinTuGHActivity.this);
                HoaDon_DTO hoaDonDto = new HoaDon_DTO();
                hoaDonDto.setHoten(hoTen);
                hoaDonDto.setEmail(email);
                hoaDonDto.setSDT(sdt);
                hoaDonDto.setDiachinhan(diachi);
                hoaDonDto.setThucdon(tenMon);
                hoaDonDto.setTongtien(Integer.parseInt(donGia));
                hoaDonDto.setNgaydathang(String.valueOf(h));
                hoaDonDto.setThanhtoan("tienmat");
                hoaDonDto.setTrangthai(1);

                long kq = hoaDonDao.InsertHD(hoaDonDto);
                if(kq>0){
                    Toast.makeText(DienThongTinTuGHActivity.this, "thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DienThongTinTuGHActivity.this,HoaDonUserActivity.class);
                    userDao = new User_DAO(DienThongTinTuGHActivity.this);
                    User_DTO loggedInUser = userDao.getCurrentLoggedInUser();
                    Bundle bundle = new Bundle();
                    bundle.putString("user",loggedInUser.getMaND());
                    intent.putExtras(bundle);
                    startActivity(intent);


                }else {
                    Toast.makeText(DienThongTinTuGHActivity.this, "that bai", Toast.LENGTH_SHORT).show();

                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DienThongTinTuGHActivity.this, HomeActivity.class);
                SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
                String ma = sharedPreferences.getString("USERNAME","");
                Bundle bundle = new Bundle();
                bundle.putString("user",ma);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}