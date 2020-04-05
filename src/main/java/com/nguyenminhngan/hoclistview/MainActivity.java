package com.nguyenminhngan.hoclistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nguyenminhngan.hoclistview.databinding.ActivityListViewCoBanLoai2Binding;
import com.nguyenminhngan.hoclistview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
    }

    public void moManHinhListViewCoBanLoai1(View view) {
        Intent intent = new Intent(MainActivity.this,ListViewCoBanLoai1Activity.class);
        startActivity(intent);
    }

    public void moManHinhListViewCoBanLoai2(View view) {
        Intent intent = new Intent(MainActivity.this,ListViewCoBanLoai2Activity.class);
        startActivity(intent);
    }
}
