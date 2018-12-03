package gui;

//瘤汾 规 积己 拳搁

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePanel extends JPanel{
	Container cont;
	public CreatePanel(Container conte) {
		super();
		this.cont=conte;
		setBounds(0, 0, 300, 200);
		setBackground(new Color(150, 100, 80));
		setLayout(null);
		JLabel widthlabel = new JLabel("width");
		JLabel heightlabel = new JLabel("height");
		JLabel bomblabel = new JLabel("bomb");
		JTextField width = new JTextField();
		JTextField height = new JTextField();
		JTextField bomb = new JTextField();
		JButton create = new JButton("积己");
		width.setBounds(90, 10, 50, 20);
		height.setBounds(90, 50, 50, 20);
		bomb.setBounds(90, 100, 50, 20);
		widthlabel.setBounds(10, 10, 50, 20);
		heightlabel.setBounds(10, 50, 50, 20);
		bomblabel.setBounds(10, 100, 50, 20);
		create.setBounds(10,150,50,20);
		add(width);
		add(height);
		add(bomb);
		add(widthlabel);
		add(heightlabel);
		add(bomblabel);
		add(create);
		create.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cont.removeAll();
				cont.repaint();
				cont.add(new GamePanel(cont));
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
	}

}
