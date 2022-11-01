/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swing_hibernate.repository;

import com.mycompany.swing_hibernate.model.ChucVu;
import com.mycompany.swing_hibernate.model.NhanVien;
import com.mycompany.swing_hibernate.util.SQLServerConnect;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class NhanVienRepository {

    private static final Session SESSION = SQLServerConnect.getConnection().openSession();

    public List<NhanVien> getAll() {
        List<NhanVien> lstNV = null;
//        lstNV = SESSION.createCriteria(NhanVien.class).list();
        Query query = SESSION.createQuery("FROM NhanVien");
        lstNV = query.getResultList();
//        SESSION.close();
        return lstNV;
    }

    public NhanVien getOne(int ma) {
        NhanVien nv = null;
        try {
            Query query = SESSION.createQuery("FROM NhanVien where maNV = :maNV");
            query.setParameter("maNV", ma);
            nv = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return nv;
    }

    public String add(NhanVien nv) {
        try {
            SESSION.getTransaction().begin();
            SESSION.save(nv);
            SESSION.getTransaction().commit();
            return "Thêm thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "Thêm thất bại";
        }
    }

    public String update(NhanVien nv) {
        try {
            SESSION.getTransaction().begin();
            SESSION.clear();
            SESSION.saveOrUpdate(nv);
            SESSION.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return "Update thất bại";
        }
        return "Update thành công";
    }

    public String remove(int maNV) {
        try {
            Query query = SESSION.createQuery("DELETE FROM NhanVien where maNV = :maNV");
            query.setParameter("maNV", maNV);
            SESSION.getTransaction().begin();
            SESSION.clear();
            query.executeUpdate();
            SESSION.getTransaction().commit();
            return "Xoá thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xoá thất bại";
        }
    }

    public static void main(String[] args) {
//        ChucVu cv = new ChucVu();
//        cv.setMaCV(3);
//        NhanVien nv1 = new NhanVien(13, "DỤNG", 30, true, cv);
//        String test = new NhanVienRepository().update(nv1);
//        System.out.println(test);
        List<NhanVien> lstTest = new NhanVienRepository().getAll();
        for (NhanVien nv : lstTest) {
//            System.out.println(nv.getMaNV()+" "+nv.getName()+" "+nv.getAge()+" "+nv.isGender()+" "+nv.getCv());
            System.out.println(nv.toString());
        }

//        NhanVien nv = new NhanVienRepository().getOne(6);
//        System.out.println(nv.toString());
    }
}
