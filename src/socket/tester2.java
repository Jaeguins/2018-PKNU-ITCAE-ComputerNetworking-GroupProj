package socket;

import java.io.IOException;

public class tester2 {
    public static void main(String args[]){
        Client user = new Client();

        try{
            user.EnterMyself();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}