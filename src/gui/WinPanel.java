package gui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;

//Áö·Ú ½Â¸®È­¸é

public class WinPanel extends JPanel{
	
	public WinPanel(Container cont) {
		super();
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		JLabel victory = new JLabel("½Â¸®");
		
	}
	
}