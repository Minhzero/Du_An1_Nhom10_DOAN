package minhnqph38692.fpoly.du_an1_nhom10_doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;

public class ChiTietSP extends AppCompatActivity {
private TextView txt_ten, txt_gia,txt_thongtin;
private Button btn_muahang;
private ImageView img_anhchitiet;
private Spinner spn_doanphu;
private EditText edt_soluong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sp);
        Button back=findViewById(R.id.back);
        btn_muahang=findViewById(R.id.btn_muahang);
        txt_gia=findViewById(R.id.txt_gia);
        txt_ten=findViewById(R.id.txt_ten);
        txt_thongtin=findViewById(R.id.txt_thongtin);
        spn_doanphu=findViewById(R.id.spn_doanphu);
        edt_soluong=findViewById(R.id.edt_soluong);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            String tenMon = intent.getStringExtra("tenmon");
            int donGia = intent.getIntExtra("giadoan", 0);
            String thongTin = intent.getStringExtra("thongtin");
           // int soluong= Integer.parseInt(edt_soluong.getText().toString());

            txt_ten.setText(tenMon);
            txt_gia.setText(String.valueOf(donGia));
            txt_thongtin.setText(thongTin);

            ArrayList<String> doanPhuList = getDoanPhuData();

            MyDbHelper dbHelper = new MyDbHelper(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM dt_doanphu", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String tenDoanPhu = cursor.getString(1);
                    doanPhuList.add(tenDoanPhu);
                } while (cursor.moveToNext());
                cursor.close();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, doanPhuList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spn_doanphu.setAdapter(adapter);

        }

    }

    private ArrayList<String> getDoanPhuData() {
        ArrayList<String> doanPhuList = new ArrayList<>();

        return doanPhuList;
    }
}