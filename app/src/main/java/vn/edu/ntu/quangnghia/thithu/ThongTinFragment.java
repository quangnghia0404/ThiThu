package vn.edu.ntu.quangnghia.thithu;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vn.edu.ntu.quangnghia.controller.IHienthiController;
import vn.edu.ntu.quangnghia.model.Hienthi;


public class ThongTinFragment extends Fragment {


    EditText edtName;
    EditText edtNgaydi;
    ImageView imvngaydi;
    EditText edtNgayden;
    ImageView imvngayden;
    RadioButton rbSang;
    RadioButton rbChieu;
    RadioButton rbToi;
    RadioGroup rdgGioHoc;
    Spinner spinner1;
    Button btnDK;
    Button btnXemDanhSach;

    String loai;


    NavController navController;
    IHienthiController controller;
    List<Hienthi> listhienthis = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thong_tin, container, false);
        addViews(view);
        addevents();
        return view;
    }


    private void addevents() {
        imvngaydi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        edtNgaydi.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
        imvngayden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        edtNgayden.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });


        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rdgGioHoc.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) rdgGioHoc.findViewById(selectedId);
                loai = spinner1.getSelectedItem().toString();

                Hienthi c = new Hienthi();
                c.setName(edtName.getText().toString());
                c.setNgaydi(edtNgaydi.getText().toString());
                c.setNgayden(edtNgayden.getText().toString());
                c.setThoidiem(radioButton.getText().toString());
                c.setLoai(loai);
                controller.addContact(c);
                Toast.makeText(getActivity(),"Đã thêm thành công", Toast.LENGTH_LONG).show();
            }
        });
        btnXemDanhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_thongTinFragment_to_danhSachFragment);
            }
        });
    }


    private void addViews(View view) {

        edtName = view.findViewById(R.id.edtName);
        edtNgaydi = view.findViewById(R.id.edtNgaydi);
        imvngaydi = view.findViewById(R.id.imvngaydi);
        edtNgayden = view.findViewById(R.id.edtNgayden);
        imvngayden = view.findViewById(R.id.imvngayden);
        rbSang = view.findViewById(R.id.rbSang);
        rbChieu = view.findViewById(R.id.rbChieu);
        rbToi = view.findViewById(R.id.rbToi);
        rdgGioHoc = view.findViewById(R.id.rdgGioHoc);
        spinner1 = view.findViewById(R.id.spinner1);
        btnDK = view.findViewById(R.id.btnDK);
        btnXemDanhSach = view.findViewById(R.id.btnXemDanhSach);

        controller = (IHienthiController) ((MainActivity)getActivity()).getApplication();
        listhienthis = controller.getAllHienthi();

        navController= NavHostFragment.findNavController(ThongTinFragment.this);
        ((MainActivity)getActivity()).navController = navController;
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final String[] loaidv = new String[]{"Lập trình Java","Lập trình Android","lập trình ASP.NET"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ThongTinFragment.this.getActivity(), R.layout.support_simple_spinner_dropdown_item,loaidv);
        spinner1.setAdapter(arrayAdapter);
    }
    @Override
    public void onPause() {
        super.onPause();
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}