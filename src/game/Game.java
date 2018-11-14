package game;

import socket.Server;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Game implements GameInterface {
    Server server;
    int width,height,mineNum;
    int[][] field;
    boolean[][] baled;
    boolean[][] checker;
    boolean[][] flags;
    class Node{
        public int x,y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    Queue<Node>openingQueue=new LinkedList<>();
    @Override
    public void pinging(int x, int y) {

    }
    @Override
    public void opening(int x, int y) {
        if(!flags[x][y]) {
            openingQueue.clear();
            openingQueue.add(new Node(x, y));
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    checker[i][j] = false;
                }
            }
            checker[x][y] = true;
            openInternal();
        }
    }

    @Override
    public void flaging(int x, int y) {
        if(!baled[x][y])
        flags[x][y]=!flags[x][y];
    }

    public int openInternal(){

        while(!openingQueue.isEmpty()){
            int tX,tY;
            Node t=openingQueue.poll();
            tX=t.x;
            tY=t.y;
            t=null;
            baled[tX][tY]=true;
            switch(field[tX][tY]){
                case 0:
                    if(tX-1>=0&&tX-1<width&&tY>=0&&tY<height&&!checker[tX-1][tY]){
                        openingQueue.add(new Node(tX-1,tY));
                        checker[tX-1][tY]=true;
                    }
                    if(tX+1>=0&&tX+1<width&&tY>=0&&tY<height&&!checker[tX+1][tY]){
                        openingQueue.add(new Node(tX+1,tY));
                        checker[tX+1][tY]=true;
                    }
                    if(tX>=0&&tX<width&&tY-1>=0&&tY-1<height&&!checker[tX][tY-1]){
                        openingQueue.add(new Node(tX,tY-1));
                        checker[tX][tY-1]=true;
                    }
                    if(tX>=0&&tX<width&&tY+1>=0&&tY+1<height&&!checker[tX][tY+1]){
                        openingQueue.add(new Node(tX,tY+1));
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
        this.width=width;
        this.height=height;
        this.mineNum=mineNum;
        initiatingInternal();
    }
    public void initiatingInternal(){
        Random random=new Random();
        field=new int[width][height];
        baled=new boolean[width][height];
        checker=new boolean[width][height];
        flags=new boolean[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                field[i][j]=0;
                baled[i][j]=false;
                flags[i][j]=false;
            }
        }
        for(int i=0;i<mineNum;i++){
            boolean unLocated=true;
            int tempX,tempY;
            while(unLocated){
                tempX=random.nextInt(width);
                tempY=random.nextInt(height);
                if(field[tempX][tempY]==0){
                    field[tempX][tempY]=-1;
                    unLocated=false;
                }
            }
        }
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if(field[i][j]==0){
                    int count=0;
                    for(int k=-1;k<2;k++){
                        for(int l=-1;l<2;l++){
                            if(i+k>=0&&j+l>=0&&i+k<width&&j+l<height&&field[i+k][j+l]==-1)count+=1;
                        }
                    }
                    field[i][j]=count;
                }
            }
        }
    }
    public void printAll(){
        System.out.print("    ");
        for(int i=0;i<width;i++){
            System.out.printf(" %2d ",i);
        }
        System.out.print("\n");
        for(int i=0;i<width;i++){
            System.out.printf("%2d :",i);
            for(int j=0;j<height;j++){
                if(flags[i][j]){
                    System.out.printf(" %2s ","P");
                }
                else if(baled[i][j]){
                    if(field[i][j]==0)System.out.printf("    ");
                    else System.out.printf(" %2d ",field[i][j]);
                }
                else {
                    System.out.print(" ** ");
                }
            }
            System.out.print("\n");
        }
    }
    @Override
    public int getStatus(int x, int y) {
        return field[x][y];
    }

}
