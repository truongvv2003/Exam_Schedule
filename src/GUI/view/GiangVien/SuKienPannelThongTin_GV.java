package GUI.view.GiangVien;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;

import BLL.LopHocPhanBLL;
import BLL.SinhVienBLL;
import DTO.SinhVien;
import GUI.view.Admin.PanelThongTin;
import GUI.viewItem.IconRenderer;

public class SuKienPannelThongTin_GV implements MouseListener, WindowFocusListener, ComponentListener{
	private PanelThongTin_GV panelThongTin_GV;
	private DanhSachSinhVienHocPhan_GV danhSachSinhVienHocPhan_GV;
	private static int maLopHoc;
	
	public SuKienPannelThongTin_GV(PanelThongTin_GV panelLopHocPhan_GV)
	{
		this.panelThongTin_GV = panelLopHocPhan_GV;
	}
	
	public SuKienPannelThongTin_GV(DanhSachSinhVienHocPhan_GV danhSachSinhVienHocPhan_GV)
	{
		this.danhSachSinhVienHocPhan_GV = danhSachSinhVienHocPhan_GV;
	}
	
	public void insertData()
	{
		
		ArrayList<ArrayList<String>> duLieu = LopHocPhanBLL.getInstance().getListThongTinLopHocPhan(ManHinhChinh_GV.taiKhoanGV);
		panelThongTin_GV.model.setNumRows(0);
		for(int i = 0 ; i < duLieu.size(); i++)
		{
			Vector<Object> vec = new Vector<Object>();
			vec.add(i+1);
			vec.add(duLieu.get(i).get(0));
			vec.add(duLieu.get(i).get(1));
			vec.add(duLieu.get(i).get(2));
			panelThongTin_GV.model.addRow(vec);
		}
		panelThongTin_GV.tableCuaTui.setModel(panelThongTin_GV.model);
		
		TableColumn column = panelThongTin_GV.tableCuaTui.getColumnModel().getColumn(4);
		column.setCellRenderer(new IconRenderer());
		Icon icon = new ImageIcon(PanelThongTin.class.getResource("/res/timkiem.png"));
		panelThongTin_GV.tableCuaTui.setValueAt(icon, 0, 4);
	}
	
	public void insertDataLopHocPhan()
	{
		ArrayList<SinhVien> duLieu = SinhVienBLL.getInstance().getListSVienTrongLop(maLopHoc);
		danhSachSinhVienHocPhan_GV.model.setNumRows(0);
		for(int i = 0 ; i < duLieu.size(); i++)
		{
			Vector<Object> vec = new Vector<>();
			vec.add(i+1);
			vec.add(duLieu.get(i).getIDSv());
			vec.add(duLieu.get(i).getHoTen());
			vec.add(duLieu.get(i).getLop());
			danhSachSinhVienHocPhan_GV.model.addRow(vec);
		}
		danhSachSinhVienHocPhan_GV.tableCuaTui.setModel(danhSachSinhVienHocPhan_GV.model);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
    	if (e.getClickCount() == 1) {
	        int row = this.panelThongTin_GV.tableCuaTui.rowAtPoint(e.getPoint()); // lấy chỉ số dòng của ô được chọn
	        int col = this.panelThongTin_GV.tableCuaTui.columnAtPoint(e.getPoint()); // lấy chỉ số cột của ô được chọn
	        if (row >= 0 && col == 4) {
	            // xử lý sự kiện ở đây với giá trị của ô được chọn
	        	String maLopHoc = (String) this.panelThongTin_GV.tableCuaTui.getValueAt(row, 1);
				DanhSachSinhVienHocPhan_GV danhSachHocPhan_GV = new DanhSachSinhVienHocPhan_GV();
				SuKienPannelThongTin_GV.maLopHoc = Integer.parseInt(maLopHoc);
				danhSachHocPhan_GV.setVisible(true);
	        }
    	}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
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
		this.danhSachSinhVienHocPhan_GV.dispose();
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
		if(e.getSource() == this.panelThongTin_GV)
		{
			this.insertData();
		}
		else if (e.getSource() == this.danhSachSinhVienHocPhan_GV)
		{
			this.insertDataLopHocPhan();
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
