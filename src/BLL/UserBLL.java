package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAL.CheckUser;

public class UserBLL {
	private static UserBLL instance;
	
	private UserBLL() {}
	
	public static UserBLL getInstance()
	{
		if(instance == null)
		{
			instance = new UserBLL();
		}
		return instance;
	}
	
	public int checkLogin(String taiKhoan, String matKhau) throws SQLException // 0 la sai tk mk , 1 la sinh vien , 2 la giao vien
	{
		return CheckUser.getInstance().checkLogin(taiKhoan, matKhau);
	}
	
	public boolean checkAdmin(String taiKhoan, String matKhau)
	{
		return CheckUser.getInstance().checkAdmin(taiKhoan, matKhau);
	}
	
	public boolean doiMatKhau(String taiKhoan, String newpwd)
	{
		return CheckUser.getInstance().doiMatKhau(taiKhoan, newpwd);
	}
	
	public boolean resetMatKhau(int taiKhoan)
	{
		return CheckUser.getInstance().resetMatKhau(taiKhoan);
	}
	public ArrayList<String> getMatKhau(String chuoiTim){
		return CheckUser.getInstance().getMatKhau(chuoiTim);
	}
	public boolean saveAdmin(String TaiKhoan, String MatKhau) {
		return CheckUser.getInstance().saveAdmin(TaiKhoan, MatKhau);
	}
	public String getMatKhauUser(int taiKhoan)
	{
		return CheckUser.getInstance().getMatKhauUser(taiKhoan);
	}
	public ArrayList<String> getTinh(){
		return CheckUser.getInstance().getTinh();
	}
}
