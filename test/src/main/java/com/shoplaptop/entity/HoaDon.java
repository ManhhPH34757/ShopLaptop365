package com.shoplaptop.entity;

import java.util.Date;

public class HoaDon {
	private int ID;
	private String MaHD ;
	private String MaKH ;
	private int ID_HinhThucVanChuyen;
	private String HinhThucVanChuyen;
	private int ID_HinhThucThanhToan;
	private String HinhThucThanhToan;
	private int ID_PhieuGiamGia;
	private String PhieuGiamGia;
	private String DotGiamGia;
	private String MaNV;
	private Date NgayTao;
	private double TongTien;
		
	public HoaDon() {
		
	}
	
	public HoaDon(int iD, String maHD, String maKH, int iD_HinhThucVanChuyen, String hinhThucVanChuyen,
			int iD_HinhThucThanhToan, String hinhThucThanhToan, int iD_PhieuGiamGia, String phieuGiamGia,
			String dotGiamGia, String maNV, Date ngayTao, double tongTien) {
		
		ID = iD;
		MaHD = maHD;
		MaKH = maKH;
		ID_HinhThucVanChuyen = iD_HinhThucVanChuyen;
		HinhThucVanChuyen = hinhThucVanChuyen;
		ID_HinhThucThanhToan = iD_HinhThucThanhToan;
		HinhThucThanhToan = hinhThucThanhToan;
		ID_PhieuGiamGia = iD_PhieuGiamGia;
		PhieuGiamGia = phieuGiamGia;
		DotGiamGia = dotGiamGia;
		MaNV = maNV;
		NgayTao = ngayTao;
		TongTien = tongTien;
	}
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public int getID_HinhThucVanChuyen() {
		return ID_HinhThucVanChuyen;
	}
	public void setID_HinhThucVanChuyen(int iD_HinhThucVanChuyen) {
		ID_HinhThucVanChuyen = iD_HinhThucVanChuyen;
	}
	public String getHinhThucVanChuyen() {
		return HinhThucVanChuyen;
	}
	public void setHinhThucVanChuyen(String hinhThucVanChuyen) {
		HinhThucVanChuyen = hinhThucVanChuyen;
	}
	public int getID_HinhThucThanhToan() {
		return ID_HinhThucThanhToan;
	}
	public void setID_HinhThucThanhToan(int iD_HinhThucThanhToan) {
		ID_HinhThucThanhToan = iD_HinhThucThanhToan;
	}
	public String getHinhThucThanhToan() {
		return HinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		HinhThucThanhToan = hinhThucThanhToan;
	}
	public int getID_PhieuGiamGia() {
		return ID_PhieuGiamGia;
	}
	public void setID_PhieuGiamGia(int iD_PhieuGiamGia) {
		ID_PhieuGiamGia = iD_PhieuGiamGia;
	}
	public String getPhieuGiamGia() {
		return PhieuGiamGia;
	}
	public void setPhieuGiamGia(String phieuGiamGia) {
		PhieuGiamGia = phieuGiamGia;
	}
	public String getDotGiamGia() {
		return DotGiamGia;
	}
	public void setDotGiamGia(String dotGiamGia) {
		DotGiamGia = dotGiamGia;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public Date getNgayTao() {
		return NgayTao;
	}
	public void setNgayTao(Date ngayTao) {
		NgayTao = ngayTao;
	}
	public double getTongTien() {
		return TongTien;
	}
	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	@Override
	public String toString() {
		return  MaHD  ;
	}
	
	
	
}
