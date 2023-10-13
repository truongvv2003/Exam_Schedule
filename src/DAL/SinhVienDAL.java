package DAL;


import java.sql.SQLException;
import java.util.ArrayList;

import DTO.GiangVien;
import DTO.SinhVien;

public class SinhVienDAL {
	private static SinhVienDAL instance;
	private SinhVienDAL() {}
	public static SinhVienDAL getInstance()
	{
		if(instance == null) {
			instance = new SinhVienDAL();
		}
		return instance;
	}
	public SinhVien getSinhVien(String maSV) {
		SinhVien sv = null;
		connectSQL.getInstance().ConnectToDatabase();
		try {
			String sqL = "select * from SinhVien where IDSv = " + maSV;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			
			while(connectSQL.getInstance().result.next()) {
			
				sv = new SinhVien(connectSQL.getInstance().result.getInt("IDSv"), connectSQL.getInstance().result.getString("HoTen"),
						connectSQL.getInstance().result.getString("Lop"), connectSQL.getInstance().result.getString("NganhHoc"),
						connectSQL.getInstance().result.getBoolean("GioiTinh"), connectSQL.getInstance().result.getString("NoiSinh"),
						connectSQL.getInstance().result.getString("SoDienThoai"),
						connectSQL.getInstance().result.getDate("NgaySinh"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sv;
	}
	public ArrayList<SinhVien> getListSvien()
	{
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select * from SinhVien";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			
			while(connectSQL.getInstance().result.next())
			{
				SinhVien sv = new SinhVien(connectSQL.getInstance().result.getInt("IDSv"),connectSQL.getInstance().result.getString("HoTen"),connectSQL.getInstance().result.getString("Lop"));
				dsSV.add(sv);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;
	}
	
	public ArrayList<Integer> getListIDSVienTrongHocPhan(int maHocPhan)
	{
		ArrayList<Integer> dsSV = new ArrayList<Integer>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL =
					"select SinhVien.IDSv from SinhVien join HocSinhTrongLop "
					+"on SinhVien.IDSv = HocSinhTrongLop.IDSv "
					+"join LopHocPhan "
					+"on HocSinhTrongLop.maLopHoc = LopHocPhan.maLopHoc " 
					+"where LopHocPhan.maHocPhan = "+ maHocPhan;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			
			while(connectSQL.getInstance().result.next())
			{
				dsSV.add(connectSQL.getInstance().result.getInt("IDSv"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;
	}
	public ArrayList<Integer> getListIDSVienTrongHocPhanThuong(int maHocPhan)
	{
		ArrayList<Integer> dsSV = new ArrayList<Integer>();
		connectSQL.getInstance() .ConnectToDatabase();
		try
		{
			String sqL =
					"select SinhVien.IDSv from SinhVien join HocSinhTrongLop "
					+"on SinhVien.IDSv = HocSinhTrongLop.IDSv "
					+"join LopHocPhan "
					+"on HocSinhTrongLop.maLopHoc = LopHocPhan.maLopHoc " 
					+"where LopHocPhan.maHocPhan = "+ maHocPhan
					+" and LopHocPhan.isThiPhongMay = 0";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			
			while(connectSQL.getInstance().result.next())
			{
				dsSV.add(connectSQL.getInstance().result.getInt("IDSv"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;
	}
	public ArrayList<Integer> getListIDSVienTrongHocPhanMay(int maHocPhan)
	{
		ArrayList<Integer> dsSV = new ArrayList<Integer>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL =
					"select SinhVien.IDSv from SinhVien join HocSinhTrongLop "
					+"on SinhVien.IDSv = HocSinhTrongLop.IDSv "
					+"join LopHocPhan "
					+"on HocSinhTrongLop.maLopHoc = LopHocPhan.maLopHoc " 
					+"where LopHocPhan.maHocPhan = "+ maHocPhan
					+" and LopHocPhan.isThiPhongMay = 1";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			
			while(connectSQL.getInstance().result.next())
			{
				dsSV.add(connectSQL.getInstance().result.getInt("IDSv"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;
	}
	public ArrayList<SinhVien> getListSVienTrongLop(int maLop)
	{
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL =
			"select SinhVien.IDSv,HoTen,Lop from SinhVien join HocSinhTrongLop "
			+"on SinhVien.IDSv = HocSinhTrongLop.IDSv "
			+"join LopHocPhan "
			+"on HocSinhTrongLop.maLopHoc = LopHocPhan.maLopHoc "
			+"where LopHocPhan.maLopHoc = " + maLop;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			
			while(connectSQL.getInstance().result.next())
			{
				SinhVien sv = new SinhVien(connectSQL.getInstance().result.getInt("IDSv"),connectSQL.getInstance().result.getString("HoTen"),connectSQL.getInstance().result.getString("Lop"));
				dsSV.add(sv);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;
	}
	public ArrayList<SinhVien> getListSVienTrongHocPhan(int maHocPhan)
	{
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		connectSQL .getInstance().ConnectToDatabase();
		try
		{
			String sqL =
					"select SinhVien.IDSv,HoTen,Lop from SinhVien join HocSinhTrongLop "
					+"on SinhVien.IDSv = HocSinhTrongLop.IDSv "
					+"join LopHocPhan "
					+"on HocSinhTrongLop.maLopHoc = LopHocPhan.maLopHoc " 
					+"where LopHocPhan.maHocPhan = "+ maHocPhan;
			connectSQL .getInstance().result = connectSQL .getInstance().statement.executeQuery(sqL);
			
			while(connectSQL .getInstance().result.next())
			{
				SinhVien sv = new SinhVien(connectSQL .getInstance().result.getInt("IDSv"),connectSQL .getInstance().result.getString("HoTen"),connectSQL .getInstance().result.getString("Lop"));
				dsSV.add(sv);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;
	}
	public ArrayList<Integer> getListIDSvien()
	{
		ArrayList<Integer> dsSV = new ArrayList<Integer>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select IDSv from SinhVien";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			
			while(connectSQL.getInstance().result.next())
			{
				dsSV.add(connectSQL.getInstance().result.getInt("IDSv"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSV;
	}
	public ArrayList<ArrayList<Integer>> getListIDSVienTrongHocPhan()
	{
		ArrayList<ArrayList<Integer>> dsSVinHP = new ArrayList<ArrayList<Integer>>();
		connectSQL.getInstance().ConnectToDatabase();
		ArrayList<Integer> temp = HocPhanDAL.getInstance().getListMaHocPhan();
		for(int i = 0 ; i < temp.size(); i++)
		{
			//System.out.println("i: " + i);
			ArrayList<Integer> temp1 = this.getListIDSVienTrongHocPhan(temp.get(i));
			dsSVinHP.add(temp1);
		}
		return dsSVinHP;
	}
	
	public ArrayList<SinhVien> SearchSV(String chuoiTim){
		ArrayList<SinhVien> dsSV = new ArrayList<SinhVien>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select IDSv, HoTen from SinhVien where HoTen like N'%" + chuoiTim + "%'"
				+ " or IDSv like N'%" + chuoiTim + "%'";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				SinhVien sv = new SinhVien(connectSQL.getInstance().result.getInt("IDSv"), 
						connectSQL.getInstance().result.getString("HoTen"));
				dsSV.add(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSV;
	}
	public ArrayList<Object> SearchSV_GV(String chuoiTim){
		ArrayList<Object> dsChung = new ArrayList<Object>();
		ArrayList<SinhVien> dsSv = this.SearchSV(chuoiTim);
		ArrayList<GiangVien> dsGv = GiangVienDAL.getInstance().SearchGV(chuoiTim);
		dsChung.addAll(dsSv);
		dsChung.addAll(dsGv);
		return dsChung;
	}
}
