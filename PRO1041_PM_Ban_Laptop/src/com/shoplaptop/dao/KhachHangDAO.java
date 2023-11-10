package com.shoplaptop.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shoplaptop.entity.KhachHang;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XJdbc;

public class KhachHangDAO implements ShopLaptop365DAO<KhachHang, String> {
	Connection connection = new XJdbc().Connect();
	Statement statement = null;
	PreparedStatement pStatement = null;
	ResultSet rSet = null;
	
	ArrayList<KhachHang> list = new ArrayList<KhachHang>();
	
		String insertKH_SQL="INSERT INTO dbo.KhachHang(MaKH, HoTen, SoDienThoai, NgaySinh, GioiTinh, Email, DiaChi) VALUES (?,?,?,?,?,?,?)";
		String updateKH_SQL="UPDATE dbo.KhachHang SET (HoTen=?, SoDienThoai=?, NgaySinh=?, GioiTinh=?, Email=?, DiaChi=?) WHERE MaKH=?";
		String deleteKH_SQL="DELETE FROM KhachHang WHERE MaKH=?";

	@Override
	public String insert(KhachHang khachHang) {
		try {
			pStatement = connection.prepareStatement(insertKH_SQL);
			pStatement.setString(1, khachHang.getMaKH());
			pStatement.setString(2, khachHang.getHoTen());
			pStatement.setString(3, khachHang.getSoDienThoai());
			pStatement.setString(4,XDate.toString(khachHang.getNgaySinh(), "YYYY-MM-dd"));
			pStatement.setBoolean(5, khachHang.isGioiTinh());
			pStatement.setString(6, khachHang.getEmail());
			pStatement.setString(7, khachHang.getDiaChi());
			
			pStatement.executeUpdate();
			return "Thêm khách hàng thành công";
			
		} catch (Exception e) {
			return "Thêm khách hàng thất bại";
		}
	}

	@Override
	public String update(KhachHang khachHang) {
		try {
			pStatement = connection.prepareStatement(updateKH_SQL);
			
			pStatement.setString(1, khachHang.getHoTen());
			pStatement.setString(2, khachHang.getSoDienThoai());
			pStatement.setString(3,XDate.toString(khachHang.getNgaySinh(), "YYYY-MM-dd"));
			pStatement.setBoolean(4, khachHang.isGioiTinh());
			pStatement.setString(5, khachHang.getEmail());
			pStatement.setString(6, khachHang.getDiaChi());
			pStatement.setString(7, khachHang.getMaKH());
			
			pStatement.executeUpdate();
			return "Sửa khách hàng thành công";
			
		} catch (Exception e) {
			return "Sửa khách hàng thất bại";
		}
		
	}

	@Override
	public String delete(String MaKH) {
		try {
			pStatement = connection.prepareStatement(deleteKH_SQL);
			
			pStatement.setString(1, MaKH);
			
			pStatement.executeUpdate();
			return "Xóa khách hàng thành công";
			
		} catch (Exception e) {
			return "Xóa khách hàng thất bại";
		}
	}

	@Override
	public KhachHang selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KhachHang> selectAll() {
		try {
			String sellectall= "SELECT * FROM dbo.KhachHang";
			statement = connection.createStatement();
			rSet =statement.executeQuery(sellectall);
			while (rSet.next()) {
				String MaKH = rSet.getString("MaKH");
				String HoTen = rSet.getString("HoTen");
				String SoDienThoai = rSet.getString("SoDienThoai");
				Date NgaySinh = rSet.getDate("NgaySinh");
				boolean GioiTinh = rSet.getBoolean("GioiTinh");
				String Email = rSet.getString("Email");
				String DiaChi = rSet.getString("DiaChi");
				
				KhachHang khachHang = new KhachHang(MaKH, HoTen, SoDienThoai, NgaySinh, GioiTinh, Email, DiaChi);
				list.add(khachHang);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<KhachHang> selectBySQL(String sql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

}
