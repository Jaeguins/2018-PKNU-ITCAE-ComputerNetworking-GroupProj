package game;

class Node{
    static int width,height;

    private int x,y,value;
    private boolean baled,flagged;
    Node(int x,int y){
        this.x=x;
        this.y=y;
        value=0;
        baled=true;
        flagged=false;
    }
    static boolean isInField(int x,int y){
        if(x>=0&&x<width&&y>=0&&y<height)return true;
        return false;
    }
    int getValue(){return value;}
    void setValue(int value){this.value=value;}
    int getX(){return x;}
    int getY(){return y;}
    boolean isBaled(){return baled;}
    void setBaled(boolean value){baled=value;}
    boolean isFlagged(){return flagged;}
    void setFlagged(boolean value){flagged=value;}
    String getStatus(){
        if(flagged) return "P";
        if(baled) return "**";
        if(value==0) return "  ";
        return String.format("%2d",value);
    }
}