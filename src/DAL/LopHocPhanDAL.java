package DAL;


import java.sql.PreparedStatement;
import java.util.ArrayList;

import DTO.LopHocPhan;

public class LopHocPhanDAL {
	private static LopHocPhanDAL instance;
	private LopHocPhanDAL() {}
	public static LopHocPhanDAL getInstance()
	{
		if(instance == null) {
			instance = new LopHocPhanDAL();
		}
		return instance;
	}
	
	
	public ArrayList<LopHocPhan> getListLopHocPhan()
	{
		ArrayList<LopHocPhan> dsLHP = new ArrayList<LopHocPhan>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from LopHocPhan";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				LopHocPhan lhp = new LopHocPhan(connectSQL.getInstance().result.getInt("maLopHoc"),connectSQL.getInstance().result.getInt("maHocPhan"),connectSQL.getInstance().result.getInt("maGiangVien"),connectSQL.getInstance().result.getBoolean("isThiPhongMay"));
				dsLHP.add(lhp);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsLHP;
	}
	
	public ArrayList<LopHocPhan> getListLopHocPhanThuong()
	{
		ArrayList<LopHocPhan> dsLHP = new ArrayList<LopHocPhan>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from LopHocPhan where isPhongMay = 0";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				LopHocPhan lhp = new LopHocPhan(connectSQL.getInstance().result.getInt("maLopHoc"),connectSQL.getInstance().result.getInt("maHocPhan"),connectSQL.getInstance().result.getInt("maGiangVien"),connectSQL.getInstance().result.getBoolean("isThiPhongMay"));
				dsLHP.add(lhp);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsLHP;
	}
	public ArrayList<LopHocPhan> getListLopHocPhanMay()
	{
		ArrayList<LopHocPhan> dsLHP = new ArrayList<LopHocPhan>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from LopHocPhan where isPhongMay = 1";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				LopHocPhan lhp = new LopHocPhan(connectSQL.getInstance().result.getInt("maLopHoc"),connectSQL.getInstance().result.getInt("maHocPhan"),connectSQL.getInstance().result.getInt("maGiangVien"),connectSQL.getInstance().result.getBoolean("isThiPhongMay"));
				dsLHP.add(lhp);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsLHP;
	}
	
	
	public ArrayList<ArrayList<String>> getListThongTinLopHocPhan()
	{
		ArrayList<ArrayList<String>> dsTTLopHocPhan = new ArrayList<ArrayList<String>>();
		connectSQL.getInstance().ConnectToDatabase();
		System.out.println(111);
		try
		{
			String sqL = "select LopHocPhan.maLopHoc,HocPhan.TenHocPhan,GiangVien.HoTen from HocPhan join"
					+" LopHocPhan on HocPhan.maHocPhan = LopHocPhan.maHocPhan"
					+" join GiangVien on GiangVien.IDGiangVien = LopHocPhan.maGiangVien";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				ArrayList<String> temp = new ArrayList<>(3);
				temp.add(Integer.toString(connectSQL.getInstance().result.getInt("maLopHoc")));
				temp.add(connectSQL.getInstance().result.getString("TenHocPhan"));
				temp.add(connectSQL.getInstance().result.getString("HoTen"));
				dsTTLopHocPhan.add(temp);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dsTTLopHocPhan;
	}
	
	public ArrayList<ArrayList<String>> getListThongTinLopHocPhan(String IDGiangVien)
	{
		ArrayList<ArrayList<String>> dsTTLopHocPhan = new ArrayList<ArrayList<String>>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select LopHocPhan.maLopHoc,HocPhan.TenHocPhan,GiangVien.HoTen from HocPhan join"
					+" LopHocPhan on HocPhan.maHocPhan = LopHocPhan.maHocPhan"
					+" join GiangVien on GiangVien.IDGiangVien = LopHocPhan.maGiangVien"
					+" where LopHocPhan.maGiangVien = "+ IDGiangVien;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				ArrayList<String> temp = new ArrayList<>(3);
				temp.add(Integer.toString(connectSQL.getInstance().result.getInt("maLopHoc")));
				temp.add(connectSQL.getInstance().result.getString("TenHocPhan"));
				temp.add(connectSQL.getInstance().result.getString("HoTen"));
				dsTTLopHocPhan.add(temp);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dsTTLopHocPhan;
	}
	
	public ArrayList<ArrayList<String>> getListHocPhanDangKy(String IDGiangVien)
	{
		ArrayList<ArrayList<String>> dsTTLopHocPhan = new ArrayList<ArrayList<String>>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select maLopHoc,TenHocPhan,isThiPhongMay from LopHocPhan join HocPhan\r\n"
					+ "on LopHocPhan.maHocPhan = HocPhan.maHocPhan\r\n"
					+ "where LopHocPhan.maGiangVien = " + IDGiangVien;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				ArrayList<String> temp = new ArrayList<>(3);
				temp.add(Integer.toString(connectSQL.getInstance().result.getInt("maLopHoc")));
				temp.add(connectSQL.getInstance().result.getString("TenHocPhan"));
				temp.add(Boolean.toString(connectSQL.getInstance().result.getBoolean("isThiPhongMay")));
				dsTTLopHocPhan.add(temp);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dsTTLopHocPhan;
	}
	
	public boolean SetPhongThuong(String maLop)
	{
		connectSQL.getInstance().ConnectToDatabase();
		try {
			String sql = "update LopHocPhan set isThiPhongMay = 0 where maLopHoc = " + maLop;
			PreparedStatement pst = connectSQL.getInstance().getConn().prepareStatement(sql);
			pst.executeUpdate();
			return true;
		}catch(Exception e){}
		return false;
	}
	
	public boolean SetPhongMay(String maLop)
	{
		connectSQL.getInstance().ConnectToDatabase();
		try {
			String sql = "update LopHocPhan set isThiPhongMay = 1 where maLopHoc = " + maLop;
			PreparedStatement pst = connectSQL.getInstance().getConn().prepareStatement(sql);
			pst.executeUpdate();
			return true;
		}catch(Exception e){}
		return false;
	}
}

