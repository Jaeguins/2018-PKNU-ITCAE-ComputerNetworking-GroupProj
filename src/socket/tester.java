package socket;

import java.io.IOException;

public class tester {
    public static void main(String args[]){
        Server user = new Server();

        try{
            user.OpenServer();

            user.s_socket.close();;
            user.c_socket.close();;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
