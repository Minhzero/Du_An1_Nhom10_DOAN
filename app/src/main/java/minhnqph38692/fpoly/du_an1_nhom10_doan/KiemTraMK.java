package minhnqph38692.fpoly.du_an1_nhom10_doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.User_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;

public class KiemTraMK extends AppCompatActivity {
    TextInputEditText xntk_email;
    Button xntk_kt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_tra_mk);
        xntk_kt = findViewById(R.id.xntk_kt);
        xntk_email = findViewById(R.id.xntk_email);

        xntk_kt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = xntk_email.getText().toString();

                User_DAO user_dao = new User_DAO(KiemTraMK.this);
                User_DTO user_dto = user_dao.getAccountEmail(email);

                if (user_dto != null && user_dto.getEmail().equals(email)){
                    Intent intent = new Intent(KiemTraMK.this, QuenMK.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("email",email);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(KiemTraMK.this, "email sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}