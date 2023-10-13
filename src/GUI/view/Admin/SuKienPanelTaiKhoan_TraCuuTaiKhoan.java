package GUI.view.Admin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

import BLL.SinhVienBLL;
import BLL.UserBLL;
import DTO.GiangVien;
import DTO.SinhVien;
import GUI.viewItem.IconRenderer;



public class SuKienPanelTaiKhoan_TraCuuTaiKhoan implements MouseListener , KeyListener{
	PanelTaiKhoan_TraCuuTaiKhoan panelTaiKhoan_TraCuuTaiKhoan;
	ArrayList<Object> dsChung = new ArrayList<Object>();
	ArrayList<String> dsMatKhau = new ArrayList<String>();
	public SuKienPanelTaiKhoan_TraCuuTaiKhoan(PanelTaiKhoan_TraCuuTaiKhoan panelTaiKhoan_TraCuuTaiKhoan2) {
		// TODO Auto-generated constructor stub
		this.panelTaiKhoan_TraCuuTaiKhoan = panelTaiKhoan_TraCuuTaiKhoan2;
	}

	public void insertDs() {
		if(this.panelTaiKhoan_TraCuuTaiKhoan.jTextField_TraCuuTaiKhoan.getText().replaceAll(" ", "").equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập vào thông tin tra cứu");
		}
		dsChung = SinhVienBLL.getInstance().SearchSV_GV(this.panelTaiKhoan_TraCuuTaiKhoan.jTextField_TraCuuTaiKhoan.getText());
		if(dsChung.size() > 0) {	
			dsMatKhau = UserBLL.getInstance().getMatKhau(this.panelTaiKhoan_TraCuuTaiKhoan.jTextField_TraCuuTaiKhoan.getText());
			this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.setModel(this.panelTaiKhoan_TraCuuTaiKhoan.model);
			this.panelTaiKhoan_TraCuuTaiKhoan.model.setNumRows(0);
			for(int i = 0; i < dsChung.size(); i++) {
				Vector<Object> vec = new Vector<Object>();
				vec.add(i + 1);
				if(dsChung.get(i) instanceof SinhVien) {
					SinhVien sv = (SinhVien) dsChung.get(i);
					vec.add(sv.getIDSv());
					vec.add(sv.getHoTen());
					vec.add(sv.getIDSv());
					vec.add(dsMatKhau.get(i));
				}
				if(dsChung.get(i) instanceof GiangVien) {
					GiangVien gv = (GiangVien) dsChung.get(i);
					vec.add(gv.getIDGiangVien());
					vec.add(gv.getHoTen());
					vec.add(gv.getIDGiangVien());
					vec.add(dsMatKhau.get(i));
				}
				this.panelTaiKhoan_TraCuuTaiKhoan.model.addRow(vec);
			}
			this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.setEnabled(false);
			this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.setModel(this.panelTaiKhoan_TraCuuTaiKhoan.model);
			TableColumn column = this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.getColumnModel().getColumn(5);
			column.setCellRenderer(new IconRenderer());
			Icon icon = new ImageIcon(PanelThongTin.class.getResource("/res/wrench.png"));
			this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.setValueAt(icon, 0, 5);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelTaiKhoan_TraCuuTaiKhoan.nutpanelTraCuu) {
			this.insertDs();
		}
		if(e.getClickCount() == 1)
		{
			int row = this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.rowAtPoint(e.getPoint());
			int col = this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.columnAtPoint(e.getPoint());
			if(row >= 0 && col == 5)
			{
				//Thong bao xac nhan reset mat khau
				int taiKhoan = (int)this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.getValueAt(row, 3);
				if(taiKhoan == 0) return;
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn Reset mật khẩu của tài khoản " + taiKhoan +" ?" , "Xác nhận", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
				    // Code xử lý khi chọn Yes 
					UserBLL.getInstance().resetMatKhau(taiKhoan);
					JOptionPane.showMessageDialog(null, "Reset mật khẩu thành công!!");
					this.panelTaiKhoan_TraCuuTaiKhoan.tableCuaTui.setValueAt(UserBLL.getInstance().getMatKhauUser(taiKhoan), row, 4);
				} else {
				    // Code xử lý khi chọn No
				}
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.insertDs();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
