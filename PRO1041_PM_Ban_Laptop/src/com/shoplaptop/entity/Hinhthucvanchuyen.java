package com.shoplaptop.entity;

public class Hinhthucvanchuyen {
	int ID;
	String hinhthuc;
	String DonVi;
	float giavc;
	public Hinhthucvanchuyen() {
		super();
	}
	public Hinhthucvanchuyen(int iD, String hinhthuc, String donVi, float giavc) {
		super();
		ID = iD;
		this.hinhthuc = hinhthuc;
		DonVi = donVi;
		this.giavc = giavc;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getHinhthuc() {
		return hinhthuc;
	}
	public void setHinhthuc(String hinhthuc) {
		this.hinhthuc = hinhthuc;
	}
	public String getDonVi() {
		return DonVi;
	}
	public void setDonVi(String donVi) {
		DonVi = donVi;
	}
	public float getGiavc() {
		return giavc;
	}
	public void setGiavc(float giavc) {
		this.giavc = giavc;
	}
	@Override
	public String toString() {
		return "Hinhthucvanchuyen [ID=" + ID + ", hinhthuc=" + hinhthuc + ", DonVi=" + DonVi + ", giavc=" + giavc + "]";
	}
	
	
	
	
}
