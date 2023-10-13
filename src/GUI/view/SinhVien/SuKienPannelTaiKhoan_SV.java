package GUI.view.SinhVien;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SuKienPannelTaiKhoan_SV implements MouseListener{
	private PanelTaiKhoan_SV panelTaiKhoan_SV;

	
	public SuKienPannelTaiKhoan_SV(PanelTaiKhoan_SV panelTaiKhoan_SV)
	{
		this.panelTaiKhoan_SV = panelTaiKhoan_SV;

	}
	
	public void form_DuocChon(JPanel panel) {
		panelTaiKhoan_SV.panelTaiKhoan_ThongTin_SV.setVisible(false);
		panelTaiKhoan_SV.panelTaiKhoan_DoiMatKhau_SV.setVisible(false);
		panel.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelTaiKhoan_SV.nutpanelDoiMatKhau)
		{
			this.form_DuocChon(this.panelTaiKhoan_SV.panelTaiKhoan_DoiMatKhau_SV);
		}
		if(e.getSource() == this.panelTaiKhoan_SV.nutpanelThongTin)
		{
			this.form_DuocChon(this.panelTaiKhoan_SV.panelTaiKhoan_ThongTin_SV);
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

