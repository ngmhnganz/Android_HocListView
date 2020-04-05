package com.nguyenminhngan.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.nguyenminhngan.hoclistview.databinding.ActivityListViewCoBanLoai1Binding;

import java.lang.reflect.Array;

public class ListViewCoBanLoai1Activity extends AppCompatActivity {

    ActivityListViewCoBanLoai1Binding binding;
    ArrayAdapter<String>adapterTinhThanh;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewCoBanLoai1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvTinhThanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position là vị trí đang chọn
                String data=adapterTinhThanh.getItem(position);
                binding.txtTinhThanh.setText(position+"->"+data);
            }
        });
    }

    private void loadData() {
        //Step1: tải dữ liệu lên 1 mảng:
        String[] arr = getResources().getStringArray(R.array.arrTinhThanh);
        //Step2: khởi tạo adapter phù hợp với dữ liệu:
        adapterTinhThanh = new ArrayAdapter<>(
                //màn hình hiện tạii
                ListViewCoBanLoai1Activity.this,
                //layout cơ bản có sẳn của Android
                android.R.layout.simple_list_item_1,
                arr
        );
        //Step3: gắn adapter cho listview
        binding.lvTinhThanh.setAdapter(adapterTinhThanh);
    }
}
