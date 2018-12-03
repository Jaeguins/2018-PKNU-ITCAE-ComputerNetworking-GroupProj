package socket;

import java.io.IOException;
import java.util.Scanner;

public class tester2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Client user = new Client();
        String msg;

        try{
            user.EnterMyself();
            /*while(true){
                msg = sc.nextLine();
                user.CtoSmsg(msg);
            }*/
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}