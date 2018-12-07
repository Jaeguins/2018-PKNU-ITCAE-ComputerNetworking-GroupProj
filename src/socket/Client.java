package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

import Main.Main;
import gui.GamePanel;

public class Client implements ClientInterface {
    Main inst = Main.Instance;
    Socket c_socket;
    GamePanel view;
    int index; // client num
    boolean ing = true;
    ClientThread th;

    public class  ClientThread extends Thread{
        int FirstConnect = 0;
        byte[] data = new byte[100];
        Scanner scanner;
        OutputStream out;
        @Override
        public void run() {
            super.run();
            System.out.println("enetered room :"+c_socket.getInetAddress());
            try{
                scanner = new Scanner(c_socket.getInputStream());
                int playerNum=scanner.nextInt(),width=scanner.nextInt(),height=scanner.nextInt(),mineNum=scanner.nextInt();
                inst.frame.add(new GamePanel(inst.frame.getContentPane(),width,height));
                view=(GamePanel)(inst.nowActivePane);
                view.playerNum=playerNum;
                while (ing){
                    int x=0,y=0;
                    String type=scanner.next();
                    switch(type){
                        case "start":
                            view.started=true;
                            System.out.println("game started");
                            break;
                        case "open":
                            x=scanner.nextInt();
                            y=scanner.nextInt();
                            view.buttons[x][y].Open(scanner.nextInt());
                            break;
                        case "ping":
                            x=scanner.nextInt();
                            y=scanner.nextInt();
                            view.buttons[x][y].Ping(scanner.nextBoolean());
                            break;
                        case "flag":
                            x=scanner.nextInt();
                            y=scanner.nextInt();
                            view.buttons[x][y].Flag(scanner.nextBoolean());
                            break;
                        case "win":
                            view.gameOver(true);
                            c_socket.close();
                            return;
                        case "lose":
                            view.gameOver(false);
                            c_socket.close();
                            return;
                    }
                    System.out.println("client : "+x+" "+y+" : "+type);
                }
            }
            catch (IOException e){
                try {
                    c_socket.close();
                }catch(IOException g){
                    g.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    public void EnterRoom(String ip)throws IOException{
        c_socket = new Socket(ip, 8888);
        th = new ClientThread();
        th.start();
    }

    public void PushMsg(String msg){
        try{
            th.out = c_socket.getOutputStream();
            th.out.write(msg.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void ByteToString(){
        String msg = new String(th.data);
        System.out.println("Server: " + msg);
    }

    public void CtoSmsg(String msg){
        PushMsg(msg);
    }

    public void CloseClient()throws IOException{
        c_socket.close();
    }
}