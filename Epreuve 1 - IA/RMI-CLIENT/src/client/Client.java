/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class Client {

    private static String numero_equipe;
    private static int tailleMap;
    private static char[][] map_pleine;
    
   public static void main(String[] args) {
      
      final Socket clientSocket;
      final BufferedReader in;
      final PrintWriter out;
      int tour = 0;
      
     
  
      try {
        
         clientSocket = new Socket("192.168.0.16",1337);
   
         //flux pour envoyer
         out = new PrintWriter(clientSocket.getOutputStream());
         //flux pour recevoir
         in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
   

        String  msg = "Error 404 not found\n";
        out.println(msg);
        out.flush();
                
        
        msg = in.readLine();
        while(in.readLine()!="FIN"){
                 
                 System.out.println(tour);
                 msg = in.readLine();
                 System.out.println(msg); 
                 tour ++;
                    
                  msg = "E-E-E\n";
                  out.println(msg);
                  out.flush();
                    
                 }
                 System.out.println("Serveur déconecté");
                 out.close();
                 clientSocket.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
   }
        
        
         
      
   
    
  }

               
                
                 