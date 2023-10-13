package DAL;

import java.sql.PreparedStatement;
import java.time.LocalDate;

public class KeHoachDAL {
	private static KeHoachDAL instance;
	private KeHoachDAL() {}
	public static KeHoachDAL getInstance()
	{
		if(instance == null)
			instance = new KeHoachDAL();
		return instance;
	}
	
	public int getTuanBatDau()
	{
		int tuanBatDau;
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select TuanBatDau From KeHoach";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			connectSQL.getInstance().result.next();
			tuanBatDau = connectSQL.getInstance().result.getInt("TuanBatDau");
			return tuanBatDau;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getTuanKetThuc()
	{
		int tuanKetThuc;
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select TuanKetThuc From KeHoach";
			if(connectSQL.getInstance().ExcecuteNonQuery(sqL) < 1) return 0;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			connectSQL.getInstance().result.next();
			tuanKetThuc = connectSQL.getInstance().result.getInt("TuanKetThuc");
			return tuanKetThuc;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public void addDuLieuKeHoach(int tuanBatDau, int tuanKetThuc)
	{
		this.xoaDuLieuKeHoach();
		try
		{
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "insert into KeHoach (TuanBatDau,TuanKetThuc) values (?,?)";
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.setInt(1,tuanBatDau);
			pst.setInt(2, tuanKetThuc);
			pst.executeUpdate();
		}catch(Exception e){
			
		}
	}
	
	public void xoaDuLieuKeHoach()
	{
		try {
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "DELETE FROM KeHoach";
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	
	public LocalDate getNgayBatDau()
	{
		connectSQL.getInstance().ConnectToDatabase();
		try
		{
			String sqL = "select NgayBatDau From KeHoach join ThoiGian on KeHoach.TuanBatDau = ThoiGian.soTuan";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			connectSQL.getInstance().result.next();
			return connectSQL.getInstance().result.getDate("NgayBatDau").toLocalDate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return LocalDate.now();
	}
}
