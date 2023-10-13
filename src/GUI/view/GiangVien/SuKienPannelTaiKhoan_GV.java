package GUI.view.GiangVien;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SuKienPannelTaiKhoan_GV implements MouseListener{
	private PanelTaiKhoan_GV panelTaiKhoan_GV;

	
	public SuKienPannelTaiKhoan_GV(PanelTaiKhoan_GV panelTaiKhoan_GV)
	{
		this.panelTaiKhoan_GV = panelTaiKhoan_GV;

	}
	
	public void form_DuocChon(JPanel panel) {
		panelTaiKhoan_GV.panelTaiKhoan_ThongTin_GV.setVisible(false);
		panelTaiKhoan_GV.panelTaiKhoan_DoiMatKhau_GV.setVisible(false);
		panel.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelTaiKhoan_GV.nutpanelDoiMatKhau)
		{
			this.form_DuocChon(this.panelTaiKhoan_GV.panelTaiKhoan_DoiMatKhau_GV);
		}
		if(e.getSource() == this.panelTaiKhoan_GV.nutpanelThongTin)
		{
			this.form_DuocChon(this.panelTaiKhoan_GV.panelTaiKhoan_ThongTin_GV);
		}
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




}
