package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.ManHinh;
import com.shoplaptop.utils.XJdbc;

public class ManHinhDAO implements ShopLaptop365DAO<ManHinh, Integer> {
	
	String selectAll_SQL = "SELECT * FROM ManHinh";
	String selectByID = "SELECT * FROM ManHinh WHERE ID = ?";
	@Override
	public String insert(ManHinh entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(ManHinh entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManHinh selectById(Integer id) {
		List<ManHinh> list = this.selectBySQL(selectByID, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<ManHinh> selectAll() {
		return selectBySQL(selectAll_SQL);
	}

	@Override
	public List<ManHinh> selectBySQL(String sql, Object... args) {
		List<ManHinh> list = new ArrayList<ManHinh>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				ManHinh manHinh = new ManHinh();
				manHinh.setId(rs.getInt("ID"));
				manHinh.setMaManHinh(rs.getString("maManHinh"));
				manHinh.setKichThuocManHinh(rs.getDouble("KichThuocManHinh"));
				manHinh.setCongNgheManHinh(rs.getString("CongNgheManHinh"));
				manHinh.setDoPhanGiai(rs.getString("DoPhanGiai"));
				manHinh.setTanSoQuet(rs.getInt("TanSoQuet"));
				manHinh.setTamNen(rs.getString("TamNen"));
				manHinh.setDoSang(rs.getInt("DoSang"));
				manHinh.setDoPhuMau(rs.getString("DoPhuMau"));
				manHinh.setTiLeManHinh(rs.getString("TiLeManHinh"));
				list.add(manHinh);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ManHinh selectByMaKH(String MaKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManHinh selectByTenKH(String Tenkh) {
		// TODO Auto-generated method stub
		return null;
	}

}
