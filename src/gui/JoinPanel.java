package gui;
//참가 화면
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinPanel extends JPanel{
	
	public JoinPanel(Container cont) {
		super();
		setBounds(0, 0, 300, 200);
		setBackground(new Color(128, 100, 190));
		setLayout(null);
		JButton join = new JButton("참가");
		JLabel iplabel = new JLabel("IP");
		JLabel portlabel = new JLabel("port");
		JTextField ip = new JTextField();
		JTextField port = new JTextField();
		iplabel.setBounds(10, 10, 50, 20);
		portlabel.setBounds(10, 50, 50, 20);
		ip.setBounds(90, 10, 200, 20);
		port.setBounds(90, 50, 100, 20);
		join.setBounds(10, 100, 50, 50);
		add(iplabel);
		add(portlabel);
		add(ip);
		add(port);
		add(join);
		join.addMouseListener(new GameJoin(cont));
	}

}
class GameJoin implements MouseListener {

	Container cont;

	public GameJoin(Container cont) {
		this.cont = cont;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
