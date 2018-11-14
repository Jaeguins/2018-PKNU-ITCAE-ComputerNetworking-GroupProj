package game;

public interface GameInterface {
    void pinging(int x,int y);
    void opening(int x,int y);
    void flaging(int x,int y);
    void initiating(int width,int height,int mineNum);
    int getStatus(int x,int y);
}