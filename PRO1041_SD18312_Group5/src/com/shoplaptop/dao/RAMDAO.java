package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.RAM;
import com.shoplaptop.utils.XJdbc;

public class RAMDAO implements ShopLaptop365DAO<RAM, Integer> {

	String selectAll_SQL = "SELECT * FROM RAM";
	String selectByID = "SELECT * FROM RAM WHERE ID = ?";
	
	@Override
	public String insert(RAM entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(RAM entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RAM selectById(Integer id) {
		List<RAM> list = this.selectBySQL(selectByID, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<RAM> selectAll() {
		return selectBySQL(selectAll_SQL);
	}

	@Override
	public List<RAM> selectBySQL(String sql, Object... args) {
		List<RAM> list = new ArrayList<RAM>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				RAM ram = new RAM();
				ram.setId(rs.getInt("ID"));
				ram.setMaRAM(rs.getString("MaRAM"));
				ram.setLoaiRAM(rs.getString("LoaiRAM"));
				ram.setDungLuong(rs.getInt("DungLuong"));
				ram.setTocDoRAM(rs.getInt("TocDoRAM"));
				ram.setSoKheCamRoi(rs.getInt("SoKheCamRoi"));
				ram.setSoKheRAMConLai(rs.getInt("SoKheRAMConLai"));
				ram.setSoRAMOnboard(rs.getInt("SoRAMOnboard"));
				ram.setHoTroRAMToiDa(rs.getInt("HoTroRAMToiDa"));
				list.add(ram);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
