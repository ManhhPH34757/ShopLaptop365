package com.shoplaptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.TaiKhoan;
import com.shoplaptop.utils.XJdbc;

public class TaiKhoanDAO implements ShopLaptop365DAO<TaiKhoan, String> {
	
	
	Connection connection = new XJdbc().Connect();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String Insert_sql = "INSERT INTO dbo.TaiKhoan( MaNV,TenDangNhap, MatKhau,VaiTro)VALUES( ?,?,?,? )";

	String Update_sql = "UPDATE dbo.TaiKhoan SET VaiTro =? WHERE MaNV =?";
	
	String DeleteString_sql = "DELETE FROM dbo.TaiKhoan WHERE MaNV =?";
	
	String SelectById_SQL = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";
	
	String sellectAll = "SELECT * FROM dbo.TaiKhoan";
//	String SelectById_SQL = "SELECT * FROM dbo.TaiKhoan WHERE MaNV =?";
	
	
	@Override
	public String insert(TaiKhoan taiKhoan) {
		try {
			XJdbc.update(Insert_sql, taiKhoan.getMaNV(),taiKhoan.getTenDangNhap(),taiKhoan.getMatKhau(),taiKhoan.isVaiTro());
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(TaiKhoan taiKhoan) {
		try {
			XJdbc.update(Update_sql, taiKhoan.isVaiTro(),taiKhoan.getMaNV());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String delete(String MaNV) {
		// TODO Auto-generated method stub
		try {
			XJdbc.update(DeleteString_sql, MaNV);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
		return selectBySQL(sellectAll);
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
