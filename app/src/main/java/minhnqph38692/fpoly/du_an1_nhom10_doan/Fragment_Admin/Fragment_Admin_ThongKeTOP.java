package minhnqph38692.fpoly.du_an1_nhom10_doan.Fragment_Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin.ThongKeTopAdapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.ThongKeTop_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.ThongkeTop_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Fragment_Admin_ThongKeTOP extends Fragment {
    ListView ls_top10;
    ThongKeTop_DAO thongKeTopDao;
    ThongKeTopAdapter thongKeTopAdapter;
    List<ThongkeTop_DTO> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_thongke_top,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ls_top10 = view.findViewById(R.id.ls_top10);
        thongKeTopDao = new ThongKeTop_DAO(getContext());
        list = thongKeTopDao.getTop();
        thongKeTopAdapter= new ThongKeTopAdapter(getContext(),list);
        ls_top10.setAdapter(thongKeTopAdapter);
    }
}
