/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404;

import ia_error404.Cases.Case;
import ia_error404.Cases.Type_Case;
import ia_error404.Parseur.Fabrique;
import ia_error404.Team.Equipe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/*
 * www.codeurjava.com
 */
public class Client {

    private static String numero_equipe;
    private static int tailleMap;
    private static char[][] map_pleine;
    
public static void main(String[] args) {
      
    final Socket clientSocket;
    final BufferedReader in;
    final PrintWriter out;



    try {

        clientSocket = new Socket("100.64.87.25",1337);

        //flux pour envoyer
        out = new PrintWriter(clientSocket.getOutputStream());
        //flux pour recevoir
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Thread envoyer = new Thread(new Runnable() {
            String msg;
            @Override
            public void run() {
                while(true){
                    msg = "Error 404 not found\n";
                    out.println(msg);
                    out.flush();
                }
            }
        });
        envoyer.start();

        Thread recevoir = new Thread(new Runnable() {
            String msg;
            @Override
            public void run() {
                try {
                    msg = in.readLine();
                    while(msg!=null){
                        //System.out.println("valeur-basique "+msg);

                        //Recuperation du numero de team 
                        numero_equipe=msg.substring(0,1);
                        System.out.println("Numero d'équipe" +numero_equipe );

                        msg = in.readLine();
                        //Taille de la map 
                        String temp[] = msg.split("_");

                        String[] blocTailleMap = temp[2].split(":");
                        tailleMap = Integer.parseInt(blocTailleMap[0]);

                        System.out.println("Taille map " +tailleMap);
                        String[] bloc_map = msg.split(",");
                        String map [][] =new String[tailleMap][tailleMap] ;

                        String temp10[] = msg.split("_");
                        String temp12[] = temp10[2].split(",");

                        map_pleine=new char[tailleMap][tailleMap];
                        for (int k = 0; k < tailleMap; k++) {
                            for (int i = 0; i < tailleMap; i++) {
                                map_pleine[k][i] = temp12[k+1].charAt(i);
                            }
                        }
                        Map m=new Map();
                        Equipe monEquipe=new Equipe("Error 404", numero_equipe);
                        Equipe equipeAdv=new Equipe("Autres", "4");
                        for(int numLigne=0;numLigne<tailleMap;numLigne++){
                            for(int numColonne=0;numColonne<tailleMap;numColonne++){
                                char c=map_pleine[numLigne][numColonne];
                                //creation de la case
                                Case nouvelleCase=null;
                                switch(c){
                                    case 'X':nouvelleCase=Fabrique.construireCase(Type_Case.Mur, numLigne, numColonne, m, null, null);
                                    break;
                                    case '.':nouvelleCase=Fabrique.construireCase(Type_Case.Sol, numLigne, numColonne, m, null, null);
                                    break;
                                    case 'A':nouvelleCase=Fabrique.construireCase(Type_Case.Base, numLigne, numColonne, m, monEquipe, null);
                                    break;
                                    case 'E':nouvelleCase=Fabrique.construireCase(Type_Case.Base, numLigne, numColonne, m, equipeAdv, null);
                                    break;
                                    default:System.out.println("Type case inconnue");
                                    break;
                                }
                                
                            }
                        }
                    }
                    System.out.println("Serveur déconecté");
                    out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        recevoir.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}