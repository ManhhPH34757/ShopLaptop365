package com.shoplaptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.Hinhthucthanhtoan;
import com.shoplaptop.utils.XJdbc;

public class Thanhtoanservice implements ShopLaptop365DAO<Hinhthucthanhtoan, String>{

	Connection connection = new XJdbc().Connect();
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	ArrayList<Hinhthucthanhtoan> list = new ArrayList<Hinhthucthanhtoan>();
	
	@Override
	public String insert(Hinhthucthanhtoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Hinhthucthanhtoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hinhthucthanhtoan selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hinhthucthanhtoan> selectAll() {
		return this.selectBySQL(sellectall);
		
	}
	String sellectall = "SELECT * FROM dbo.HinhThucThanhToan";
	@Override
	public List<Hinhthucthanhtoan> selectBySQL(String sql, Object... args) {
		try {
			
			st = connection.createStatement();
			rs = st.executeQuery(sellectall);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String HinhThuc = rs.getString("HinhThuc");
				
				Hinhthucthanhtoan hinhthucthanhtoan = new Hinhthucthanhtoan(id, HinhThuc);
				list.add(hinhthucthanhtoan);
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Hinhthucthanhtoan selectByMaKH(String MaKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hinhthucthanhtoan selectByTenKH(String Tenkh) {
		// TODO Auto-generated method stub
		return null;
	}

}