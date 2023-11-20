package minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import minhnqph38692.fpoly.du_an1_nhom10_doan.ChiTietSP;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class User_DanhSachSP_Adapter extends RecyclerView.Adapter<User_DanhSachSP_Adapter.ViewHolder> {
    ArrayList<DoAn_DTO> list;
    Context context;

    public User_DanhSachSP_Adapter(ArrayList<DoAn_DTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_sp,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.txt_ten.setText("ten mon "+list.get(position).getTendoan());
holder.txt_gia.setText("don gia "+list.get(position).getGiadoan());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(context, ChiTietSP.class);
        i.putExtra("tenmon",list.get(position).getTendoan());
        i.putExtra("giadoan",list.get(position).getGiadoan());
        i.putExtra("thongtin",list.get(position).getThongtin());
        context.startActivity(i);
    }
});

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
TextView txt_ten,txt_gia;
ImageView img_anh;
Button btn_datmon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             txt_ten=itemView.findViewById(R.id.txt_ten);
             txt_gia=itemView.findViewById(R.id.txt_gia);
             img_anh=itemView.findViewById(R.id.img_sp);
             btn_datmon=itemView.findViewById(R.id.btn_datmon);
        }
    }

}
