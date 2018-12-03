package socket;

import java.io.IOException;
import java.util.Scanner;

public class tester2 {
    public static void main(String args[]){
        Client user = new Client();

        try{
            user.EnterRoom("127.0.0.1");
            user.PullMsg();
            user.CtoSmsg("server hi");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}