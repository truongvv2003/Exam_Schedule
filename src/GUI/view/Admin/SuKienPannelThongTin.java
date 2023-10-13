package GUI.view.Admin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SuKienPannelThongTin implements MouseListener{
	private PanelThongTin panelThongTin;

	
	public SuKienPannelThongTin(PanelThongTin panelThongTin)
	{
		this.panelThongTin = panelThongTin;

	}
	
	public void form_DuocChon(JPanel panel) {
		panelThongTin.panelThongTin_GiangVien.setVisible(false);
		panelThongTin.panelThongTin_LopHocPhan.setVisible(false);
		panel.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelThongTin.nutpanelLopHocPhan)
		{
			this.form_DuocChon(this.panelThongTin.panelThongTin_LopHocPhan);
		}
		if(e.getSource() == this.panelThongTin.nutpanelGiangVien)
		{
			this.form_DuocChon(this.panelThongTin.panelThongTin_GiangVien);
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

