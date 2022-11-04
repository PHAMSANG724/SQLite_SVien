package com.example.sqlite_svien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sqlite_svien.adapter.SinhVienAdapter;
import com.example.sqlite_svien.dao.SinhVienDAO;
import com.example.sqlite_svien.model.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvSinhVien;
    private ArrayList<SinhVien> sinhVienList;
    private SinhVienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSinhVien = findViewById(R.id.lv_svien);

        sinhVienList = new ArrayList<>();
        sinhVienList = SinhVienDAO.AllSinhVien(MainActivity.this);

        adapter = new SinhVienAdapter(MainActivity.this, sinhVienList);
        lvSinhVien.setAdapter(adapter);

        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_them)
        {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        }
        if (id == R.id.menu_thoat)
        {
            finish();
        }
        return true;
    }
}