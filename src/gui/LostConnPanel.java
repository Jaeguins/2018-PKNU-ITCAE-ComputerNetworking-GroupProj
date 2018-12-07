package gui;

//연결실패 화면

import Main.Main;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;


public class LostConnPanel extends JPanel{
	
	public LostConnPanel(Container cont) {
		super();
		Main.Instance.frame.setSize(300,200);
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		JLabel disconnect = new JLabel("connection failed");
		disconnect.setBounds(0,0,150,50);
		JButton btn=new JButton("go to Main");
		btn.setBounds(0,50,150,50);
		btn.addMouseListener(new GotoMainListener());
		add(btn);
		add(disconnect);
		new Thread(() -> {
			cont.revalidate();
			cont.repaint();
		}).start();
	}
	
}