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

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin.Admin_ThemSp_Adapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.DoAn_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Fragment_Admin_ThemSP extends Fragment {
    RecyclerView rc_themsp;
    FloatingActionButton tsp_float_add;
    List<DoAn_DTO> list;
    DoAn_DAO doAn_dao;
    Admin_ThemSp_Adapter admin_themSp_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_themsp,container,false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc_themsp =view.findViewById(R.id.rc_themsp);
        tsp_float_add = view.findViewById(R.id.tsp_float_add);

        doAn_dao = new DoAn_DAO(getContext());
        list = doAn_dao.getAll();
        admin_themSp_adapter = new Admin_ThemSp_Adapter(getContext(),list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        rc_themsp.setLayoutManager(linearLayoutManager);
        rc_themsp.setAdapter(admin_themSp_adapter);

    }


}
