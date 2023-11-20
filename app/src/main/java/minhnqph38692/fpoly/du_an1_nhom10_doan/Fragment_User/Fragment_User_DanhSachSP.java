package minhnqph38692.fpoly.du_an1_nhom10_doan.Fragment_User;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import minhnqph38692.fpoly.du_an1_nhom10_doan.Adapter.User_DanhSachSP_Adapter;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DAO.DoAn_DAO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DTO.DoAn_DTO;
import minhnqph38692.fpoly.du_an1_nhom10_doan.DbHelper.MyDbHelper;
import minhnqph38692.fpoly.du_an1_nhom10_doan.R;

public class Fragment_User_DanhSachSP extends Fragment {

    private ImageView headerImageView;
    private ListView listViewDanhSach;

    private int[] imageResources = {R.drawable.anh, R.drawable.login, R.drawable.login1};
    private int currentImageIndex = 0;

    private Handler handler = new Handler();
    private Runnable imageSwitcher = new Runnable() {
        @Override
        public void run() {
            currentImageIndex = (currentImageIndex + 1) % imageResources.length;
            headerImageView.setImageResource(imageResources[currentImageIndex]);

            handler.postDelayed(this, 2000);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_danhsach_sp, container, false);
        headerImageView = rootView.findViewById(R.id.headerImageView);
        listViewDanhSach = rootView.findViewById(R.id.listView_ds);


        DoAn_DAO doAnDAO;
        doAnDAO = new DoAn_DAO(getContext());


        User_DanhSachSP_Adapter adapter = new User_DanhSachSP_Adapter((ArrayList<DoAn_DTO>) doAnDAO.getAll(), getContext());
        listViewDanhSach.setAdapter(adapter);
        handler.post(imageSwitcher);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        handler.removeCallbacks(imageSwitcher);
        super.onDestroyView();
    }


}
