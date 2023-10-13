package DTO;

import java.util.ArrayList;

public class LichThi {
	@SuppressWarnings("unused")
	private String maLich;
	private int Tuan;
	private int Thu;
	private int TietBatDau;
	private int TietKetThuc;
	private int maPhong;
	private int maHocPhan;
	private ArrayList<Integer> IDDSSv;
	public int getTuan() {
		return Tuan;
	}
	public void setTuan(int tuan) {
		Tuan = tuan;
	}
	public int getThu() {
		return Thu;
	}
	public void setThu(int thu) {
		Thu = thu;
	}
	public int getTietBatDau() {
		return TietBatDau;
	}
	public void setTietBatDau(int tietBatDau) {
		TietBatDau = tietBatDau;
	}
	public int getTietKetThuc() {
		return TietKetThuc;
	}
	public void setTietKetThuc(int tietKetThuc) {
		TietKetThuc = tietKetThuc;
	}
	public int getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}
	public int getMaHocPhan() {
		return maHocPhan;
	}
	public void setMaHocPhan(int maHocPhan) {
		this.maHocPhan = maHocPhan;
	}
	public ArrayList<Integer> getIDDSSv() {
		return IDDSSv;
	}
	public void setIDDSSv(ArrayList<Integer> iDSV) {
		IDDSSv = iDSV;
	}
	public String getMaLich()
	{
		String maLich = Integer.toString(Tuan*60+Thu*10+TietBatDau) + Integer.toString(maPhong) + Integer.toString(maHocPhan);
		this.maLich = maLich;
		return maLich;
	}
	public void setMaLich(String maLich)
	{
		this.maLich = maLich;
	}
	public LichThi(int tuan, int thu, int tietBatDau, int tietKetThuc, int maPhong, int maHocPhan,
			ArrayList<Integer> iDSV) {
		super();
		Tuan = tuan;
		Thu = thu;
		TietBatDau = tietBatDau;
		TietKetThuc = tietKetThuc;
		this.maPhong = maPhong;
		this.maHocPhan = maHocPhan;
		IDDSSv = iDSV;
	}
	
	public LichThi(String maLich, int tuan, int thu , int tietBatDau, int tietKetThuc, int maPhong, int maHocPhan)
	{
		this.maLich = maLich;
		this.Tuan = tuan;
		this.Thu = thu;
		this.TietBatDau = tietBatDau;
		this.TietKetThuc = tietKetThuc;
		this.maPhong = maPhong;
		this.maHocPhan = maHocPhan;
		this.IDDSSv = null;
	}
	
}
