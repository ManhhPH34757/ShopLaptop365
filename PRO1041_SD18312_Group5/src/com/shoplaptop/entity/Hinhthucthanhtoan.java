package com.shoplaptop.entity;

public class Hinhthucthanhtoan {
	int id;
	String hinhthuc;
	public Hinhthucthanhtoan() {
		
	}
	public Hinhthucthanhtoan(int id, String hinhthuc) {
		
		this.id = id;
		this.hinhthuc = hinhthuc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHinhthuc() {
		return hinhthuc;
	}
	public void setHinhthuc(String hinhthuc) {
		this.hinhthuc = hinhthuc;
	}
	@Override
	public String toString() {
		return id +" - "+ hinhthuc;
	}

	
	
	
}