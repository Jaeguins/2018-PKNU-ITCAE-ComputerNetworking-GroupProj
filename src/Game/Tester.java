package Game;

import java.util.Random;
import java.util.Scanner;

public class Tester {
    public static void main(String args[]){
        Game g=new Game();
        g.initiating(20,20,20);
        Random random=new Random();
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<3;i++){
            String input=scanner.next();
            int x,y;
            switch(input){
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
