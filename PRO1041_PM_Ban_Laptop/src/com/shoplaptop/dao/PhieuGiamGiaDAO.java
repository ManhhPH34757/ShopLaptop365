/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoplaptop.dao;
import java.sql.*;

import com.shoplaptop.entity.PhieuGiamGia;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XJdbc;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuGiamGiaDAO {
    PhieuGiamGia pgg;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<PhieuGiamGia> getALLDAO(){
        ArrayList<PhieuGiamGia> dspg = new ArrayList<>();
        String sql = "select * from PhieuGiamGia";
        try {
            con = new XJdbc().Connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                dspg.add(new PhieuGiamGia(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6)));
            }
            System.out.println(dspg.get(0).toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return dspg;
    }
    public void ADDAO(PhieuGiamGia pgg){
        String sql = "insert into PhieuGiamGia values(?,?,?,?,?,?)";
        try {
            con = new XJdbc().Connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, pgg.getMaPG());
            ps.setString(2, pgg.getTenPhieu());
            ps.setString(3, new XDate().toString(pgg.getHan(), "yyyy-MM-dd"));
            ps.setInt(4, pgg.getSoLuong());
            ps.setFloat(5, pgg.getGiaGiam());
            ps.setFloat(6, pgg.getDieuKienGiam());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void XOADAO(String MaPG){
        String sql = "delete PhieuGiamGia where MaPG = ?";
        try {
            con = new XJdbc().Connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, MaPG);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void UPDATEDAO(PhieuGiamGia pgg){
        String sql = "Update PhieuGiamGia \n"
                + "set TenPhieu = ?,\n"
                + "    Han = ?,\n"
                + "     SoLuong = ?,\n"
                + "	GiaGiam =?,\n"
                + "	DieuKienHoaDon = ? \n"
                + "	where MaPG = ?";
        try {
            con = new XJdbc().Connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, pgg.getTenPhieu());
            ps.setString(2, new XDate().toString(pgg.getHan(), "yyyy-MM-dd"));
            ps.setInt(3, pgg.getSoLuong());
            ps.setFloat(4, pgg.getGiaGiam());
            ps.setFloat(5, pgg.getDieuKienGiam());
            ps.setString(6, pgg.getMaPG());
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        PhieuGiamGiaDAO pggdao = new PhieuGiamGiaDAO();
        pggdao.getALLDAO();
    }
}
