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

import GUI.view.GiangVien.ManHinhChinh_GV;

public class SuKienDoiHoatAnhTrenMenu_GV extends WindowAdapter implements MouseListener, MouseMotionListener{
	ManHinhChinh_GV manHinhChinh_GV;
	
	JPanel panel;
	JLabel jLabel;
	

	
	public SuKienDoiHoatAnhTrenMenu_GV(ManHinhChinh_GV manHinh_Chinh_GV) {
		
		this.manHinhChinh_GV = manHinh_Chinh_GV;
	}
	
	public SuKienDoiHoatAnhTrenMenu_GV(ManHinhChinh_GV manHinh_Chinh_GV , JPanel panel) {
		
		this.manHinhChinh_GV = manHinh_Chinh_GV;
		this.panel = panel;
	}
	
	public SuKienDoiHoatAnhTrenMenu_GV(ManHinhChinh_GV manHinh_Chinh_GV , JLabel jLabel) {
		
		this.manHinhChinh_GV = manHinh_Chinh_GV;
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
		if(e.getSource() == this.manHinhChinh_GV.paneSignOut) {
			this.manHinhChinh_GV.suKien_paneSignOut();
		}
		
		if(e.getSource() == this.manHinhChinh_GV.lblSignOut) {
			this.manHinhChinh_GV.suKien_paneSignOut();
		}
		
		if(e.getSource() == this.manHinhChinh_GV.lblIconSigOut) {
			this.manHinhChinh_GV.suKien_paneSignOut();
		}
		
		//panel
		if(e.getSource() == this.manHinhChinh_GV.paneHome) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelHome);
		}
		
		if(e.getSource() == this.manHinhChinh_GV.paneThongTin) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelThongTin);
		}
		
		if(e.getSource() == this.manHinhChinh_GV.paneXepLichThi) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelXepLichThi);
		}
		
		if(e.getSource() == this.manHinhChinh_GV.paneTaiKhoan) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelTaiKhoan);
		}
		//lbl text
		if(e.getSource() == this.manHinhChinh_GV.lblHome) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelHome);
		}
		
		if(e.getSource() == this.manHinhChinh_GV.lblThongTin) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelThongTin);
		}
		
		if(e.getSource() == this.manHinhChinh_GV.lblXepLichThi) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelXepLichThi);
		}
		
		if(e.getSource() == this.manHinhChinh_GV.lblTaiKhoan) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelTaiKhoan);
		}
		//lbl icon
		if(e.getSource() == this.manHinhChinh_GV.lblIconHome) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelHome);
		}
	
		if(e.getSource() == this.manHinhChinh_GV.lblIconThongTin) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelThongTin);
		}
		
		if(e.getSource() == this.manHinhChinh_GV.lblIconXepLichThi) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelXepLichThi);
		}
		
		if(e.getSource() == this.manHinhChinh_GV.lblIconXepLichThi) {
			this.manHinhChinh_GV.form_DuocChon(this.manHinhChinh_GV.panelTaiKhoan);
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
	        this.manHinhChinh_GV.dispose();
	    }

	}
	


}
