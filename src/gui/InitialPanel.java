package gui;
// �ʱ�ȭ��
import Main.Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InitialPanel extends JPanel{
	public InitialPanel(Container cont) {
		super();
		setBounds(0, 0, 300, 200);
		setBackground(new Color(150, 100, 80));
		setLayout(new FlowLayout());
		JButton join = new JButton("����");
		JButton create1 = new JButton("����");
		add(join);
		add(create1);
		join.addMouseListener(new JoinAction(cont));
		create1.addMouseListener(new Creator(cont));
		new Thread(() -> {
			cont.revalidate();
			cont.repaint();
		}).start();
	}

}

class JoinAction implements MouseListener {
	Container cont;

	public JoinAction(Container cont) {
		this.cont=cont;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		cont.removeAll();
		cont.add(new JoinPanel(cont));
		cont.revalidate();
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

class Creator implements MouseListener{

	Container cont;

	public Creator(Container cont) {
		this.cont =cont;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		cont.removeAll();
		cont.repaint();
		cont.add(new CreatePanel(cont));
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