package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.DongLaptop;
import com.shoplaptop.utils.XJdbc;

public class DongLaptopDAO implements ShopLaptop365DAO<DongLaptop, Integer> {
	
	String selectDongByHang = "SELECT DongLaptop.ID, MaDong, Hang, Hang.TenHang, TenDong FROM Donglaptop JOIN Hang ON Hang.ID = DongLaptop.Hang WHERE TenHang = ?";
	String selectDongLT = "SELECT DongLaptop.ID, MaDong, Hang, Hang.TenHang, TenDong FROM Donglaptop JOIN Hang ON Hang.ID = DongLaptop.Hang WHERE dbo.DongLaptop.ID = ?";

	@Override
	public String insert(DongLaptop entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(DongLaptop entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DongLaptop selectById(Integer id) {
		List<DongLaptop> list = this.selectBySQL(selectDongLT, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<DongLaptop> selectAll() {
		return null;
	}
	
	public List<DongLaptop> selectAllDongLaptop(String hang) {
		return selectBySQL(selectDongByHang, hang);
	}

	@Override
	public List<DongLaptop> selectBySQL(String sql, Object... args) {
		List<DongLaptop> list = new ArrayList<DongLaptop>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				DongLaptop dongLaptop = new DongLaptop();
				dongLaptop.setId(rs.getInt("ID"));
				dongLaptop.setId_Hang(rs.getInt("Hang"));
				dongLaptop.setMaDong(rs.getString("MaDong"));
				dongLaptop.setTenDong(rs.getString("TenDong"));
				dongLaptop.setTenHang(rs.getString("TenHang"));
				list.add(dongLaptop);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
