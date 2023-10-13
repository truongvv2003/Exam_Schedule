package GUI.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.view.GiangVien.ManHinhChinh_GV;

public class SuKienlblX_MHC_GV  implements MouseListener{
	ManHinhChinh_GV manHinhChinh_GV;

		

		
	public SuKienlblX_MHC_GV(ManHinhChinh_GV manHinhChinh_GV) {
			
		this.manHinhChinh_GV = manHinhChinh_GV;
	}

	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_GV.lblX) {
			this.manHinhChinh_GV.lblX.setForeground(Color.RED);
		}
		else if(e.getSource() == this.manHinhChinh_GV.lblX_1) {
			this.manHinhChinh_GV.lblX_1.setForeground(Color.RED);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_GV.lblX) {
			this.manHinhChinh_GV.lblX.setForeground(Color.WHITE);
		}	
		else if(e.getSource() == this.manHinhChinh_GV.lblX_1) {
			this.manHinhChinh_GV.lblX_1.setForeground(Color.WHITE);
		}

	}
	
	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_GV.lblX) {
			this.manHinhChinh_GV.suKienlblX();
		}
		else if(e.getSource() == this.manHinhChinh_GV.lblX_1) {
			this.manHinhChinh_GV.suKienlblMiniSize();
		}
	}
}
