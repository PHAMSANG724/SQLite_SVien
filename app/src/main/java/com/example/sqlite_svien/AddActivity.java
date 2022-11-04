package com.example.sqlite_svien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite_svien.dao.SinhVienDAO;
import com.example.sqlite_svien.database.DbHelper;

public class AddActivity extends AppCompatActivity {

    EditText hoten_input, gioitinh_input, dienthoai_input, email_input;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        hoten_input = findViewById(R.id.hoten_input);
        gioitinh_input = findViewById(R.id.gioitinh_input);
        dienthoai_input = findViewById(R.id.dienthoai_input);
        email_input = findViewById(R.id.email_input);
        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = hoten_input.getText().toString();
                int gioitinh = Integer.parseInt(gioitinh_input.getText().toString());
                String dienthoai = dienthoai_input.getText().toString();
                String email = email_input.getText().toString();
                if (SinhVienDAO.insert(AddActivity.this, hoten, gioitinh, dienthoai, email)){
                    Toast.makeText(AddActivity.this, "Add thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(AddActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}