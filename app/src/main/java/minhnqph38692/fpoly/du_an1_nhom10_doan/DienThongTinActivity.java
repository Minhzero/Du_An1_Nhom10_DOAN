package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DienThongTinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thong_tin);
        Intent intent = getIntent();
        String tenMon = intent.getStringExtra("TenMon");
        int donGia = intent.getIntExtra("TongTien", 0);
        String doanPhu = intent.getStringExtra("DoanPhu");
        String email = intent.getStringExtra("Email");
        String hoTen = intent.getStringExtra("HoTen");
        String sdt = intent.getStringExtra("SDT");

        TextView txtTenMon = findViewById(R.id.txt_thucdon1);
        TextView txtDonGia = findViewById(R.id.txt_tongtien1);
      // TextView txtDoanPhu = findViewById(R.id.);
     //   TextView txtSoLuong = findViewById(R.id.txt_tongtien);
        TextView txtEmail = findViewById(R.id.txt_email1);
        TextView txtHoTen = findViewById(R.id.txt_hoten1);
        TextView txtSDT = findViewById(R.id.txt_SDT1);
        EditText edt_diachi=findViewById(R.id.edt_diachi1);


        txtTenMon.setText(tenMon);
        txtDonGia.setText(String.valueOf(donGia));
     //   txtDoanPhu.setText(doanPhu);
        txtEmail.setText(email);
        txtHoTen.setText(hoTen);
        txtSDT.setText(sdt);
    }
}