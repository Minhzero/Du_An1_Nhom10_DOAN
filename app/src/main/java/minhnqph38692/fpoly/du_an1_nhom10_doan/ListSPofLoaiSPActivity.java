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

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.ListspofloaispAdapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.User_DanhSachSP_Adapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.User_LoaiSanPham_Adapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.DoAn_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.Fragment_User.Fragment_User_LoaiSP;

public class ListSPofLoaiSPActivity extends AppCompatActivity {
RecyclerView rcvlistsp;

ImageView btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_spof_loai_spactivity);
        rcvlistsp=findViewById(R.id.recyclerlistspofloai);
        btnback=findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        String selectedLoai=intent.getStringExtra("tenloaidoan");
        DoAn_DAO doAnDAO;
        doAnDAO = new DoAn_DAO(getApplicationContext());
        ArrayList<DoAn_DTO> list= doAnDAO.getData1(selectedLoai);
        ListspofloaispAdapter adapter = new ListspofloaispAdapter(list,getApplicationContext());
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        rcvlistsp.setLayoutManager(linearLayoutManager);
        rcvlistsp.setAdapter(adapter);

    }
}