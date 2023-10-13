package GUI.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.view.SinhVien.ManHinhChinh_SV;

public class SuKienDoiHoatAnhTrenMenu_SV extends WindowAdapter implements MouseListener, MouseMotionListener{
	ManHinhChinh_SV manHinhChinh_SV;
	
	JPanel panel;
	JLabel jLabel;
	

	
	public SuKienDoiHoatAnhTrenMenu_SV(ManHinhChinh_SV manHinh_Chinh_SV) {
		
		this.manHinhChinh_SV = manHinh_Chinh_SV;
	}
	
	public SuKienDoiHoatAnhTrenMenu_SV(ManHinhChinh_SV manHinh_Chinh_SV , JPanel panel) {
		
		this.manHinhChinh_SV = manHinh_Chinh_SV;
		this.panel = panel;
	}
	
	public SuKienDoiHoatAnhTrenMenu_SV(ManHinhChinh_SV manHinh_Chinh_SV , JLabel jLabel) {
		
		this.manHinhChinh_SV = manHinh_Chinh_SV;
		this.jLabel = jLabel;
	}
	
	

	
	public void mouseEntered(MouseEvent e) {
		panel.setBackground(new Color(112, 128, 144));
	}
	
	public void mouseExited(MouseEvent e) {
		panel.setBackground(new Color(47, 79, 79));
	}
	
	public void mousePressed(MouseEvent e) {
		panel.setBackground(new Color(60, 179, 133));
	}

	public void mouseReleased(MouseEvent e) {
		panel.setBackground(new Color(112, 128, 144));
	}
	
	public void mouseClicked(MouseEvent e) {
		// Sig Out
		if(e.getSource() == this.manHinhChinh_SV.paneSignOut) {
			this.manHinhChinh_SV.suKien_paneSignOut();
		}
		
		if(e.getSource() == this.manHinhChinh_SV.lblSignOut) {
			this.manHinhChinh_SV.suKien_paneSignOut();
		}
		
		if(e.getSource() == this.manHinhChinh_SV.lblIconSigOut) {
			this.manHinhChinh_SV.suKien_paneSignOut();
		}
		
		//panel
		if(e.getSource() == this.manHinhChinh_SV.paneHome) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelHome);
		}
		
		if(e.getSource() == this.manHinhChinh_SV.paneXemLichThi) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelXemLichThi);
		}
		
		if(e.getSource() == this.manHinhChinh_SV.paneTaiKhoan) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelTaiKhoan);
		}
		//lbl text
		if(e.getSource() == this.manHinhChinh_SV.lblHome) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelHome);
		}
		
		if(e.getSource() == this.manHinhChinh_SV.paneXemLichThi) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelXemLichThi);
		}
		
		if(e.getSource() == this.manHinhChinh_SV.lblTaiKhoan) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelTaiKhoan);
		}
		//lbl icon
		if(e.getSource() == this.manHinhChinh_SV.lblIconHome) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelHome);
		}
	
		if(e.getSource() == this.manHinhChinh_SV.lblIconXemLichThi) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelXemLichThi);
		}
		
		
		if(e.getSource() == this.manHinhChinh_SV.lblIconTaiKhoan) {
			this.manHinhChinh_SV.form_DuocChon(this.manHinhChinh_SV.panelTaiKhoan);
		}

		
	}

	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
	    int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát khỏi ứng dụng?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
	    if (option == JOptionPane.YES_OPTION) {
	        this.manHinhChinh_SV.dispose();
	    }

	}
	


}
