package DAL;


import java.sql.SQLException;
import java.util.ArrayList;

import DTO.GiangVien;

public class GiangVienDAL {
	private static GiangVienDAL instance;
	private GiangVienDAL() {}
	public static GiangVienDAL getInstance()
	{
		if(instance == null) {
			instance = new GiangVienDAL();
		}
		return instance;
	}
	
	
	
	public ArrayList<GiangVien> getListGVien()
	{
		ArrayList<GiangVien> dsGV = new ArrayList<GiangVien>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from GiangVien";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			
			while(connectSQL.getInstance().result.next())
			{
				GiangVien gv = new GiangVien(connectSQL.getInstance().result.getInt("IDGiangVien"),connectSQL.getInstance().result.getString("HoTen"),connectSQL.getInstance().result.getBoolean("GioiTinh"),connectSQL.getInstance().result.getDate("NgaySinh"),connectSQL.getInstance().result.getString("QueQuan"),connectSQL.getInstance().result.getString("ChucDanhKH"),connectSQL.getInstance().result.getString("SoDienThoai"));
				dsGV.add(gv);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsGV;
	}
	public ArrayList<GiangVien> SearchGV(String chuoiTim){
		ArrayList<GiangVien> dsGV = new ArrayList<GiangVien>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select IDGiangVien, HoTen from GiangVien where HoTen like N'%" + chuoiTim + "%'"
				+ " or IDGiangVien like N'%" + chuoiTim + "%'";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				GiangVien gv = new GiangVien(connectSQL.getInstance().result.getInt("IDGiangVien"), 
						connectSQL.getInstance().result.getString("HoTen"));
				dsGV.add(gv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsGV;
	}
	public GiangVien getGiangVien(String idGV){
		GiangVien gv = null;
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from GiangVien where IDGiangVien = " + idGV;
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				gv = new GiangVien(Integer.parseInt(connectSQL.getInstance().result.getString("IDGiangVien")), 
						connectSQL.getInstance().result.getString("HoTen"),
						connectSQL.getInstance().result.getBoolean("GioiTinh"),
						connectSQL.getInstance().result.getDate("NgaySinh"),
						connectSQL.getInstance().result.getString("QueQuan"),
						connectSQL.getInstance().result.getString("ChucDanhKH"),
						connectSQL.getInstance().result.getString("SoDienThoai"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gv;
	}
}
