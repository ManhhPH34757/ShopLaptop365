package com.shoplaptop.entity;

import java.util.Date;

public class BaoCao_LS_HoaDon {
	String manv;
	String mahd;
	Date ngaytao;
	String LS;
	
	
	public BaoCao_LS_HoaDon() {
		
	}
	

	public BaoCao_LS_HoaDon(String mahd, Date ngaytao, String lS) {
		super();
		this.mahd = mahd;
		this.ngaytao = ngaytao;
		LS = lS;
	}


	public BaoCao_LS_HoaDon(String manv, String mahd, Date ngaytao, String lS) {
		
		this.manv = manv;
		this.mahd = mahd;
		this.ngaytao = ngaytao;
		LS = lS;
	}


	public String getManv() {
		return manv;
	}


	public void setManv(String manv) {
		this.manv = manv;
	}


	public String getMahd() {
		return mahd;
	}


	public void setMahd(String mahd) {
		this.mahd = mahd;
	}


	public Date getNgaytao() {
		return ngaytao;
	}


	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}


	public String getLS() {
		return LS;
	}


	public void setLS(String lS) {
		LS = lS;
	}


	@Override
	public String toString() {
		return "BaoCaoHoaDon [manv=" + manv + ", mahd=" + mahd + ", ngaytao=" + ngaytao + ", LS=" + LS + "]";
	}
	
	
	
}
