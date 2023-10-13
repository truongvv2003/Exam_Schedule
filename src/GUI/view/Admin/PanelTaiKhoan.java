package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;


@SuppressWarnings("serial")
public class PanelTaiKhoan extends JPanel {

	
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public JPanel panelDau;
	public MenuName menuName;
	public JPanel jPanelFromVao;
	public PanelTaiKhoan_DoiMatKhau panelTaiKhoan_DoiMatKhau;
	public PanelTaiKhoan_TraCuuTaiKhoan panelTaiKhoan_TraCuuTaiKhoan;
	public JPanel nutpanelDoiMatKhau;
	public JLabel lblDoiMatKhau;
	public JPanel nutpanelTraCuuTaiKhoan;
	public JLabel lblTraCuuTaiKhoan;



	public PanelTaiKhoan() {

		caiDatPanelTaiKhoan();
		menuName.setText("Tài Khoản");
        setCustomScrollBar();
        
	}

	private void caiDatPanelTaiKhoan() {

		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 964, 701);
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
		jPanelFromVao.setBorder(null);
		jPanelFromVao.setLayout(null);
		jPanelFromVao.setBounds(0, 0, 940, 579);
		
		
		
		panelTaiKhoan_DoiMatKhau = new PanelTaiKhoan_DoiMatKhau();
		panelTaiKhoan_DoiMatKhau.setBounds(new Rectangle(0, 0, 940, 579));
		panelTaiKhoan_DoiMatKhau.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTaiKhoan_DoiMatKhau.setBounds(0, 0, 940, 579);
		
		panelTaiKhoan_TraCuuTaiKhoan = new PanelTaiKhoan_TraCuuTaiKhoan();
		panelTaiKhoan_TraCuuTaiKhoan.setBounds(new Rectangle(0, 0, 940, 579));
		panelTaiKhoan_TraCuuTaiKhoan.jScrollPaneTable.setBorder(new LineBorder(new Color(130, 135, 144)));
		panelTaiKhoan_TraCuuTaiKhoan.jScrollPaneTable.setBounds(12, 128, 918, 440);
		panelTaiKhoan_TraCuuTaiKhoan.lblTraCuu.setBounds(10, 10, 205, 26);
		panelTaiKhoan_TraCuuTaiKhoan.nutpanelTraCuu.setSize(225, 46);
		panelTaiKhoan_TraCuuTaiKhoan.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTaiKhoan_TraCuuTaiKhoan.setBounds(0, 0, 940, 579);
		
		jPanelFromVao.add(panelTaiKhoan_DoiMatKhau);
		jPanelFromVao.add(panelTaiKhoan_TraCuuTaiKhoan);

		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		jScrollPaneTable.setBounds(10, 108, 940, 579);
		jScrollPaneTable.setViewportView(jPanelFromVao);
		
		nutpanelDoiMatKhau = new JPanel();
		nutpanelDoiMatKhau.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelDoiMatKhau.addMouseListener(new PanelButtonMouseAdapter(nutpanelDoiMatKhau));
		nutpanelDoiMatKhau.addMouseListener(new SuKienPannelTaiKhoan(this));
		
		nutpanelDoiMatKhau.setBackground(new Color(47, 79, 79));
		nutpanelDoiMatKhau.setBounds(170, 50, 225, 46);
		nutpanelDoiMatKhau.setLayout(null);
		
		lblDoiMatKhau = new JLabel("Đổi mật khẩu");
		lblDoiMatKhau.setForeground(new Color(255, 255, 255));
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiMatKhau.setFont(new Font("Arial", Font.BOLD, 16));
		lblDoiMatKhau.setBounds(22, 10, 177, 26);
		nutpanelDoiMatKhau.add(lblDoiMatKhau);
		//
		nutpanelTraCuuTaiKhoan = new JPanel();
		nutpanelTraCuuTaiKhoan.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelTraCuuTaiKhoan.addMouseListener(new PanelButtonMouseAdapter(nutpanelTraCuuTaiKhoan));
		
		nutpanelTraCuuTaiKhoan.addMouseListener(new SuKienPannelTaiKhoan(this));
		
		nutpanelTraCuuTaiKhoan.setBackground(new Color(47, 79, 79));
		nutpanelTraCuuTaiKhoan.setBounds(565, 50, 225, 46);
		nutpanelTraCuuTaiKhoan.setLayout(null);
		
		lblTraCuuTaiKhoan = new JLabel("Tra cứu tài khoản");
		lblTraCuuTaiKhoan.setForeground(new Color(255, 255, 255));
		lblTraCuuTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraCuuTaiKhoan.setFont(new Font("Arial", Font.BOLD, 16));
		lblTraCuuTaiKhoan.setBounds(24, 10, 175, 26);
		nutpanelTraCuuTaiKhoan.add(lblTraCuuTaiKhoan);
		//
		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
		jPanelBody.add(panelDau);
		jPanelBody.add(jScrollPaneTable);
		jPanelBody.add(nutpanelDoiMatKhau);
		jPanelBody.add(nutpanelTraCuuTaiKhoan);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 964, 701);
		jScrollPane_Body.setViewportView(jPanelBody);
		
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


