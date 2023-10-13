package GUI.view.SinhVien;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;


import javax.swing.JOptionPane;



import BLL.UserBLL;

public class suKienPanelTaiKhoan_DoiMatKhau_SV implements MouseListener, KeyListener{
	
	PanelTaiKhoan_DoiMatKhau_SV panelTaiKhoan_DoiMatKhau_SV;
	public suKienPanelTaiKhoan_DoiMatKhau_SV(PanelTaiKhoan_DoiMatKhau_SV PanelTaiKhoan_DoiMatKhau_SV)
	{
		this.panelTaiKhoan_DoiMatKhau_SV = PanelTaiKhoan_DoiMatKhau_SV;
	}
	@SuppressWarnings("deprecation")
	public  void SuKienDoiMatKhau() {
			if(this.panelTaiKhoan_DoiMatKhau_SV.jTextField_MatKhauCu.getText().equals(ManHinhChinh_SV.matKhauSV) == false) {
				JOptionPane.showMessageDialog(null, "Mật khẩu cũ bạn nhập vào không đúng");
			}
			else if(this.panelTaiKhoan_DoiMatKhau_SV.jTextField_MatKhauMoi.getText().replaceAll(" ", "").equals("") == true) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu mới");
			}
			else if(this.panelTaiKhoan_DoiMatKhau_SV.jTextField_MatKhauMoi.getText().equals(ManHinhChinh_SV.matKhauSV) == true) {
				JOptionPane.showMessageDialog(null, "Mật khẩu bạn nhập trùng với mật khẩu cũ");
			}
			else if(this.panelTaiKhoan_DoiMatKhau_SV.jTextField_MatKhauMoi.getText().equals(this.panelTaiKhoan_DoiMatKhau_SV.jTextField_NhapLaiMatKhau.getText())== false) {
				JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không khớp");
			}
			
			else {
				UserBLL.getInstance().doiMatKhau(ManHinhChinh_SV.taiKhoanSV, this.panelTaiKhoan_DoiMatKhau_SV.jTextField_MatKhauMoi.getText());
				JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
				this.panelTaiKhoan_DoiMatKhau_SV.jTextField_MatKhauCu.setText("");
				this.panelTaiKhoan_DoiMatKhau_SV.jTextField_MatKhauMoi.setText("");
				this.panelTaiKhoan_DoiMatKhau_SV.jTextField_NhapLaiMatKhau.setText("");
			}
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelTaiKhoan_DoiMatKhau_SV.nutpanelLuu) {
			this.SuKienDoiMatKhau();
		}
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.SuKienDoiMatKhau();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
