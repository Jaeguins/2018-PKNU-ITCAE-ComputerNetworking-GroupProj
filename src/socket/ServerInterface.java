package socket;

import java.io.IOException;

public interface ServerInterface {
    void OpenServer() throws IOException;
    void ServerAccept();
    void broadCast(String msg);
}
