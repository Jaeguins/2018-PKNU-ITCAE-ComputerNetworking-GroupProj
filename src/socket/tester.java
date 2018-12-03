package socket;

import java.io.IOException;
import java.util.Scanner;

public class tester {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Server host = new Server();
        String msg;

        try{
                host.OpenServer();
                msg = sc.nextLine();
                host.StoCmsg(0,"client hi");
                host.PullMsg();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}