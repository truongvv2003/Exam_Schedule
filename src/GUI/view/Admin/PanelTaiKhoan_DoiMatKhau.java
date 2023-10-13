package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;



@SuppressWarnings("serial")
public class PanelTaiKhoan_DoiMatKhau extends JPanel {


	public JPanel nutpanelLuu;
	public JLabel lblLuu;
	public JPasswordField jTextField_MatKhauCu;
	public JPasswordField jTextField_MatKhauMoi;
	public JPasswordField jTextField_NhapLaiMatKhau;


	public PanelTaiKhoan_DoiMatKhau() {
		caiDatPanelTaiKhoan_DoiMatKhau();
	}

	private void caiDatPanelTaiKhoan_DoiMatKhau() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 940, 423);
		this.setLayout(null);
        this.setOpaque(false);
		this.setVisible(false);
        

        JLabel lblTieuDe = new JLabel("ĐỔI MẬT KHẨU");
        lblTieuDe.setForeground(new Color(255, 255, 255));
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblTieuDe.setBounds(237, 10, 478, 31);
  
        
        JPanel panelTieuDe = new JPanel();
        panelTieuDe.setBackground(new Color(47, 79, 79));
        panelTieuDe.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelTieuDe.setBounds(0, 0, 938, 51);
        panelTieuDe.add(lblTieuDe);
        
        
        JPanel jPanelBody = new JPanel();
        jPanelBody.setBorder(null);
        jPanelBody.add(panelTieuDe);        
        panelTieuDe.setLayout(null);
        
        
        JScrollPane jScrollPaneBody = new JScrollPane(); 
        jScrollPaneBody.setBorder(new LineBorder(new Color(0, 0, 0)));
        jScrollPaneBody.setBounds(0, 0, 940, 579);
        jScrollPaneBody.setViewportView(jPanelBody);
        jPanelBody.setLayout(null);
        
        JLabel lblMatKhauCu = new JLabel("Mật khẩu cũ:");
        lblMatKhauCu.setFont(new Font("Arial", Font.BOLD, 16));
        lblMatKhauCu.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMatKhauCu.setBounds(215, 131, 155, 28);
        jPanelBody.add(lblMatKhauCu);
        
        JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới:");
        lblMatKhauMoi.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMatKhauMoi.setFont(new Font("Arial", Font.BOLD, 16));
        lblMatKhauMoi.setBounds(215, 203, 155, 28);
        jPanelBody.add(lblMatKhauMoi);
        
        
        JLabel lblNhapLaiMatKhau = new JLabel("Nhập lại mật khẩu:");
        lblNhapLaiMatKhau.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNhapLaiMatKhau.setFont(new Font("Arial", Font.BOLD, 16));
        lblNhapLaiMatKhau.setBounds(215, 275, 155, 28);
        jPanelBody.add(lblNhapLaiMatKhau);
        
        
        
        jTextField_MatKhauCu = new JPasswordField();
        jTextField_MatKhauCu.setFont(new Font("Arial", Font.BOLD, 14));
        jTextField_MatKhauCu.setBounds(435, 131, 229, 28);
        jPanelBody.add(jTextField_MatKhauCu);
        
        jTextField_MatKhauMoi = new JPasswordField();
        jTextField_MatKhauMoi.setFont(new Font("Arial", Font.BOLD, 14));
        jTextField_MatKhauMoi.setBounds(435, 203, 229, 28);
        jPanelBody.add(jTextField_MatKhauMoi);
        
        jTextField_NhapLaiMatKhau = new JPasswordField();
        jTextField_NhapLaiMatKhau.setFont(new Font("Arial", Font.BOLD, 14));
        jTextField_NhapLaiMatKhau.setBounds(435, 275, 229, 28);
        jPanelBody.add(jTextField_NhapLaiMatKhau);
        
		
		
		nutpanelLuu = new JPanel();
		nutpanelLuu.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelLuu.addMouseListener(new PanelButtonMouseAdapter(nutpanelLuu));
		nutpanelLuu.addMouseListener(new SuKienPanelTaiKhoan_DoiMatKhau(this));
		nutpanelLuu.setBackground(new Color(47, 79, 79));
		nutpanelLuu.setBounds(355, 370, 243, 46);
		nutpanelLuu.setLayout(null);
		
		lblLuu = new JLabel("Lưu mật khẩu");
		lblLuu.setForeground(new Color(255, 255, 255));
		lblLuu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuu.setFont(new Font("Arial", Font.BOLD, 16));
		lblLuu.setBounds(10, 10, 223, 26);
		nutpanelLuu.add(lblLuu);
		jPanelBody.add(nutpanelLuu);

        
        this.add(jScrollPaneBody);
		
	}
}
