/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404;

import ia_error404.Cases.Case;
import ia_error404.Cases.Case_Sol;
import ia_error404.Cases.Type_Case;
import ia_error404.Objet.Fruit;
import ia_error404.Objet.Type_Fruit;
import ia_error404.Parseur.Fabrique;
import ia_error404.Team.Equipe;
import ia_error404.Team.Lanceur;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * www.codeurjava.com
 */
public class Client {

    private static String numero_equipe;
    private static int tailleMap;
    private static char[][] map_pleine;
    
   public static void main(String[] args) throws InterruptedException {
      
      final Socket clientSocket;
      final BufferedReader in;
      final PrintWriter out;
      int tour = 0;
      int tailleMap;
      Fabrique fab = Fabrique.get();
      Map m = new Map();
  
      try {
        
         clientSocket = new Socket("172.23.4.222",1337);
   
         //flux pour envoyer
         out = new PrintWriter(clientSocket.getOutputStream());
         //flux pour recevoir
         in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
   

        String  msg = "Error 404 not found\n";
        out.println(msg);
        out.flush();
                
        
        msg = in.readLine();
        msg = in.readLine();
        System.out.println(msg);
        System.out.println("-------");
        String[] split1 = msg.split("_");
        String map = split1[2];
          System.out.println(map);
        String[] lignesMapF = map.split(",");
        tailleMap = lignesMapF[1].length();
        System.out.println(tailleMap);
        String[] lignesMap = new String[13];
        for (int i=0; i<tailleMap;i++){
            lignesMap[i]= lignesMapF[i+1];
            System.out.println(lignesMap[i]);
        }
        
        for (int numLigne =0; numLigne<tailleMap ; numLigne++){
            for (int numColonne = 0; numColonne<tailleMap; numColonne++){
                Case nouvelleCase=null;
                            Coordonnees coord = new Coordonnees(numLigne, numColonne);
                            String temp = lignesMap[numLigne];
                            char lettre = temp.charAt(numLigne);
                            switch(lettre){
                                case 'X':nouvelleCase=fab.construireCase(Type_Case.Mur, numLigne, numColonne, m);
                                break;
                                case '.':nouvelleCase=fab.construireCase(Type_Case.Sol, numLigne, numColonne, m);
                                break;
                                case '0':nouvelleCase=fab.construireCase(Type_Case.Sol, numLigne, numColonne, m);
                                break;
                                case '1':nouvelleCase=fab.construireCase(Type_Case.Sol, numLigne, numColonne, m);
                                break;
                                case '2':nouvelleCase=fab.construireCase(Type_Case.Sol, numLigne, numColonne, m);
                                break;
                                case '3':nouvelleCase=fab.construireCase(Type_Case.Sol, numLigne, numColonne, m);
                                break;
                                case '4':nouvelleCase=fab.construireCase(Type_Case.Sol, numLigne, numColonne, m);
                                break;
                                default:System.out.println("Type case inconnue");
                                break;
                                }
                                
                            switch(lettre){
                                case '0':m.getHashCase().get(coord).setInventaire(new Fruit(Type_Fruit.mirabelle,nouvelleCase,null));break;
                                case '1':m.getHashCase().get(coord).setInventaire(new Fruit(Type_Fruit.prune,nouvelleCase,null));break;
                                case '2':m.getHashCase().get(coord).setInventaire(new Fruit(Type_Fruit.cerise,nouvelleCase,null));break;
                                case '3':m.getHashCase().get(coord).setInventaire(new Fruit(Type_Fruit.framboise,nouvelleCase,null));break;
                                case '4':m.getHashCase().get(coord).setInventaire(new Fruit(Type_Fruit.chataigne,nouvelleCase,null));break;
                            }
            }
        }
        m.genererGrapheSimple();
        m.setFruitsOK();
        String infoEquipe= "";
        switch(split1[0]){
            case "0" : infoEquipe= split1[3];
                break;
            case "1" : infoEquipe= split1[4];
                break; 
            case "2" : infoEquipe = split1[5];
                break;
            case "3" : infoEquipe = split1[6];
                break;
        
      }
      String[] infoTeam = infoEquipe.split(",");
          System.out.println(infoTeam.length + " test");
      String infoQ = infoTeam[2];
      String infoL1 = infoTeam[3];
      String infoL2 = infoTeam[4];
          System.out.println(infoL2);
      String[] infoQt= infoQ.split(":");
      String[] infoL1t= infoL1.split(":");
      String[] infoL2t= infoL2.split(":");
      
      int posQX = Integer.parseInt(infoQt[1]);
          System.out.println(infoQt[1]);
      int posQY = Integer.parseInt(infoQt[2]);
      System.out.println(infoQt[2]);
      int posL1X = Integer.parseInt(infoL1t[1]);
      System.out.println(infoL1t[1]);
      int posL1Y = Integer.parseInt(infoL1t[2]);
      System.out.println(infoL1t[2]);
      int posL2X = Integer.parseInt(infoL2t[1]);
      System.out.println(infoL2t[1]);
      int posL2Y = Integer.parseInt(infoL2t[2]);
      System.out.println(infoL2t[2]);
      Coordonnees cQ = new Coordonnees(posQX, posQY);
      Coordonnees cL1 = new Coordonnees(posL1X, posL1Y);
      Coordonnees CL2 = new Coordonnees(posL2X, posL2Y);

      Lanceur Q = new Lanceur((m.getHash().get(cQ)),m,"x");
      Lanceur L1 = new Lanceur((m.getHash().get(cL1)),m,"x");
      Lanceur L2 = new Lanceur((m.getHash().get(CL2)),m,"x");      
      m.addBase(Q,m.getHash().get(cQ));
      m.addBase(L1,m.getHash().get(cL1));
      m.addBase(L2,m.getHash().get(CL2));
        while(!msg.equals("FIN")){
                 msg = in.readLine();
                 System.out.println(tour);
                 tour ++;
                 msg = "";
                 msg+=Q.getAction()+"-X-X\n";
                 System.out.println("----------------");
                 //msg+=L1.getAction()+"-";
                 //msg+=L2.getAction()+"\n";
                 
                 //msg = "E-E-E\n";
                  out.write(msg);
                  out.flush();
                  //msg = in.readLine();
                  System.out.println(msg);
                //  sleep(80000);
                 }
                 System.out.println("Serveur déconecté");
                 out.close();
                 clientSocket.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
   }
        
        
         
      
   
    
  }
        
        
         
      
   
  