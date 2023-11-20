package minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.LoaiDoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Admin_QL_LoaiSP_Adapter extends RecyclerView.Adapter<Admin_QL_LoaiSP_Adapter.ViewHolder>{

    Context context;
    List<LoaiDoAn_DTO> list;

    public Admin_QL_LoaiSP_Adapter(Context context, List<LoaiDoAn_DTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View v = inflater.inflate(R.layout.rc_loaidoan,parent,false);
        Admin_QL_LoaiSP_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LoaiDoAn_DTO loaiDoAnDto = list.get(position);
        holder.lda_maloai.setText("Mã Loại : "+loaiDoAnDto.getMaloai());
        holder.lda_ten.setText("Tên loại : "+loaiDoAnDto.getTenloai());
        holder.lda_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.lda_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView lda_maloai,lda_ten;
        ImageView lda_delete,lda_edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lda_maloai = itemView.findViewById(R.id.lda_maloai);
            lda_ten = itemView.findViewById(R.id.lda_ten);
            lda_delete = itemView.findViewById(R.id.lda_delete);
            lda_edit = itemView.findViewById(R.id.lda_edit);
        }
    }
}
