package GUI.view.SinhVien;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.LineBorder;

import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;

import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

import BLL.LichThiBLL;

@SuppressWarnings("serial")
public class PanelXemLichThi_SV extends JPanel {

	
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public JPanel panelXemLichThi;
	public JLabel lblXemLichThi;
	public TableCuaTui tableCuaTui;
	private class MyModel extends AbstractTableModel
	{
        String[][] list;
        public MyModel(String[][] list) {
            this.list = list;
        }

        @Override
        public String getColumnName(int column) {
        	switch(column)
        	{
        	case 0:
        		return "Số thứ tự";
        	case 1:
        		return "Tuần thứ";
        	case 2:
        		return "Tiết bắt đầu";
        	case 3:
        		return "Số tiết thi";
        	case 4:
        		return "Phòng thi";
        	case 5:
        		return "Tên học phần";
        	case 6:
        		return "Ngày thi";
        	}
			return "";
        }
        
        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public int getRowCount() {
            return list.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
        	if(list[rowIndex][columnIndex] == null)
        		return "";
        	return list[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
		
	}

	public PanelXemLichThi_SV() {

		caiDatPanelXepLichThi();
        setCustomScrollBar();
        
	}

	private void caiDatPanelXepLichThi() {

		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 964, 701);
		this.setLayout(null);
        this.setOpaque(false);

		
		tableCuaTui = new TableCuaTui();
		MyModel model = new MyModel(LichThiBLL.getInstance().getLichThiSVien(Integer.parseInt(ManHinhChinh_SV.taiKhoanSV)));
		tableCuaTui.setModel(model);
		

		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 66, 940, 621);
		jScrollPaneTable.setViewportView(tableCuaTui);
		
		
		panelXemLichThi = new JPanel();
		panelXemLichThi.setBorder(new LineBorder(new Color(0, 0, 0)));

		panelXemLichThi.setBackground(new Color(47, 79, 79));
		panelXemLichThi.setBounds(0, 0, 960, 56);
		panelXemLichThi.setLayout(null);
		
		lblXemLichThi = new JLabel("XEM LỊCH THI");
		lblXemLichThi.setForeground(new Color(255, 255, 255));
		lblXemLichThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblXemLichThi.setFont(new Font("Arial", Font.BOLD, 18));
		lblXemLichThi.setBounds(47, 10, 858, 36);
		panelXemLichThi.add(lblXemLichThi);
		
		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false);
		jPanelBody.add(jScrollPaneTable);
		jPanelBody.add(panelXemLichThi);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 964, 701);
		jScrollPane_Body.setViewportView(jPanelBody);
		
		
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

