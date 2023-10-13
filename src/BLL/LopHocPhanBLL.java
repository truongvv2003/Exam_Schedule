package BLL;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import DAL.LopHocPhanDAL;
import DTO.LopHocPhan;
import GUI.view.GiangVien.PanelXepLichThi_GV;

public class LopHocPhanBLL {
private static LopHocPhanBLL instance;
	
	private LopHocPhanBLL()
	{
		
	}
	
	public static LopHocPhanBLL getInstance()
	{
		if(instance == null)
		{ 
			instance = new LopHocPhanBLL();
		}
		return instance;
	}
	public ArrayList<LopHocPhan> getListLopHocPhan(){
		return LopHocPhanDAL.getInstance().getListLopHocPhan();
	}
	
	public ArrayList<ArrayList<String>> getListThongTinLopHocPhan(){
		return LopHocPhanDAL.getInstance().getListThongTinLopHocPhan();
	}

	public ArrayList<ArrayList<String>> getListThongTinLopHocPhan(String IDGiangVien){
		return LopHocPhanDAL.getInstance().getListThongTinLopHocPhan(IDGiangVien);
	}
	
	public Object[][] getListHocPhanDangKy(String IDGiangVien){
		ArrayList<ArrayList<String>> temp = LopHocPhanDAL.getInstance().getListHocPhanDangKy(IDGiangVien);
		Object[][] data = new Object[temp.size()][5];
		for(int i = 0 ; i < temp.size();i++)
		{
			data[i][0] = Integer.toString(i+1);
			data[i][1] = temp.get(i).get(0);
			data[i][2] = temp.get(i).get(1);
			if(temp.get(i).get(2).equals("true"))
			{
				ImageIcon a = new ImageIcon(PanelXepLichThi_GV.class.getResource("/res/check.png"));
				Image b = a.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
				data[i][3] = new ImageIcon(b);
			}
			else
			{
				ImageIcon a = new ImageIcon(PanelXepLichThi_GV.class.getResource("/res/remove.png"));
				Image b = a.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
				data[i][3] = new ImageIcon(b);
			}
			ImageIcon a = new ImageIcon(PanelXepLichThi_GV.class.getResource("/res/wrench.png"));
			Image b = a.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
			data[i][4] = new ImageIcon(b);
		}
		return data;
	}
	
	public boolean SetPhongMay(String maLop)
	{
		return LopHocPhanDAL.getInstance().SetPhongMay(maLop);
	}
	
	public boolean SetPhongThuong(String maLop)
	{
		return LopHocPhanDAL.getInstance().SetPhongThuong(maLop);
	}
}
