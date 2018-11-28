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
    static char diff='/';
    private int nowTurn=0;
    private int totalPlayer;
    private Queue<Node>openingQueue=new LinkedList<>();
    private void pinging(int x, int y,boolean status) {
        server.broadCast("ping"+diff+x+diff+y+diff+status+diff);
    }
    private void opening(int x, int y) {
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
    private void flaging(int x, int y) {
        if(field[x][y].isBaled()) {
            field[x][y].setFlagged(!field[x][y].isFlagged());
            server.broadCast("flag" + diff + x + diff + y + diff+field[x][y].isFlagged()+diff);
        }
    }
    private int openInternal(){
        while(!openingQueue.isEmpty()){
            Node t=openingQueue.poll();
            t.setBaled(false);
            server.broadCast("open"+diff+t.getX()+diff+t.getY()+diff);
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
    private void nextTurn(){
        nowTurn=(nowTurn+1)%totalPlayer;
    }

    public void gameOver(){

    }
    @Override
    public void initiating(int width,int height,int mineNum,int totalPlayer) {
        this.totalPlayer=totalPlayer;
        this.mineNum=mineNum;
        Node.width=width;
        Node.height=height;
    }

    @Override
    public void leftClick(int x, int y, int playerNum) {
        if(playerNum==nowTurn){
            opening(x,y);
            nextTurn();
        }else{
            pinging(x,y,true);
        }
    }

    @Override
    public void rightClick(int x, int y, int playerNum) {
        if(playerNum==nowTurn){
            flaging(x,y);
        }else{
            pinging(x,y,false);
        }
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
        System.out.print("早  ");
        for(int i=0;i<Node.width;i++)
            System.out.printf("早%2d",i);
        System.out.print('\n');
        for(int i=0;i<Node.width+1;i++)
            System.out.print("池式");
        System.out.print('\n');
        for(int i=0;i<Node.width;i++){
            System.out.printf("早%2d",i);
            for(int j=0;j<Node.height;j++)
                System.out.printf("早%s",field[i][j].getStatus());
            System.out.print("\n");
            for(int j=0;j<Node.height+1;j++)
                System.out.print("池式");
            System.out.print("\n");
        }
    }
    @Override
    public String getStatus(int x, int y) {
        return field[x][y].getStatus();
    }

}
