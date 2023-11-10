package com.shoplaptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shoplaptop.entity.NhanVien;
import com.shoplaptop.utils.XJdbc;

public class NhanVienService implements ShopLaptop365DAO<NhanVien, String>{
	Connection connection = new XJdbc().Connect();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	ArrayList<NhanVien> list = new ArrayList<NhanVien>();
	
	String Insert_SQL = "INSERT INTO NhanVien (MaNV,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,Hinh,DiaChi) VALUES (?,?,?,?,?,?,?,?) "
					+ "INSERT INTO dbo.TaiKhoan(MaNV, TenDangNhap, MatKhau, VaiTro) VALUES(?,?,?,?)";
	String Delete_SQL = "DELETE FROM dbo.NhanVien WHERE MaNV = ?";
			
	String Update_SQL = "UPDATE dbo.NhanVien SET HoTen =? , SoDienThoai =? , NgaySinh =? , GioiTinh =? , Email =? , Hinh =? , DiaChi =? WHERE MaNV =? "
			+ "UPDATE dbo.TaiKhoan SET TenDangNhap =? , MatKhau =? , VaiTro =? WHERE MaNV =?";
	String SelectById_SQL = "SELECT * FROM dbo.NhanVien WHERE MaNV = ?\r\n"
					+ "SELECT * FROM dbo.TaiKhoan WHERE MaNV = ?";
	
	@Override	
	public String insert(NhanVien entity) {
		try {
			XJdbc.update(Insert_SQL, entity.getMaNV(),entity.getHoTen(),entity.getSoDienThoai(),entity.getNgaySinh(),entity.isGioiTinh(),entity.getEmail(),entity.getHinh(),entity.getDiaChi(),
					entity.getMaNV(),entity.getTendangnhap(),entity.getMatkhau(),entity.isVaitro());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String update(NhanVien entity) {
		try {
			XJdbc.update(Update_SQL, entity.getHoTen(),entity.getSoDienThoai(),entity.getNgaySinh(),entity.isGioiTinh(),entity.getEmail(),entity.getHinh(),entity.getDiaChi(),entity.getMaNV(),
					entity.getTendangnhap(),entity.getMatkhau(),entity.isVaitro(),entity.getMaNV());
			
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String delete(String id) {
		
		try {
			XJdbc.update(Delete_SQL, id);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public NhanVien selectById(String id) {
		List<NhanVien> list = this.selectBySQL(SelectById_SQL, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<NhanVien> selectAll() {
		try {
			String selectall = "SELECT * FROM dbo.NhanVien JOIN dbo.TaiKhoan ON TaiKhoan.MaNV = NhanVien.MaNV";
			st = connection.createStatement();
			rs = st.executeQuery(selectall);
			while (rs.next()) {
				String manv = rs.getString("MaNv");
				String hoten = rs.getString("HoTen");
				String Sodienthoai = rs.getString("SoDienThoai");
				Date ngaysinh = rs.getDate("NgaySinh");
				boolean Gioitinh = rs.getBoolean("GioiTinh");
				String email = rs.getString("Email");
				String Hinh = rs.getString("Hinh");
				String Diachi = rs.getString("DiaChi");
				String tendangnhap = rs.getString("TenDangNhap");
				String matkhau = rs.getString("MatKhau");
				boolean VaiTro = rs.getBoolean("VaiTro");
				
				
				NhanVien nhanVien = new NhanVien(manv, hoten, Sodienthoai, ngaysinh, Gioitinh, email, Hinh, Diachi, tendangnhap, matkhau, VaiTro);
				list.add(nhanVien);
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public List<NhanVien> selectBySQL(String sql, Object... args) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNV(rs.getString("MaNv"));
				nhanVien.setHoTen(rs.getString("HoTen"));
				nhanVien.setSoDienThoai(rs.getString("SoDienThoai"));
				nhanVien.setGioiTinh(rs.getBoolean("GioiTinh"));
				nhanVien.setEmail(rs.getString("Email"));
				nhanVien.setHinh(rs.getString("Hinh"));
				nhanVien.setTendangnhap(rs.getString("TenDangNhap"));
				nhanVien.setMatkhau(rs.getString("MatKhau"));
				nhanVien.setVaitro(rs.getBoolean("VaiTro"));
				list.add(nhanVien);
				
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
		
		
}
