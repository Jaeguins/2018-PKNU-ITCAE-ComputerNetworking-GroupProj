package gui;
//참가 화면
import Main.Main;
import socket.Client;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinPanel extends JPanel{
	Container cont;
	JButton join,back;
	JLabel ipLabel;
	JTextField ip;
	public JoinPanel(Container conte) {
		super();
		cont=conte;
		cont.setSize(300,200);
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		setLayout(null);
		join = new JButton("참가");
		back = new JButton("메인");
		ipLabel = new JLabel("IP");
		ip = new JTextField();
		ipLabel.setBounds(10, 10, 50, 20);
		ip.setBounds(90, 10, 200, 20);
		join.setBounds(10, 100, 150, 50);
		back.setBounds(10,150,150,50);
		add(ipLabel);
		add(ip);
		add(join);
		add(back);
		join.addMouseListener(new GameJoin());
		back.addMouseListener(new GotoMainListener());
		new Thread(() -> {
			cont.revalidate();
			cont.repaint();
		}).start();
	}
	class GameJoin implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			cont.removeAll();
			cont.repaint();
			Main inst=Main.Instance;
			inst.client=new Client();
			try {
				inst.client.EnterRoom(ip.getText());
			}catch(IOException ex){
				ex.printStackTrace();
				cont.add(new LostConnPanel(cont));
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
