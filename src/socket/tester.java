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
            user.EnterMyself();
            while(true){
                System.out.println("서버 입력: ");
                msg = sc.nextLine();
                host.BroadCast(msg);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}