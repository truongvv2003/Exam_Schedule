package DTO;

public class PhongHoc {
	private int maPhong;
	private int sucChua;
	private boolean isPhongMay;
	private boolean isPhongTrong;
	
	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isPhongMay() {
		return isPhongMay;
	}

	public void setPhongMay(boolean isPhongMay) {
		this.isPhongMay = isPhongMay;
	}

	public boolean isPhongTrong() {
		return isPhongTrong;
	}

	public void setPhongTrong(boolean isPhongTrong) {
		this.isPhongTrong = isPhongTrong;
	}
	
	public PhongHoc(int maPhong, int sucChua, boolean isPhongMay) {
		super();
		this.maPhong = maPhong;
		this.sucChua = sucChua;
		this.isPhongMay = isPhongMay;
	}

	@Override
	public String toString() {
		return "PhongHoc [maPhong=" + maPhong + ", sucChua=" + sucChua + ", isPhongMay=" + isPhongMay
				+ ", isPhongTrong=" + isPhongTrong + "]";
	}

	public PhongHoc() {}
}
