package GUI.viewItem;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import GUI.view.Admin.PanelXepLichThi_XemLichThi;


@SuppressWarnings("serial")
public class BangXemLichThi extends JPanel {

	private MenuName menuName;
	public TableCuaTui tableCuaTui;
	public DefaultTableModel model;
	String[][] data;

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
        		return "Tiết";
        	case 1:
        		return "Thứ 2";
        	case 2:
    			return "Thứ 3";
        	case 3:
    			return "Thứ 4";
        	case 4:
    			return "Thứ 5";
        	case 5:
    			return "Thứ 6";
        	case 6:
    			return "Thứ 7";
        	}
			return "";
        }
        
        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public int getRowCount() {
            return 10;
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
	
	public BangXemLichThi(String name, String[][] data) {
		//this();
		//setOpaque(false);
		this.data = data;
		caiDatBangXemLichThi();
		setOpaque(false);
		menuName.setText(name);
		//caiDatBangXemLichThi();

	}

	public BangXemLichThi() {
		caiDatBangXemLichThi();
		setOpaque(false);
	}

	private void caiDatBangXemLichThi() {
		this.setBorder(new LineBorder(new Color(130, 135, 144)));
		this.setBounds(0, 0, 732, 397);

		menuName = new MenuName("                          ");
		menuName.setBounds(10, 10, 713, 30);

		tableCuaTui = new TableCuaTui();
//		tableCuaTui.setBounds(10, 50, 713, 336);
//		tableCuaTui.setFont(new Font("Arial", Font.PLAIN, 14));
//		
//		tableCuaTui.getTableHeader().setReorderingAllowed(false);
//		model = new DefaultTableModel();
//		model.addColumn("Tiết");
//		model.addColumn("Thứ 2");
//		model.addColumn("Thứ 3");
//		model.addColumn("Thứ 4");
//		model.addColumn("Thứ 5");
//		model.addColumn("Thứ 6");
//		model.addColumn("Thứ 7");
//		for(int i = 0 ; i < 10 ; i++)
//		{
//			
//			Vector<Object> vec = new Vector<>();
//			vec.add(i+1);
//			model.addRow(vec);
//		}

		tableCuaTui.setModel(new MyModel(data));
//		tableCuaTui.setEnabled(false);
		//tableCuaTui.putClientProperty("terminateEditOnFocusLost", true);
		setLayout(null);

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setWheelScrollingEnabled(false);
		jScrollPane.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				PanelXepLichThi_XemLichThi.jScrollPaneTable.dispatchEvent(e);
			}
		});
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		jScrollPane.setBounds(10, 50, 713, 336);
		jScrollPane.setViewportView(tableCuaTui);

		this.add(menuName);
		this.add(jScrollPane);

	}



}
