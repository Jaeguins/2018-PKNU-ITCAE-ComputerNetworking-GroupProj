package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustButton extends JButton {
    GamePanel context;
    static int cellWidth=30,cellHeight=30;
    static Font font=new Font("consolas",Font.PLAIN,20);
    static Color defaultBack=Color.GRAY;
    int i,j;
    public CustButton(GamePanel context,int i,int j){
        this.context=context;
        this.i=i;
        this.j=j;
        setBounds(cellWidth*i,cellHeight*j,cellWidth,cellHeight);
        setText("");
        setFont(font);
        setMargin(new Insets(1,1,1,1));
        setBackground(defaultBack);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(context.started&&CustButton.this.isEnabled()) {
                    switch(e.getButton()){
                        case MouseEvent.BUTTON1:
                            context.inst.client.PushMsg("L " + i + " " + j + " " + context.playerNum + " ");
                            break;
                        case MouseEvent.BUTTON3:
                            context.inst.client.PushMsg("R " + i + " " + j + " " + context.playerNum + " ");
                            break;
                    }
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
    }
    public void Open(int number) {
        if(number==-1)
            setText("*");
        else if(number!=0)
            setText("" + number);
        this.setBackground(Color.LIGHT_GRAY);
        this.setEnabled(false);
    }
    public void Ping(boolean value){
        new Thread(() -> {
            if(value)
            setBackground(Color.RED);
            else setBackground(Color.GREEN);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBackground(defaultBack);
        }).start();
    }
    public void Flag(boolean value){
        if(value)
            setText("P");
        else
            setText("");
    }
}