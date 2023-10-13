package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;


@SuppressWarnings("serial")
public class PanelThongTin extends JPanel {

	
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public JPanel panelDau;
	public MenuName menuName;
	public JPanel nutpanelLopHocPhan;
	public JPanel nutpanelGiangVien;
	public JLabel lblLopHocPhan;
	public JLabel lblGiangVien;
	public JPanel jPanelFromVao;
	public PanelThongTin_LopHocPhan panelThongTin_LopHocPhan;
	public PanelThongTin_GiangVien panelThongTin_GiangVien;



	public PanelThongTin() {

		caiDatPanelThongTin();
		menuName.setText("Thông Tin");
        setCustomScrollBar();
        
	}

	private void caiDatPanelThongTin() {

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
		jPanelFromVao.setLayout(null);
		jPanelFromVao.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jPanelFromVao.setBounds(0, 0, 940, 579);
		
		
		panelThongTin_LopHocPhan = new PanelThongTin_LopHocPhan();
		panelThongTin_LopHocPhan.jScrollPane_Body.setBounds(0, 0, 940, 579);
		panelThongTin_LopHocPhan.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelThongTin_LopHocPhan.setBounds(0, 0, 940, 579);
		
		panelThongTin_GiangVien = new PanelThongTin_GiangVien();
		panelThongTin_GiangVien.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelThongTin_GiangVien.setBounds(0, 0, 940, 579);
		
		jPanelFromVao.add(panelThongTin_LopHocPhan);
		jPanelFromVao.add(panelThongTin_GiangVien);

		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 108, 940, 579);
		jScrollPaneTable.setViewportView(jPanelFromVao);

		
		
		
		nutpanelLopHocPhan = new JPanel();
		nutpanelLopHocPhan.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelLopHocPhan.addMouseListener(new PanelButtonMouseAdapter(nutpanelLopHocPhan));
		nutpanelLopHocPhan.addMouseListener(new SuKienPannelThongTin(this));
		nutpanelLopHocPhan.setBackground(new Color(47, 79, 79));
		nutpanelLopHocPhan.setBounds(170, 50, 225, 46);
		nutpanelLopHocPhan.setLayout(null);
		
		lblLopHocPhan = new JLabel("Lớp học phần");
		lblLopHocPhan.setForeground(new Color(255, 255, 255));
		lblLopHocPhan.setHorizontalAlignment(SwingConstants.CENTER);
		lblLopHocPhan.setFont(new Font("Arial", Font.BOLD, 16));
		lblLopHocPhan.setBounds(41, 10, 146, 26);
		nutpanelLopHocPhan.add(lblLopHocPhan);
		
		nutpanelGiangVien = new JPanel();
		nutpanelGiangVien.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelGiangVien.addMouseListener(new PanelButtonMouseAdapter(nutpanelGiangVien));
		nutpanelGiangVien.addMouseListener(new SuKienPannelThongTin(this));
		nutpanelGiangVien.setBackground(new Color(47, 79, 79));
		nutpanelGiangVien.setBounds(565, 50, 225, 46);
		nutpanelGiangVien.setLayout(null);
		
		lblGiangVien = new JLabel("Giảng viên");
		lblGiangVien.setForeground(new Color(255, 255, 255));
		lblGiangVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiangVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblGiangVien.setBounds(47, 10, 140, 26);
		nutpanelGiangVien.add(lblGiangVien);
		
		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
		jPanelBody.add(panelDau);
		jPanelBody.add(jScrollPaneTable);
		jPanelBody.add(nutpanelLopHocPhan);
		jPanelBody.add(nutpanelGiangVien);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 964, 701);
		jScrollPane_Body.setViewportView(jPanelBody);
		
		this.addComponentListener(new SuKienPannelThongTin_LopHocPhan(this));
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


