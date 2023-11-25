package com.shoplaptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.Hinhthucvanchuyen;
import com.shoplaptop.utils.XJdbc;

public class Vanchuyenservice implements ShopLaptop365DAO<Hinhthucvanchuyen, String>{
	
	Connection connection = new XJdbc().Connect();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	ArrayList<Hinhthucvanchuyen> list = new ArrayList<Hinhthucvanchuyen>();
	
	
	
	@Override
	public String insert(Hinhthucvanchuyen entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Hinhthucvanchuyen entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hinhthucvanchuyen selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	String sellectall = "SELECT * FROM dbo.HinhThucVanChuyen";
	@Override
	public List<Hinhthucvanchuyen> selectAll() {
		
		return this.selectBySQL(sellectall);
		
	}

	@Override
	public List<Hinhthucvanchuyen> selectBySQL(String sql, Object... args) {
try {
			
			st = connection.createStatement();
			rs = st.executeQuery(sellectall);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String hinhthuc = rs.getString("HinhThuc");
				String donvi = rs.getString("DonVi");
				float giavc = rs.getFloat("GiaVC");
				
				Hinhthucvanchuyen hinhthucvanchuyen = new Hinhthucvanchuyen(id, hinhthuc, donvi, giavc);
				list.add(hinhthucvanchuyen);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
return list;
	}


}