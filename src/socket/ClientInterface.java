package socket;

import java.io.IOException;

public interface ClientInterface {
    void EnterMyself() throws IOException;
    void EnterRoom(String ip, int port)throws IOException;
    void CloseClient()throws IOException;
    void CtoSmsg(String msg);
}