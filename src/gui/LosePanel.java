package gui;

// 지뢰 패배화면

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class LosePanel extends JPanel{
	
	public LosePanel(Container cont) {
		super();
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		JLabel lose = new JLabel("패배");
		add(lose);
	}
	
}