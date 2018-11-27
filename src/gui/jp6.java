package tttttt;

//瘤汾 规 积己 拳搁

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jp6 extends JPanel{
	
	public jp6(Container cont) {
		super();
		setBounds(0, 0, 300, 200);
		setBackground(new Color(150, 100, 80));
		setLayout(null);
		JLabel widthlabel = new JLabel("width");
		JLabel heightlabel = new JLabel("height");
		JLabel bomblabel = new JLabel("bomb");
		JTextField width = new JTextField();
		JTextField height = new JTextField();
		JTextField bomb = new JTextField();
		JButton create = new JButton("积己");
		width.setBounds(90, 10, 50, 20);
		height.setBounds(90, 50, 50, 20);
		bomb.setBounds(90, 100, 50, 20);
		widthlabel.setBounds(10, 10, 50, 20);
		heightlabel.setBounds(10, 50, 50, 20);
		bomblabel.setBounds(10, 100, 50, 20);
	
		add(width);
		add(height);
		add(bomb);
		add(widthlabel);
		add(heightlabel);
		add(bomblabel);
		
	}

}
