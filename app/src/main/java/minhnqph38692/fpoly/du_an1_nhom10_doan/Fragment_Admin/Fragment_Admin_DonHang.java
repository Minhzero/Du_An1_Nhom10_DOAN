package minhnqph38692.fpoly.du_an1_nhom10_doan.Fragment_Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin.AdminHoaDonAdapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.HoaDon_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Fragment_Admin_DonHang extends Fragment {
    RecyclerView rchoadon;
    List<HoaDon_DTO> list;
    AdminHoaDonAdapter adminHoaDonAdapter;
    HoaDon_DAO hoaDonDao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_donhang,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rchoadon = view.findViewById(R.id.rchoadon);

        hoaDonDao = new HoaDon_DAO(getContext());
        list= hoaDonDao.getAll();
        adminHoaDonAdapter = new AdminHoaDonAdapter(getContext(),list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        rchoadon.setLayoutManager(linearLayoutManager);
        rchoadon.setAdapter(adminHoaDonAdapter);
    }
}
