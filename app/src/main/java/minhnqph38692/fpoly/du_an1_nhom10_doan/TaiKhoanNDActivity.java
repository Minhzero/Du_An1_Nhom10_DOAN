package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.User_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;

public class TaiKhoanNDActivity extends AppCompatActivity {
    TextView tennguoidung,emailnguoidung,sdtnguoidung,namsinhnguoidung;


    User_DAO user_dao ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan_ndactivity);
        tennguoidung=findViewById(R.id.tennguoidung);
        emailnguoidung =findViewById(R.id.emailnguoidung);
        sdtnguoidung=findViewById(R.id.sdtnguoidung);
        namsinhnguoidung=findViewById(R.id.namsinhnguoidung);


        Bundle bundle = getIntent().getExtras();
        String maND = bundle.getString("ma");
        user_dao = new User_DAO(this);
        User_DTO user_dto = user_dao.getID(maND);

        tennguoidung.setText(user_dto.getHoTen());
        emailnguoidung.setText(user_dto.getEmail());
        sdtnguoidung.setText(user_dto.getSDT());
        namsinhnguoidung.setText(user_dto.getNamSinh());




    }
}