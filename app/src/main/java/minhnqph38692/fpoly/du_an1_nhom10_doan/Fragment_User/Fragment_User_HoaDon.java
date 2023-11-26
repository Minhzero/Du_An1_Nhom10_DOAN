package minhnqph38692.fpoly.du_an1_nhom10_doan.Fragment_User;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.HoaDonAdapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.HoaDon_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.HoaDon_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Fragment_User_HoaDon extends Fragment {
RecyclerView rcl_hoadon;
HoaDonAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_user_hoadon,container,false);
        rcl_hoadon=view.findViewById(R.id.rcl_hoadon);
        HoaDon_DAO hoaDon_dao= new HoaDon_DAO(getContext());
        List<HoaDon_DTO> list= hoaDon_dao.getAll();
        adapter=new HoaDonAdapter(list,requireContext());
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(requireContext(),rcl_hoadon.VERTICAL,false);
        rcl_hoadon.setAdapter(adapter);
        rcl_hoadon.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
