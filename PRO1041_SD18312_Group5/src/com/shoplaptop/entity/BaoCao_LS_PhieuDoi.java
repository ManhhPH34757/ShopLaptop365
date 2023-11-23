package com.shoplaptop.entity;

public class BaoCao_LS_PhieuDoi {
	private String Manv;
	private String mahd;
	private String LS;
	public BaoCao_LS_PhieuDoi() {
		super();
	}
	public BaoCao_LS_PhieuDoi(String manv, String mahd, String lS) {
		super();
		Manv = manv;
		this.mahd = mahd;
		LS = lS;
	}
	public String getManv() {
		return Manv;
	}
	public void setManv(String manv) {
		Manv = manv;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getLS() {
		return LS;
	}
	public void setLS(String lS) {
		LS = lS;
	}
	@Override
	public String toString() {
		return "BaoCao_LS_PhieuDoi [Manv=" + Manv + ", mahd=" + mahd + ", LS=" + LS + "]";
	}
	
	
	
}
