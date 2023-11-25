package minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;

public class AdminHoaDonAdapter extends RecyclerView.Adapter<AdminHoaDonAdapter.ViewHolder>{
    Context context;
    List<HoaDon_DTO>  list;

    public AdminHoaDonAdapter(Context context, List<HoaDon_DTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
