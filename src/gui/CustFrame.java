package gui;
import Main.Main;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustFrame extends JFrame {
	
	public CustFrame(){
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
		CustFrame ts = new CustFrame();
	}
}

