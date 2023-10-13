package GUI.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.view.SinhVien.ManHinhChinh_SV;

public class SuKienlblX_MHC_SV  implements MouseListener{
	ManHinhChinh_SV manHinhChinh_SV;

		

		
	public SuKienlblX_MHC_SV(ManHinhChinh_SV manHinhChinh_SV) {
			
		this.manHinhChinh_SV = manHinhChinh_SV;
	}

	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_SV.lblX) {
			this.manHinhChinh_SV.lblX.setForeground(Color.RED);
		}
		else if(e.getSource() == this.manHinhChinh_SV.lblX_1) {
			this.manHinhChinh_SV.lblX_1.setForeground(Color.RED);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_SV.lblX) {
			this.manHinhChinh_SV.lblX.setForeground(Color.WHITE);
		}	
		else if(e.getSource() == this.manHinhChinh_SV.lblX_1) {
			this.manHinhChinh_SV.lblX_1.setForeground(Color.WHITE);
		}

	}
	
	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_SV.lblX) {
			this.manHinhChinh_SV.suKienlblX();
		}
		else if(e.getSource() == this.manHinhChinh_SV.lblX_1) {
			this.manHinhChinh_SV.suKienlblMiniSize();
		}
	}
}
