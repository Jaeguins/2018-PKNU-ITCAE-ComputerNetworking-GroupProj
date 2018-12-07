package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import Main.Main;
import game.Game;

public class Server implements ServerInterface{
    Main inst = Main.Instance;
    public Game game;
    ServerSocket s_socket;
    Socket[] c_socket = new Socket[2];
    ServerThread[] th = new ServerThread[2];
    static String diff=" ";
    int n_socket = 0;
    boolean ing = true;

    public class ServerThread extends Thread{
        public ServerThread(int index){
            this.index=index;
        }
        int index;
        byte[] data = new byte[100];
        Scanner in;
        OutputStream out;
        @Override
        public void run() {
            try {
                super.run();
                PushMsg(index, index + diff + game.width + diff + game.height + diff + game.mineNum + diff);
                if (index == 1) {
                    BroadCast("start ");
                    s_socket.close();
                }
                while (ing) {
                    String type = in.next();
                    int x = 0, y = 0, playerNum = 0;
                    switch (type) {
                        case "L":
                            x = in.nextInt();
                            y = in.nextInt();
                            playerNum = in.nextInt();
                            game.leftClick(x, y, playerNum);
                            break;
                        case "R":
                            x = in.nextInt();
                            y = in.nextInt();
                            playerNum = in.nextInt();
                            game.rightClick(x, y, playerNum);
                            break;
                    }
                    System.out.println("server : " + playerNum + diff + type + diff + x + diff + y + diff);
                }
            }catch(Exception e){
                System.out.println("connection lost");
                try {
                    c_socket[index].close();
                }catch(IOException g){
                    g.printStackTrace();
                }finally{
                    BroadCast("lost ");
                }
            }
        }
    }

    public void OpenServer()throws IOException{
        s_socket = new ServerSocket(8888);
    }
    public void StartGame(int width,int height,int mineNum){
        game=new Game(this);
        game.initiating(width,height,mineNum,2);
        Thread t= new Thread(() -> {
            for (int i = 0; i < 2; i++) Connect(i);
        });
        t.start();
    }
    public void Connect(int i){
        try{
            System.out.println("user standby...");
            c_socket[i] = s_socket.accept();
            System.out.println("user " + (i) + " connected!...");
            th[i] = new ServerThread(i);
            th[i].in=new Scanner(c_socket[i].getInputStream());
            th[i].out=c_socket[i].getOutputStream();
            th[i].start();
            n_socket++;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PushMsg(int index, String msg){
        try{
            if(c_socket[index].isClosed())return;
            th[index].out.write(msg.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void ByteToString(int index){
        String msg = new String(th[index].data);
        System.out.println("Client " + index + ": " + msg);
    }

    public void StoCmsg(int UserNum, String msg){
        PushMsg(UserNum, msg);
    }

    public void BroadCast(String msg){
        for(int i = 0; i < n_socket; i++)

            PushMsg(i, msg);
    }

    public void CloseServer()throws IOException{
        s_socket.close();
    }
}