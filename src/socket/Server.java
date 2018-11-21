package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args)
    {
        try{
            ServerSocket ms_socket = new ServerSocket(8888);
            Socket mc_socket = ms_socket.accept();

            OutputStream output_data = mc_socket.getOutputStream();

            String sendstr = "Welcome to Mine";
            output_data.write(sendstr.getBytes());

            ms_socket.close();
            mc_socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
