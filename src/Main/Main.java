package Main;

import gui.CustFrame;
import socket.Client;
import socket.Server;

import javax.swing.*;

public class Main {
    public static Main Instance;
    public Server server;
    public Client client;
    public CustFrame frame;
    public JPanel nowActivePane;
    public Main(){
        Instance=this;
        frame=new CustFrame();
    }
    public static void main(String args[]){
        Main m=new Main();
    }
}
