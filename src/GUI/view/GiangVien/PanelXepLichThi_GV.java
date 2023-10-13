package GUI.view.GiangVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import BLL.LichThiBLL;
import BLL.LopHocPhanBLL;
import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PanelXepLichThi_GV extends JPanel {
	
	private JScrollPane jScrollPane_Body;
	private JPanel jPanelBody;
	private JScrollPane jScrollPaneTable;
	private TableCuaTui tableCuaTui;
	private JPanel panelXemLichThi;
	private JLabel lblXemLichThi;
	private MyModel model;
	private class MyModel extends AbstractTableModel
	{
		Object [][] list;
		public MyModel(Object list[][])
		{
			this.list = list;
		}
		
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
        	switch(column)
        	{
        	case 0:
        		return "Số thứ tự";
        	case 1:
        		return "Mã lớp học phần";
        	case 2:
    			return "Tên học phần";
        	case 3:
    			return "Thi phòng máy";
        	case 4:
    			return "Đăng ký loại phòng";
        	}
			return "";
		}
		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 5;
		}
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return list.length;
		}
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			if(list[rowIndex][columnIndex] == null || list[rowIndex][columnIndex].equals(""))
				return "";
			return list[rowIndex][columnIndex];
		}
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
        
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 3 || columnIndex == 4) {
                return Icon.class;
            }
            return Object.class;
        }
        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
        	// TODO Auto-generated method stub
        	list[rowIndex][columnIndex] = value;
            fireTableCellUpdated(rowIndex, columnIndex);
        }
	}


	public PanelXepLichThi_GV() {


		caiDatPanelXepLichThi_1();
		tableCuaTui.fixTable(jScrollPaneTable);
        setCustomScrollBar();
	}

	private void caiDatPanelXepLichThi_1() {

		
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 964, 701);
		this.setLayout(null);
        this.setOpaque(false);
		this.setVisible(true);
		panelXemLichThi = new JPanel();
		panelXemLichThi.setBorder(new LineBorder(new Color(0, 0, 0)));

		panelXemLichThi.setBackground(new Color(47, 79, 79));
		panelXemLichThi.setBounds(0, 0, 960, 51);
		panelXemLichThi.setLayout(null);
		
		lblXemLichThi = new JLabel("ĐĂNG KÍ THI PHÒNG MÁY");
		lblXemLichThi.setForeground(new Color(255, 255, 255));
		lblXemLichThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblXemLichThi.setFont(new Font("Arial", Font.BOLD, 18));
		lblXemLichThi.setBounds(47, 10, 858, 36);
		panelXemLichThi.add(lblXemLichThi);
		
		tableCuaTui = new TableCuaTui();
		tableCuaTui.setFont(new Font("Arial", Font.PLAIN, 14));
		model = new MyModel(LopHocPhanBLL.getInstance().getListHocPhanDangKy(ManHinhChinh_GV.taiKhoanGV));
		tableCuaTui.setModel(model);

		
		tableCuaTui.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent e) {
	    	if (e.getClickCount() == 1) {
		        int row = tableCuaTui.rowAtPoint(e.getPoint()); // lấy chỉ số dòng của ô được chọn
		        int col = tableCuaTui.columnAtPoint(e.getPoint()); // lấy chỉ số cột của ô được chọn
		        if (row >= 0 && col == 4) {
		        	@SuppressWarnings("unused")
					LocalDate now = LocalDate.now();
		        	if(LichThiBLL.getInstance().checkLichThiRong() == false) {
		        		JOptionPane.showMessageDialog(null, "Hết thời gian đăng ký");
		        		return;
		        	}
		            // xử lý sự kiện ở đây với giá trị của ô được chọn
		        	int option = JOptionPane.showOptionDialog(null,
		        			"Hãy chọn phòng thi của lớp "+tableCuaTui.getValueAt(row, 1) +":[" +tableCuaTui.getValueAt(row, 2)+"]",
		        			"Cài đặt phòng thi",
		        			JOptionPane.YES_NO_CANCEL_OPTION, 
		        			JOptionPane.QUESTION_MESSAGE, 
		        			null,
		        			new Object[]{"Phòng máy", "Phòng thường", "Cancel"},
		        			"Cancel");
		        	if(option == 1)
		        	{
		        		//setPhongThuong
		        		if(LopHocPhanBLL.getInstance().SetPhongThuong((String)tableCuaTui.getValueAt(row, 1)) == true)
		        		{
		        			JOptionPane.showMessageDialog(null, "Set phòng thường thành công");
		        			ImageIcon a = new ImageIcon(PanelXepLichThi_GV.class.getResource("/res/remove.png"));
		    				model.setValueAt(a, row, 3);
		    				tableCuaTui.setModel(model);
		        		}
		        	}
		        	else if(option == 0)
		        	{
		        		//setPhongMay
		        		if(LopHocPhanBLL.getInstance().SetPhongMay((String)tableCuaTui.getValueAt(row, 1)) == true)
		        		{
		        			JOptionPane.showMessageDialog(null, "Set phòng máy thành công");
		        			ImageIcon a = new ImageIcon(PanelXepLichThi_GV.class.getResource("/res/check.png"));
		    				model.setValueAt(a, row, 3);
		    				tableCuaTui.setModel(model);
		        		}
		        	}
		        }
	    	}
	    }
	});
		
		
		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 61, 940, 626);
		jScrollPaneTable.setViewportView(tableCuaTui);
		

		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
		jPanelBody.add(panelXemLichThi);
		jPanelBody.add(jScrollPaneTable);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 964, 701);
		jScrollPane_Body.setViewportView(jPanelBody);
		


//        
		this.add(jScrollPane_Body);
//		
		

	}
	

	private void setCustomScrollBar() {
    	jScrollPane_Body.setViewportBorder(null);
    	jScrollPane_Body.getViewport().setOpaque(false);
    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
    }
}

	

