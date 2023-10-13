package BLL;

import java.util.ArrayList;

import DAL.PhongHocDAL;

public class PhongHocBLL {
	private static PhongHocBLL instance;
	private PhongHocBLL() {}
	public static PhongHocBLL getInstance()
	{
		if(instance == null)
			instance = new PhongHocBLL();
		return instance;
	}
	public ArrayList<Integer> getListMaPhong()
	{
		return PhongHocDAL.getInstance().getListMaPhong();
	}
}
