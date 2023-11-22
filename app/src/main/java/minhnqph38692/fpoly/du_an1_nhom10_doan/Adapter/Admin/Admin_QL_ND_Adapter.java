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
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.User_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.User_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Admin_QL_ND_Adapter extends RecyclerView.Adapter<Admin_QL_ND_Adapter.ViewHolder> {

    Context context;
    List<User_DTO> list;
    User_DAO user_dao;

    public Admin_QL_ND_Adapter(Context context, List<User_DTO> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View v = inflater.inflate(R.layout.rc_nd,parent,false);
        Admin_QL_ND_Adapter.ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User_DTO user_dto = list.get(position);
        holder.txtmatv.setText("Ma Thanh Vien:"+user_dto.getMaTV());
        holder.txttentv.setText("Ho Va Ten:"+user_dto.getHoTen());
        holder.txtnamsinh.setText("Nam sinh:"+user_dto.getNamSinh());
        holder.imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.imgdel.setOnClickListener(new View.OnClickListener() {
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

        TextView txtmatv,txttentv,txtnamsinh;
        ImageView imgedit,imgdel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtmatv = itemView.findViewById(R.id.txtmatv);
            txttentv = itemView.findViewById(R.id.txttentv);
            txtnamsinh = itemView.findViewById(R.id.txtnamsinh);

            imgedit = itemView.findViewById(R.id.imgedit);
            imgdel=itemView.findViewById(R.id.imgdel);
        }
    }


}