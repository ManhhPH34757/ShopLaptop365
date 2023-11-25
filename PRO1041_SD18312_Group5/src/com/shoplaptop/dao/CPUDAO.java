package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.CPU;
import com.shoplaptop.utils.XJdbc;

public class CPUDAO implements ShopLaptop365DAO<CPU, Integer>{

	String selectAll_SQL = "SELECT * FROM CPU";
	String selectByID = "SELECT * FROM CPU WHERE ID = ?";
	@Override
	public String insert(CPU entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(CPU entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CPU selectById(Integer id) {
		List<CPU> list = this.selectBySQL(selectByID, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<CPU> selectAll() {
		return selectBySQL(selectAll_SQL);
	}

	@Override
	public List<CPU> selectBySQL(String sql, Object... args) {
		List<CPU> list = new ArrayList<CPU>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				CPU cpu = new CPU();
				cpu.setId(rs.getInt("ID"));
				cpu.setMaCPU(rs.getString("MaCPU"));
				cpu.setHangCPU(rs.getString("HangCPU"));
				cpu.setCongNghe(rs.getString("CongNghe"));
				cpu.setLoaiCPU(rs.getString("LoaiCPU"));
				cpu.setTocDoCPU(rs.getDouble("TocDoCPU"));
				cpu.setTocDoToiDa(rs.getDouble("TocDoToiDa"));
				cpu.setSoNhan(rs.getInt("SoNhan"));
				cpu.setSoLuong(rs.getInt("SoLuong"));
				cpu.setBoNhoDem(rs.getInt("BoNhoDem"));
				list.add(cpu);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public CPU selectByMaKH(String MaKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CPU selectByTenKH(String Tenkh) {
		// TODO Auto-generated method stub
		return null;
	}

}
