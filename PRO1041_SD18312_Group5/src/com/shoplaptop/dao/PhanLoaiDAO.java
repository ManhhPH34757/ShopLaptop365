package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.PhanLoai;
import com.shoplaptop.utils.XJdbc;

public class PhanLoaiDAO implements ShopLaptop365DAO<PhanLoai, Integer> {
	
	String selectAll_SQL = "SELECT * FROM PhanLoai";
	String selectByID = "SELECT * FROM PhanLoai WHERE ID = ?";

	@Override
	public String insert(PhanLoai entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(PhanLoai entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhanLoai selectById(Integer id) {
		List<PhanLoai> list = this.selectBySQL(selectByID, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<PhanLoai> selectAll() {
		return selectBySQL(selectAll_SQL);
	}

	@Override
	public List<PhanLoai> selectBySQL(String sql, Object... args) {
		List<PhanLoai> list = new ArrayList<PhanLoai>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				PhanLoai phanLoai = new PhanLoai();
				phanLoai.setId(rs.getInt("ID"));
				phanLoai.setMaLoai(rs.getString("MaLoai"));
				phanLoai.setTenLoai(rs.getString("TenLoai"));
				phanLoai.setMoTa(rs.getString("MoTa"));
				list.add(phanLoai);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
