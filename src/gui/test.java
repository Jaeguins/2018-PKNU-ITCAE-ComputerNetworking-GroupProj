package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test extends JFrame {

	
	public test(){
		super("Áö·ÚÃ£±â");
		init();
		first();
	}
	
	public void init() {
		setBounds(100,100,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	public void first() {
		setLayout(null);
		Container cont = getContentPane();
		JPanel jp= new InitialPanel(cont);
		cont.add(jp);
		
		
	}
	public static void main(String[] args) {
		test ts = new test();
	}
}

