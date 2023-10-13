package GUI.view.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;


@SuppressWarnings("serial")
public class PanelXepLichThi_XemLichThi extends JPanel {
	
	private JScrollPane jScrollPane_Body;
	private JScrollPane scrollPane_radioButton;
	private JPanel jPanelBody;
	public static JScrollPane jScrollPaneTable;
	private JPanel panelDau;
	private MenuName menuName;
	public JPanel panelChuaCacRadioButton;
	public JPanel panelChuaLichThiTuan;
	public ButtonGroup groupRadioButton;
	public JPanel nutpanelChonPhong;
	private JLabel lblChonPhong;
	public boolean checkDuLieuRong;


	public PanelXepLichThi_XemLichThi() {
		this.checkDuLieuRong = false;

		caiDatPanelXemLichThi();
		
		menuName.setText("Xem lịch thi");
        setCustomScrollBar();
        setCustomScrollPane_radioButton();

		
	}

	private void caiDatPanelXemLichThi() {

		
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 940, 579);
		this.setLayout(null);
        this.setOpaque(false);
		this.setVisible(false);
		menuName = new MenuName();
		menuName.setBounds(0, 0, 936, 40);
		
		panelDau = new JPanel();
		panelDau.setBounds(0, 0, 936, 40);
		panelDau.setLayout(null);
		panelDau.add(menuName);

		
        panelChuaLichThiTuan = new JPanel(new FlowLayout());
        panelChuaLichThiTuan.setLayout(new BoxLayout(panelChuaLichThiTuan, BoxLayout.Y_AXIS));
		
		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBorder(new LineBorder(new Color(130, 135, 144)));
		jScrollPaneTable.setBounds(203, 50, 723, 515);
		jScrollPaneTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPaneTable.setViewportView(panelChuaLichThiTuan);

		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
		jPanelBody.add(panelDau);
		jPanelBody.add(jScrollPaneTable);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 940, 579);
		jScrollPane_Body.setViewportView(jPanelBody);
		
		groupRadioButton = new ButtonGroup();

		JLabel lblPhongThi = new JLabel("Phòng thi");
		lblPhongThi.setHorizontalAlignment(JLabel.CENTER);
		lblPhongThi.setBounds(10, 10, 163, 43);
		lblPhongThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhongThi.setFont(new Font("Arial", Font.BOLD, 16));
		JPanel panelPhongThi = new JPanel();
		panelPhongThi.setBorder((Border) new LineBorder(new Color(100, 100, 100), 1));
		panelPhongThi.setPreferredSize(new Dimension(183,58));
		panelPhongThi.setLayout(null);
		panelPhongThi.add(lblPhongThi);
		
		
		// panel cha của các panelradiobutton
		
		panelChuaCacRadioButton = new JPanel();
		panelChuaCacRadioButton.setLayout(new BoxLayout(panelChuaCacRadioButton, BoxLayout.Y_AXIS));
		panelChuaCacRadioButton.add(panelPhongThi);
		
		// thanh cuộn của radiobutton
		
		scrollPane_radioButton = new JScrollPane();
		scrollPane_radioButton.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane_radioButton.setBounds(10, 78, 183, 399);
		scrollPane_radioButton.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane_radioButton.setViewportView(panelChuaCacRadioButton);
		
		
		// Chọn phòng
		
		nutpanelChonPhong = new JPanel();
		nutpanelChonPhong.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelChonPhong.addMouseListener(new PanelButtonMouseAdapter(nutpanelChonPhong));
		nutpanelChonPhong.setBackground(new Color(47, 79, 79));
		nutpanelChonPhong.setBounds(10, 498, 183, 46);
		nutpanelChonPhong.setLayout(null);
		
		lblChonPhong = new JLabel("Chọn Phòng");
		lblChonPhong.setForeground(new Color(255, 255, 255));
		lblChonPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChonPhong.setFont(new Font("Arial", Font.BOLD, 16));
		lblChonPhong.setBounds(10, 10, 163, 26);
		nutpanelChonPhong.add(lblChonPhong);
		//
		
		jPanelBody.add(nutpanelChonPhong);
		
		jPanelBody.add(scrollPane_radioButton);
		
		
		this.add(jScrollPane_Body);
	
		this.addComponentListener(new SuKienAdmin(this));
		this.nutpanelChonPhong.addMouseListener(new SuKienAdmin(this));

	}
	

	private void setCustomScrollBar() {
    	jScrollPane_Body.setViewportBorder(null);
    	jScrollPane_Body.getViewport().setOpaque(false);
    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
    }
	
	private void setCustomScrollPane_radioButton() {
		scrollPane_radioButton.setViewportBorder(null);
		scrollPane_radioButton.getViewport().setOpaque(false);
		scrollPane_radioButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane_radioButton.setVerticalScrollBar(new ScrollBarCustom());
		scrollPane_radioButton.setHorizontalScrollBar(new ScrollBarCustom());
    }
}
