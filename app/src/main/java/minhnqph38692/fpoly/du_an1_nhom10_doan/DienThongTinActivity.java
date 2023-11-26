package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.HoaDonAdapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.Fragment_User.Fragment_User_HoaDon;

public class DienThongTinActivity extends AppCompatActivity {
private String thanhtoan="";
    private List<HoaDon_DTO> danhSachHoaDon = new ArrayList<>();
    private HoaDonAdapter adapter;
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
        TextView txtDoAnPhu = findViewById(R.id.txt_doanphu);
        TextView txtEmail = findViewById(R.id.txt_email1);
        TextView txtHoTen = findViewById(R.id.txt_hoten1);
        TextView txtSDT = findViewById(R.id.txt_SDT1);
        EditText edt_diachi = findViewById(R.id.edt_diachi1);
        Button btn_xacnhan = findViewById(R.id.btn_xacnhan);
        Button btn_huy = findViewById(R.id.btn_huy);
        RadioGroup radioGroup= findViewById(R.id.radioGroup);
        RadioButton btn_tienmat=findViewById(R.id.btn_tienmat);
        RadioButton btn_chuyenkhoan=findViewById(R.id.btn_chuyenkhoan);





if (btn_tienmat.isChecked()){
    thanhtoan="tinmat";
}else if (btn_chuyenkhoan.isChecked()){
    thanhtoan="chuyenkhoan";

}

        txtTenMon.setText(tenMon);
        txtDonGia.setText(String.valueOf(donGia));
        txtDoAnPhu.setText(doanPhu);
        txtEmail.setText(email);
        txtHoTen.setText(hoTen);
        txtSDT.setText(sdt);

btn_xacnhan.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
adapter= new HoaDonAdapter(danhSachHoaDon,getApplicationContext());

        String diachi = edt_diachi.getText().toString();

        Bundle bundle = new Bundle();

        bundle.putString("DiaChi", diachi);
        bundle.putString("tenMon",tenMon);
        bundle.putString("email",email);
        bundle.putString("hoten",hoTen);
        bundle.putString("sdt",sdt);
        bundle.putInt("tongtien",donGia);
        bundle.putString("doanphu",doanPhu);
        bundle.putString("thanhtoan",thanhtoan);


        // Gọi phương thức updateDataFromActivity trong adapter
        adapter.updateDataFromActivity(bundle);

        // Cập nhật RecyclerView
        adapter.notifyDataSetChanged();





    }
});

    }
}
