package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.HoaDonAdapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.HoaDon_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.User_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;

public class HoaDonUserActivity extends AppCompatActivity {
    RecyclerView rcl_hoadon;
    HoaDonAdapter adapter;
    ImageView hoadonback;
    String maND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_user);
        rcl_hoadon=findViewById(R.id.rcl_hoadon);
//        HoaDon_DAO hoaDon_dao= new HoaDon_DAO(HoaDonUserActivity.this);
//        List<HoaDon_DTO> list= hoaDon_dao.getAll();
        User_DAO userDao = new User_DAO(HoaDonUserActivity.this);
        User_DTO loggedInUser = userDao.getCurrentLoggedInUser();

        // Lấy email của người dùng đã đăng nhập
        String loggedInUserEmail = loggedInUser.getEmail();

        // Truy vấn danh sách hóa đơn dựa trên email của người dùng
        HoaDon_DAO hoaDon_dao = new HoaDon_DAO(HoaDonUserActivity.this);
        List<HoaDon_DTO> list = hoaDon_dao.getAllByEmail(loggedInUserEmail);
        adapter=new HoaDonAdapter(list,HoaDonUserActivity.this);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(HoaDonUserActivity.this,rcl_hoadon.VERTICAL,false);
        rcl_hoadon.setAdapter(adapter);
        rcl_hoadon.setLayoutManager(linearLayoutManager);
        hoadonback=findViewById(R.id.hoadonback);

        hoadonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HoaDonUserActivity.this, HomeActivity.class);
                User_DAO userDao = new User_DAO(HoaDonUserActivity.this);
                User_DTO loggedInUser = userDao.getCurrentLoggedInUser();
                Bundle bundle = new Bundle();
                bundle.putString("user",loggedInUser.getMaND());
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }
}