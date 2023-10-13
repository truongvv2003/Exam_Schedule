package DAL;

import java.util.ArrayList;

import DTO.HocPhan;
import DTO.PhongHoc;

public class ToMauDoThi {
	private int [][]DoThi; // do thi 
	private ArrayList<HocPhan> listDsHp;
	static ArrayList<ArrayList<HocPhan>> listHocPhanDuocToMau;
	private int[] Bac;
	private int m; // So mau
	private int[] Mau; // Mang i se duoc to mau i
	public static int soTuanToiThieu;
	public int[][] getDoThi() {
		return DoThi;
	}
	public void setDoThi(int[][] doThi) {
		DoThi = doThi;
	}
	
	public int[] getBac() {
		return Bac;
	}
	public void setBac(int[] bac) {
		Bac = bac;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int[] getMau() {
		return Mau;
	}
	public void setMau(int[] mau) {
		Mau = mau;
	}
	public ArrayList<ArrayList<HocPhan>> getListHocPhanDuocToMau() {
		return listHocPhanDuocToMau;
	}
	public void setListHocPhanDuocToMau(ArrayList<ArrayList<HocPhan>> listHocPhanDuocToMau) {
		ToMauDoThi.listHocPhanDuocToMau = listHocPhanDuocToMau;
	}
	public ToMauDoThi(ArrayList<HocPhan> listDSHP, ArrayList<PhongHoc> a) {
		this.listDsHp = new ArrayList<HocPhan>();
		this.listDsHp = listDSHP;
		this.DoThi = new int[listDsHp.size()][listDsHp.size()];
		for(int i =0; i<listDsHp.size();i++) {
			DoThi[i][i] = 1;
		}
		this.TaoBac();
		this.m = 0;
		this.Mau = new int[1000];
		this.Bac = new int[1000];
		for(int i = 0; i < listDsHp.size(); i++)
		{
			for(int j = 0; j < listDsHp.size(); j++)
			{
				this.Bac[i] = this.Bac[i] + this.DoThi[i][j];
			}
		}
		this.ToMau(a);
	}

	public void ShowDanhSachTheoMau()
	{
		for(int i = 0 ; i < this.m; i ++)
		{
			System.out.println("Hoc phan mau: "+ i );
			for(int j = 0 ; j < ToMauDoThi.listHocPhanDuocToMau.get(i).size(); j ++)
			{
				System.out.println(ToMauDoThi.listHocPhanDuocToMau.get(i).get(j));
			}
		}
	}
	public static boolean CheckSinhVien(HocPhan hocphanA, HocPhan hocphanB) {
		for(int i = 0; i < hocphanA.getDsSv().size();i++) {
			for(int j = 0; j < hocphanB.getDsSv().size();j++) {
				if(hocphanA.getDsSv().get(i).compareTo(hocphanB.getDsSv().get(j)) == 0 ) { 
					return true;} //1
			}
		}
		return false; //0
	}
	public void TaoBac() {
		for(int i =0; i < listDsHp.size();i++) {
			for(int j = i +1; j < listDsHp.size();j++) {
				if(CheckSinhVien(listDsHp.get(i),listDsHp.get(j))==true) {
					this.DoThi[i][j] = 1;
					this.DoThi[j][i] = 1;
				}
				
			}
		}
	}
	public int ChonDinh()
	{
		int max = this.Bac[0];
		int vt = 0;
		for(int i = 1; i < listDsHp.size(); i++)
		{
			if(this.Bac[i] > max)
			{
				max = this.Bac[i];
				vt = i;
			}
		}
		return vt;
	}
	public int chonMau(int S)
	{

		int color, OK;
		for(color = 0; color < this.m;color++){
			OK = 1;
			for(int i = 0; i < listDsHp.size(); i++)
			{
				if(this.DoThi[S][i] == 1 && this.Mau[i] == color)
				{
					OK = 0;
					break;
				}
			}
			if(OK==1) return color;
		}
		return this.m++;
	}

	public void CheckListHocPhanDuocToMau(ArrayList<PhongHoc> a)
    {
        int sucChua = 0;
        int mau = this.m;
        
        for(int i = 0; i < a.size(); i++ )
        {
            sucChua += a.get(i).getSucChua();
        }
        for(int i = 0 ; i < mau ; i++)
        {
            for(int j = 0 ; j < ToMauDoThi.listHocPhanDuocToMau.get(i).size(); j++)
            {
                if(ToMauDoThi.listHocPhanDuocToMau.get(i).get(j).getDsSv().size() > sucChua)                	
                {
                	int size = listHocPhanDuocToMau.get(i).get(j).getDsSv().size(); 
                    int heso =(int)size/sucChua;
                    if(heso < (double)size/sucChua) heso++;
      
                    int soLuongSV = (int)ToMauDoThi.listHocPhanDuocToMau.get(i).get(j).getDsSv().size()/heso; 
                    if(soLuongSV < (double)ToMauDoThi.listHocPhanDuocToMau.get(i).get(j).getDsSv().size()/heso) soLuongSV++;
                    int k = 0;
                    while(k < heso)
                    {	
                    	int start = k*soLuongSV;
                    	int end = (k+1)*soLuongSV - 1;
                    	if(k == heso-1)	end = size - 1;
                    
                
                    	HocPhan temp = new HocPhan(ToMauDoThi.listHocPhanDuocToMau.get(i).get(j),start,end);
                    	ToMauDoThi.listHocPhanDuocToMau.get(i).add(temp);
                    	k++;
                    }
                    ToMauDoThi.listHocPhanDuocToMau.get(i).remove(j);
                    j--;
                }
            }
        }
    }
	public void ToMau(ArrayList<PhongHoc> a) {
		for(int k = 0; k < listDsHp.size(); k++)
		{
			int S = ChonDinh();
			int color = chonMau(S);
			this.Mau[S] = color;
			this.Bac[S] = -1;
		}
		ToMauDoThi.listHocPhanDuocToMau = new ArrayList<ArrayList<HocPhan>>();
		for(int i = 0 ; i < this.m; i ++)
		{
			ArrayList<HocPhan> temp = new ArrayList<HocPhan>();
			ToMauDoThi.listHocPhanDuocToMau.add(temp);
		}
		for(int i = 0 ; i < listDsHp.size() ; i ++)
		{
			for(int j = 0; j < this.m; j++) {
				if(Mau[i] == j)
				{
					ToMauDoThi.listHocPhanDuocToMau.get(j).add(listDsHp.get(i));
				}
			}
		}
		this.CheckListHocPhanDuocToMau(a);
	}

	public static ArrayList<ArrayList<HocPhan>> getListHocPhanTheoMau()
	{
		ToMauDoThi dthi = new ToMauDoThi(HocPhanDAL.getInstance().getListHocPhanThuong(),PhongHocDAL.getInstance().getListPhongHocThuong());
		return dthi.getListHocPhanDuocToMau();
	}	
	
	public static ArrayList<ArrayList<HocPhan>> getListHocPhanMayTheoMau()
	{
		ToMauDoThi dthi = new ToMauDoThi(HocPhanDAL.getInstance().getListHocPhanMay(),PhongHocDAL.getInstance().getListPhongMay());
		return dthi.getListHocPhanDuocToMau();
	}

}
