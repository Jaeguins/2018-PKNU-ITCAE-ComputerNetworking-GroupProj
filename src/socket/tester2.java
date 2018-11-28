package socket;

import java.io.IOException;

public class tester2 {
    public static void main(String args[]){
        Client user = new Client();

        try{
            user.EnterMyself();
            user.PullMsg();
            user.ByteToString();
            System.out.println(user.rec);

            user.c_socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
