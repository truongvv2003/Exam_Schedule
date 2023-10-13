package DAL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.GiangVien;
import DTO.SinhVien;
import DTO.User;


public class CheckUser {
	
	private static CheckUser instance;
	
	public static CheckUser getInstance()
	{
		if(instance == null)
		{
			instance = new CheckUser();
		}
		return instance;
	}
	
	public boolean isNumber(String str)
	{
	    if (str == null) {
	        return false;
	    }
	    try {
	        @SuppressWarnings("unused")
			int d = Integer.parseInt(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public int checkLogin(String taiKhoan, String matKhau) throws SQLException //0 la sai tk mk, 1 la hoc sinh, 2 la giao vien
	{
		if(isNumber(taiKhoan) == false) return 0;
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select PhanQuyen from [User] where TaiKhoan = " + taiKhoan + " and MatKhau = '" + matKhau+"'";
		connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
		if(connectSQL.getInstance().result.next())
		{
			//connectSQL.getInstance().result.first();
			boolean phanQuyen = connectSQL.getInstance().result.getBoolean("PhanQuyen");
			if(phanQuyen == false) return 1;
			else return 2;
		}
		return 0;
	}
	
	public boolean saveAdmin(String taiKhoan, String matKhau)
	{
		try
		{
			FileOutputStream fos=new FileOutputStream("D:\\Admin.txt");	
			OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw=new BufferedWriter(osw);
			String line = taiKhoan + " " + matKhau;
			bw.write(line);
			
			bw.close();
			osw.close();
			fos.close();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean checkAdmin(String taiKhoan, String matKhau) {
	    String user = "", password = "";
	    try {
	        FileInputStream fis = new FileInputStream("D:\\Admin.txt");
	        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
	        BufferedReader br = new BufferedReader(isr);

	        String line = br.readLine();
	        if (line != null) {
	            String[] arr = line.split(" ");
	            if (arr.length == 2) {
	                user = arr[0];
	                password = arr[1];
	            }
	        }
	        br.close();
	        isr.close();
	        fis.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    System.out.println(user+password);
	    if (user.equals(taiKhoan) && password.equals(matKhau)) {
	        return true;
	    } else {
	        return false;
	    }
	}

	public boolean doiMatKhau(String taiKhoan, String newpwd)
	{
		try {
			String sql = "update [User] "
					+ "set MatKhau = '" +  newpwd
					+"' where TaiKhoan = " + taiKhoan;
			PreparedStatement pst = connectSQL.getInstance().getConn().prepareStatement(sql);
			pst.executeUpdate();
			return true;
		}catch(Exception e){}
		return false;
	}
	
	public boolean resetMatKhau(int taiKhoan)
	{
		try {
			String sql = "update [User] "
					+ "set MatKhau = '" + taiKhoan
					+"' where TaiKhoan = " + taiKhoan;
			PreparedStatement pst = connectSQL.getInstance().getConn().prepareStatement(sql);
			pst.executeUpdate();
			return true;
		}catch(Exception e){}
		return false;
	}
	
	public User getUser(String taiKhoan)
	{
		User user = new User();
		try
		{	
			String sql = "select * from [User] where TaiKhoan = " + taiKhoan;
			ResultSet rs = connectSQL.getInstance().getStatement().executeQuery(sql);	
			user.setTaiKhoan(rs.getInt("TaiKhoan"));
			user.setMatKhau(rs.getString("MatKhau"));
			user.setPhanQuyen(rs.getBoolean("PhanQuyen"));
			return user;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return user;
	}
	public String getMatKhauUser(int taiKhoan)
	{
		String password = new String();
		try
		{	
			String sql = "select MatKhau from [User] where TaiKhoan = " + taiKhoan;
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			connectSQL.getInstance().result.next();
			return connectSQL.getInstance().result.getString("MatKhau");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return password;
	}
	public ArrayList<String> getMatKhau(String chuoiTim){
		ArrayList<String> dsMatKhau = new ArrayList<String>();
		ArrayList<Object> dsChung = new ArrayList<Object>();
		dsChung = SinhVienDAL.getInstance().SearchSV_GV(chuoiTim);
		connectSQL.getInstance().ConnectToDatabase();
		
		for(int i = 0; i < dsChung.size(); i++) {
			if(dsChung.get(i) instanceof SinhVien) {
				SinhVien sv = (SinhVien) dsChung.get(i);
				String sqL = "select * from [User] where TaiKhoan = " + sv.getIDSv();
				try {
					connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
					if(connectSQL.getInstance().result.next())
					dsMatKhau.add(connectSQL.getInstance().result.getString("MatKhau"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			if(dsChung.get(i) instanceof GiangVien) {
				GiangVien gv = (GiangVien) dsChung.get(i);
				String sqL = "select MatKhau from [User] where TaiKhoan = " + gv.getIDGiangVien();
				try {
					connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sqL);
					if(connectSQL.getInstance().result.next());
					dsMatKhau.add(connectSQL.getInstance().result.getString("MatKhau"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		return dsMatKhau;
	}
	public ArrayList<String> getTinh(){
		ArrayList<String> listTinh = new ArrayList<String>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from Tinh";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				listTinh.add(connectSQL.getInstance().result.getString("Province"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTinh;
	}
}
