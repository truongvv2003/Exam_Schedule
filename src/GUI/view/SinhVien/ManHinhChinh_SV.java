package GUI.view.SinhVien;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.border.LineBorder;

import GUI.view.Login;
import GUI.view.SuKienDoiHoatAnhTrenMenu_SV;
import GUI.view.SuKienlblX_MHC_SV;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

@SuppressWarnings("serial")
public class ManHinhChinh_SV extends JFrame {

	public static ManHinhChinh_SV manHinhChinh;
	private JPanel jPanel_Chinh;
	public PanelHome_SV panelHome;
	public PanelXemLichThi_SV panelXemLichThi;
	public PanelTaiKhoan_SV panelTaiKhoan;
	public JPanel paneSignOut;
	public JPanel paneHome;
	public JPanel paneXemLichThi;
	public JPanel paneTaiKhoan;
	public JLabel lblHome;
	public JLabel lblXemLichThi;
	public JLabel lblIconXemLichThi;
	public JLabel lblTaiKhoan;
	public JLabel lblIconTaiKhoan;
	public JLabel lblSignOut;
	public JLabel lblIconSigOut;
	public JLabel lblIconHome;
	public JLabel lblX;
	public JLabel lblX_1;

	
	public static String taiKhoanSV;
	public static String matKhauSV;
	public ManHinhChinh_SV() {
		setUndecorated(true);
		setResizable(false);
		caiDatGiaoDien();

	}
	
	public static ManHinhChinh_SV getManHinhChinh()
	{
		if(manHinhChinh == null)
		{
			manHinhChinh = new ManHinhChinh_SV();
		}
		return manHinhChinh;
	}
	
	//public ManHinh
	
	public void caiDatGiaoDien() {
		
		// set thằng màn hình chính
		this.setBackground(new Color(47, 79, 79));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new SuKienDoiHoatAnhTrenMenu_SV(this));
		UIManager.put("Frame.needDefaultIcon", true); // ẩn thằng phóng to thu nhỏ
		setBounds(100, 100, 1292, 746);
		setLocationRelativeTo(null); // đặt màn hình ở giữa
		// cần set layout cho jPanel chính
		jPanel_Chinh = new JPanel();
		jPanel_Chinh.setBackground(new Color(0, 128, 128));
		jPanel_Chinh.setBorder(new LineBorder(new Color(0, 0, 128), 2)); // độ dày của viền là 2 pixel
		
		setContentPane(jPanel_Chinh); // nó sẽ là nội dung chính hiển thị trên của sổ
		jPanel_Chinh.setLayout(null);
		
		
		
		panelHome = new PanelHome_SV();
		panelHome.setBounds(0, 0, 964, 701);


		panelXemLichThi = new PanelXemLichThi_SV();
		panelXemLichThi.setBounds(0, 0, 964, 701);

		panelTaiKhoan = new PanelTaiKhoan_SV();
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
		lblIconLogo.setIcon(new ImageIcon(ManHinhChinh_SV.class.getResource("/res/university.png")));
		lblIconLogo.setBounds(22, 10, 264, 200);
		paneMenu.add(lblIconLogo);
		
		// sự kiện đổi hoạt ảnh trên menu
		paneHome = new JPanel();
		paneHome.addMouseListener(new SuKienDoiHoatAnhTrenMenu_SV(this, paneHome));
		
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
		lblIconHome.setIcon(new ImageIcon(ManHinhChinh_SV.class.getResource("/res/Home.png")));
		lblIconHome.setBounds(10, -2, 76, 76);
		paneHome.add(lblIconHome);
		
		
		
		paneXemLichThi = new JPanel();
		paneXemLichThi.addMouseListener(new SuKienDoiHoatAnhTrenMenu_SV(this, paneXemLichThi));
		
		paneXemLichThi.setBackground(new Color(47, 79, 79));
		paneXemLichThi.setBounds(10, 307, 288, 76);
		paneMenu.add(paneXemLichThi);
		paneXemLichThi.setLayout(null);
		
