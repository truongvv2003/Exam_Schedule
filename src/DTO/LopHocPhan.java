package DTO;

public class LopHocPhan {
	private int maLopHoc;
	private int maHocPhan;
	private int maGiangVien;
	private boolean isThiPhongMay;
	public int getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(int maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	public int getMaHocPhan() {
		return maHocPhan;
	}
	public void setMaHocPhan(int maHocPhan) {
		this.maHocPhan = maHocPhan;
	}
	public int getMaGiaoVien() {
		return maGiangVien;
	}
	public void setMaGiaoVien(int maGiaoVien) {
		this.maGiangVien = maGiaoVien;
	}
	public boolean isThiPhongMay() {
		return isThiPhongMay;
	}
	public void setThiPhongMay(boolean isThiPhongMay) {
		this.isThiPhongMay = isThiPhongMay;
	}
	public LopHocPhan(int maLopHoc, int maHocPhan, int maGiaoVien, boolean isThiPhongMay) {
		super();
		this.maLopHoc = maLopHoc;
		this.maHocPhan = maHocPhan;
		this.maGiangVien = maGiaoVien;
		this.isThiPhongMay = isThiPhongMay;
	}
	
}
