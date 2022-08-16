
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armok
 */
public class Server {
  int port = 3124;
  InetAddress ip = null;
  MyTimer timer = new MyTimer();
  Model m = new Model();
  ArrayList<Ivent> ivents = new ArrayList<>();
  
  //ObjectOutputStream oos;
  //ObjectInputStream ois;
  DataOutputStream dos;
  DataInputStream dis;
  Gson convert = new Gson();
  
  
  public Server() {
    
      try{
          ivents = m.getAllIvent();
      } catch(SQLException ex) {}
    
      
    try {
      ip = InetAddress.getLocalHost();
    } catch (UnknownHostException ex) {
      Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    try {
      ServerSocket ss = new ServerSocket(port, 0, ip);
      System.out.println("Server has started!");
      Thread t = new Thread(
        ()->{
          while(true) {
              try {
                  Thread.sleep(1000);
                  timer.tick();
              } catch (InterruptedException ex) {
                  Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        }
      );
      
      t.start();
      
      while (true) {        
        Socket cs = ss.accept();
        Thread t1 = new Thread(()->{
            try {
                while(true){
                    dos = new DataOutputStream(cs.getOutputStream());
                    String str = convert.toJson(new Message(timer.getHour(), timer.getMin(), timer.getSec(), ivents));
                    dos.writeUTF(str);
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } 
        });
        t1.start();
        Thread t2 = new Thread(()->{
            try {
                while(true){
                   dis = new DataInputStream(cs.getInputStream());
                   String obj = dis.readUTF();
                   Ivent ivt = convert.fromJson(obj, Ivent.class);
                   ivents.add(ivt);
                   m.AddIvent(ivt);
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } 
        });
        t2.start();
      }
    } catch (IOException ex) {
      System.out.println("Сan't start the server!!!");
    }
  }

  public static void main(String[] args) {
    new Server();
  }
}


