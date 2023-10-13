package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;
import DTO.GiangVien;
import BLL.GiangVienBLL;

@SuppressWarnings("serial")
public class PanelThongTin_GiangVien extends JPanel {

	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public TableCuaTui tableCuaTui;
	public JPanel panelDau;
	public DefaultTableModel model;
	String[][] data = new String[5][1];

	private class MyModel extends AbstractTableModel {
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
        		return "Mã giảng viên";
        	case 2:
    			return "Tên giảng viên";
        	case 3:
        		return "Ngày sinh";
        	case 4:
        		return "Quê quán";
        	case 5:
        		return "Chức danh KH";
        	}
			return "";
        }
        
        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public int getRowCount() {
            return list.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
        	if(columnIndex == 0)
        	{
        		return Integer.toString(rowIndex+1);
        	}
        	if(list[rowIndex][columnIndex] == null)
        		return "";
        	return list[rowIndex][columnIndex];
        	//return "helo";
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    }
	
	public PanelThongTin_GiangVien() {


		caiDatPanelThongTin();
		
		tableCuaTui.fixTable(jScrollPaneTable);
        setCustomScrollBar();

		
	}

	private void caiDatPanelThongTin() {

		
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 940, 579);
		
		this.setLayout(null);
        this.setOpaque(false);
        
        JLabel lblTieuDe = new JLabel("GIẢNG VIÊN");
        lblTieuDe.setForeground(new Color(255, 255, 255));
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblTieuDe.setBounds(237, 10, 478, 31);
  
        
        JPanel panelTieuDe = new JPanel();
        panelTieuDe.setLayout(null);
        panelTieuDe.setBackground(new Color(47, 79, 79));
        panelTieuDe.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelTieuDe.setBounds(0, 0, 939, 51);
        panelTieuDe.add(lblTieuDe);
		
		tableCuaTui = new TableCuaTui();
		tableCuaTui.setFont(new Font("Arial", Font.PLAIN, 14));
		tableCuaTui.getTableHeader().setReorderingAllowed(false);
		//de vao BLL
		ArrayList<GiangVien> dataGiangVien = GiangVienBLL.getInstance().getListGiangVien();
		data= new String[dataGiangVien.size()][6];
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		for(int i = 0 ; i < dataGiangVien.size(); i++)
		{
			data[i][0] = Integer.toString(i+1);
			data[i][1] = Integer.toString(dataGiangVien.get(i).getIDGiangVien());
			data[i][2] = dataGiangVien.get(i).getHoTen();
			String date = dateFormat.format(dataGiangVien.get(i).getNgaySinh());
			if(date.equals("01/01/2001"))
				data[i][3] = "Không rõ";
			else data[i][3] = dateFormat.format(dataGiangVien.get(i).getNgaySinh());
			data[i][4] = dataGiangVien.get(i).getQueQuan();
			data[i][5] = dataGiangVien.get(i).getChucDanhKH();
		}
		MyModel model = new MyModel(data);
		
		tableCuaTui.setModel(model);
		
		
		
		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 61, 916, 504);
		jScrollPaneTable.setViewportView(tableCuaTui);
		

		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(true); // để không che khuất thằng phía sau
		jPanelBody.add(panelTieuDe);
		jPanelBody.add(jScrollPaneTable);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 940, 579);
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

