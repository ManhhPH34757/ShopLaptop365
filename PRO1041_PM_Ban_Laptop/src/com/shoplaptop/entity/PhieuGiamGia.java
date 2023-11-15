/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoplaptop.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PhieuGiamGia {
    private String MaPG;
    private String TenPhieu;
    private Date Han;
    private int SoLuong;
    private double GiaGiam;
    private double DieuKienGiam;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(String MaPG, String TenPhieu, Date Han, int SoLuong, double GiaGiam, double DieuKienGiam) {
        this.MaPG = MaPG;
        this.TenPhieu = TenPhieu;
        this.Han = Han;
        this.SoLuong = SoLuong;
        this.GiaGiam = GiaGiam;
        this.DieuKienGiam = DieuKienGiam;
    }

    public String getMaPG() {
        return MaPG;
    }

    public void setMaPG(String MaPG) {
        this.MaPG = MaPG;
    }

    public String getTenPhieu() {
        return TenPhieu;
    }

    public void setTenPhieu(String TenPhieu) {
        this.TenPhieu = TenPhieu;
    }

    public Date getHan() {
        return Han;
    }

    public void setHan(Date Han) {
        this.Han = Han;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaGiam() {
        return GiaGiam;
    }

    public void setGiaGiam(double GiaGiam) {
        this.GiaGiam = GiaGiam;
    }

    public double getDieuKienGiam() {
        return DieuKienGiam;
    }

    public void setDieuKienGiam(double DieuKienGiam) {
        this.DieuKienGiam = DieuKienGiam;
    }

    @Override
    public String toString() {
        return "PhieuGiamGia{" + "MaPG=" + MaPG + ", TenPhieu=" + TenPhieu + ", Han=" + Han + ", SoLuong=" + SoLuong + ", GiaGiam=" + GiaGiam + ", DieuKienGiam=" + DieuKienGiam + '}';
    }

  
    
}
