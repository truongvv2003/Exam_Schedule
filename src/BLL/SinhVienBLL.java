package BLL;

import DTO.SinhVien;

import java.util.ArrayList;

import DAL.SinhVienDAL;
import DAL.connectSQL;

public class SinhVienBLL {
	private static SinhVienBLL instance;
	
	private SinhVienBLL()
	{
		
	}
	
	public static SinhVienBLL getInstance()
	{
		if(instance == null)
		{
			instance = new SinhVienBLL();
		}
		return instance;
	}
	
	public ArrayList<SinhVien> getListSVienTrongLop(int maLopHoc)
	{
		return SinhVienDAL.getInstance().getListSVienTrongLop(maLopHoc);
	}
	
	public SinhVien getSinhVien(String maSv) {
		return SinhVienDAL.getInstance().getSinhVien(maSv);
	}
	public ArrayList<Object> SearchSV_GV(String chuoiTim){
		return SinhVienDAL.getInstance().SearchSV_GV(chuoiTim);
	}
	@SuppressWarnings("unused")
	public void UpdateThongTinSV(String MaSV, String NoiSinh, String SDT) {
		connectSQL.getInstance().ConnectToDatabase();
		try {
			String sql = "update SinhVien "
					+ "set NoiSinh = N'" + NoiSinh + "', SoDienThoai = '" + SDT 
					+"' where IDSv = " + MaSV;
			int rowUpdated = connectSQL.getInstance().statement.executeUpdate(sql);
		}catch(Exception e){}
	}
}
