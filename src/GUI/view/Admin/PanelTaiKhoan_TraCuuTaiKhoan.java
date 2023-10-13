package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import GUI.view.*;
import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;

@SuppressWarnings("serial")
public class PanelTaiKhoan_TraCuuTaiKhoan extends JPanel {


	public JPanel nutpanelTraCuu;
	public JLabel lblTraCuu;
	public JTextField jTextField_TraCuuTaiKhoan;
	public TableCuaTui tableCuaTui;
	public JScrollPane jScrollPaneTable;
	public DefaultTableModel model;


	public PanelTaiKhoan_TraCuuTaiKhoan() {
		caiDatPanelTaiKhoan_TraCuuTaiKhoan();
		setCustomScrollBar();
	}

	private void caiDatPanelTaiKhoan_TraCuuTaiKhoan() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 939, 579);
		this.setLayout(null);
        this.setOpaque(false);
		this.setVisible(true);
        

        JLabel lblTieuDe = new JLabel("TRA CỨU TÀI KHOẢN");
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
        
        JLabel lblTraCuuTaiKhoan = new JLabel("Tra cứu tài khoản:");
        lblTraCuuTaiKhoan.setFont(new Font("Arial", Font.BOLD, 16));
        lblTraCuuTaiKhoan.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTraCuuTaiKhoan.setBounds(60, 81, 155, 28);
        jPanelBody.add(lblTraCuuTaiKhoan);
        
        
        jTextField_TraCuuTaiKhoan = new JTextField();
        jTextField_TraCuuTaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);
        jTextField_TraCuuTaiKhoan.setFont(new Font("Arial", Font.BOLD, 14));
    	jTextField_TraCuuTaiKhoan.setText("Nhập ID hoặc tên");
        jTextField_TraCuuTaiKhoan.setBounds(275, 81, 299, 28);
        jTextField_TraCuuTaiKhoan.addKeyListener(new SuKienPanelTaiKhoan_TraCuuTaiKhoan(this));
        jTextField_TraCuuTaiKhoan.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
            	if(jTextField_TraCuuTaiKhoan.getText().equals(""))
                	jTextField_TraCuuTaiKhoan.setText("Nhập ID hoặc tên");
            }

            @Override
            public void focusGained(FocusEvent e) {
                // TODO Auto-generated method stub
            		jTextField_TraCuuTaiKhoan.setText("");
            }
        });
        jPanelBody.add(jTextField_TraCuuTaiKhoan);
        
		
		
		nutpanelTraCuu = new JPanel();
		nutpanelTraCuu.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelTraCuu.addMouseListener(new PanelButtonMouseAdapter(nutpanelTraCuu));
		nutpanelTraCuu.addMouseListener(new SuKienPanelTaiKhoan_TraCuuTaiKhoan(this));
		nutpanelTraCuu.setBackground(new Color(47, 79, 79));
		nutpanelTraCuu.setBounds(634, 72, 243, 46);
		nutpanelTraCuu.setLayout(null);
		
		lblTraCuu = new JLabel("Tra cứu");
		lblTraCuu.setForeground(new Color(255, 255, 255));
		lblTraCuu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraCuu.setFont(new Font("Arial", Font.BOLD, 16));
		lblTraCuu.setBounds(10, 10, 223, 26);
		nutpanelTraCuu.add(lblTraCuu);
		jPanelBody.add(nutpanelTraCuu);

		tableCuaTui = new TableCuaTui();
		tableCuaTui.setFont(new Font("Arial", Font.PLAIN, 14));
		model = new DefaultTableModel();
		this.model.addColumn("Số thứ tự");
		this.model.addColumn("ID");
		this.model.addColumn("Họ và tên");
		this.model.addColumn("Tên đăng nhập");
		this.model.addColumn("Mật khẩu");
		this.model.addColumn("Reset mật khẩu");
		tableCuaTui.setModel(model);
		tableCuaTui.addMouseListener(new SuKienPanelTaiKhoan_TraCuuTaiKhoan(this));
		model.setNumRows(0);
		this.tableCuaTui.setEnabled(false);
		tableCuaTui.getTableHeader().setReorderingAllowed(false);

		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBorder(new LineBorder(new Color(130, 135, 144)));
		jScrollPaneTable.setBounds(10, 128, 918, 439);
		jScrollPaneTable.setViewportView(tableCuaTui);
		jPanelBody.add(jScrollPaneTable);
        
        this.add(jScrollPaneBody);
		
	}
	private void setCustomScrollBar() {
		jScrollPaneTable.setViewportBorder(null);
		jScrollPaneTable.getViewport().setOpaque(false);
		jScrollPaneTable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jScrollPaneTable.setVerticalScrollBar(new ScrollBarCustom());
		jScrollPaneTable.setHorizontalScrollBar(new ScrollBarCustom());
	}
}
