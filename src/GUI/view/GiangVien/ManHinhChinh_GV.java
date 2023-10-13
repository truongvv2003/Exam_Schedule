package GUI.view.GiangVien;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.border.LineBorder;

import GUI.view.Login;
import GUI.view.SuKienDoiHoatAnhTrenMenu_GV;
import GUI.view.SuKienlblX_MHC_GV;
import GUI.view.Admin.ManHinhChinh;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

@SuppressWarnings("serial")
public class ManHinhChinh_GV extends JFrame {

	public ManHinhChinh_GV manHinhChinh;
	private JPanel jPanel_Chinh;
	public PanelHome_GV panelHome;
	public PanelThongTin_GV panelThongTin;
	public PanelXepLichThi_GV panelXepLichThi;
	public PanelTaiKhoan_GV panelTaiKhoan;
	public JPanel paneSignOut;
	public JPanel paneHome;
	public JPanel paneThongTin;
	public JPanel paneXepLichThi;
	public JPanel paneTaiKhoan;
	public JLabel lblHome;
	public JLabel lblThongTin;
	public JLabel lblIconThongTin;
	public JLabel lblXepLichThi;
	public JLabel lblIconXepLichThi;
	public JLabel lblTaiKhoan;
	public JLabel lblIconTaiKhoan;
	public JLabel lblSignOut;
	public JLabel lblIconSigOut;
	public JLabel lblIconHome;
	public JLabel lblX;
	public JLabel lblX_1;
	
	
	public static String taiKhoanGV;
	public static String matKhauGV;
	
	public ManHinhChinh_GV() {
		setUndecorated(true);
		setResizable(false);
		caiDatGiaoDien();

	}
	
	
	//public ManHinh
	
	public void caiDatGiaoDien() {
		
		// set thằng màn hình chính
		this.setBackground(new Color(47, 79, 79));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new SuKienDoiHoatAnhTrenMenu_GV(this));
		UIManager.put("Frame.needDefaultIcon", true); // ẩn thằng phóng to thu nhỏ
		setBounds(100, 100, 1292, 746);
		setLocationRelativeTo(null); // đặt màn hình ở giữa
		// cần set layout cho jPanel chính
		jPanel_Chinh = new JPanel();
		jPanel_Chinh.setBackground(new Color(0, 128, 128));
		jPanel_Chinh.setBorder(new LineBorder(new Color(0, 0, 128), 2)); // độ dày của viền là 2 pixel
		
		setContentPane(jPanel_Chinh); // nó sẽ là nội dung chính hiển thị trên của sổ
		jPanel_Chinh.setLayout(null);
		
		
		
		panelHome = new PanelHome_GV();
		panelHome.setBounds(0, 0, 964, 701);

		panelThongTin = new PanelThongTin_GV();
		panelThongTin.setBounds(0, 0, 964, 701);

		panelXepLichThi = new PanelXepLichThi_GV();
		panelXepLichThi.setBounds(0, 0, 964, 701);

		panelTaiKhoan = new PanelTaiKhoan_GV();
		panelTaiKhoan.setBounds(0, 0, 964, 701);
		
		

		
		JPanel paneMenu = new JPanel();
		paneMenu.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		paneMenu.setBackground(new Color(47, 79, 79));
		paneMenu.setBounds(0, 0, 308, 746);
		paneMenu.setLayout(null);
		jPanel_Chinh.add(paneMenu);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBackground(new Color(47, 79, 79));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setIcon(new ImageIcon(ManHinhChinh_GV.class.getResource("/res/university.png")));
		lblIconLogo.setBounds(22, 10, 264, 200);
		paneMenu.add(lblIconLogo);
		
		// sự kiện đổi hoạt ảnh trên menu
		paneHome = new JPanel();
		paneHome.addMouseListener(new SuKienDoiHoatAnhTrenMenu_GV(this, paneHome));
		
		paneHome.setBackground(new Color(47, 79, 79));
		paneHome.setBounds(10, 231, 288, 76);
		paneMenu.add(paneHome);
		paneHome.setLayout(null);
		
		lblHome = new JLabel("TRANG CHỦ");
		lblHome.setForeground(Color.WHITE);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHome.setBounds(90, 10, 192, 56);
		paneHome.add(lblHome);
		
		lblIconHome = new JLabel("");
		lblIconHome.setIcon(new ImageIcon(ManHinhChinh_GV.class.getResource("/res/Home.png")));
		lblIconHome.setBounds(10, -2, 76, 76);
		paneHome.add(lblIconHome);

		paneThongTin = new JPanel();
		paneThongTin.addMouseListener(new SuKienDoiHoatAnhTrenMenu_GV(this, paneThongTin));
		
		paneThongTin.setBackground(new Color(47, 79, 79));
		paneThongTin.setBounds(10, 306, 288, 76);
		paneMenu.add(paneThongTin);
		paneThongTin.setLayout(null);
		
		lblThongTin = new JLabel("XEM THÔNG TIN");
		lblThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTin.setForeground(Color.WHITE);
		lblThongTin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblThongTin.setBounds(79, 10, 203, 44);
		paneThongTin.add(lblThongTin);
		
