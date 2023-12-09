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
import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin.DauBepHoaDonAdapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.HoaDon_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class FragmentDonHangDauBep extends Fragment {
    RecyclerView rchoadon1;
    List<HoaDon_DTO> list;
    DauBepHoaDonAdapter dauBepHoaDonAdapter;
    HoaDon_DAO hoaDonDao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentdonhangdaubep,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rchoadon1 = view.findViewById(R.id.rchoadon1);

        hoaDonDao = new HoaDon_DAO(getContext());
        list= hoaDonDao.getAll();
        dauBepHoaDonAdapter = new DauBepHoaDonAdapter(getContext(),list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        rchoadon1.setLayoutManager(linearLayoutManager);
        rchoadon1.setAdapter(dauBepHoaDonAdapter);
    }
}
