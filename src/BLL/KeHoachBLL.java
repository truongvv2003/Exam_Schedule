package BLL;

import java.time.LocalDate;

import DAL.KeHoachDAL;

public class KeHoachBLL {
	private static KeHoachBLL instance;
	private KeHoachBLL() {}
	public static KeHoachBLL getInstance()
	{
		if(instance == null)
			instance = new KeHoachBLL();
		return instance;
	}
	
	public int getTuanBatDau()
	{
		return KeHoachDAL.getInstance().getTuanBatDau();
	}
	
	public int getTuanKetThuc()
	{
		return KeHoachDAL.getInstance().getTuanKetThuc();
	}
	
	public LocalDate getNgayBatDau()
	{
		return KeHoachDAL.getInstance().getNgayBatDau();
	}
}
