package tttttt;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class test extends JFrame {

	
	
	public test(String x){
		super("����� ��");
		init();
		first();
	}
	
	public void init() {
		setBounds(100,100,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	public void first() {
		Container cont = getContentPane();
		JLabel jl = new JLabel("���� ������Դϴ�.");
		cont.
		
		cont.add(jl);
	}
	public static void main(String[] args) {
		
	}
}
