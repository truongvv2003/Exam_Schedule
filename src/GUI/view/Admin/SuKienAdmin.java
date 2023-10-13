package GUI.view.Admin;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BLL.HocPhanBLL;
import BLL.KeHoachBLL;
import BLL.LichThiBLL;
import BLL.PhongHocBLL;
import BLL.SinhVienBLL;
import BLL.ThoiGianBLL;
import DTO.LichThi;
import DTO.SinhVien;
import GUI.viewItem.BangXemLichThi;
import GUI.viewItem.Phong;

public class SuKienAdmin implements MouseListener, ComponentListener, WindowFocusListener {
	private DanhSachSinhVienHocPhan danhSachSinhVienHocPhan;
	private PanelXepLichThi_ThoiGianThi panelThoiGianThi;
	private PanelXepLichThi_XemLichThi panelXemLichThi;
	private PanelXepLichThi panelXepLichThi;

	public SuKienAdmin(DanhSachSinhVienHocPhan danhSachSinhVienHocPhan) {
		this.danhSachSinhVienHocPhan = danhSachSinhVienHocPhan;
	}

	public SuKienAdmin(PanelXepLichThi_ThoiGianThi panelThoiGianThi) {
		this.panelThoiGianThi = panelThoiGianThi;
	}

	public SuKienAdmin(PanelXepLichThi_XemLichThi panelXemLichThi) {
		this.panelXemLichThi = panelXemLichThi;
	}

