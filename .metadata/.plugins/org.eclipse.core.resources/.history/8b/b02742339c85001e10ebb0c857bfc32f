package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.SerialNumber;
import com.shoplaptop.utils.XJdbc;

public class SerialNumberDAO implements ShopLaptop365DAO<SerialNumber, String>{

	String insertSerial = "";
	String selectBySerialNumber = "SELECT Serial.ID, ID_BienThe, dbo.BienThe.MaBienThe, SerialNumber, TrangThai FROM dbo.Serial JOIN dbo.BienThe ON BienThe.ID = Serial.ID_BienThe WHERE SerialNumber = ?";
	
	@Override
	public String insert(SerialNumber entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(SerialNumber entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SerialNumber selectById(String id) {
		List<SerialNumber> list = this.selectBySQL(selectBySerialNumber, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<SerialNumber> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SerialNumber> selectBySQL(String sql, Object... args) {
		List<SerialNumber> list = new ArrayList<SerialNumber>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				SerialNumber serialNumber = new SerialNumber();
				serialNumber.setId(rs.getInt("ID"));
				serialNumber.setId_BienThe(rs.getInt("ID_BienThe"));
				serialNumber.setMaBienThe(rs.getString("MaBienThe"));
				serialNumber.setSerialNumber(rs.getString("SerialNumber"));
				serialNumber.setTrangThai(rs.getBoolean("TrangThai"));
				list.add(serialNumber);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
