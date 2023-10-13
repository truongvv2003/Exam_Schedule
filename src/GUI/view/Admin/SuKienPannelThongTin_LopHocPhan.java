package GUI.view.Admin;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import GUI.viewItem.IconRenderer;

public class SuKienPannelThongTin_LopHocPhan implements MouseListener, WindowFocusListener, ComponentListener, FocusListener{
	private PanelThongTin_LopHocPhan panelThongTin_LopHocPhan;
	private DanhSachSinhVienHocPhan danhSachSinhVienHocPhan;
	private PanelThongTin panelThongTin;
	private static int maLopHoc;
	
	public SuKienPannelThongTin_LopHocPhan(PanelThongTin panelThongTin)
	{
		this.panelThongTin = panelThongTin;
		this.panelThongTin_LopHocPhan = panelThongTin.panelThongTin_LopHocPhan;
	}
	public SuKienPannelThongTin_LopHocPhan(PanelThongTin_LopHocPhan panelLopHocPhan_LopHocPhan)
	{
		this.panelThongTin_LopHocPhan = panelLopHocPhan_LopHocPhan;
	}
	
	public SuKienPannelThongTin_LopHocPhan(DanhSachSinhVienHocPhan danhSachSinhVienHocPhan)
	{
		this.danhSachSinhVienHocPhan = danhSachSinhVienHocPhan;
	}
	
	
	public void insertData()
	{
		ArrayList<ArrayList<String>> duLieu = LopHocPhanBLL.getInstance().getListThongTinLopHocPhan();
		panelThongTin_LopHocPhan.model.setNumRows(0);
		for(int i = 0 ; i < duLieu.size(); i++)
		{
			Vector<Object> vec = new Vector<Object>();
			vec.add(i+1);
			vec.add(duLieu.get(i).get(0));
			vec.add(duLieu.get(i).get(1));
			vec.add(duLieu.get(i).get(2));
			panelThongTin_LopHocPhan.model.addRow(vec);
		}
		panelThongTin_LopHocPhan.tableCuaTui.setModel(panelThongTin_LopHocPhan.model);
		
		TableColumn column = panelThongTin_LopHocPhan.tableCuaTui.getColumnModel().getColumn(4);
		column.setCellRenderer(new IconRenderer());
		Icon icon = new ImageIcon(PanelThongTin.class.getResource("/res/timkiem.png"));
		panelThongTin_LopHocPhan.tableCuaTui.setValueAt(icon, 0, 4);
	}
	
	public void insertDataLopHocPhan()
	{
		ArrayList<SinhVien> duLieu = SinhVienBLL.getInstance().getListSVienTrongLop(maLopHoc);
		danhSachSinhVienHocPhan.model.setNumRows(0);
		for(int i = 0 ; i < duLieu.size(); i++)
		{
			Vector<Object> vec = new Vector<>();
			vec.add(i+1);
			vec.add(duLieu.get(i).getIDSv());
			vec.add(duLieu.get(i).getHoTen());
			vec.add(duLieu.get(i).getLop());
			danhSachSinhVienHocPhan.model.addRow(vec);
		}
		danhSachSinhVienHocPhan.tableCuaTui.setModel(danhSachSinhVienHocPhan.model);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
    	if (e.getClickCount() == 1) {
	        int row = this.panelThongTin_LopHocPhan.tableCuaTui.rowAtPoint(e.getPoint()); // lấy chỉ số dòng của ô được chọn
	        int col = this.panelThongTin_LopHocPhan.tableCuaTui.columnAtPoint(e.getPoint()); // lấy chỉ số cột của ô được chọn
	        if (row >= 0 && col == 4) {
	            // xử lý sự kiện ở đây với giá trị của ô được chọn
	        	String maLopHoc = (String) this.panelThongTin_LopHocPhan.tableCuaTui.getValueAt(row, 1);
				DanhSachSinhVienHocPhan danhSachHocPhan = new DanhSachSinhVienHocPhan();
				SuKienPannelThongTin_LopHocPhan.maLopHoc = Integer.parseInt(maLopHoc);
				danhSachHocPhan.setVisible(true);
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
		this.danhSachSinhVienHocPhan.dispose();
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
		if(e.getSource() == this.panelThongTin)
		{
			this.insertData();
			return;
		}
		if(e.getSource() == this.panelThongTin_LopHocPhan)
		{
			this.insertData();
		}
		else if (e.getSource() == this.danhSachSinhVienHocPhan)
		{
			this.insertDataLopHocPhan();
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
