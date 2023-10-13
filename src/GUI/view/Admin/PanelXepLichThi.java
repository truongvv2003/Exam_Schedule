package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;


@SuppressWarnings("serial")
public class PanelXepLichThi extends JPanel {

	
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public JPanel panelDau;
	public MenuName menuName;
	public JPanel nutpanelThoiGianThi;
	public JPanel nutpanelXemLichThi;
	public JLabel lblThoiGianThi;
	public JLabel lblXemLichThi;
	public JPanel jPanelFromVao;
	public PanelXepLichThi_ThoiGianThi panelXepLichThi_ThoiGianThi;
	public PanelXepLichThi_XemLichThi panelXepLichThi_XemLichThi;
	public static boolean AllowedClick = true;


	public PanelXepLichThi() {

		caiDatPanelXepLichThi();
		menuName.setText("Xếp lich thi");
        setCustomScrollBar();
        
	}

	private void caiDatPanelXepLichThi() {

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
		
		
		panelXepLichThi_ThoiGianThi = new PanelXepLichThi_ThoiGianThi();
		panelXepLichThi_ThoiGianThi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelXepLichThi_ThoiGianThi.setBounds(0, 0, 940, 579);
		
		panelXepLichThi_XemLichThi = new PanelXepLichThi_XemLichThi();
		panelXepLichThi_XemLichThi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelXepLichThi_XemLichThi.setBounds(0, 0, 940, 579);
		
		jPanelFromVao.add(panelXepLichThi_ThoiGianThi);
		jPanelFromVao.add(panelXepLichThi_XemLichThi);

		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 108, 940, 579);
		jScrollPaneTable.setViewportView(jPanelFromVao);

		
		
		
		nutpanelThoiGianThi = new JPanel();
		nutpanelThoiGianThi.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelThoiGianThi.addMouseListener(new PanelButtonMouseAdapter(nutpanelThoiGianThi) {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				form_DuocChon(panelXepLichThi_ThoiGianThi);
			}
		});
		nutpanelThoiGianThi.addMouseListener(new SuKienAdmin(this));
		nutpanelThoiGianThi.setBackground(new Color(47, 79, 79));
		nutpanelThoiGianThi.setBounds(170, 50, 225, 46);
		nutpanelThoiGianThi.setLayout(null);
		
		lblThoiGianThi = new JLabel("Thời Gian Thi");
		lblThoiGianThi.setForeground(new Color(255, 255, 255));
		lblThoiGianThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblThoiGianThi.setFont(new Font("Arial", Font.BOLD, 16));
		lblThoiGianThi.setBounds(43, 10, 146, 26);
		nutpanelThoiGianThi.add(lblThoiGianThi);
		
		
		nutpanelXemLichThi = new JPanel();
		nutpanelXemLichThi.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelXemLichThi.addMouseListener(new PanelButtonMouseAdapter(nutpanelXemLichThi));
		nutpanelXemLichThi.addMouseListener(new SuKienAdmin(this));
		nutpanelXemLichThi.setBackground(new Color(47, 79, 79));
		nutpanelXemLichThi.setBounds(565, 50, 225, 46);
		nutpanelXemLichThi.setLayout(null);
		
		lblXemLichThi = new JLabel("Xem lịch thi");
		lblXemLichThi.setForeground(new Color(255, 255, 255));
		lblXemLichThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblXemLichThi.setFont(new Font("Arial", Font.BOLD, 16));
		lblXemLichThi.setBounds(47, 10, 140, 26);
		nutpanelXemLichThi.add(lblXemLichThi);
		
		
		
		
		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
		jPanelBody.add(panelDau);
		jPanelBody.add(jScrollPaneTable);
		jPanelBody.add(nutpanelThoiGianThi);
		jPanelBody.add(nutpanelXemLichThi);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 964, 701);
		jScrollPane_Body.setViewportView(jPanelBody);

		form_DuocChon(panelXepLichThi_ThoiGianThi);
		this.addMouseListener(new SuKienAdmin(this));
		this.add(jScrollPane_Body);
	}
	

	private void setCustomScrollBar() {
    	jScrollPane_Body.setViewportBorder(null);
    	jScrollPane_Body.getViewport().setOpaque(false);
    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
    }
	
	public void form_DuocChon(JPanel panel) {
		panelXepLichThi_ThoiGianThi.setVisible(false);
		panelXepLichThi_XemLichThi.setVisible(false);
		panel.setVisible(true);
	}
	
}
