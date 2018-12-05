package socket;

import java.io.IOException;
import java.util.Scanner;

public class tester {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Server host = new Server();
        Client user = new Client();
        String msg;

        try{
                host.OpenServer();
                user.EnterRoom("127.0.0.1");
                while(true){
                    msg = sc.nextLine();
                    host.BroadCast(msg);
                    msg = sc.nextLine();
                    user.CtoSmsg(msg);
                }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}