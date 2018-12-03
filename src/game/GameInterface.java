package game;

public interface GameInterface {
    void initiating(int width,int height,int mineNum,int totalPlayer);
    void leftClick(int x,int y,int playerNum);
    void rightClick(int x,int y,int playerNum);
    String getStatus(int x,int y);
    void printAll();
}