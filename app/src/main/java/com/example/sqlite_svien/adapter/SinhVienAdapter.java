package com.example.sqlite_svien.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sqlite_svien.R;
import com.example.sqlite_svien.UpdateActivity;
import com.example.sqlite_svien.model.SinhVien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private final List<SinhVien> sinhVienList;
    private final Context context;

    public SinhVienAdapter(Context context, List<SinhVien> listList) {
        this.context = context;
        this.sinhVienList = listList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_sinhvien, null);

            viewHolder.tvMaSV437 = view.findViewById(R.id.tv_masv);
            viewHolder.tvHoTen437 = view.findViewById(R.id.tv_hoten);
            viewHolder.tvDienThoai437 = view.findViewById(R.id.tv_dienthoai);
            viewHolder.tvEmail437 = view.findViewById(R.id.tv_email);
            viewHolder.ivGioiTinh437 = view.findViewById(R.id.iv_gioitinh);
            viewHolder.mainLayout437 = view.findViewById(R.id.mainLayout);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        SinhVien sv = sinhVienList.get(i);
        viewHolder.tvMaSV437.setText("Mã SV: " + sv.getMaSV437());
        viewHolder.tvHoTen437.setText("Họ Tên: " + sv.getHoTen437());
        viewHolder.tvDienThoai437.setText("Điện thoại: " + sv.getDienThoai437());
        viewHolder.tvEmail437.setText("Email: " + sv.getEmail437());
        if (sv.getGioiTinh437() == 0) {
            viewHolder.ivGioiTinh437.setImageResource(R.drawable.female_icon);
        } else {
            viewHolder.ivGioiTinh437.setImageResource(R.drawable.male_icon);
        }
        viewHolder.mainLayout437.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("", String.valueOf(sinhVienList.get(i)));
                context.startActivity(intent);
            }
        });

        return view;
    }

    class ViewHolder {
        ImageView ivGioiTinh437;
        TextView tvMaSV437, tvHoTen437, tvDienThoai437, tvEmail437;
        LinearLayout mainLayout437;
    }

}
