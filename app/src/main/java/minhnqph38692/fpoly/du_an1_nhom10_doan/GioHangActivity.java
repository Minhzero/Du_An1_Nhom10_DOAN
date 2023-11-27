package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.GiohangAdapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.GioHangDAo;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.User_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.GioHangDTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;

public class GioHangActivity extends AppCompatActivity {
    TextView gh_tongtien;
    RecyclerView rc_giohang;
    Button gh_dathang;
    GioHangDAo gioHangDAo;
    List<GioHangDTO> list;
    GiohangAdapter giohangAdapter;
    ImageView giohangback;
    String anh;
    String tenMon;
    int donGia;
    String thongTin;
    StringBuilder invoice;
    StringBuilder doanphu;
    long tongtiengh = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        rc_giohang = findViewById(R.id.rc_giohang);
        giohangback = findViewById(R.id.giohangback);
        gh_tongtien = findViewById(R.id.gh_tongtien);
        gh_dathang = findViewById(R.id.gh_dathang);

        gioHangDAo = new GioHangDAo(this);
        list = gioHangDAo.getAll();
        giohangAdapter = new GiohangAdapter(GioHangActivity.this,list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GioHangActivity.this,
                LinearLayoutManager.VERTICAL,false);
        rc_giohang.setLayoutManager(linearLayoutManager);
        rc_giohang.setAdapter(giohangAdapter);
        TT();
        Tensp();
//        TenDoanphu();


        gh_dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User_DAO userDAO = new User_DAO(GioHangActivity.this);
                User_DTO loggedInUser = userDAO.getCurrentLoggedInUser();
                Intent intent = new Intent(GioHangActivity.this, DienThongTinTuGHActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TenMon", String.valueOf(invoice));
                bundle.putString("Email", loggedInUser.getEmail());
                bundle.putString("HoTen", loggedInUser.getHoTen());
                bundle.putString("SDT", loggedInUser.getSDT());
                bundle.putString("TongTien", String.valueOf(tongtiengh));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            anh = intent.getStringExtra("anh");
            tenMon = intent.getStringExtra("tenmon");
            donGia = intent.getIntExtra("giadoan", 0);
            thongTin = intent.getStringExtra("thongtin");

        }

        giohangback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GioHangActivity.this, ChiTietSPActivity.class);

                i.putExtra("anh",anh);
                i.putExtra("tenmon",tenMon);
                i.putExtra("giadoan",donGia);
                i.putExtra("thongtin",thongTin);
                startActivity(i);
            }
        });

    }
    private void TT(){

        for (int i =0; i<list.size();i++){
            tongtiengh = tongtiengh+(list.get(i).getGiasp() * list.get(i).getSoluongsp());

        }
        gh_tongtien.setText(String.valueOf(tongtiengh));
    }
    public void Tensp() {

        invoice = new StringBuilder();

        for (GioHangDTO gioHangDTO : list) {
            invoice.append( "\n"+gioHangDTO.getTensp()+" và " +gioHangDTO.getTendoanphu());
        }
    }
//        public void TenDoanphu(){
//
//            doanphu = new StringBuilder();
//
//            for (GioHangDTO gioHangDTO : list){
//                doanphu.append(gioHangDTO.getTendoanphu()+"\n");
//            }
//    }
}