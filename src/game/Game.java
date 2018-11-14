package game;

import socket.Server;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Game implements GameInterface {
    Server server;
    private boolean initialized=true;
    private int mineNum;
    private Node[][] field;
    private boolean[][] checker;

    private Queue<Node>openingQueue=new LinkedList<>();
    @Override
    public void pinging(int x, int y) {

    }
    @Override
    public void opening(int x, int y) {
        if(initialized){
            initiatingInternal(x,y);
            initialized=false;
        }
        if(!field[x][y].isFlagged()) {
            openingQueue.clear();
            openingQueue.add(field[x][y]);
            for (int i = 0; i < Node.width; i++) {
                for (int j = 0; j < Node.height; j++) {
                    checker[i][j] = false;
                }
            }
            checker[x][y] = true;
            openInternal();
        }
    }

    @Override
    public void flaging(int x, int y) {
        if(field[x][y].isBaled())
        field[x][y].setFlagged(!field[x][y].isFlagged());
    }
    private int openInternal(){
        while(!openingQueue.isEmpty()){
            Node t=openingQueue.poll();
            t.setBaled(false);
            int tX=t.getX(),tY=t.getY();
            switch(t.getValue()){
                case 0:
                    if(Node.isInField(tX-1,tY)&&!checker[tX-1][tY]){
                        openingQueue.add(field[tX-1][tY]);
                        checker[tX-1][tY]=true;
                    }
                    if(Node.isInField(tX+1,tY)&&!checker[tX+1][tY]){
                        openingQueue.add(field[tX+1][tY]);
                        checker[tX+1][tY]=true;
                    }
                    if(Node.isInField(tX,tY-1)&&!checker[tX][tY-1]){
                        openingQueue.add(field[tX][tY-1]);
                        checker[tX][tY-1]=true;
                    }
                    if(Node.isInField(tX,tY+1)&&!checker[tX][tY+1]){
                        openingQueue.add(field[tX][tY+1]);
                        checker[tX][tY+1]=true;
                    }
                    break;
                case -1:
                    return -1;
            }
        }
        return 0;
    }
    public void gameOver(){

    }
    @Override
    public void initiating(int width,int height,int mineNum) {
        this.mineNum=mineNum;
        Node.width=width;
        Node.height=height;
    }
    private void initiatingInternal(int x,int y){
        Random random=new Random();
        field=new Node[Node.width][Node.height];
        checker=new boolean[Node.width][Node.height];

        for(int i=0;i<Node.width;i++)
            for(int j=0;j<Node.height;j++)
                field[i][j]=new Node(i,j);
        for(int i=0;i<mineNum;i++){
            boolean unLocated=true;
            int tempX,tempY;
            while(unLocated){
                tempX=random.nextInt(Node.width);
                tempY=random.nextInt(Node.height);
                if(tempX!=x&&tempY!=y&&field[tempX][tempY].getValue()==0){
                    field[tempX][tempY].setValue(-1);
                    unLocated=false;
                }
            }
        }
        for(int i=0;i<Node.width;i++)
            for(int j=0;j<Node.height;j++)
                if(field[i][j].getValue()==0){
                    int count=0;
                    for(int k=-1;k<2;k++)
                        for(int l=-1;l<2;l++)
                            if(Node.isInField(i+k,j+l)&&field[i+k][j+l].getValue()==-1)count+=1;
                    field[i][j].setValue(count);
                }
    }
    @Override
    public void printAll(){
        System.out.print("��  ");
        for(int i=0;i<Node.width;i++)
            System.out.printf("��%2d",i);
        System.out.print('\n');
        for(int i=0;i<Node.width+1;i++)
            System.out.print("����");
        System.out.print('\n');
        for(int i=0;i<Node.width;i++){
            System.out.printf("��%2d",i);
            for(int j=0;j<Node.height;j++)
                System.out.printf("��%s",field[i][j].getStatus());
            System.out.print("\n");
            for(int j=0;j<Node.height+1;j++)
                System.out.print("����");
            System.out.print("\n");
        }
    }
    @Override
    public String getStatus(int x, int y) {
        return field[x][y].getStatus();
    }

}
