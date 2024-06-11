/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salman Alfarizi
 */
public class Server_TCP extends Thread{
    
    ServerSocket server;
    Socket s;
   

    public Server_TCP() {
        try {
            this.server = new ServerSocket(6969);
            this.start();
        } catch (IOException ex) {
            Logger.getLogger(Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Broadcast(String tmp){
        for (HandleSocket hs : HandleSocket.clients){
             hs.SendChat(tmp);
        }
    }
    
    @Override
    public void run() {
        try {
            s = server.accept();
            HandleSocket hs = new HandleSocket( s);
            hs.start();
            hs.clients.add(hs);
        } catch (IOException ex) {
            Logger.getLogger(Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new Server_TCP();
    }
    
}
