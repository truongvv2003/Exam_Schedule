package DTO;

import java.util.Date;

public class SinhVien {
	private	int IDSv;
	private String HoTen;
	private String Lop;
	private Date NgaySinh;
	private String NganhHoc;
	private Boolean GioiTinh;
	private String NoiSinh;
	private String SoDienThoai;
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getNganhHoc() {
		return NganhHoc;
	}
	public void setNganhHoc(String nganhHoc) {
		NganhHoc = nganhHoc;
	}
	public Boolean getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getNoiSinh() {
		return NoiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		NoiSinh = noiSinh;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public int getIDSv() {
		return IDSv;
	}
	public void setIDSv(int iDSv) {
		IDSv = iDSv;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getLop() {
		return Lop;
	}
	public void setLop(String lop) {
		Lop = lop;
	}
	public SinhVien(int iDSv, String hoTen, String lop, String nganhHoc, Boolean gioiTinh, String noiSinh,
			String soDienThoai, Date ngaySinh) {
		super();
		IDSv = iDSv;
		HoTen = hoTen;
		Lop = lop;
		NganhHoc = nganhHoc;
		GioiTinh = gioiTinh;
		NoiSinh = noiSinh;
		SoDienThoai = soDienThoai;
		NgaySinh = ngaySinh;
	}
	public SinhVien(int iDSv, String hoTen, String lop) {
		super();
		IDSv = iDSv;
		HoTen = hoTen;
		Lop = lop;
	}
	public SinhVien(int iDSv, String hoTen) {
		super();
		IDSv = iDSv;
		HoTen = hoTen;
	}
	
	
}
