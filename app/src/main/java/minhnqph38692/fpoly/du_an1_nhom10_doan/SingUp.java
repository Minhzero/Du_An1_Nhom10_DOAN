package minhnqph38692.fpoly.du_an1_nhom10_doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.User_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;

public class SingUp extends AppCompatActivity {
    TextInputEditText sg_tenDN,sg_tenND,sg_email,sg_Mk,sg_Mk1;
    Button sg_Singup,sg_back;
    User_DAO user_dao;
    List<User_DTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        sg_tenDN = findViewById(R.id.sg_tenDN);
        sg_tenND = findViewById(R.id.sg_tenND);
        sg_email = findViewById(R.id.sg_email);
        sg_Mk = findViewById(R.id.sg_Mk);
        sg_Mk1 = findViewById(R.id.sg_Mk1);
        sg_Singup = findViewById(R.id.sg_Singup);
        sg_back = findViewById(R.id.sg_back);

        sg_Singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingupUser();
            }
        });
        sg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingUp.this, Login.class);
                startActivity(intent);
            }
        });

    }
    public void SingupUser(){
        String tenDN = sg_tenDN.getText().toString();
        String tenND = sg_tenND.getText().toString();
        String email = sg_email.getText().toString();
        String mk = sg_Mk.getText().toString();
        String mk1 = sg_Mk1.getText().toString();

        if(tenDN.isEmpty()||tenND.isEmpty()||email.isEmpty()||mk.isEmpty()||mk1.isEmpty()){
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }else {
            if (mk.equals(mk1)) {
                user_dao = new User_DAO(this);
                User_DTO userDto = new User_DTO();
                userDto.setMaND(tenDN);
                userDto.setHoTen(tenND);
                userDto.setEmail(email);
                userDto.setMatKhau(mk);

                long kq = user_dao.Insert_User(userDto);
                if (kq > 0) {
                    Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SingUp.this, Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Đăng ký ko thành công", Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
            }
        }



    }
}