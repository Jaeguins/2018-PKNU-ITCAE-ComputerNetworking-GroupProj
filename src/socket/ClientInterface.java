package socket;

import java.io.IOException;

public interface ClientInterface {
    void EnterRoom(String ip)throws IOException;
    void CloseClient()throws IOException;
    void CtoSmsg(String msg);
}