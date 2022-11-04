package com.example.sqlite_svien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private Context context;

    public DbHelper(@Nullable Context context) {
        super(context, "QLSinhVien.sqlite", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSVCreate = "CREATE TABLE IF NOT EXISTS " +
                "SinhVien(MaSV INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "HoTen VARCHAR(200), " +
                "GioiTinh INTEGER, " +
                "DienThoai VARCHAR(13), " +
                "Email VARCHAR(200))";
        sqLiteDatabase.execSQL(sqlSVCreate);
        String sqlInsert1 = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Xyz', '0', '0437', 'zyx@gmail.com')";
        String sqlInsert2 = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Mno', '0', '0437', 'zyx@gmail.com')";
        String sqlInsert3 = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Double(W)', '1', '0437', 'W@gmail.com')";

        sqLiteDatabase.execSQL(sqlInsert1);
        sqLiteDatabase.execSQL(sqlInsert2);
        sqLiteDatabase.execSQL(sqlInsert3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
