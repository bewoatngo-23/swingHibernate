/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swing_hibernate.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ChucVu")
public class ChucVu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCV")
    private Integer maCV;

    @Column(name = "TenCV")
    private String tenCV;

    @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
    private List<NhanVien> lstNV;

    public ChucVu() {
    }

    public ChucVu(Integer maCV, String tenCV, List<NhanVien> lstNV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.lstNV = lstNV;
    }

    public Integer getMaCV() {
        return maCV;
    }

    public void setMaCV(Integer maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public List<NhanVien> getLstNV() {
        return lstNV;
    }

    public void setLstNV(List<NhanVien> lstNV) {
        this.lstNV = lstNV;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "maCV=" + maCV + ", tenCV=" + tenCV;
    }

}
