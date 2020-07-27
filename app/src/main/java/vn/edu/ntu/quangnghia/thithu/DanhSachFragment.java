package vn.edu.ntu.quangnghia.thithu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.controller.IHienthiController;
import vn.edu.ntu.quangnghia.model.Hienthi;

public class DanhSachFragment extends Fragment {

    NavController navController;
    IHienthiController controller;
    Toolbar toolbar;
    ThongtinAdapter adapter;

    RecyclerView rvlists;
    List<Hienthi> listhienthis = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_danh_sach, container, false);
        addViews(view);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.itemAdd){
            navController.navigate(R.id.action_danhSachFragment_to_thongTinFragment);
        }
        return super.onOptionsItemSelected(item);
    }

    private void addViews(View view) {
        rvlists = view.findViewById(R.id.rvlists);


        controller = (IHienthiController) ((MainActivity)getActivity()).getApplication();
        listhienthis = controller.getAllHienthi();
        adapter = new ThongtinAdapter(listhienthis);

        rvlists.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvlists.setAdapter(adapter);

        navController= NavHostFragment.findNavController(DanhSachFragment.this);
        ((MainActivity)getActivity()).navController = navController;
    }

    public class ThongtinViewholder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtngaydi;
        TextView txtngayden;
        TextView txtLoai;
        TextView txtGioDi;

        public ThongtinViewholder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtngaydi = itemView.findViewById(R.id.txtngaydi);
            txtngayden = itemView.findViewById(R.id.txtngayden);
            txtLoai = itemView.findViewById(R.id.txtLoai);
            txtGioDi = itemView.findViewById(R.id.txtGioDi);
        }

        public void bind(Hienthi hienthi) {
            txtName.setText("Chúc mừng bạn:"+hienthi.getName());
            txtngaydi.setText("Ngày đi :"+hienthi.getNgaydi());
            txtngayden.setText("Ngày đến:"+hienthi.getNgayden());
            txtLoai.setText("Loại dịch vụ:"+hienthi.getLoai());
            txtGioDi.setText("Vào thời điểm:"+hienthi.getThoidiem());
        }
    }

    public class ThongtinAdapter extends RecyclerView.Adapter<ThongtinViewholder> {

        List<Hienthi> listhienthis = new ArrayList<>();

        public ThongtinAdapter(List<Hienthi> listhienthis) {
            this.listhienthis = listhienthis;
        }

        @NonNull
        @Override
        public ThongtinViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.hienthi,parent,false);
            return new ThongtinViewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ThongtinViewholder holder, int position) {
            holder.bind(listhienthis.get(position));
        }

        @Override
        public int getItemCount() {
            return listhienthis.size();
        }
    }
}