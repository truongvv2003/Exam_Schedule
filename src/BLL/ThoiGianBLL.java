package BLL;

import java.util.ArrayList;

import DAL.ThoiGianDAL;

public class ThoiGianBLL {
	private static ThoiGianBLL instance;
	private ThoiGianBLL() {}
	public static ThoiGianBLL getInstance()
	{
		if(instance == null)
			instance = new ThoiGianBLL();
		return instance;
	}
	
	public ArrayList<Integer> getListTuanThi()
	{
		return ThoiGianDAL.getInstance().getListTuanThi();
	}
}
