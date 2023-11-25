package com.shoplaptop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoplaptop.entity.GPU;
import com.shoplaptop.utils.XJdbc;

public class DoHoaCPU implements ShopLaptop365DAO<GPU, Integer> {
	
	String selectAll_SQL = "SELECT * FROM GPU";
	String selectByID = "SELECT * FROM GPU WHERE ID = ?";

	@Override
	public String insert(GPU entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(GPU entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GPU selectById(Integer id) {
		List<GPU> list = this.selectBySQL(selectByID, id);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<GPU> selectAll() {
		return selectBySQL(selectAll_SQL);
	}

	@Override
	public List<GPU> selectBySQL(String sql, Object... args) {
		List<GPU> list = new ArrayList<GPU>();
		try {
			ResultSet rs = XJdbc.query(sql, args);
			while (rs.next()) {
				GPU doHoa = new GPU();
				doHoa.setId(rs.getInt("ID"));
				doHoa.setMaGPU(rs.getString("MaGPU"));
				doHoa.setLoaiCard(rs.getString("LoaiCard"));
				doHoa.setHang(rs.getString("Hang"));
				list.add(doHoa);
			}
			rs.getStatement().getConnection().close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public GPU selectByMaKH(String MaKH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GPU selectByTenKH(String Tenkh) {
		// TODO Auto-generated method stub
		return null;
	}

}
