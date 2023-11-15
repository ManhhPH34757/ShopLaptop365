package com.shoplaptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.BaoCao_LS_HoaDon;
import com.shoplaptop.entity.BaoCao_LS_PhieuDoi;
import com.shoplaptop.utils.XJdbc;

public class LS_PhieuDoiDao implements ShopLaptop365DAO<BaoCao_LS_PhieuDoi, String>{
	
	Connection connection = new XJdbc().Connect();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String SellectALl = "SELECT * FROM dbo.LS_PhieuDoi";
	
	
	@Override
	public String insert(BaoCao_LS_PhieuDoi entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(BaoCao_LS_PhieuDoi entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaoCao_LS_PhieuDoi selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaoCao_LS_PhieuDoi> selectAll() {
		// TODO Auto-generated method stub
		return selectBySQL(SellectALl);
	}

	@Override
	public List<BaoCao_LS_PhieuDoi> selectBySQL(String sql, Object... args) {
		List<BaoCao_LS_PhieuDoi> list = new ArrayList<>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				BaoCao_LS_PhieuDoi baoCao = new BaoCao_LS_PhieuDoi();
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


