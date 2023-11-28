package minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.ChiTietSPActivity;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.LoaiDoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.ListSPofLoaiSPActivity;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class User_LoaiSanPham_Adapter extends RecyclerView.Adapter<User_LoaiSanPham_Adapter.ViewHolder>{
    List<LoaiDoAn_DTO> list;
    Context context;

    public User_LoaiSanPham_Adapter(List<LoaiDoAn_DTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.rc_loaispuser,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtmaloaidoan.setText("Mã loại:"+list.get(position).getMaloai());
holder.txttenloaidoan.setText("Tên loại:"+list.get(position).getTenloai());
holder.txttenloaidoan.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context, ListSPofLoaiSPActivity.class);
        intent.putExtra("tenloaidoan",list.get(position).getTenloai());
        context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
TextView txtmaloaidoan,txttenloaidoan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtmaloaidoan=itemView.findViewById(R.id.txtmaloaidoan);
            txttenloaidoan=itemView.findViewById(R.id.txttenloaidoan);
        }
    }


}