		lblXemLichThi = new JLabel("LỊCH THI");
		lblXemLichThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblXemLichThi.setForeground(Color.WHITE);
		lblXemLichThi.setFont(new Font("Dialog", Font.BOLD, 20));
		lblXemLichThi.setBounds(78, 10, 204, 44);
		paneXemLichThi.add(lblXemLichThi);
		
		lblIconXemLichThi = new JLabel("");
		lblIconXemLichThi.setIcon(new ImageIcon(ManHinhChinh_SV.class.getResource("/res/Cutomer.png")));
		lblIconXemLichThi.setBounds(10, 0, 76, 76);
		paneXemLichThi.add(lblIconXemLichThi);
		
		paneTaiKhoan = new JPanel();
		paneTaiKhoan.addMouseListener(new SuKienDoiHoatAnhTrenMenu_SV(this, paneTaiKhoan));
		
		paneTaiKhoan.setBackground(new Color(47, 79, 79));
		paneTaiKhoan.setBounds(10, 381, 288, 76);
		paneMenu.add(paneTaiKhoan);
		paneTaiKhoan.setLayout(null);
		
		lblTaiKhoan = new JLabel("TÀI KHOẢN");
		lblTaiKhoan.addMouseListener(new SuKienDoiHoatAnhTrenMenu_SV(this, paneTaiKhoan));
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setForeground(Color.WHITE);
		lblTaiKhoan.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTaiKhoan.setBounds(79, 10, 203, 44);
		paneTaiKhoan.add(lblTaiKhoan);
		
		lblIconTaiKhoan = new JLabel("");
		lblIconTaiKhoan.setIcon(new ImageIcon(ManHinhChinh_SV.class.getResource("/res/settings.png")));
		lblIconTaiKhoan.setBounds(10, 0, 76, 76);
		paneTaiKhoan.add(lblIconTaiKhoan);
		
		paneSignOut = new JPanel();
		paneSignOut.addMouseListener(new SuKienDoiHoatAnhTrenMenu_SV(this, paneSignOut));
		
		paneSignOut.setBackground(new Color(47, 79, 79));
		paneSignOut.setBounds(10, 455, 288, 76);
		paneMenu.add(paneSignOut);
		paneSignOut.setLayout(null);
		
		lblSignOut = new JLabel("ĐĂNG XUẤT");
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSignOut.setBounds(80, 10, 202, 44);
		paneSignOut.add(lblSignOut);
		
		lblIconSigOut = new JLabel("");
		lblIconSigOut.setIcon(new ImageIcon(ManHinhChinh_SV.class.getResource("/res/SignOut.png")));
		lblIconSigOut.setBounds(10, 0, 76, 76);
		paneSignOut.add(lblIconSigOut);
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX.addMouseListener(new SuKienlblX_MHC_SV(this));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(1264, 0, 25, 25);
		jPanel_Chinh.add(lblX);
		
		lblX_1 = new JLabel("―");
		lblX_1.setForeground(new Color(255, 255, 255));
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX_1.addMouseListener(new SuKienlblX_MHC_SV(this));
		lblX_1.setBounds(1229, 0, 25, 25);
		jPanel_Chinh.add(lblX_1);
	
		
		JPanel jPanel_FormDuaVao = new JPanel();
		jPanel_FormDuaVao.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		jPanel_FormDuaVao.setBounds(318, 35, 964, 701);
		
		jPanel_Chinh.add(jPanel_FormDuaVao);
		
		jPanel_FormDuaVao.setLayout(null);
		jPanel_FormDuaVao.add(panelHome);
		jPanel_FormDuaVao.add(panelXemLichThi);
		jPanel_FormDuaVao.add(panelTaiKhoan);
		
		form_DuocChon(panelHome);
	}

	public void form_DuocChon(JPanel panel) {
		panelHome.setVisible(false);
		panelXemLichThi.setVisible(false);
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
			ManHinhChinh_SV.this.dispose();
		}
	}
	
	public void suKienlblMiniSize() {
		ManHinhChinh_SV.this.setState(JFrame.ICONIFIED);
	}
}
