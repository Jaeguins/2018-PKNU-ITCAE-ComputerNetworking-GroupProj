package socket;

import java.io.IOException;
import java.util.Scanner;

public class tester {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Server host = new Server();
        Client user = new Client();
        String msg;
        int num;

        try{
            host.OpenServer();
            user.EnterMyself();
            while(true){
                System.out.println("S->C input: ");
                msg = sc.nextLine();
                num = sc2.nextInt();
                host.StoCmsg(num, msg);

                System.out.println("C->S input: ");
                msg = sc.nextLine();
                user.CtoSmsg(msg);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}