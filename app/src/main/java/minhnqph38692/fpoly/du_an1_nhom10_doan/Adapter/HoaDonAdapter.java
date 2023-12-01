package minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonAdapter.ViewHolder> {
    List<HoaDon_DTO> list;
    Context context;

    public HoaDonAdapter(List<HoaDon_DTO> list, Context context) {
        this.list = list;
        this.context = context;
    }
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###.###");

    @NonNull
    @Override
    public HoaDonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hoadon,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull HoaDonAdapter.ViewHolder holder, int position) {
holder.txt_madon.setText(list.get(position).getMahoadon()+"");
holder.txt_email.setText(list.get(position).getEmail());
holder.txt_hoten.setText(list.get(position).getHoten());
holder.txt_sdt.setText(list.get(position).getSDT());
holder.txt_diachi.setText(list.get(position).getDiachinhan());
holder.txt_thucdon.setText(list.get(position).getThucdon());
holder.txt_ngaydat.setText(list.get(position).getNgaydathang());
holder.txt_tongtien.setText(decimalFormat.format(list.get(position).getTongtien())+" VND");
holder.txt_thanhtoan.setText(list.get(position).getThanhtoan());
        holder.cb_xacnhan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                   holder.cb_xacnhan.setVisibility(View.GONE);
                } else {
                    holder.cb_xacnhan.setVisibility(View.VISIBLE);

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_madon,txt_email,txt_hoten,txt_sdt,txt_diachi,txt_thucdon,txt_ngaydat,txt_tongtien,txt_thanhtoan;
        CheckBox cb_xacnhan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_madon=itemView.findViewById(R.id.txt_madon);
            txt_email=itemView.findViewById(R.id.txt_email);
            txt_hoten=itemView.findViewById(R.id.txt_hoten);
            txt_sdt=itemView.findViewById(R.id.txt_SDT);
            txt_diachi=itemView.findViewById(R.id.txt_diachi);
            txt_tongtien=itemView.findViewById(R.id.txt_tongtien);
            txt_thanhtoan=itemView.findViewById(R.id.txt_thanhtoan);
            txt_thucdon=itemView.findViewById(R.id.txt_thucdon);
            txt_ngaydat=itemView.findViewById(R.id.txt_ngaydat);

            cb_xacnhan=itemView.findViewById(R.id.cb_xacnhan);
        }
    }
}
