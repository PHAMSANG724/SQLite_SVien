package com.example.sqlite_svien.model;

public class SinhVien {
    private int MaSV437;
    private String HoTen437;
    private int GioiTinh437;
    private String DienThoai437;
    private String Email437;


    public SinhVien(int maSV437, String hoTen437, int gioiTinh437, String dienThoai437, String email437) {
        this.MaSV437 = maSV437;
        this.HoTen437 = hoTen437;
        this.GioiTinh437 = gioiTinh437;
        this.DienThoai437 = dienThoai437;
        this.Email437 = email437;
    }

    public int getMaSV437() {
        return MaSV437;
    }

    public void setMaSV437(int maSV437) {
        MaSV437 = maSV437;
    }

    public String getHoTen437() {
        return HoTen437;
    }

    public void setHoTen437(String hoTen437) {
        HoTen437 = hoTen437;
    }

    public int getGioiTinh437() {
        return GioiTinh437;
    }

    public void setGioiTinh437(int gioiTinh437) {
        GioiTinh437 = gioiTinh437;
    }

    public String getDienThoai437() {
        return DienThoai437;
    }

    public void setDienThoai437(String dienThoai437) {
        DienThoai437 = dienThoai437;
    }

    public String getEmail437() {
        return Email437;
    }

    public void setEmail437(String email437) {
        Email437 = email437;
    }
}
