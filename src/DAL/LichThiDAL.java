package DAL;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import DTO.LichThi;

public class LichThiDAL {
	private static LichThiDAL instance;
	private LichThiDAL() {}
	public static LichThiDAL getInstance()
	{
		if(instance == null) {
			instance = new LichThiDAL();
		}
		return instance;
	}
	
	public void insertHocSinhTrongPhongThi(LichThi lichThi)
	{
		connectSQL.getInstance().ConnectToDatabase();
		try {
		for(int i = 0 ; i < lichThi.getIDDSSv().size(); i++)
			{
				String sql = "insert into HocSinhTrongPhongThi (maLich,IDSv) values (?,?)";
				PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
				pst.setString(1, lichThi.getMaLich());
				pst.setInt(2, lichThi.getIDDSSv().get(i));
				pst.executeUpdate();
			}
		}catch(Exception e)
		{
			
		}
	}
	public void insertLichThi(LichThi lichThi)
	{
		try
		{
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "insert into LichThi (maLich,Tuan,Thu,TietBatDau,TietKetThuc,maPhong,maHocPhan) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.setString(1, lichThi.getMaLich());
			pst.setInt(2, lichThi.getTuan());
			pst.setInt(3, lichThi.getThu());
			pst.setInt(4, lichThi.getTietBatDau());
			pst.setInt(5, lichThi.getTietKetThuc());
			pst.setInt(6, lichThi.getMaPhong());
			pst.setInt(7, lichThi.getMaHocPhan());
			pst.executeUpdate();
			this.insertHocSinhTrongPhongThi(lichThi);
		}catch(Exception e){
			
		}
	}
	public void deleteDataInLichThi()
	{
		try {
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "DELETE FROM LichThi";
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	public void deleteDataInHocSinhTrongPhongThi()
	{
		try {
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "DELETE FROM HocSinhTrongPhongThi";
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	public ArrayList<Integer> getListTuanThi()
	{
		ArrayList<Integer> dsTuan = new ArrayList<Integer>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select soTuan From ThoiGian";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				dsTuan.add(connectSQL.getInstance().result.getInt("soTuan"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dsTuan;
	}
	
	public ArrayList<LichThi> getListLichThiTheoPhong(String maPhong)
	{
		System.out.println(maPhong);
		ArrayList<LichThi> dsLichThi = new ArrayList<LichThi>();
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sql = "select * from lichthi where maPhong =" + maPhong;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next())
			{
				String maLich = connectSQL.getInstance().result.getString("maLich");
				int Tuan = connectSQL.getInstance().result.getInt("Tuan");
				int Thu = connectSQL.getInstance().result.getInt("Thu") - 2  ;
				int TietBatDau = connectSQL.getInstance().result.getInt("TietBatDau") - 1;
				int TietKetThuc = connectSQL.getInstance().result.getInt("TietKetThuc") - 1;
				int maHocPhan = connectSQL.getInstance().result.getInt("maHocPhan");
				LichThi temp = new LichThi(maLich,Tuan,Thu,TietBatDau,TietKetThuc,Integer.parseInt(maPhong),maHocPhan);
				dsLichThi.add(temp);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dsLichThi;
	}
	
	public boolean setLuiTuan(int soTuanLuiLai)
	{
		try {
			String sql = "update LichThi set Tuan = Tuan -" + soTuanLuiLai;
			PreparedStatement pst = connectSQL.getInstance().getConn().prepareStatement(sql);
			pst.executeUpdate();
			return true;
		}catch(Exception e){}
		return false;
	}
	
	public ArrayList<ArrayList<String>> getLichThiChoSVien(int IDSV)
	{
		ArrayList<ArrayList<String>> lichThiSVien = new ArrayList<ArrayList<String>>();
		connectSQL.getInstance().ConnectToDatabase();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		Calendar calendar = Calendar.getInstance();
		try
		{
			String sql = "select distinct Tuan,Thu,TietBatDau,TietKetThuc,maPhong,TenHocPhan,NgayBatDau"
					+" from LichThi join HocSinhTrongPhongThi"
					+" on LichThi.maLich = HocSinhTrongPhongThi.maLich"
					+" join ThoiGian on LichThi.Tuan = ThoiGian.soTuan"
					+" join HocPhan on HocPhan.maHocPhan = LichThi.maHocPhan"
					+" where HocSinhTrongPhongThi.IDSv = "+ IDSV;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next())
			{
				ArrayList<String> data = new ArrayList<String>();
				data.add(Integer.toString(connectSQL.getInstance().result.getInt("Tuan")));
				int thu = connectSQL.getInstance().result.getInt("Thu");
				int tietBatDau = connectSQL.getInstance().result.getInt("TietBatDau");
				data.add(Integer.toString(tietBatDau));
				data.add(Integer.toString(connectSQL.getInstance().result.getInt("TietKetThuc")-tietBatDau));
				data.add(Integer.toString(connectSQL.getInstance().result.getInt("maPhong")));
				data.add(connectSQL.getInstance().result.getString("TenHocPhan"));
				Date temp = connectSQL.getInstance().result.getDate("NgayBatDau");
				calendar.setTime(temp);
				calendar.add(Calendar.DATE, thu - 2);
				data.add(dateFormat.format(calendar.getTime()));
				lichThiSVien.add(data);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lichThiSVien;
	}
	public int XoaLichThi() {
		String delete = "DELETE FROM HocSinhTrongPhongThi\r\n"
				+ "DELETE FROM LichThi";
		int rowUpdate = 0;
		try {
			rowUpdate = connectSQL.getInstance().statement.executeUpdate(delete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdate;
		
	}
}

