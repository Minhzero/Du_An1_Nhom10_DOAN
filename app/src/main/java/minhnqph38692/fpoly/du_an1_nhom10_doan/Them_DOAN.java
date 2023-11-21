package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Them_DOAN extends AppCompatActivity {
    TextInputEditText ed_linkanh,ed_tendoan,ed_giadoan,ed_mota;
    Button btn_themdoan,btn_huythemdoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_doan);
        ed_linkanh = findViewById(R.id.ed_linkanh);
        ed_tendoan = findViewById(R.id.ed_tendoan);
        ed_giadoan = findViewById(R.id.ed_giadoan);
        ed_mota = findViewById(R.id.ed_mota);
        btn_themdoan=findViewById(R.id.btn_themdoan);
        btn_huythemdoan = findViewById(R.id.btn_themdoan);

        btn_themdoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_huythemdoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}