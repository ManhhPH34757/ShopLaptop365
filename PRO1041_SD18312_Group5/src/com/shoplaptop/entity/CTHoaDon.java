package com.shoplaptop.entity;

public class CTHoaDon {
	private int ID;
	private int ID_HoaDon ;
	private String MaHD;
	private int ID_Serial;
	private String SerialNumber;
	private String tenLaptop;
	private double gia;
	
	
	
	public CTHoaDon() {
		
	}
	

	public CTHoaDon(int iD, int iD_HoaDon, String maHD, int iD_Serial, String serialNumber, String tenLaptop,
			double gia) {
		
		ID = iD;
		ID_HoaDon = iD_HoaDon;
		MaHD = maHD;
		ID_Serial = iD_Serial;
		SerialNumber = serialNumber;
		this.tenLaptop = tenLaptop;
		this.gia = gia;
	}

	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public int getID_HoaDon() {
		return ID_HoaDon;
	}

	public void setID_HoaDon(int iD_HoaDon) {
		ID_HoaDon = iD_HoaDon;
	}

	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String maHD) {
		MaHD = maHD;
	}

	public int getID_Serial() {
		return ID_Serial;
	}

	public void setID_Serial(int iD_Serial) {
		ID_Serial = iD_Serial;
	}

	public String getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}

	public String getTenLaptop() {
		return tenLaptop;
	}

	public void setTenLaptop(String tenLaptop) {
		this.tenLaptop = tenLaptop;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return "CTHoaDon [ID_HoaDon=" + ID_HoaDon + ", MaHD=" + MaHD + ", ID_Serial=" + ID_Serial + ", SerialNumber="
				+ SerialNumber + "]";
	}
	
	
}
