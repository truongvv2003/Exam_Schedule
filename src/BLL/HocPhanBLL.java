package BLL;

import DAL.HocPhanDAL;

public class HocPhanBLL {
	private static HocPhanBLL instance;
	
	private HocPhanBLL() {}
	
	public static HocPhanBLL getInstance()
	{
		if (instance == null)
			instance = new HocPhanBLL();
		return instance;
	}
	
	public String getTenHocPhan(int maHocPhan)
	{
		return HocPhanDAL.getInstance().getTenHocPhan(maHocPhan);
	}
}
