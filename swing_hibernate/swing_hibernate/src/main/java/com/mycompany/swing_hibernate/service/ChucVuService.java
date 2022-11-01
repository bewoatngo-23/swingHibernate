/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swing_hibernate.service;

import com.mycompany.swing_hibernate.model.ChucVu;
import com.mycompany.swing_hibernate.repository.ChucVuRepository;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChucVuService {

    private final ChucVuRepository cvr = new ChucVuRepository();

    public List<ChucVu> getAll() {
        return cvr.getAll();
    }

    public ChucVu getOne(String tenCV) {
        return cvr.getOne(tenCV);
    }
}
