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
	JButton join;
	JLabel ipLabel,portLabel;
	JTextField ip,port;
	public JoinPanel(Container conte) {
		super();
		cont=conte;
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		setLayout(null);
		join = new JButton("참가");
		ipLabel = new JLabel("IP");
		portLabel = new JLabel("port");
		ip = new JTextField();
		port = new JTextField();
		ipLabel.setBounds(10, 10, 50, 20);
		portLabel.setBounds(10, 50, 50, 20);
		ip.setBounds(90, 10, 200, 20);
		port.setBounds(90, 50, 100, 20);
		join.setBounds(10, 100, 50, 50);
		add(ipLabel);
		add(portLabel);
		add(ip);
		add(port);
		add(join);
		join.addMouseListener(new GameJoin());
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
				inst.client.EnterRoom(ip.getText(), Integer.parseInt(port.getText()));
				cont.add(new GamePanel(cont));
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
