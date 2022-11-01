/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swing_hibernate.service;

import com.mycompany.swing_hibernate.model.NhanVien;
import com.mycompany.swing_hibernate.repository.NhanVienRepository;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienService {

    private final NhanVienRepository nvr = new NhanVienRepository();

    public List<NhanVien> getAll() {
        return nvr.getAll();
    }

    public String add(NhanVien nv) {
        return nvr.add(nv);
    }

    public String delete(int maNV) {
        return nvr.remove(maNV);
    }

    public String update(NhanVien nv) {
        return nvr.update(nv);
    }

    public String getOne(int ma) {
        if (nvr.getOne(ma) == null) {
            return "không tìm thấy";
        } else {
            return "tìm thấy";
        }
    }

    public static void main(String[] args) {
        String test = new NhanVienService().getOne(6);
        System.out.println(test);
    }
}
