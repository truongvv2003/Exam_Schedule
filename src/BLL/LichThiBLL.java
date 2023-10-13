package BLL;

import DTO.*;
import GUI.view.Admin.PanelXepLichThi;
import GUI.view.Admin.PanelXepLichThi_ThoiGianThi;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.LichThiDAL;
import DAL.XepLich;
import DAL.connectSQL;

public class LichThiBLL {
	private static LichThiBLL instance;
	private LichThiBLL() {}
	public static boolean AllowedClick = true;
	public static LichThiBLL getInstance() {
		if(instance == null)
			instance = new LichThiBLL();
		return instance;
	}
	
	public boolean checkLichThiRong()
	{
		String sqL = "select * from LichThi";
		return connectSQL.getInstance().ExcecuteNonQuery(sqL) == 0;
	}
	
	public void thucHienXepLich(int tuanBatDau) throws InterruptedException
	{
		ThreadCompleteListner listener = new ThreadCompleteListner() {
			
			@Override
			public void onThreadComplete(Thread thread) {
				// TODO Auto-generated method stub
				PanelXepLichThi_ThoiGianThi.isAllowedClick = true;
				PanelXepLichThi.AllowedClick = true;
				JOptionPane.showMessageDialog(null, "Lịch thi đã xếp xong!!");
			}
		};
		XepLich temp = new XepLich(tuanBatDau,listener);
		temp.setDaemon(false);
		temp.start();
	}
	public ArrayList<LichThi> getLichThiTheoPhong(String maPhong)
	{
		return LichThiDAL.getInstance().getListLichThiTheoPhong(maPhong);
	}
	public String[][] getLichThiSVien(int IDSV)
	{
		ArrayList<ArrayList<String>> thoiGianThi = LichThiDAL.getInstance().getLichThiChoSVien(IDSV);
		String data[][] = new String[thoiGianThi.size()][7];
		for(int i = 0 ; i < thoiGianThi.size(); i++)
		{
			data[i][0] = Integer.toString(i+1);
			data[i][1] = thoiGianThi.get(i).get(0);
			data[i][2] = thoiGianThi.get(i).get(1);
			data[i][3] = thoiGianThi.get(i).get(2);
			data[i][4] = thoiGianThi.get(i).get(3);
			data[i][5] = thoiGianThi.get(i).get(4);
			data[i][6] = thoiGianThi.get(i).get(5);
		}
		return data;
	}
	public int XoaLich() {
		return LichThiDAL.getInstance().XoaLichThi();
	}
}
