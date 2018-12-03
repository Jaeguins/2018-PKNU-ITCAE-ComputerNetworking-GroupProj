package gui;

//연결실패 화면

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class LostConnPanel extends JPanel{
	
	public LostConnPanel(Container cont) {
		super();
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		JLabel disconnect = new JLabel("connection failed");
		
	}
	
}