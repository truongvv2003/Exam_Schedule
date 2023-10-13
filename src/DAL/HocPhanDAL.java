package DAL;


import java.util.ArrayList;

import DTO.HocPhan;

public class HocPhanDAL {
	private static HocPhanDAL instance;
	private HocPhanDAL() {}
	public static HocPhanDAL getInstance()
	{
		if(instance == null) {
			instance = new HocPhanDAL();
		}
		return instance;
	}
	
	public ArrayList<HocPhan> getListHocPhan()
	{
		ArrayList<HocPhan> dsHP = new ArrayList<HocPhan>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from HocPhan";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				int maHocPhan = connectSQL.getInstance().result.getInt("maHocPhan");
				String tenHocPhan = connectSQL.getInstance().result.getString("TenHocPhan");
				int SoTietThi = connectSQL.getInstance().result.getInt("SoTietThi");
				HocPhan hp = new HocPhan(maHocPhan, tenHocPhan, SoTietThi);
				dsHP.add(hp);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		for(int i = 0 ; i < dsHP.size(); i++)
		{
			ArrayList<Integer> DsSv = new ArrayList<Integer>();
			DsSv = SinhVienDAL.getInstance().getListIDSVienTrongHocPhan(dsHP.get(i).getMaHocPhan());
			dsHP.get(i).setDsSv(DsSv);
		}
		return dsHP;
	}
	public ArrayList<HocPhan> getListHocPhanThuong()
	{
		ArrayList<HocPhan> dsHP = new ArrayList<HocPhan>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select distinct HocPhan.maHocPhan,TenHocPhan,SoTietThi from HocPhan join LopHocPhan "
					+"on HocPhan.maHocPhan = LopHocPhan.maHocPhan "
					+"where LopHocPhan.isThiPhongMay = 0";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				int maHocPhan = connectSQL.getInstance().result.getInt("maHocPhan");
				String tenHocPhan = connectSQL.getInstance().result.getString("TenHocPhan");
				int SoTietThi = connectSQL.getInstance().result.getInt("SoTietThi");
				HocPhan hp = new HocPhan(maHocPhan, tenHocPhan, SoTietThi);
				dsHP.add(hp);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		for(int i = 0 ; i < dsHP.size(); i++)
		{
			ArrayList<Integer> DsSv = new ArrayList<Integer>();
			DsSv = SinhVienDAL.getInstance().getListIDSVienTrongHocPhanThuong(dsHP.get(i).getMaHocPhan());
			dsHP.get(i).setDsSv(DsSv);
		}
		return dsHP;
	}
	public ArrayList<HocPhan> getListHocPhanMay()
	{
		ArrayList<HocPhan> dsHP = new ArrayList<HocPhan>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select distinct HocPhan.maHocPhan,TenHocPhan,SoTietThi from HocPhan join LopHocPhan "
					+"on HocPhan.maHocPhan = LopHocPhan.maHocPhan "
					+"where LopHocPhan.isThiPhongMay = 1";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				int maHocPhan = connectSQL.getInstance().result.getInt("maHocPhan");
				String tenHocPhan = connectSQL.getInstance().result.getString("TenHocPhan");
				int SoTietThi = connectSQL.getInstance().result.getInt("SoTietThi");
				HocPhan hp = new HocPhan(maHocPhan, tenHocPhan, SoTietThi);
				dsHP.add(hp);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		for(int i = 0 ; i < dsHP.size(); i++)
		{
			ArrayList<Integer> DsSv = new ArrayList<Integer>();
			DsSv = SinhVienDAL.getInstance().getListIDSVienTrongHocPhanMay(dsHP.get(i).getMaHocPhan());
			dsHP.get(i).setDsSv(DsSv);
		}
		return dsHP;
	}
	public ArrayList<Integer> getListMaHocPhan()
	{
		ArrayList<Integer> dsHP = new ArrayList<Integer>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from HocPhan";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				dsHP.add(connectSQL.getInstance().result.getInt("maHocPhan"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsHP;
	}
	
	public String getTenHocPhan(int maHocPhan)
	{
		String name = new String();
		try
		{
			String sqL = "select TenHocPhan from HocPhan where maHocPhan = " + maHocPhan;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				name = connectSQL.getInstance().result.getString("TenHocPhan");
			}
			return name;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return name;
	}
	
}
