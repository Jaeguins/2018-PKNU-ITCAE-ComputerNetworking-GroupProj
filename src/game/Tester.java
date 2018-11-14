package game;

import java.util.Scanner;

public class Tester {
    public static void main(String args[]){
        Game g=new Game();
        g.initiating(20,20,20);
        Scanner scanner=new Scanner(System.in);
        int x,y;
        while(true){
            switch(scanner.next()){
                case "o":
                    x=scanner.nextInt();
                    y=scanner.nextInt();
                    g.opening(x,y);
                    break;
                case "f":
                    x=scanner.nextInt();
                    y=scanner.nextInt();
                    g.flaging(x,y);
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
            g.printAll();
        }

    }
}
