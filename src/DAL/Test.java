package DAL;

import java.awt.EventQueue;
import java.sql.SQLException;

import GUI.view.Login;


public class Test {
	public static void main(String[] args) throws SQLException {
//		ToMauDoThi a = new ToMauDoThi(connectSQL.getdata().getListHocPhanThuong(),connectSQL.getdata().getListPhongHocThuong());	
//		a.ShowDanhSachTheoMau();
//		System.out.println(1);
//		XepLich b = new XepLich();
//		System.out.println(2);
//		for(int i = 0 ; i < connectSQL.getdata().getListHocPhanMay().size(); i++)
//		{
//			System.out.println(connectSQL.getdata().getListHocPhanMay().get(i));
//		}
//		ArrayList<ArrayList<HocPhan>> a = ToMauDoThi.getListHocPhanMayTheoMau();
//		for(ArrayList<HocPhan> temp : a)
//		{
//			System.out.println(temp);
////		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
//					ManHinhChinh_GV frame = new ManHinhChinh_GV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//		String[][] data = LopHocPhanBLL.getInstance().getListHocPhanDangKy("102001");
//		System.out.println(data);
//		ArrayList<ArrayList<String>> temp = LopHocPhanDAL.getInstance().getListHocPhanDangKy("102001");
//		for(ArrayList<String> a : temp)
//		{
//			System.out.println(a);
//		}
//		ManHinhChinh manHinhChinh = new ManHinhChinh();
//		manHinhChinh.setVisible(true);
		
//		ManHinhChinh_SV manHinhChinh = new ManHinhChinh_SV();
//		manHinhChinh.setVisible(true);

//		LichThiDAL.getInstance().test();
		//ArrayList<LopHocPhan> DuLieu = connectSQL.getInstance().getListLopHocPhan();
//		
//		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
//		a = LichThiDAL.getInstance().getLichThiChoSVien(102210383);
//		for(ArrayList<String> temp : a)
//		{
//			System.out.println(temp);
//		}
	}
}



