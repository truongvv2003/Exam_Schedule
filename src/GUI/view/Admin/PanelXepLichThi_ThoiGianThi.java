package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import BLL.KeHoachBLL;
import BLL.ThoiGianBLL;
import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;

@SuppressWarnings("serial")
public class PanelXepLichThi_ThoiGianThi extends JPanel {

	public JPanel nutpanelXepLich;
	public JPanel nutpanelXoaLich;
	public JPanel nutpanelSetLich;
	public JLabel lblXepLich;
	public JLabel lblXoaLich;
	private JLabel lblSetLich;
	public static JComboBox<Integer> tuanBatDau;
	public static JTextField tuanKetThuc;
	public static boolean isAllowedClick = true;
	public PanelXepLichThi_ThoiGianThi() {
		caiDatPanelXepLichThi_ThoiGianThi();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void caiDatPanelXepLichThi_ThoiGianThi() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 940, 579);
		this.setLayout(null);
        this.setOpaque(false);
		//this.setVisible(false);
        

        JLabel lblTieuDe = new JLabel("CHỈNH SỬA THỜI GIAN THI");
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
        jScrollPaneBody.setBounds(0, 0, 940, 579);
        jScrollPaneBody.setViewportView(jPanelBody);
        jPanelBody.setLayout(null);
        
        JLabel lblNamhoc = new JLabel("Niên khóa:");
        lblNamhoc.setFont(new Font("Arial", Font.BOLD, 14));
        lblNamhoc.setHorizontalAlignment(SwingConstants.CENTER);
        lblNamhoc.setBounds(282, 110, 105, 28);
        jPanelBody.add(lblNamhoc);
        
        JLabel lblHocKi = new JLabel("Học kì:");
        lblHocKi.setHorizontalAlignment(SwingConstants.CENTER);
        lblHocKi.setFont(new Font("Arial", Font.BOLD, 14));
        lblHocKi.setBounds(282, 152, 105, 28);
        jPanelBody.add(lblHocKi);
        
        JComboBox comboBox_NienKhoa = new JComboBox();
        comboBox_NienKhoa.setModel(new DefaultComboBoxModel(new String[] {"2022 - 2023"}));
        comboBox_NienKhoa.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox_NienKhoa.setBounds(419, 111, 229, 28);
        jPanelBody.add(comboBox_NienKhoa);
        
        JComboBox comboBox_HocKi = new JComboBox();
        comboBox_HocKi.setModel(new DefaultComboBoxModel(new String[] {"Học kì II"}));
        comboBox_HocKi.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox_HocKi.setBounds(419, 153, 229, 28);
        jPanelBody.add(comboBox_HocKi);
        
        
        MenuName menuNameGTDienRaThiChung = new MenuName("Thời gian diễn ra kì thi chung");
        menuNameGTDienRaThiChung.setFont(new Font("Arial", Font.PLAIN, 16));
        menuNameGTDienRaThiChung.setBounds(10, 240, 916, 28);
        jPanelBody.add(menuNameGTDienRaThiChung);
        
        JLabel lblDienRaThiChungBatDau = new JLabel("Bắt đầu:");
        lblDienRaThiChungBatDau.setHorizontalAlignment(SwingConstants.CENTER);
        lblDienRaThiChungBatDau.setFont(new Font("Arial", Font.BOLD, 14));
        lblDienRaThiChungBatDau.setBounds(33, 320, 105, 28);
        jPanelBody.add(lblDienRaThiChungBatDau);
        
        JLabel lblDienRaThiChungKetThuc = new JLabel("Kết thúc:");
        lblDienRaThiChungKetThuc.setHorizontalAlignment(SwingConstants.CENTER);
        lblDienRaThiChungKetThuc.setFont(new Font("Arial", Font.BOLD, 14));
        lblDienRaThiChungKetThuc.setBounds(581, 320, 105, 28);
        jPanelBody.add(lblDienRaThiChungKetThuc);
        
        
        PanelXepLichThi_ThoiGianThi.tuanBatDau = new JComboBox();
        PanelXepLichThi_ThoiGianThi.tuanBatDau.setFont(new Font("Arial", Font.BOLD, 14));
        PanelXepLichThi_ThoiGianThi.tuanBatDau.setBounds(171, 320, 180, 28);
       // this.tuanBatDau.addActionListener(new SuKienThoiGianThi(this));
        jPanelBody.add(tuanBatDau);
        //
        PanelXepLichThi_ThoiGianThi.tuanKetThuc = new JTextField();
        PanelXepLichThi_ThoiGianThi.tuanKetThuc.setFont(new Font("Arial", Font.BOLD, 14));
        PanelXepLichThi_ThoiGianThi.tuanKetThuc.setBounds(719, 320, 180, 28);
        PanelXepLichThi_ThoiGianThi.tuanKetThuc.setEnabled(false);
   
