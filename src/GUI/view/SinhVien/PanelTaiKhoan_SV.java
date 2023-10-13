package GUI.view.SinhVien;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelTaiKhoan_SV extends JPanel {

	
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public JPanel panelDau;
	public MenuName menuName;
	public JPanel jPanelFromVao;
	public PanelTaiKhoan_ThongTin_SV panelTaiKhoan_ThongTin_SV;
	public PanelTaiKhoan_DoiMatKhau_SV panelTaiKhoan_DoiMatKhau_SV;
	public JPanel nutpanelThongTin;
	public JLabel lblThongTin;
	public JPanel nutpanelDoiMatKhau;
	public JLabel lblDoiMatKhau;



	public PanelTaiKhoan_SV() {

		caiDatPanelXepLichThi();
		menuName.setText("Tài Khoản");
        setCustomScrollBar();
        
	}

	private void caiDatPanelXepLichThi() {

		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 964, 546);
		this.setLayout(null);
        this.setOpaque(false);
		
		
		menuName = new MenuName();
		menuName.setBounds(0, 0, 964, 40);
		
		panelDau = new JPanel();
		panelDau.setBounds(0, 0, 964, 40);
		panelDau.setLayout(null);
		panelDau.add(menuName);

		//From dua vao
		jPanelFromVao = new JPanel();
		jPanelFromVao.setLayout(null);
		jPanelFromVao.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jPanelFromVao.setBounds(0, 0, 940, 579);
		
		
		panelTaiKhoan_ThongTin_SV = new PanelTaiKhoan_ThongTin_SV();
		panelTaiKhoan_ThongTin_SV.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTaiKhoan_ThongTin_SV.setBounds(0, 0, 940, 421);
		
		panelTaiKhoan_DoiMatKhau_SV = new PanelTaiKhoan_DoiMatKhau_SV();
		panelTaiKhoan_DoiMatKhau_SV.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTaiKhoan_DoiMatKhau_SV.setBounds(0, 0, 940, 421);
		
		jPanelFromVao.add(panelTaiKhoan_ThongTin_SV);
		jPanelFromVao.add(panelTaiKhoan_DoiMatKhau_SV);

		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 108, 940, 423);
		jScrollPaneTable.setViewportView(jPanelFromVao);

		
		
		
		nutpanelThongTin = new JPanel();
		nutpanelThongTin.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelThongTin.addMouseListener(new PanelButtonMouseAdapter(nutpanelThongTin));
		nutpanelThongTin.addMouseListener(new SuKienPannelTaiKhoan_SV(this));
		nutpanelThongTin.setBackground(new Color(47, 79, 79));
		nutpanelThongTin.setBounds(170, 50, 242, 46);
		nutpanelThongTin.setLayout(null);
		
		lblThongTin = new JLabel("Thông tin tài khoản");
		lblThongTin.setForeground(new Color(255, 255, 255));
		lblThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTin.setFont(new Font("Arial", Font.BOLD, 16));
		lblThongTin.setBounds(27, 10, 192, 26);
		nutpanelThongTin.add(lblThongTin);
		
		
		nutpanelDoiMatKhau = new JPanel();
		nutpanelDoiMatKhau.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelDoiMatKhau.addMouseListener(new PanelButtonMouseAdapter(nutpanelDoiMatKhau));
		nutpanelDoiMatKhau.addMouseListener(new SuKienPannelTaiKhoan_SV(this));
		nutpanelDoiMatKhau.setBackground(new Color(47, 79, 79));
		nutpanelDoiMatKhau.setBounds(548, 50, 242, 46);
		nutpanelDoiMatKhau.setLayout(null);
		
		lblDoiMatKhau = new JLabel("Đổi mật khẩu");
		lblDoiMatKhau.setForeground(new Color(255, 255, 255));
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiMatKhau.setFont(new Font("Arial", Font.BOLD, 16));
		lblDoiMatKhau.setBounds(47, 10, 152, 26);
		nutpanelDoiMatKhau.add(lblDoiMatKhau);
		
		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
		jPanelBody.add(panelDau);
		jPanelBody.add(jScrollPaneTable);
		jPanelBody.add(nutpanelThongTin);
		jPanelBody.add(nutpanelDoiMatKhau);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 964, 701);
		jScrollPane_Body.setViewportView(jPanelBody);
		
//		this.addComponentListener(new SuKienPannelTaiKhoan_SV(this));
		
		this.add(jScrollPane_Body);
	}
	

	private void setCustomScrollBar() {
    	jScrollPane_Body.setViewportBorder(null);
    	jScrollPane_Body.getViewport().setOpaque(false);
    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
    }
}


