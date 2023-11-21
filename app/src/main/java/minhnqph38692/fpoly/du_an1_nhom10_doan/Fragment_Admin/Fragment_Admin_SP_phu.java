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

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.Admin.Admin_SP_phu_Adapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.DoAnPhu_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAnPhu_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Fragment_Admin_SP_phu extends Fragment {
    RecyclerView rc_doanphu;
    FloatingActionButton dap_float_add;
    List<DoAnPhu_DTO> list;
    DoAnPhu_DAO doAnPhu_dao;
    Admin_SP_phu_Adapter admin_sp_phu_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_sp_phu,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rc_doanphu = view.findViewById(R.id.rc_doanphu);
        dap_float_add = view.findViewById(R.id.dap_float_add);

        doAnPhu_dao = new DoAnPhu_DAO(getContext());
        list= doAnPhu_dao.getAll();
        admin_sp_phu_adapter = new Admin_SP_phu_Adapter(getContext(),list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        rc_doanphu.setLayoutManager(linearLayoutManager);
        rc_doanphu.setAdapter(admin_sp_phu_adapter);
        dap_float_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
