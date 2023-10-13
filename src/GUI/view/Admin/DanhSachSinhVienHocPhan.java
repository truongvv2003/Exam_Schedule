package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;

@SuppressWarnings("serial")
public class DanhSachSinhVienHocPhan extends JFrame {
	public static int maLopHoc;
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public TableCuaTui tableCuaTui;
	public JPanel panelDau;
	public MenuName menuName;
	public JLabel lblExit;
	public DefaultTableModel model;


	public DanhSachSinhVienHocPhan() {
		setUndecorated(true);
		setResizable(false);
		
		caiDatPanelDanhSachSinhVienHocPhan();
		
		menuName.setText("Danh sách sinh viên lớp học phần");
		tableCuaTui.fixTable(jScrollPaneTable);
        setCustomScrollBar();
		
	}
	

	
	private void caiDatPanelDanhSachSinhVienHocPhan() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 913, 632);
		this.getContentPane().setLayout(null);
		

		menuName = new MenuName();
		menuName.setBounds(0, 0, 872, 40);
		
		panelDau = new JPanel();
		panelDau.setBounds(0, 0, 868, 40);
		panelDau.setLayout(null);
		panelDau.add(menuName);
		
		tableCuaTui = new TableCuaTui();
		model = new DefaultTableModel();
		this.model.addColumn("Số thứ tự");
		this.model.addColumn("Mã số sinh viên");
		this.model.addColumn("Họ và tên");
		this.model.addColumn("Lớp sinh hoạt");
		tableCuaTui.setModel(model);
		this.addComponentListener(new SuKienPannelThongTin_LopHocPhan(this));
		
		tableCuaTui.getTableHeader().setReorderingAllowed(false);
		
		
		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 50, 890, 573);
		jScrollPaneTable.setViewportView(tableCuaTui);
		

		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(true); // để không che khuất thằng phía sau
		jPanelBody.setLayout(null);
		jPanelBody.add(panelDau);
		jPanelBody.add(jScrollPaneTable);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 913, 633);
		jScrollPane_Body.setViewportView(jPanelBody);
		
		
		lblExit = new JLabel("X");
		lblExit.setBounds(878, 0, 25, 25);
		jPanelBody.add(lblExit);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(new Color(0, 0, 0));
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		jPanelBody.add(lblExit);
		
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DanhSachSinhVienHocPhan.this.dispose();
			}
			// di chuyển chuột vào
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.RED);
			}
			// di chuyển chuột ra khỏi
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.BLACK);
			}
		});
		
		
		getContentPane().add(jScrollPane_Body);
		
		this.setLocationRelativeTo(null);
		
		this.addWindowFocusListener(new SuKienPannelThongTin_LopHocPhan(this));

	}
	

	private void setCustomScrollBar() {
    	jScrollPane_Body.setViewportBorder(null);
    	jScrollPane_Body.getViewport().setOpaque(false);
    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
    }

}
