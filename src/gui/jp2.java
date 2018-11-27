package tttttt;
//참가 화면
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jp2 extends JPanel{
	
	public jp2(Container cont) {
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
		join.addMouseListener(new edong3(cont));
	}

}
