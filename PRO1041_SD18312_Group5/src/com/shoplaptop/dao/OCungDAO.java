package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.OCung;
import com.shoplaptop.utils.XJdbc;

public class OCungDAO implements ShopLaptop365DAO<OCung, Integer> {
	
	String selectAll_SQL = "SELECT * FROM OCung";
	String selectByID = "SELECT * FROM OCung WHERE ID = ?";
	
	@Override
	public String insert(OCung entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(OCung entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OCung selectById(Integer id) {
		List<OCung> list = this.selectBySQL(selectByID, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<OCung> selectAll() {
		return selectBySQL(selectAll_SQL);
	}

	@Override
	public List<OCung> selectBySQL(String sql, Object... args) {
		List<OCung> list = new ArrayList<OCung>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				OCung oCung = new OCung();
				oCung.setId(rs.getInt("ID"));
				oCung.setMaOCung(rs.getString("MaOCung"));
				oCung.setKieuOCung(rs.getString("KieuOCung"));
				oCung.setDungLuong(rs.getInt("DungLuong"));
				list.add(oCung);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	

}
