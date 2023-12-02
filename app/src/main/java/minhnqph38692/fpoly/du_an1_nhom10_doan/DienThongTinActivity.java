package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Date;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.GioHangDAo;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.HoaDon_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.GioHangDTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;

public class DienThongTinActivity extends AppCompatActivity {
    Button mua,trolai;
    String tenMon;
    int donGia;
    String doanPhu;
    String email;
    String hoTen;
    String sdt;
    String anh;
    String tenMon1;
    int donGia1;
    String thongTin;
    String sl;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###.###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thong_tin);
        mua = findViewById(R.id.mua);
        trolai = findViewById(R.id.trolai);
        Intent intent = getIntent();
         tenMon = intent.getStringExtra("TenMon");
         donGia = intent.getIntExtra("TongTien", 0);
         doanPhu = intent.getStringExtra("DoanPhu");
         email = intent.getStringExtra("Email");
         hoTen = intent.getStringExtra("HoTen");
        sdt = intent.getStringExtra("SDT");
        sl = intent.getStringExtra("sl");


        TextView txtTenMon = findViewById(R.id.txt_thucdon1);
        TextView txtDonGia = findViewById(R.id.txt_tongtien1);
      // TextView txtDoanPhu = findViewById(R.id.);
//        TextView txtSoLuong = findViewById(R.id.txt_tongtien);
//        TextView txtEmail = findViewById(R.id.txt_email1);
//        TextView txtHoTen = findViewById(R.id.txt_hoten1);
//        TextView txtSDT = findViewById(R.id.txt_SDT1);
        EditText edt_diachi=findViewById(R.id.edt_diachi1);


        txtTenMon.setText(tenMon+"va"+doanPhu+"  SL: "+sl);
        txtDonGia.setText(String.valueOf(donGia));
     //   txtDoanPhu.setText(doanPhu);
//        txtEmail.setText(email);
//        txtHoTen.setText(hoTen);
//        txtSDT.setText(sdt);
        mua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_diachi.getText().toString().isEmpty()){
                    Toast.makeText(DienThongTinActivity.this, "Địa chỉ không được để trống", Toast.LENGTH_SHORT).show();
                }else {
                    tenMon = intent.getStringExtra("TenMon");
                    donGia = intent.getIntExtra("TongTien", 0);
                    doanPhu = intent.getStringExtra("DoanPhu");
                    email = intent.getStringExtra("Email");
                    hoTen = intent.getStringExtra("HoTen");
                    sdt = intent.getStringExtra("SDT");
                    sl = intent.getStringExtra("sl");
                    String diachi = edt_diachi.getText().toString();
                    Date ate = new Date();
                    CharSequence h = DateFormat.format("d/MM /yyyy",ate.getTime());


                    HoaDon_DAO hoaDonDao = new HoaDon_DAO(DienThongTinActivity.this);
                    HoaDon_DTO hoaDonDto = new HoaDon_DTO();
                    hoaDonDto.setHoten(hoTen);
                    hoaDonDto.setEmail(email);
                    hoaDonDto.setSDT(sdt);
                    hoaDonDto.setDiachinhan(diachi);
                    hoaDonDto.setThucdon(tenMon+"va"+doanPhu+" SL:"+sl);
                    hoaDonDto.setTongtien(donGia);
                    hoaDonDto.setNgaydathang(String.valueOf(h));
                    hoaDonDto.setThanhtoan("Chưa thanh toán");
                    hoaDonDto.setTrangthai("Đang chế biến món ăn");

                    long kq = hoaDonDao.InsertHD(hoaDonDto);
                    if(kq>0){
                        Toast.makeText(DienThongTinActivity.this, "Đặt món thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(DienThongTinActivity.this, "Đặt món thất bại", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        Intent intent1 = getIntent();
        if (intent1 != null) {
            anh = intent1.getStringExtra("anh");
            tenMon1 = intent1.getStringExtra("tenmon");
            donGia1 = intent1.getIntExtra("giadoan", 0);
            thongTin = intent1.getStringExtra("thongtin");

        }

        trolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DienThongTinActivity.this, ChiTietSPActivity.class);

                i.putExtra("anh",anh);
                i.putExtra("tenmon",tenMon1);
                i.putExtra("giadoan",donGia1);
                i.putExtra("thongtin",thongTin);
                startActivity(i);
            }
        });

    }
}