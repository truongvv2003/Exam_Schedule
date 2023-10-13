package GUI.view.Admin;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class PanelHome extends JPanel {

	public PanelHome() {
		this.setBounds(0, 0, 964, 701);
		this.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		this.setVisible(true);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 0, 964, 701);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 964, 701);
		label.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon a = new ImageIcon(PanelHome.class.getResource("/res/anhTruong.png"));
		Image b = a.getImage().getScaledInstance(964, 701, java.awt.Image.SCALE_SMOOTH);
		panel.setLayout(null);
		label.setIcon(new ImageIcon(b));
		panel.add(label);
		this.add(panel);
	}

	

}