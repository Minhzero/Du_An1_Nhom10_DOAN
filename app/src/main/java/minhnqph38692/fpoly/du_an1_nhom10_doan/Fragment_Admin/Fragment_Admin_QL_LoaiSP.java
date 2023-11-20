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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin.Admin_QL_LoaiSP_Adapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.LoaiDoAn_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.LoaiDoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Fragment_Admin_QL_LoaiSP extends Fragment {
    RecyclerView rc_loaidoan;
    FloatingActionButton lda_float_add;
    List<LoaiDoAn_DTO > list;
    LoaiDoAn_DAO doAn_dao;
    Admin_QL_LoaiSP_Adapter admin_ql_loaiSP_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_ql_loai_sp,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc_loaidoan = view.findViewById(R.id.rc_loaidoan);
        lda_float_add = view.findViewById(R.id.lda_float_add);

        doAn_dao = new LoaiDoAn_DAO(getContext());
        list = doAn_dao.getAll();
        admin_ql_loaiSP_adapter = new Admin_QL_LoaiSP_Adapter(getContext(),list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        rc_loaidoan.setLayoutManager(linearLayoutManager);
        rc_loaidoan.setAdapter(admin_ql_loaiSP_adapter);
    }
}
