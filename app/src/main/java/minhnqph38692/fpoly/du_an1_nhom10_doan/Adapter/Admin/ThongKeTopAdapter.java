package minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.ThongkeTop_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;


public class ThongKeTopAdapter extends BaseAdapter {
    Context context;
    List<ThongkeTop_DTO> list;

    public ThongKeTopAdapter(Context context, List<ThongkeTop_DTO> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if(convertView==null){
            row = View.inflate(context, R.layout.layout_listview_thongketop,null);

        }else {
            row=convertView;
        }
        ThongkeTop_DTO top_dto = list.get(position);
        TextView tenmonan = row.findViewById(R.id.top10_tenmonan);
        TextView soluong = row.findViewById(R.id.top10_soluong);

        tenmonan.setText(top_dto.getTenmonan());
        soluong.setText(top_dto.getSoluong()+"");
        return row;
    }
}
