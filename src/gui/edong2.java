package tttttt;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//초기 > 생성
public class edong2 implements MouseListener{

	Container cont;
	
	public edong2(Container cont) {
		this.cont =cont;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		cont.removeAll();
		cont.repaint();
		cont.add(new jp6(cont));
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
