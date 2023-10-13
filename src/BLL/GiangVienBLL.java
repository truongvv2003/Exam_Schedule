package BLL;

import java.util.ArrayList;

import DAL.GiangVienDAL;
import DAL.connectSQL;
import DTO.GiangVien;

public class GiangVienBLL {
	private static GiangVienBLL instance;
	private GiangVienBLL() {}
	public static GiangVienBLL getInstance()
	{
		if(instance == null)
			instance = new GiangVienBLL();
		return instance;
	}
	
	public ArrayList<GiangVien> getListGiangVien()
	{
		return GiangVienDAL.getInstance().getListGVien();
	}
	public GiangVien getGiangVien(String idGV) {
		return GiangVienDAL.getInstance().getGiangVien(idGV);
	}
	@SuppressWarnings("unused")
	public void UpdateThongTinGV(String MaGV, String NoiSinh, String SDT) {
		connectSQL.getInstance().ConnectToDatabase();
		try {
			String sql = "update GiangVien "
					+ "set QueQuan = N'" + NoiSinh + "', SoDienThoai = '" + SDT 
					+"' where IDGiangVien = " + MaGV;
			int rowUpdated = connectSQL.getInstance().statement.executeUpdate(sql);
		}catch(Exception e){}
	}
	
}
