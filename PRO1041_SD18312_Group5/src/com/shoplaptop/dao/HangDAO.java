package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.Hang;
import com.shoplaptop.utils.XJdbc;

public class HangDAO implements ShopLaptop365DAO<Hang, Integer> {
	
	String selectAll_SQL = "SELECT * FROM Hang";
	String selectByID_SQL = "SELECT * FROM Hang WHERE ID = ?";

	@Override
	public String insert(Hang entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Hang entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hang selectById(Integer id) {
		List<Hang> list = this.selectBySQL(selectByID_SQL, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Hang> selectAll() {
		return selectBySQL(selectAll_SQL);
	}

	@Override
	public List<Hang> selectBySQL(String sql, Object... args) {
		List<Hang> list = new ArrayList<Hang>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				Hang hang = new Hang();
				hang.setId(rs.getInt("ID"));
				hang.setMaHang(rs.getString("MaHang"));
				hang.setTenHang(rs.getString("TenHang"));
				hang.setHoTro(rs.getString("HoTro"));
				list.add(hang);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Hang selectByMaKH(String MaKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hang selectByTenKH(String Tenkh) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
