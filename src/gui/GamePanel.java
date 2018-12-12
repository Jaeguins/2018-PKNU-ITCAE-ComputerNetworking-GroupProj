package gui;

import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Áö·ÚÈ­¸é??
public class GamePanel extends JPanel {
    Container cont;
    Main inst;
    JPanel fieldPanel;
    JLabel turnInd;
    public CustButton[][] buttons;
    public boolean started;
    public int playerNum;
    public GamePanel(Container cont,int width,int height){
        System.out.println("game panel opened");
        setBackground(Color.BLUE);
        this.cont=cont;
        inst=Main.Instance;
        inst.nowActivePane=this;
        fieldPanel=new JPanel();
        fieldPanel.setLayout(null);
        fieldPanel.setBounds(50,50,CustButton.cellWidth*width,CustButton.cellHeight*height);
        buttons=new CustButton[width][height];
        turnInd=new JLabel();
        turnInd.setBounds(50,10,100,30);
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                buttons[i][j]=new CustButton(this,i,j);
                fieldPanel.add(buttons[i][j]);
            }
        }
        cont.add(turnInd);
        cont.add(fieldPanel);
        cont.repaint();
        inst.frame.setSize(100+CustButton.cellWidth*width,150+CustButton.cellHeight*height);
    }
    public void gameOver(boolean flag){
        cont.removeAll();
        cont.repaint();
        if(flag){
            cont.add(new WinPanel(cont));
        }else{
            cont.add(new LosePanel(cont));
        }
    }
    public void nextTurn(int val){
        if(val==playerNum){
            turnInd.setText("Your Turn");
            turnInd.setForeground(Color.GREEN);
        }else{
            turnInd.setText("Company's Turn");
            turnInd.setForeground(Color.RED);
        }
    }
    public void lost(){
        cont.removeAll();
        cont.repaint();
        cont.add(new LostConnPanel(cont));
    }
}