        //this.tuanKetThuc.addActionListener(new SuKienThoiGianThi(this));
        jPanelBody.add(tuanKetThuc);
		
		
		nutpanelXepLich = new JPanel();
		nutpanelXepLich.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelXepLich.addMouseListener(new PanelButtonMouseAdapter(nutpanelXepLich));
		nutpanelXepLich.addMouseListener(new SuKienAdmin(this));
		nutpanelXepLich.setBackground(new Color(47, 79, 79));
		nutpanelXepLich.setBounds(195, 439, 183, 46);
		nutpanelXepLich.setLayout(null);
		
		lblXepLich = new JLabel("Xếp Lịch");
		lblXepLich.setForeground(new Color(255, 255, 255));
		lblXepLich.setHorizontalAlignment(SwingConstants.CENTER);
		lblXepLich.setFont(new Font("Arial", Font.BOLD, 16));
		lblXepLich.setBounds(10, 10, 163, 26);
		nutpanelXepLich.add(lblXepLich);
		jPanelBody.add(nutpanelXepLich);
        
        this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				if(tuanBatDau.getItemCount() == 0)
				{
					tuanKetThuc.setText(Integer.toString(KeHoachBLL.getInstance().getTuanKetThuc()));
					ArrayList<Integer> soTuan = ThoiGianBLL.getInstance().getListTuanThi();
					for(int i = 1 ; i < soTuan.size(); i++)
					{
						tuanBatDau.addItem(soTuan.get(i));
					}
				}
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
		nutpanelXoaLich = new JPanel();
		nutpanelXoaLich.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelXoaLich.addMouseListener(new PanelButtonMouseAdapter(nutpanelXoaLich));
		nutpanelXoaLich.addMouseListener(new SuKienAdmin(this));
		nutpanelXoaLich.setBackground(new Color(47, 79, 79));
		nutpanelXoaLich.setBounds(568, 439, 183, 46);
		nutpanelXoaLich.setLayout(null);
		
		lblXoaLich = new JLabel("Xóa Lịch");
		lblXoaLich.setForeground(new Color(255, 255, 255));
		lblXoaLich.setHorizontalAlignment(SwingConstants.CENTER);
		lblXoaLich.setFont(new Font("Arial", Font.BOLD, 16));
		lblXoaLich.setBounds(10, 10, 163, 26);
		nutpanelXoaLich.add(lblXoaLich);
		jPanelBody.add(nutpanelXoaLich);
		
		nutpanelSetLich = new JPanel();
		nutpanelSetLich.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelSetLich.addMouseListener(new PanelButtonMouseAdapter(nutpanelSetLich));
		nutpanelSetLich.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Integer> soTuan = ThoiGianBLL.getInstance().getListTuanThi();
				if(soTuan.get(0) + 1 < soTuan.get(soTuan.size()-1)) {
					tuanBatDau.setSelectedItem(soTuan.get(0) + 1);					
				}
				else JOptionPane.showMessageDialog(null, "Không thể set tuần thi với thời gian còn lại của học kỳ");
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
				
			}
		});
		nutpanelSetLich.setBackground(new Color(47, 79, 79));
		nutpanelSetLich.setBounds(384, 316, 164, 37);
		nutpanelSetLich.setLayout(null);
		
		lblSetLich = new JLabel("Set tuần bắt đầu");
		lblSetLich.setForeground(new Color(255, 255, 255));
		lblSetLich.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetLich.setFont(new Font("Arial", Font.BOLD, 14));
		lblSetLich.setBounds(10, 10, 144, 17);
		nutpanelSetLich.add(lblSetLich);
		jPanelBody.add(nutpanelSetLich);
        
		
        this.add(jScrollPaneBody);
		
	}
}

