package DAL;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ThoiGianDAL {
	private static ThoiGianDAL instance;
	private ThoiGianDAL() {}
	public static ThoiGianDAL getInstance()
	{
		if(instance == null)
			instance = new ThoiGianDAL();
		return instance;
	}
	
	public ArrayList<Integer> getListTuanThi()
	{
		ArrayList<Integer> dsTuan = new ArrayList<Integer>();
		connectSQL.getInstance().ConnectToDatabase();
		LocalDate now = LocalDate.now();
		try
		{
			String sqL = "select NgayBatDau, soTuan From ThoiGian";
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
			while(connectSQL.getInstance().result.next())
			{
				Date temp = connectSQL.getInstance().result.getDate("NgayBatDau");
				if(now.compareTo(temp.toLocalDate()) > 0)
				{
					continue;
				}
				else
				{
					dsTuan.add(connectSQL.getInstance().result.getInt("soTuan"));
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dsTuan;
	}
	
	public int getSoTuanMax() throws SQLException
	{
		connectSQL.getInstance().ConnectToDatabase();
		String sqL = "select MAX(soTuan) from ThoiGian";
		connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
		connectSQL.getInstance().result.next();
		return connectSQL.getInstance().result.getInt(1);
	}
}
