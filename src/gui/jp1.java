package gui;
// 초기화면
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class jp1 extends JPanel{
	
	public jp1(Container cont) {
		super();
		setBounds(0, 0, 300, 200);
		setBackground(new Color(150, 100, 80));
		setLayout(new FlowLayout());
		JButton join1 = new JButton("참가");
		JButton create1 = new JButton("생성");
		add(join1);
		add(create1);
		join1.addMouseListener(new edong1(cont));
		create1.addMouseListener(new edong2(cont));
	}

}
