package minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class User_DanhSachSP_Adapter extends BaseAdapter {
     public ArrayList<DoAn_DTO> list;
   public Context context;

    public User_DanhSachSP_Adapter(ArrayList<DoAn_DTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=((Activity)context).getLayoutInflater();
        View v=layoutInflater.inflate(R.layout.item_user_sp,viewGroup,false);
        TextView txt_tendoan=v.findViewById(R.id.txt_ten);
        TextView txt_giadoan=v.findViewById(R.id.txt_gia);
        DoAn_DTO doAn=list.get(i);

        txt_tendoan.setText("ten"+doAn.getTendoan());
        txt_giadoan.setText("gia"+doAn.getGiadoan());
        return v;


    }
}
