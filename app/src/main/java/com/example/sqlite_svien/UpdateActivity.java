package com.example.sqlite_svien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlite_svien.model.SinhVien;


public class UpdateActivity extends AppCompatActivity {

    EditText hoten_input, gioitinh_input, dienthoai_input, email_input;
    Button btn_update, btn_delete;
    SinhVien sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        hoten_input = findViewById(R.id.hoten_input2);
        gioitinh_input = findViewById(R.id.gioitinh_input2);
        dienthoai_input = findViewById(R.id.dienthoai_input2);
        email_input = findViewById(R.id.email_input2);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);


        hoten_input.setText(sv.getHoTen437());
        gioitinh_input.setText(sv.getGioiTinh437());
        dienthoai_input.setText(sv.getDienThoai437());
        email_input.setText(sv.getEmail437());

    }
}