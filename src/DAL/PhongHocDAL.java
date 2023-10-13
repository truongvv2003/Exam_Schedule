package DAL;


import java.util.ArrayList;

import DTO.PhongHoc;

public class PhongHocDAL {
	private static PhongHocDAL instance;
	private PhongHocDAL() {}
	public static PhongHocDAL getInstance()
	{
		if(instance == null) {
			instance = new PhongHocDAL();
		}
		return instance;
	}
	public ArrayList<PhongHoc> getListPhongHoc()
	{
		ArrayList<PhongHoc> dsPH = new ArrayList<PhongHoc>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from PhongHoc";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				PhongHoc ph = new PhongHoc(connectSQL.getInstance().result.getInt("maPhong"),connectSQL.getInstance().result.getInt("sucChua"),connectSQL.getInstance().result.getBoolean("isPhongMay"));
				dsPH.add(ph);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsPH;
	}
	
	public ArrayList<PhongHoc> getListPhongHocThuong()
	{
		ArrayList<PhongHoc> dsPH = new ArrayList<PhongHoc>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from PhongHoc where isPhongMay = 0";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				PhongHoc ph = new PhongHoc(connectSQL.getInstance().result.getInt("maPhong"),connectSQL.getInstance().result.getInt("sucChua"),connectSQL.getInstance().result.getBoolean("isPhongMay"));
				dsPH.add(ph);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsPH;
	}
	
	public ArrayList<PhongHoc> getListPhongMay()
	{
		ArrayList<PhongHoc> dsPH = new ArrayList<PhongHoc>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from PhongHoc where isPhongMay = 1";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				PhongHoc ph = new PhongHoc(connectSQL.getInstance().result.getInt("maPhong"),connectSQL.getInstance().result.getInt("sucChua"),connectSQL.getInstance().result.getBoolean("isPhongMay"));
				dsPH.add(ph);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsPH;
	}
	public ArrayList<Integer> getListMaPhong()
	{
		ArrayList<Integer> dsMaPhong = new ArrayList<Integer>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select maPhong from PhongHoc";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				dsMaPhong.add(connectSQL.getInstance().result.getInt("maPhong"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsMaPhong;
	}
}
