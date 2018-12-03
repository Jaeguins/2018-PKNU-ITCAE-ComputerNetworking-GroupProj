package game;

import java.util.Scanner;

public class Tester {
    public static void main(String args[]){
        Game g=new Game();
        g.initiating(20,20,20,1);
        Scanner scanner=new Scanner(System.in);
        int x,y;
        while(true){
            switch(scanner.next()){
                case "o":
                    x=scanner.nextInt();
                    y=scanner.nextInt();
                    g.leftClick(x,y,0);
                    break;
                case "f":
                    x=scanner.nextInt();
                    y=scanner.nextInt();
                    g.rightClick(x,y,0);
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
            g.printAll();
        }

    }
}
