package socket;

import java.io.IOException;

public interface ClientInterface {
    void EnterMyself() throws IOException;
    void EnterRoom(String ip, int port)throws IOException;
    void GetValue(int x, int y, int LR)throws IOException;
     PushValue(String val);
    }