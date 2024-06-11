/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salman Alfarizi
 */
public class HandleSocket extends Thread{
    Server_TCP parent;
    Socket client;
    DataOutputStream out;
    BufferedReader in;
    public static ArrayList<HandleSocket> clients = new ArrayList<HandleSocket>();
    public HandleSocket(Server_TCP parent, Socket client) {
        try {
            this.parent = parent;
            this.client = client;
            this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.out = new DataOutputStream(this.client.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void SendChat(String tmp){
        try {
            out.writeBytes( tmp + "\n");
        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                String tmp = in.readLine();
                parent.Aksi(tmp);
            } catch (IOException ex) {
                Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