	public SuKienAdmin(PanelXepLichThi a) {
		this.panelXepLichThi = a;
		this.panelThoiGianThi = a.panelXepLichThi_ThoiGianThi;
		this.panelXemLichThi = a.panelXepLichThi_XemLichThi;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			if (e.getSource() == this.panelXemLichThi.nutpanelChonPhong) {
				ButtonModel selectedButton = this.panelXemLichThi.groupRadioButton.getSelection();
				if (selectedButton == null) {
					JOptionPane.showMessageDialog(null, "Hãy vui lòng chọn phòng");
				} else {
					//System.out.println(this.panelXemLichThi.groupRadioButton.getSelection().getActionCommand());
					//truyenListLichThiTuan();
					truyenDataVaoBangThiTuan(this.panelXemLichThi.groupRadioButton.getSelection().getActionCommand());	
				}
			}

		} catch (NullPointerException ex) {}
		try
		{
			if (e.getSource() == this.panelThoiGianThi.nutpanelXepLich
					&& PanelXepLichThi_ThoiGianThi.isAllowedClick == true) {
				// need thread :<
				ArrayList<Integer> soTuan = ThoiGianBLL.getInstance().getListTuanThi();
				if(LichThiBLL.getInstance().checkLichThiRong() == false) {
					JOptionPane.showMessageDialog(null, "Có lịch thi còn tồn tại hãy xóa lịch thi nếu muốn xếp lại lịch thi!!!");
				}
				else if((int)PanelXepLichThi_ThoiGianThi.tuanBatDau.getSelectedItem() < soTuan.get(soTuan.size()-1)) {
					PanelXepLichThi_ThoiGianThi.tuanKetThuc.setText("");
					PanelXepLichThi_ThoiGianThi.isAllowedClick = false;
					PanelXepLichThi.AllowedClick = false;
					try {
						LichThiBLL.getInstance().thucHienXepLich((int) PanelXepLichThi_ThoiGianThi.tuanBatDau.getSelectedItem());
						this.truyenListLichThiTuan();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
				}
				else JOptionPane.showMessageDialog(null, "Thời gian còn lại của học kỳ không đủ để xếp lịch thi");
			}
		}catch(NullPointerException ex) {}
		try {
			if(e.getSource() == this.panelXepLichThi.nutpanelXemLichThi && PanelXepLichThi.AllowedClick == false)
			{
				JOptionPane.showMessageDialog(null, "Đang xếp lịch vui lòng đợi");
			}
			else if (e.getSource() == this.panelXepLichThi.nutpanelXemLichThi && PanelXepLichThi.AllowedClick == true) {
				if (LichThiBLL.getInstance().checkLichThiRong() == false) {
					if (panelXepLichThi.panelXepLichThi_XemLichThi.checkDuLieuRong == false) {
						panelXepLichThi.panelXepLichThi_XemLichThi.checkDuLieuRong = true;
						this.truyenListRadioButton();
						this.truyenListLichThiTuan();
					}
					form_DuocChon(panelXepLichThi.panelXepLichThi_XemLichThi);
				} else {
					JOptionPane.showMessageDialog(null, "Hãy vui lòng xếp lịch thi");
				}
			}
		}catch(NullPointerException ex) {}
		try {
			if(e.getSource() == this.panelThoiGianThi.nutpanelXoaLich && PanelXepLichThi_ThoiGianThi.isAllowedClick == false) {
				JOptionPane.showMessageDialog(null, "Đang xếp lịch không thể thực hiện chức năng xóa lịch!!!");
			}
			else if(e.getSource() == this.panelThoiGianThi.nutpanelXoaLich && PanelXepLichThi_ThoiGianThi.isAllowedClick == true) {
				int option = JOptionPane.showOptionDialog(null,"Bạn có chắc chắn muốn xóa lịch thi hiện tại không ?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		                new String[]{"Yes", "No", "Cancel"}, "Yes");
				if(option == JOptionPane.YES_OPTION) {
					int check = LichThiBLL.getInstance().XoaLich();
					if(check > 0) JOptionPane.showMessageDialog(null, "Xóa lịch thi thành công!");
					else JOptionPane.showMessageDialog(null, "Dữ liệu lịch thi đang trống!");
				}
			}
		}catch(NullPointerException ex) {}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.danhSachSinhVienHocPhan) {
			this.danhSachSinhVienHocPhan.dispose();
		}
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.danhSachSinhVienHocPhan) {
			this.insertDataLopHocPhan();
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void form_DuocChon(JPanel panel) {
		this.panelXepLichThi.panelXepLichThi_ThoiGianThi.setVisible(false);
		this.panelXepLichThi.panelXepLichThi_XemLichThi.setVisible(false);
		panel.setVisible(true);
	}

	public void insertDataLopHocPhan() {
		ArrayList<SinhVien> duLieu = SinhVienBLL.getInstance().getListSVienTrongLop(DanhSachSinhVienHocPhan.maLopHoc);
		this.danhSachSinhVienHocPhan.model.setNumRows(0);
		for (int i = 0; i < duLieu.size(); i++) {
			Vector<Object> vec = new Vector<>();
			vec.add(i + 1);
			vec.add(duLieu.get(i).getIDSv());
			vec.add(duLieu.get(i).getHoTen());
			vec.add(duLieu.get(i).getLop());
			this.danhSachSinhVienHocPhan.model.addRow(vec);
		}
		this.danhSachSinhVienHocPhan.tableCuaTui.setModel(this.danhSachSinhVienHocPhan.model);
	}

	public void truyenListRadioButton() {
		panelXepLichThi.panelXepLichThi_XemLichThi.checkDuLieuRong = true;
		ArrayList<Integer> dsMaPhong = PhongHocBLL.getInstance().getListMaPhong();
		for (int i = 0; i < dsMaPhong.size(); i++) {
			Phong a = new Phong(Integer.toString(dsMaPhong.get(i)));
			a.rdBtn.setActionCommand(Integer.toString(dsMaPhong.get(i)));
			panelXepLichThi.panelXepLichThi_XemLichThi.groupRadioButton.add(a.rdBtn);
			panelXepLichThi.panelXepLichThi_XemLichThi.panelChuaCacRadioButton.add(a);
		}
	}

	@SuppressWarnings("static-access")
	public void truyenListLichThiTuan() {
		this.panelXemLichThi.jScrollPaneTable.getVerticalScrollBar().setValue(0);
		this.panelXemLichThi.checkDuLieuRong = true;
		this.panelXemLichThi.panelChuaLichThiTuan = null;
		this.panelXemLichThi.panelChuaLichThiTuan = new JPanel();
		this.panelXemLichThi.panelChuaLichThiTuan = new JPanel(new FlowLayout());
		this.panelXemLichThi.panelChuaLichThiTuan.setLayout(new BoxLayout(this.panelXemLichThi.panelChuaLichThiTuan, BoxLayout.Y_AXIS));
		this.panelXemLichThi.jScrollPaneTable.setViewportView(this.panelXemLichThi.panelChuaLichThiTuan);
		int tuanBatDau = KeHoachBLL.getInstance().getTuanBatDau();
		int tuanKetThuc = KeHoachBLL.getInstance().getTuanKetThuc();
		int soTuanThi = tuanKetThuc - tuanBatDau + 1;
		String [][] dataNull = new String[10][10];
		for(int i = 0 ; i < 10; i++)
		{
			for(int j = 0 ; j < 10 ; j++)
			{
				dataNull[i][j] = "";
			}
		}
		for(int i = 0 ; i < soTuanThi; i++)
		{
			BangXemLichThi temp = new BangXemLichThi("Tuần thứ " + (tuanBatDau + i), dataNull);
			temp.setPreferredSize(new Dimension(723, 395));
			temp.tableCuaTui.fixTable(this.panelXemLichThi.jScrollPaneTable);
			this.panelXemLichThi.panelChuaLichThiTuan.add(temp);
		}
	}
	
	@SuppressWarnings("static-access")
	public void truyenDataVaoBangThiTuan(String maPhong)
	{
		this.panelXemLichThi.jScrollPaneTable.getVerticalScrollBar().setValue(0);
		this.panelXemLichThi.panelChuaLichThiTuan.removeAll();
		ArrayList<LichThi> dsLichThi = LichThiBLL.getInstance().getLichThiTheoPhong(maPhong);
		int tuanBatDau = KeHoachBLL.getInstance().getTuanBatDau();
		int tuanKetThuc = KeHoachBLL.getInstance().getTuanKetThuc();
		int soTuanThi = tuanKetThuc - tuanBatDau + 1;
		
		
		String[][][] data = new String[10][10][soTuanThi];
		for(int i = 0 ; i < dsLichThi.size(); i++)
		{
			String tenHocPhan = HocPhanBLL.getInstance().getTenHocPhan(dsLichThi.get(i).getMaHocPhan());
			int soTietThi = dsLichThi.get(i).getTietKetThuc() - dsLichThi.get(i).getTietBatDau();
			for(int j = 0 ; j < soTietThi; j ++ )
			{
				data[j+dsLichThi.get(i).getTietBatDau()][dsLichThi.get(i).getThu()+1][dsLichThi.get(i).getTuan() - tuanBatDau] = tenHocPhan;
			}
		}
		
		for(int i = 0 ; i < soTuanThi; i++)
		{
			String[][] dataModel = new String[10][10];
			for(int j = 0 ; j < 10 ; j++)
			{
				for(int k = 0 ; k < 10; k++)
				{
					dataModel[j][k] = data[j][k][i];
				}
			}
			BangXemLichThi temp = new BangXemLichThi("Tuần thứ " + (tuanBatDau + i), dataModel);
			temp.setPreferredSize(new Dimension(723, 395));
			temp.tableCuaTui.fixTable(this.panelXemLichThi.jScrollPaneTable);
			this.panelXemLichThi.panelChuaLichThiTuan.add(temp);
		}
	}

}
