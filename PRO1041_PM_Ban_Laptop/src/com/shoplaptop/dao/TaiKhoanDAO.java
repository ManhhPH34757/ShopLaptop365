package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.TaiKhoan;
import com.shoplaptop.utils.XJdbc;

public class TaiKhoanDAO implements ShopLaptop365DAO<TaiKhoan, String> {
	
	String SelectById_SQL = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";


	@Override
	public String insert(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String MaNV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoan selectById(String tenDangNhap) {
		List<TaiKhoan> list = this.selectBySQL(SelectById_SQL, tenDangNhap);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<TaiKhoan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaiKhoan> selectBySQL(String sql, Object... args) {
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				TaiKhoan taiKhoan = new TaiKhoan();
				taiKhoan.setMaNV(rs.getString("MaNV"));
				taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
				taiKhoan.setMatKhau(rs.getString("MatKhau"));
				taiKhoan.setVaiTro(rs.getBoolean("VaiTro"));
				list.add(taiKhoan);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public TaiKhoan selectByMaKH(String MaKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoan selectByTenKH(String Tenkh) {
		// TODO Auto-generated method stub
		return null;
	}

}
