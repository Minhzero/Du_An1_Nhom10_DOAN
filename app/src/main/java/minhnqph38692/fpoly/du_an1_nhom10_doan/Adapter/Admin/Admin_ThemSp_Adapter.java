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

import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.DoAn_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Admin_ThemSp_Adapter extends RecyclerView.Adapter<Admin_ThemSp_Adapter.ViewHolder> {

    Context context;
    List<DoAn_DTO> list;
    DoAn_DAO doAn_dao;

    public Admin_ThemSp_Adapter(Context context, List<DoAn_DTO> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View v = inflater.inflate(R.layout.rc_themsp,parent,false);
        Admin_ThemSp_Adapter.ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DoAn_DTO doAn_dto = list.get(position);
        holder.tsp_tensp.setText(doAn_dto.getTendoan());
        holder.tsp_gia.setText("Giá"+doAn_dto.getGiadoan()+"VND");
        holder.tsp_loaidoan.setText("Loại : "+ doAn_dto.getMaloai());
        holder.tsp_mota.setText(doAn_dto.getThongtin());
        holder.tsp_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.tsp_delete.setOnClickListener(new View.OnClickListener() {
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

        TextView tsp_tensp,tsp_gia,tsp_mota,tsp_loaidoan;
        ImageView tsp_delete,tsp_edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tsp_tensp = itemView.findViewById(R.id.tsp_tensp);
            tsp_gia = itemView.findViewById(R.id.tsp_gia);
            tsp_mota = itemView.findViewById(R.id.tsp_mota);
            tsp_delete = itemView.findViewById(R.id.tsp_delete);
            tsp_edit = itemView.findViewById(R.id.tsp_edit);
            tsp_loaidoan=itemView.findViewById(R.id.tsp_loaidoan);
        }
    }


}
