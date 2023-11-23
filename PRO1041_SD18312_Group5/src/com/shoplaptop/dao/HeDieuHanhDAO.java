package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.HeDieuHanh;
import com.shoplaptop.utils.XJdbc;

public class HeDieuHanhDAO implements ShopLaptop365DAO<HeDieuHanh, Integer> {

	String selectAll_SQL = "SELECT * FROM HeDieuHanh";
	String selectByID_SQL = "SELECT * FROM HeDieuHanh WHERE ID = ?";
	private String OS;

	
	@Override
	public String insert(HeDieuHanh entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(HeDieuHanh entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeDieuHanh selectById(Integer id) {
		List<HeDieuHanh> list = this.selectBySQL(selectByID_SQL, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<HeDieuHanh> selectAll() {
		return selectBySQL(selectAll_SQL);
	}

	@Override
	public List<HeDieuHanh> selectBySQL(String sql, Object... args) {
		List<HeDieuHanh> list = new ArrayList<HeDieuHanh>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				HeDieuHanh heDieuHanh = new HeDieuHanh();
				heDieuHanh.setId(rs.getInt("ID"));
				heDieuHanh.setMaHeDieuHanh(rs.getString("MaHeDieuHanh"));
				heDieuHanh.setOs(rs.getString("OS"));
				heDieuHanh.setVersion(rs.getString("Versions"));
				heDieuHanh.setKieu(rs.getInt("Kieu"));
				list.add(heDieuHanh);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<String> selectOS(String sql, Object... args) {
		List<String> list = new ArrayList<String>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				OS = rs.getString("OS");
				list.add(OS);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
