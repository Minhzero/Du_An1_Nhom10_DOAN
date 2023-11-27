package minhnqph38692.fpoly.du_an1_nhom10_doan;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.HoaDon_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;

public class DienThongTinTuGHActivity extends AppCompatActivity {
    Button mua;
    String tenMon;
    String donGia;
    String doanPhu;
    String email;
    String hoTen;
    String sdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thong_tin_tugh);
        mua = findViewById(R.id.mua);
        Bundle bundle = getIntent().getExtras();
         tenMon = bundle.getString("TenMon");
         donGia = bundle.getString("TongTien");
         email = bundle.getString("Email");
         hoTen = bundle.getString("HoTen");
        sdt = bundle.getString("SDT");

        TextView txtTenMon = findViewById(R.id.txt_thucdon3);
        TextView txtDonGia = findViewById(R.id.txt_tongtien3);
        TextView txtEmail = findViewById(R.id.txt_email3);
        TextView txtHoTen = findViewById(R.id.txt_hoten3);
        TextView txtSDT = findViewById(R.id.txt_SDT3);
        EditText edt_diachi=findViewById(R.id.edt_diachi3);


        txtTenMon.setText(tenMon);
        txtDonGia.setText(donGia);
        txtEmail.setText(email);
        txtHoTen.setText(hoTen);
        txtSDT.setText(sdt);
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
                }else {
                    Toast.makeText(DienThongTinTuGHActivity.this, "that bai", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}