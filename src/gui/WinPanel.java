package gui;

import Main.Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

//Áö·Ú ½Â¸®È­¸é

public class WinPanel extends JPanel{
	Container cont;
	public WinPanel(Container cont) {
		super();
		this.cont=cont;
		setLayout(null);
		Main.Instance.frame.setSize(300,200);
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		JLabel victory = new JLabel("½Â¸®");
		victory.setBounds(0,0,200,50);
		add(victory);
		JButton btn=new JButton("go to main");
		btn.setBounds(0,50,100,50);
		btn.addMouseListener(new GotoMainListener());
		add(btn);
		new Thread(() -> {
			cont.revalidate();
			cont.repaint();
		}).start();
	}
	
}