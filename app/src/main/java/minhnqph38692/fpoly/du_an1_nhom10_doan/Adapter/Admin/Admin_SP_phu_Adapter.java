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

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAnPhu_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Admin_SP_phu_Adapter extends RecyclerView.Adapter<Admin_SP_phu_Adapter.ViewHolder> {

    Context context;
    List<DoAnPhu_DTO> list;

    public Admin_SP_phu_Adapter(Context context, List<DoAnPhu_DTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View v = inflater.inflate(R.layout.rc_doanphu,parent,false);
        Admin_SP_phu_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DoAnPhu_DTO doAnPhuDto = list.get(position);
        holder.dap_ma.setText("Mã đồ ăn phụ : "+doAnPhuDto.getMaDoAnPhu());
        holder.dap_ten.setText("Tên đồ ăn phụ : "+doAnPhuDto.getTenDoAnPhu());
        holder.dap_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.dap_delete.setOnClickListener(new View.OnClickListener() {
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

        TextView dap_ma,dap_ten;
        ImageView dap_delete,dap_edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dap_ma = itemView.findViewById(R.id.dap_ma);
            dap_ten = itemView.findViewById(R.id.dap_ten);
            dap_delete = itemView.findViewById(R.id.dap_delete);
            dap_edit = itemView.findViewById(R.id.dap_edit);
        }
    }
}
