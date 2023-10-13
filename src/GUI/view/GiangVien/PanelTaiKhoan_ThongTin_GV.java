package GUI.view.GiangVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import BLL.GiangVienBLL;
import BLL.UserBLL;
import GUI.view.PanelButtonMouseAdapter;



@SuppressWarnings("serial")
public class PanelTaiKhoan_ThongTin_GV extends JPanel {


	public JPanel nutpanelLuu;
	public JLabel lblLuu;
	public JTextField jTextField_HoVaTen;
	public JTextField jTextField_NgaySinh;
	public JComboBox<String> NoiSinh;
	public JTextField jTextField_GioiTinh;
	public JTextField textField_MaGiangVien;
	public JTextField textField_Khoa;
	public JTextField textField_ChucDanhKH;
	public JTextField textField_SoDienThoai;

	public PanelTaiKhoan_ThongTin_GV() {
		caiDatPanelXepLichThi_ThoiGianThi();
		docDuLieu();
		luuGV();
	}

	private void caiDatPanelXepLichThi_ThoiGianThi() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 940, 423);
		this.setLayout(null);
        this.setOpaque(false);
		this.setVisible(true);
        

        JLabel lblTieuDe = new JLabel("THÔNG TIN TÀI KHOẢN");
        lblTieuDe.setForeground(new Color(255, 255, 255));
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblTieuDe.setBounds(237, 10, 478, 31);
  
        
        JPanel panelTieuDe = new JPanel();
        panelTieuDe.setBackground(new Color(47, 79, 79));
        panelTieuDe.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelTieuDe.setBounds(0, 0, 936, 51);
        panelTieuDe.add(lblTieuDe);
        
        
        JPanel jPanelBody = new JPanel();
        jPanelBody.add(panelTieuDe);        
        panelTieuDe.setLayout(null);
        
        
        JScrollPane jScrollPaneBody = new JScrollPane(); 
        jScrollPaneBody.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        jScrollPaneBody.setBounds(0, 0, 940, 423);
        jScrollPaneBody.setViewportView(jPanelBody);
        jPanelBody.setLayout(null);
        
        JLabel lblHoVaTen = new JLabel("Họ và tên:");
        lblHoVaTen.setFont(new Font("Arial", Font.BOLD, 16));
        lblHoVaTen.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHoVaTen.setBounds(53, 83, 105, 28);
        jPanelBody.add(lblHoVaTen);
        
        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
        lblNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNgaySinh.setFont(new Font("Arial", Font.BOLD, 16));
        lblNgaySinh.setBounds(53, 127, 105, 28);
        jPanelBody.add(lblNgaySinh);
        
        
        JLabel lblNoiSinh = new JLabel("Nơi sinh:");
        lblNoiSinh.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNoiSinh.setFont(new Font("Arial", Font.BOLD, 16));
        lblNoiSinh.setBounds(53, 171, 105, 28);
        jPanelBody.add(lblNoiSinh);
        
        JLabel lblGioiTinh = new JLabel("Giới tính:");
        lblGioiTinh.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
        lblGioiTinh.setBounds(53, 215, 105, 28);
        jPanelBody.add(lblGioiTinh);
        
        
        jTextField_HoVaTen = new JTextField();
        jTextField_HoVaTen.setFont(new Font("Arial", Font.BOLD, 14));
        jTextField_HoVaTen.setBounds(211, 83, 229, 28);
        jTextField_HoVaTen.setEnabled(false);
        jPanelBody.add(jTextField_HoVaTen);
        
        jTextField_NgaySinh = new JTextField();
        jTextField_NgaySinh.setFont(new Font("Arial", Font.BOLD, 14));
        jTextField_NgaySinh.setBounds(211, 127, 229, 28);
        jTextField_NgaySinh.setEnabled(false);
        jPanelBody.add(jTextField_NgaySinh);
        
        NoiSinh = new JComboBox<String>();
        NoiSinh.setFont(new Font("Arial", Font.PLAIN, 14));
        NoiSinh.setBounds(211, 171, 229, 28);
        jPanelBody.add(NoiSinh);
        
        jTextField_GioiTinh = new JTextField();
        jTextField_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 14));
        jTextField_GioiTinh.setBounds(211, 215, 229, 28);
        jTextField_GioiTinh.setEnabled(false);
        jPanelBody.add(jTextField_GioiTinh);
		
		
		nutpanelLuu = new JPanel();
		nutpanelLuu.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelLuu.addMouseListener(new PanelButtonMouseAdapter(nutpanelLuu));

		nutpanelLuu.setBackground(new Color(47, 79, 79));
		nutpanelLuu.setBounds(355, 309, 243, 46);
		nutpanelLuu.setLayout(null);
		
		lblLuu = new JLabel("Lưu thông tin cá nhân");
		lblLuu.setForeground(new Color(255, 255, 255));
		lblLuu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuu.setFont(new Font("Arial", Font.BOLD, 16));
		lblLuu.setBounds(10, 10, 223, 26);
		nutpanelLuu.add(lblLuu);
		jPanelBody.add(nutpanelLuu);
		
		JLabel lblMaGiangVien = new JLabel("Mã giảng viên:");
		lblMaGiangVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaGiangVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblMaGiangVien.setBounds(459, 83, 139, 28);
		jPanelBody.add(lblMaGiangVien);
		
		textField_MaGiangVien = new JTextField();
		textField_MaGiangVien.setFont(new Font("Arial", Font.BOLD, 14));
		textField_MaGiangVien.setBounds(651, 83, 229, 28);
		textField_MaGiangVien.setEnabled(false);
		jPanelBody.add(textField_MaGiangVien);
		
		JLabel lblKhoa = new JLabel("Khoa:");
		lblKhoa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKhoa.setFont(new Font("Arial", Font.BOLD, 16));
		lblKhoa.setBounds(493, 127, 105, 28);
		jPanelBody.add(lblKhoa);
		
		textField_Khoa = new JTextField();
		textField_Khoa.setFont(new Font("Arial", Font.BOLD, 14));
		textField_Khoa.setBounds(651, 127, 229, 28);
		textField_Khoa.setEnabled(false);
		jPanelBody.add(textField_Khoa);
		
		JLabel lblDiaChi = new JLabel("Chức danh KH:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 16));
		lblDiaChi.setBounds(493, 171, 105, 28);
		jPanelBody.add(lblDiaChi);
		
		textField_ChucDanhKH = new JTextField();
		textField_ChucDanhKH.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_ChucDanhKH.setBounds(651, 171, 229, 28);
		textField_ChucDanhKH.setEnabled(false);
		jPanelBody.add(textField_ChucDanhKH);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoDienThoai.setBounds(493, 215, 105, 28);
		jPanelBody.add(lblSoDienThoai);
		
		textField_SoDienThoai = new JTextField();
		textField_SoDienThoai.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_SoDienThoai.setBounds(651, 215, 229, 28);
		jPanelBody.add(textField_SoDienThoai);
        
		ArrayList<String> listTinh = UserBLL.getInstance().getTinh();
		for (int i = 0; i < listTinh.size(); i++) {
			NoiSinh.addItem(listTinh.get(i));
		}
		
        this.add(jScrollPaneBody);
		
	}
	
	private void docDuLieu() {
		jTextField_HoVaTen.setText(GiangVienBLL.getInstance().getGiangVien(ManHinhChinh_GV.taiKhoanGV).getHoTen());
		if(GiangVienBLL.getInstance().getGiangVien(ManHinhChinh_GV.taiKhoanGV).isGioiTinh() == true) {
			jTextField_GioiTinh.setText("Nam");
		}
		else jTextField_GioiTinh.setText("Nữ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dob = GiangVienBLL.getInstance().getGiangVien(ManHinhChinh_GV.taiKhoanGV).getNgaySinh();
		jTextField_NgaySinh.setText(sdf.format(dob));
		textField_Khoa.setText("Công nghệ thông tin");
		textField_MaGiangVien.setText(GiangVienBLL.getInstance().getGiangVien(ManHinhChinh_GV.taiKhoanGV).getIDGiangVien() + "");
		textField_ChucDanhKH.setText(GiangVienBLL.getInstance().getGiangVien(ManHinhChinh_GV.taiKhoanGV).getChucDanhKH());
		textField_SoDienThoai.setText(GiangVienBLL.getInstance().getGiangVien(ManHinhChinh_GV.taiKhoanGV).getSoDienThoai());
		NoiSinh.setSelectedItem(GiangVienBLL.getInstance().getGiangVien(ManHinhChinh_GV.taiKhoanGV).getQueQuan());
	}
	private void luuGV() {
		this.nutpanelLuu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(textField_SoDienThoai.getText().replaceAll(" ", "").equals("") == true) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại của bạn");
				}
				else{
					GiangVienBLL.getInstance().UpdateThongTinGV(ManHinhChinh_GV.taiKhoanGV, NoiSinh.getSelectedItem().toString(), textField_SoDienThoai.getText());
					JOptionPane.showMessageDialog(null, "Lưu thông tin thành công");
				}
			}
		});
	}
	
}
