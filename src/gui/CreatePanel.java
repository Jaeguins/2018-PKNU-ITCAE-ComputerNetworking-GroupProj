package gui;

//지뢰 방 생성 화면

import Main.Main;
import socket.Client;
import socket.Server;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePanel extends JPanel{
	Container cont;
	JLabel widthLabel, heightLabel, bombLabel;
	JTextField widthInput, heightInput, bombInput;
	JButton create,back;
	public CreatePanel(Container conte) {
		super();
		this.cont=conte;
		Main.Instance.frame.setSize(300,300);
		setBounds(0, 0, 300, 250);
		setBackground(new Color(150, 100, 80));
		setLayout(null);
		widthLabel = new JLabel("Width");
		 heightLabel = new JLabel("Height");
		 bombLabel = new JLabel("Mines");
		 widthInput = new JTextField();
		 heightInput = new JTextField();
		 bombInput = new JTextField();
		 create = new JButton("생성");
		 back=new JButton("메인");
		widthInput.setBounds(90, 10, 50, 20);
		heightInput.setBounds(90, 50, 50, 20);
		bombInput.setBounds(90, 100, 50, 20);
		widthLabel.setBounds(10, 10, 50, 20);
		heightLabel.setBounds(10, 50, 50, 20);
		bombLabel.setBounds(10, 100, 50, 20);
		create.setBounds(10,150,150,20);
		back.setBounds(10,200,180,20);
		add(widthInput);
		add(heightInput);
		add(bombInput);
		add(widthLabel);
		add(heightLabel);
		add(bombLabel);
		add(create);
		add(back);
		create.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cont.removeAll();
				cont.repaint();

				Main inst=Main.Instance;
				inst.server=new Server();
				inst.client=new Client();

				int width=Integer.parseInt(widthInput.getText());
				int height=Integer.parseInt(heightInput.getText());
				int bomb=Integer.parseInt(bombInput.getText());
				try {
					inst.server.OpenServer();
					inst.server.StartGame(width,height,bomb);
					inst.client.EnterRoom("127.0.0.1");
					//cont.add(new GamePanel(cont,width,height));
				}catch(IOException ex){
					ex.printStackTrace();
					cont.add(new LostConnPanel(cont));
				}
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
		back.addMouseListener(new GotoMainListener());
		new Thread(() -> {
			cont.revalidate();
			cont.repaint();
		}).start();
	}

}