		lblIconThongTin = new JLabel("");
		lblIconThongTin.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/Order.png")));
		lblIconThongTin.setBounds(10, -2, 76, 76);
		paneThongTin.add(lblIconThongTin);
		
		
		paneXepLichThi = new JPanel();
		paneXepLichThi.addMouseListener(new SuKienDoiHoatAnhTrenMenu_GV(this, paneXepLichThi));
		
		paneXepLichThi.setBackground(new Color(47, 79, 79));
		paneXepLichThi.setBounds(10, 382, 288, 76);
		paneMenu.add(paneXepLichThi);
		paneXepLichThi.setLayout(null);
		
		lblXepLichThi = new JLabel("XẾP LỊCH THI");
		lblXepLichThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblXepLichThi.setForeground(Color.WHITE);
		lblXepLichThi.setFont(new Font("Dialog", Font.BOLD, 20));
		lblXepLichThi.setBounds(78, 10, 204, 44);
		paneXepLichThi.add(lblXepLichThi);
		
		lblIconXepLichThi = new JLabel("");
		lblIconXepLichThi.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/Cutomer.png")));
		lblIconXepLichThi.setBounds(10, 0, 76, 76);
		paneXepLichThi.add(lblIconXepLichThi);
		
		paneTaiKhoan = new JPanel();
		paneTaiKhoan.addMouseListener(new SuKienDoiHoatAnhTrenMenu_GV(this, paneTaiKhoan));
		
		paneTaiKhoan.setBackground(new Color(47, 79, 79));
		paneTaiKhoan.setBounds(10, 456, 288, 76);
		paneMenu.add(paneTaiKhoan);
		paneTaiKhoan.setLayout(null);
		
		lblTaiKhoan = new JLabel("TÀI KHOẢN");
		lblTaiKhoan.addMouseListener(new SuKienDoiHoatAnhTrenMenu_GV(this, paneTaiKhoan));
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setForeground(Color.WHITE);
		lblTaiKhoan.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTaiKhoan.setBounds(79, 10, 203, 44);
		paneTaiKhoan.add(lblTaiKhoan);
		
		lblIconTaiKhoan = new JLabel("");
		lblIconTaiKhoan.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/settings.png")));
		lblIconTaiKhoan.setBounds(10, 0, 76, 76);
		paneTaiKhoan.add(lblIconTaiKhoan);
		
		paneSignOut = new JPanel();
		paneSignOut.addMouseListener(new SuKienDoiHoatAnhTrenMenu_GV(this, paneSignOut));
		
		paneSignOut.setBackground(new Color(47, 79, 79));
		paneSignOut.setBounds(10, 530, 288, 76);
		paneMenu.add(paneSignOut);
		paneSignOut.setLayout(null);
		
		lblSignOut = new JLabel("ĐĂNG XUẤT");
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSignOut.setBounds(80, 10, 202, 44);
		paneSignOut.add(lblSignOut);
		
		lblIconSigOut = new JLabel("");
		lblIconSigOut.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/SignOut.png")));
		lblIconSigOut.setBounds(10, 0, 76, 76);
		paneSignOut.add(lblIconSigOut);
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX.addMouseListener(new SuKienlblX_MHC_GV(this));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(1264, 0, 25, 25);
		jPanel_Chinh.add(lblX);
		
		lblX_1 = new JLabel("―");
		lblX_1.setForeground(new Color(255, 255, 255));
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX_1.addMouseListener(new SuKienlblX_MHC_GV(this));
		lblX_1.setBounds(1229, 0, 25, 25);
		jPanel_Chinh.add(lblX_1);
	
		
		JPanel jPanel_FormDuaVao = new JPanel();
		jPanel_FormDuaVao.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		jPanel_FormDuaVao.setBounds(318, 35, 964, 701);
		
		jPanel_Chinh.add(jPanel_FormDuaVao);
		
		jPanel_FormDuaVao.setLayout(null);
		jPanel_FormDuaVao.add(panelHome);
		jPanel_FormDuaVao.add(panelThongTin);
		jPanel_FormDuaVao.add(panelXepLichThi);
		jPanel_FormDuaVao.add(panelTaiKhoan);
		
		form_DuocChon(panelHome);
	}

	public void form_DuocChon(JPanel panel) {
		panelHome.setVisible(false);
		panelThongTin.setVisible(false);
		panelXepLichThi.setVisible(false);
		panelTaiKhoan.setVisible(false);
		
		panel.setVisible(true);
	}

	public void suKien_paneSignOut() {
		if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", 
				"Thoát chương trình", JOptionPane.YES_NO_OPTION) == 0) {
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		}
		
	}
	
	public void suKienlblX() {
		if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", "Thoát chương trình", JOptionPane.YES_NO_OPTION) == 0) {
			ManHinhChinh_GV.this.dispose();
		}
	}
	
	public void suKienlblMiniSize() {
		ManHinhChinh_GV.this.setState(JFrame.ICONIFIED);
	}
}
