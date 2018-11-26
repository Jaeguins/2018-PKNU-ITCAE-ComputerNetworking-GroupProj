package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
    {
        try{
            Socket mc_socket = new Socket("127.0.0.1", 8888);

            InputStream input_data = mc_socket.getInputStream();

            byte[] rec_str = new byte[100];
            input_data.read(rec_str);

            System.out.println(new String(rec_str));

            mc_socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}