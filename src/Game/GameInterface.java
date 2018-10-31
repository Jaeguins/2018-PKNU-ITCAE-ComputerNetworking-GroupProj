package Game;

public interface GameInterface {
    void Pinging(int x,int y);
    void Opening(int x,int y);
    void Initiating();
    int getStatus(int x,int y);
}