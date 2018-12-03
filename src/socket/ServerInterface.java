package socket;

import java.io.IOException;

public interface ServerInterface {
    void OpenServer() throws IOException;
    void CloseServer()throws IOException;
    void BroadCast(String msg);
    void StoCmsg(int UserNum, String msg);
}