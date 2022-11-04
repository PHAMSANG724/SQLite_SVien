package com.example.sqlite_svien.dao;

import com.example.sqlite_svien.MainActivity;
import com.example.sqlite_svien.database.DbHelper;
import com.example.sqlite_svien.model.SinhVien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    // Lấy All Sinh viên  sinhVienList = ds
    public static ArrayList<SinhVien> AllSinhVien(Context context)
    {
        String sql="SELECT * FROM SinhVien";
        ArrayList<SinhVien> sinhVienList = new ArrayList<>();
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor =  database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            int masv = cursor.getInt(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String dienthoai = cursor.getString(3);
            String email = cursor.getString(4);
            SinhVien sv = new SinhVien(masv,hoten,gioitinh,dienthoai,email);
            sinhVienList.add(sv);
            cursor.moveToNext();
        }
        return sinhVienList;
    }

    public static boolean insert(Context context, String hoten, int gioitinh, String dienthoai, String email){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen", hoten);
        values.put("GioiTinh", gioitinh);
        values.put("DienThoai", dienthoai);
        values.put("Email", email);
        long row = db.insert("SinhVien", null, values);
        return (row>0);
    }

    public static boolean update(Context context, SinhVien sv){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen", sv.getHoTen437());
        values.put("GioiTinh", sv.getGioiTinh437());
        values.put("DienThoai", sv.getDienThoai437());
        values.put("Email", sv.getEmail437());
        int row = db.update("SinhVien", values, "MaSV=?", new String[]{sv.getMaSV437() + ""});
        return (row > 0);
    }
    public static boolean delete(Context context, int maSv) {
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("SinhVien", "MaSV=?", new String[]{maSv + ""});
        return (row > 0);
    }
}
