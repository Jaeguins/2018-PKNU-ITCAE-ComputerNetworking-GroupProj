package gui;

// 지뢰 패배화면

import Main.Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class LosePanel extends JPanel{
	Container cont;
	public LosePanel(Container cont) {
		super();
		this.cont=cont;
		Main.Instance.frame.setSize(300,200);
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		JLabel lose = new JLabel("패배");
		lose.setBounds(0,0,200,50);
		add(lose);
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