package DTO;

public class User {
	private int taiKhoan;
	private String matKhau;
	private boolean phanQuyen;
	public int getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(int taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(boolean phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	public User(int taiKhoan, String matKhau, boolean phanQuyen) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
	}
	public User() {}
}
