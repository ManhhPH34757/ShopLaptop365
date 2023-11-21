package com.shoplaptop.entity;

import java.util.Date;

<<<<<<< HEAD
=======
import com.shoplaptop.utils.XDate;

>>>>>>> 46e398cade36f024900666740023c2d75d07d685
public class NhanVien {
	private String maNV;
	private String hoTen;
	private String soDienThoai;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String email;
	private String hinh;
	private String diaChi;
<<<<<<< HEAD
	
	public NhanVien() {
		
	}

	public NhanVien(String maNV, String hoTen, String soDienThoai, Date ngaySinh, boolean gioiTinh, String email,
			String hinh, String diaChi) {
=======
//	private String tendangnhap;
//	private String matkhau;
	private boolean vaitro;
	public NhanVien() {
		super();
	}
	
	public NhanVien(String maNV, String hoTen, String soDienThoai, Date ngaySinh, boolean gioiTinh, String email,
			String hinh, String diaChi, String tendangnhap, String matkhau, boolean vaitro) {
		super();
>>>>>>> 46e398cade36f024900666740023c2d75d07d685
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.hinh = hinh;
		this.diaChi = diaChi;
<<<<<<< HEAD
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	
=======
//		this.tendangnhap = tendangnhap;
//		this.matkhau = matkhau;
		this.vaitro = vaitro;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
//	public String getTendangnhap() {
//		return tendangnhap;
//	}
//	public void setTendangnhap(String tendangnhap) {
//		this.tendangnhap = tendangnhap;
//	}
//	public String getMatkhau() {
//		return matkhau;
//	}
//	public void setMatkhau(String matkhau) {
//		this.matkhau = matkhau;
//	}
	public boolean isVaitro() {
		return vaitro;
	}
	public void setVaitro(boolean vaitro) {
		this.vaitro = vaitro;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", ngaySinh=" + XDate.toString(ngaySinh, "yyyy-MM-dd")
				+ ", gioiTinh=" + gioiTinh + ", email=" + email + ", hinh=" + hinh + ", diaChi=" + diaChi + ", vaitro="
				+ vaitro + "]";
	}

	
	
	
	
>>>>>>> 46e398cade36f024900666740023c2d75d07d685
}
