package com.shoplaptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.BaoCao_LS_HoaDon;
import com.shoplaptop.utils.XJdbc;

public class LS_HoaDonDao implements ShopLaptop365DAO<BaoCao_LS_HoaDon, String>{
	Connection connection = new XJdbc().Connect();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String SellectAll = "SELECT * FROM dbo.LS_PhieuDoi WHERE MaNV =?";
	@Override
	public String insert(BaoCao_LS_HoaDon entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(BaoCao_LS_HoaDon entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaoCao_LS_HoaDon selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaoCao_LS_HoaDon> selectAll() {
		return selectBySQL(SellectAll);
	}

	@Override
	public List<BaoCao_LS_HoaDon> selectBySQL(String sql, Object... args) {
		List<BaoCao_LS_HoaDon> list = new ArrayList<>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				BaoCao_LS_HoaDon baoCao = new BaoCao_LS_HoaDon();
				baoCao.setManv(rs.getString("MaNV"));
				baoCao.setMahd(rs.getString("MaHoaDon"));
				baoCao.setLS(rs.getString("LichSuLamViec"));
				list.add(baoCao);
				
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
