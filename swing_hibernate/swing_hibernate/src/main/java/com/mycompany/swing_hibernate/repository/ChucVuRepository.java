/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swing_hibernate.repository;

import com.mycompany.swing_hibernate.model.ChucVu;
import com.mycompany.swing_hibernate.util.SQLServerConnect;
import java.util.List;
import org.hibernate.Session;
import javax.persistence.Query;

/**
 *
 * @author Admin
 */
public class ChucVuRepository {

    private static final Session SESSION = SQLServerConnect.getConnection().openSession();

    public List<ChucVu> getAll() {

        List<ChucVu> lstGetAll = null;
        SESSION.getTransaction().begin();
        lstGetAll = SESSION.createCriteria(ChucVu.class).list();
        SESSION.getTransaction().commit();
        return lstGetAll;
    }

    public ChucVu getOne(String tenCV) {
        ChucVu cv = null;
        try {
            Query query = SESSION.createQuery("FROM ChucVu where tenCV = :tenCV");
            query.setParameter("tenCV", tenCV);
            cv = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cv;
    }

    public static void main(String[] args) {
        ChucVu cv = new ChucVuRepository().getOne("Giám đốc");
        System.out.println(cv.toString());
    }
}
