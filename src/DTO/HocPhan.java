package DTO;

import java.util.ArrayList;



public class HocPhan {
	private int maHocPhan;
	private String TenHocPhan;
	private int SoTietThi; //so tiet
	private ArrayList<Integer> DsSv;
	public int getMaHocPhan() {
		return maHocPhan;
	}
	public void setMaHocPhan(int maHocPhan) {
		this.maHocPhan = maHocPhan;
	}

	public ArrayList<Integer> getDsSv() {
		return DsSv;
	}
	public void setDsSv(ArrayList<Integer> dsSv) {
		DsSv = dsSv;
	}
	public String getTenHocPhan() {
		return TenHocPhan;
	}
	public void setTenHocPhan(String tenHocPhan) {
		TenHocPhan = tenHocPhan;
	}
	public int getSoTietThi() {
		return SoTietThi;
	}
	public void setSoTietThi(int soTietThi) {
		SoTietThi = soTietThi;
	}
	public HocPhan(int maHocPhan, String tenHocPhan, int soTietThi) {
		super();
		this.maHocPhan = maHocPhan;
		TenHocPhan = tenHocPhan;
		SoTietThi = soTietThi;
	}
	public HocPhan(HocPhan a, int start, int end)
	{
		
		
		this.maHocPhan = a.getMaHocPhan();
		this.TenHocPhan = a.getTenHocPhan();
		this.SoTietThi = a.getSoTietThi();
		this.DsSv = new ArrayList<Integer>();
		int i;
		for(i = start ; i <= end; i++)
		{
			int temp = a.getDsSv().get(i);
			this.DsSv.add(temp);
		}
	}
	
}
