package com.nguyenminhngan.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.nguyenminhngan.hoclistview.databinding.ActivityListViewCoBanLoai2Binding;
import com.nguyenminhngan.model.DanhBa;

public class ListViewCoBanLoai2Activity extends AppCompatActivity {

    ActivityListViewCoBanLoai2Binding binding;
    // vì nguồn dữ liệu là DanhBa nên adapter là DanhBa
    ArrayAdapter<DanhBa> adapterDanhBa;
    DanhBa selecteDanhBa = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewCoBanLoai2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addControls();
        addEvents();
    }

    private void addControls() {
        // khởi tạo adapter
        adapterDanhBa = new ArrayAdapter<DanhBa>(
                ListViewCoBanLoai2Activity.this,
                android.R.layout.simple_list_item_1
        );
        // gắn Adapter cho ListView
        binding.lvContact.setAdapter(adapterDanhBa);

    }

    private void addEvents() {
        binding.btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLuuMoi();
            }
        });
        binding.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXoa();
            }
        });
        binding.lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DanhBa db = adapterDanhBa.getItem(position);
                binding.edtName.setText(db.getTen());
                binding.edtPhone.setText(db.getPhone());
                selecteDanhBa = db;
            }
        });
        binding.btnChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChinhSua();
            }
        });

    }

    private void loadData() {
    }

    public void xuLyXoa() {
        if (selecteDanhBa != null) {
            adapterDanhBa.remove(selecteDanhBa);
        }
    }

    public void xuLyChinhSua() {
        if (selecteDanhBa != null) {
            selecteDanhBa.setTen(binding.edtName.getText().toString());
            selecteDanhBa.setPhone(binding.edtPhone.getText().toString());
            adapterDanhBa.notifyDataSetChanged();
        }
    }

    public void xuLyLuuMoi() {
        if (binding.edtPhone.getText().toString().isEmpty() || binding.edtName.getText().toString().isEmpty()) {
            Toast.makeText(ListViewCoBanLoai2Activity.this, "Thiếu thông tin", Toast.LENGTH_SHORT).show();
            return;
        }
            DanhBa bd = new DanhBa(binding.edtName.getText().toString(), binding.edtPhone.getText().toString());
            // đưa danh ba vào adapter
            adapterDanhBa.add(bd);
            binding.edtName.setText("");
            binding.edtPhone.setText("");
            binding.edtName.requestFocus();
    }
}
