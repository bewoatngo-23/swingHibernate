/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swing_hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNV")
    private Integer maNV;

    @Column(name = "TenNV")
    private String tenNV;

    @Column(name = "Tuoi")
    private Integer tuoi;

    @Column(name = "GioiTinh")
    private boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "MaCV", nullable = false)
    private ChucVu cv;

    public NhanVien() {
    }

    public NhanVien(Integer maNV, String tenNV, Integer tuoi, boolean gioiTinh, ChucVu cv) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.cv = cv;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public ChucVu getCv() {
        return cv;
    }

    public void setCv(ChucVu cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", cv=" + cv + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{maNV, tenNV, tuoi, gioiTinh == true ? "Nam" : "Nữ", cv.getTenCV()};
    }
}
