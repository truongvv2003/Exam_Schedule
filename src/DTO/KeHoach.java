package DTO;

public class KeHoach {
	int soTuanThi;
	int TuanBatDau;
	int TuanKetThuc;
	public int getSoTuanThi() {
		return soTuanThi;
	}
	public void setSoTuanThi(int soTuanThi) {
		this.soTuanThi = soTuanThi;
	}
	public int getTuanBatDau() {
		return TuanBatDau;
	}
	public void setTuanBatDau(int tuanBatDau) {
		TuanBatDau = tuanBatDau;
	}
	public int getTuanKetThuc() {
		return TuanKetThuc;
	}
	public void setTuanKetThuc(int tuanKetThuc) {
		TuanKetThuc = tuanKetThuc;
	}
	public KeHoach(int tuanBatDau, int tuanKetThuc) {
		soTuanThi = tuanKetThuc - tuanBatDau;
		TuanBatDau = tuanBatDau;
		TuanKetThuc = tuanKetThuc;
	}
	
}
