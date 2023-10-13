package DAL;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.*;
import GUI.view.Admin.PanelXepLichThi_ThoiGianThi;


public class XepLich extends Thread {
	private ThreadCompleteListner listener;
	private int soTuanThi;
	private int tuanBatDau;
	private LichThi lichThi;
	private KeHoach keHoach;
	public KeHoach getKeHoach() {
		return keHoach;
	}

	public void setKeHoach(KeHoach keHoach) {
		this.keHoach = keHoach;
	}

	public int getSoTuanThi() {
		return soTuanThi;
	}

	public void setSoTuanThi(int soTuanThi) {
		this.soTuanThi = soTuanThi;
	}
	public LichThi getLichThi() {
		return lichThi;
	}

	public void setLichThi(LichThi lichThi) {
		this.lichThi = lichThi;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		
    	//this.setSoTuanThi(this.keHoach.getSoTuanThi());
    	LichThiDAL.getInstance().deleteDataInHocSinhTrongPhongThi();
    	LichThiDAL.getInstance().deleteDataInLichThi();
    	this.ThuatToanXepLich();
    	this.ThuatToanXepLichPhongMay();
    	int soTuanLuiLai = 0;
    	try {
			if(tuanBatDau+this.soTuanThi-1 > ThoiGianDAL.getInstance().getSoTuanMax())
			{
				soTuanLuiLai = tuanBatDau+this.soTuanThi-1-ThoiGianDAL.getInstance().getSoTuanMax();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(soTuanLuiLai > 0 && LichThiDAL.getInstance().setLuiTuan(soTuanLuiLai) == true) {
    		JOptionPane.showMessageDialog(null, "Không thể xếp lịch vì thời gian còn lại của học kỳ không đủ!!!");
    		
    	}
    	else {
    		KeHoachDAL.getInstance().addDuLieuKeHoach(tuanBatDau - soTuanLuiLai, tuanBatDau + this.soTuanThi - 1 - soTuanLuiLai);;
    		PanelXepLichThi_ThoiGianThi.tuanKetThuc.setText(Integer.toString(tuanBatDau + this.soTuanThi -1 - soTuanLuiLai));
    		PanelXepLichThi_ThoiGianThi.tuanBatDau.setSelectedItem(tuanBatDau - soTuanLuiLai);
    	}
    	this.listener.onThreadComplete(this);
	}
	
	public XepLich(int tuanBatDau, ThreadCompleteListner listner)
	{
		this.soTuanThi = 1;
		this.tuanBatDau = tuanBatDau;
		this.listener = listner;
    	//this.setSoTuanThi(this.keHoach.getSoTuanThi());
//    	LichThiDAL.getInstance().deleteDataInHocSinhTrongPhongThi();
//    	LichThiDAL.getInstance().deleteDataInLichThi();
//    	this.ThuatToanXepLich();
//    	this.ThuatToanXepLichPhongMay();
//    	KeHoachDAL.getInstance().addDuLieuKeHoach(tuanBatDau, tuanBatDau + this.soTuanThi - 1);;
	}
	
	public boolean CheckTietSau(ArrayList<ArrayList<PhongHoc>> phongTrongNgay,long soLuongSV, int i, int tiet, int tgThi)
	{
		if(tgThi == 1) return true;
		for(int j = 1; j < tgThi; j++)
		{
			if(phongTrongNgay.get(tiet + j).get(i).isPhongTrong() == false) return false;
		}
		return true;
	}
	public boolean ChonPhong(ArrayList<ArrayList<PhongHoc>> phongTrongNgay,ArrayList<ArrayList<HocPhan>> listHocPhanTheoMau ,int tuan, int thu, int tiet , int m, int k)
	{
		long sucChua = 0;
		int tgThi = listHocPhanTheoMau.get(m).get(k).getSoTietThi();
		for(int i =0 ; i < phongTrongNgay.get(tiet).size(); i++)
		{
			boolean Check = true;
			if(phongTrongNgay.get(tiet).get(i).isPhongTrong() == false) continue;
			else
			{
				if(tgThi > 1) {
				for(int j = 1 ; j < tgThi ; j++)
				{
					if(phongTrongNgay.get(tiet+j).get(i).isPhongTrong() == false)
						{
							Check = false;
							break;
						}
					}
				}
				if(Check == true) sucChua += phongTrongNgay.get(tiet).get(i).getSucChua();
			}
		}
		long soLuongSV = listHocPhanTheoMau.get(m).get(k).getDsSv().size();
		if(sucChua >= soLuongSV)
		{
			while(soLuongSV > 0)
			{
				int i;
				for(i = 0 ; i < phongTrongNgay.get(tiet).size(); i++)
				{
					if(soLuongSV > phongTrongNgay.get(tiet).get(i).getSucChua() && phongTrongNgay.get(tiet).get(i).isPhongTrong() == true  && CheckTietSau(phongTrongNgay,soLuongSV,i,tiet,tgThi) == true)
					{
						ArrayList<Integer> DsSv = new ArrayList<Integer>();
						for(int z = 0 ; z < phongTrongNgay.get(tiet).get(i).getSucChua(); z++)
						{
							if(listHocPhanTheoMau.get(m).get(k).getDsSv().size() == 0) break;
							DsSv.add(listHocPhanTheoMau.get(m).get(k).getDsSv().get(0));
							listHocPhanTheoMau.get(m).get(k).getDsSv().remove(0);
						}
						for(int j = 0 ; j < tgThi; j++)
						{
							phongTrongNgay.get(tiet+j).get(i).setPhongTrong(false);
						}
						LichThiDAL.getInstance().insertLichThi(new LichThi(this.tuanBatDau + tuan,thu+2,tiet+1,tiet+tgThi+1,phongTrongNgay.get(tiet).get(i).getMaPhong(),listHocPhanTheoMau.get(m).get(k).getMaHocPhan(),DsSv));
						soLuongSV -= phongTrongNgay.get(tiet).get(i).getSucChua();
						continue;
					}
					else if(soLuongSV <= phongTrongNgay.get(tiet).get(i).getSucChua())
					{
						for(int j = phongTrongNgay.get(tiet).size()-1 ; j >= i; j--)
						{
							if(soLuongSV <= phongTrongNgay.get(tiet).get(j).getSucChua() && phongTrongNgay.get(tiet).get(j).isPhongTrong() == true  && CheckTietSau(phongTrongNgay,soLuongSV,j,tiet,tgThi) == true)
							{
								ArrayList<Integer> DsSv = new ArrayList<Integer>();
								for(int z = 0 ; z < phongTrongNgay.get(tiet).get(j).getSucChua(); z++)
								{
									if(listHocPhanTheoMau.get(m).get(k).getDsSv().size() == 0) break;
									DsSv.add(listHocPhanTheoMau.get(m).get(k).getDsSv().get(0));
									listHocPhanTheoMau.get(m).get(k).getDsSv().remove(0);
								}
								for(int l = 0 ; l < tgThi; l++)
								{
									phongTrongNgay.get(tiet+l).get(j).setPhongTrong(false);
								}
								LichThiDAL.getInstance().insertLichThi(new LichThi(this.tuanBatDau +tuan,thu+2,tiet+1,tiet+tgThi+1,phongTrongNgay.get(tiet).get(j).getMaPhong(),listHocPhanTheoMau.get(m).get(k).getMaHocPhan(),DsSv));
								listHocPhanTheoMau.get(m).remove(k);		
								return true;
							}
						}
					}
					
				}
			}
		}
		else return false;
		return false;
	}
	
	public void ThuatToanXepLich()
	{
		ArrayList<ArrayList<HocPhan>> listHocPhanTheoMau = ToMauDoThi.getListHocPhanTheoMau();
		int tuan, thu, tiet;
		ArrayList<ArrayList<PhongHoc>> phongTrongNgay = new ArrayList<ArrayList<PhongHoc>>(10);
		for(int i = 0 ; i < 10 ; i++)
		{
			ArrayList<PhongHoc> temp = PhongHocDAL.getInstance().getListPhongHocThuong();
			phongTrongNgay.add(temp);
		}
		for(int m = 0 ; m < listHocPhanTheoMau.size(); m++)
		{
			if(listHocPhanTheoMau.get(m) != null)
			{
				for(tuan = 0; tuan < this.soTuanThi; tuan ++)
				{
					for(thu = 0; thu < 6; thu ++)
					{
						for(tiet = 0 ; tiet < 10 ; tiet++)
						{
							if(tiet == 5 || tiet == 0)
							{ 
								for(int i = 0 ; i < 10 ; i++)
								{
									for(int j = 0 ; j < phongTrongNgay.get(i).size(); j++)
									{
										phongTrongNgay.get(i).get(j).setPhongTrong(true);
									}
								}
							}
							for(int k = 0; k < listHocPhanTheoMau.get(m).size(); k++)
							{
								if(listHocPhanTheoMau.get(m).size() == 0)
								{
									break;
								}
								long tgThi = 0;
								if(tiet == 4 || tiet == 9)
								{
									tgThi = 1;
								}
								else
								{
									tgThi = (5 - tiet%5);
								}
								if(tgThi >= listHocPhanTheoMau.get(m).get(k).getSoTietThi())
								{
									if(ChonPhong(phongTrongNgay,listHocPhanTheoMau,tuan,thu,tiet,m,k) == false)
									{
										continue;
									}	
									else
									{
										k--;
										continue;
									}
								}	
								else 
								{
									continue;
								}
							}
							if(listHocPhanTheoMau.get(m).size() == 0)
							{
								m++;
								if(m == listHocPhanTheoMau.size()) return;
								if(tiet <= 9 && tiet > 4) break;
								if(tiet <= 4) tiet = 4;
							}
						}
						if(thu==5 && tuan == this.soTuanThi - 1)
						{
							//System.out.println("Khong du ngay de xep lich cho phong thuong");
							this.soTuanThi++;
							//return;
						}
					}
				}
			}
			else
			{
				return;
			}
		}
	}
	public void ThuatToanXepLichPhongMay()
	{
		ArrayList<ArrayList<HocPhan>> listHocPhanTheoMau = ToMauDoThi.getListHocPhanMayTheoMau();
		int tuan, thu, tiet;
		ArrayList<ArrayList<PhongHoc>> phongTrongNgay = new ArrayList<ArrayList<PhongHoc>>(10);
		for(int i = 0 ; i < 10 ; i++)
		{
			ArrayList<PhongHoc> temp = PhongHocDAL.getInstance().getListPhongMay();
			phongTrongNgay.add(temp);
		}
		for(int m = 0 ; m < listHocPhanTheoMau.size(); m++)
		{
			if(listHocPhanTheoMau.get(m) != null)
			{
				for(tuan = 0; tuan < this.soTuanThi; tuan ++)
				{
					for(thu = 0; thu < 6; thu ++)
					{
						for(tiet = 0 ; tiet < 10 ; tiet++)
						{
							if(tiet == 5 || tiet == 0)
							{ 
								for(int i = 0 ; i < 10 ; i++)
								{
									for(int j = 0 ; j < phongTrongNgay.get(i).size(); j++)
									{
										phongTrongNgay.get(i).get(j).setPhongTrong(true);
									}
								}
							}
							for(int k = 0; k < listHocPhanTheoMau.get(m).size(); k++)
							{
								if(listHocPhanTheoMau.get(m).size() == 0)
								{
									break;
								}
								long tgThi = 0;
								if(tiet == 4 || tiet == 9)
								{
									tgThi = 1;
								}
								else
								{
									tgThi = (5 - tiet%5);
								}
								if(tgThi >= listHocPhanTheoMau.get(m).get(k).getSoTietThi())
								{
									if(ChonPhong(phongTrongNgay,listHocPhanTheoMau,tuan,thu,tiet,m,k) == false)
									{
										continue;
									}	
									else
									{
										k--;
										continue;
									}
								}	
								else 
								{
									continue;
								}
							}
							if(listHocPhanTheoMau.get(m).size() == 0)
							{
								m++;
								if(m == listHocPhanTheoMau.size()) return;
								if(tiet <= 9 && tiet > 4) break;
								if(tiet <= 4) tiet = 4;
							}
						}
						if(thu==5 && tuan == this.soTuanThi - 1)
						{
							//System.out.println("Khong du ngay de xep lich cho phong may");
							this.soTuanThi++;
							//return;
						}
					}
				}
			}
			else
			{
				return;
			}
		}
	}
}
