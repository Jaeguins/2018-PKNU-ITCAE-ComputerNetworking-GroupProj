package gui;

import Main.Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GotoMainListener implements MouseListener {
        Container cont= Main.Instance.frame.getContentPane();
        @Override
        public void mouseClicked(MouseEvent e) {
            cont.removeAll();
            cont.add(new InitialPanel(cont));
            cont.revalidate();
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
}
