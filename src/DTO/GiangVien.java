package DTO;

import java.sql.Date;

public class GiangVien {
	private int IDGiangVien;
	private String HoTen;
	private boolean GioiTinh;
	private Date NgaySinh;
	private String QueQuan;
	private String ChucDanhKH;
	private String SoDienThoai;
	public int getIDGiangVien() {
		return IDGiangVien;
	}
	public void setIDGiangVien(int iDGiangVien) {
		IDGiangVien = iDGiangVien;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public boolean isGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getQueQuan() {
		return QueQuan;
	}
	public void setQueQuan(String queQuan) {
		QueQuan = queQuan;
	}
	public String getChucDanhKH() {
		return ChucDanhKH;
	}
	public void setChucDanhKH(String chucDanhKH) {
		ChucDanhKH = chucDanhKH;
	}
	public GiangVien(int iDGiangVien, String hoTen, boolean gioiTinh, Date ngaySinh, String queQuan,
			String chucDanhKH, String soDienThoai) {
		IDGiangVien = iDGiangVien;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		QueQuan = queQuan;
		ChucDanhKH = chucDanhKH;
		SoDienThoai = soDienThoai;
	}
	public GiangVien(int iDGiangVien, String hoTen) {
		super();
		IDGiangVien = iDGiangVien;
		HoTen = hoTen;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
}
