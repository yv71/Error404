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
    
public static void main(String[] args) {
      
    final Socket clientSocket;
    final BufferedReader in;
    final PrintWriter out;
    Fabrique fab=Fabrique.get();
    Map m=new Map();
    Equipe monEquipe=new Equipe("Error 404", numero_equipe);
    Equipe equipeAdv=new Equipe("Autres", "4");
    int tour=1;


    try {

        clientSocket = new Socket("100.64.87.0",1337);

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
                            ArrayList<String> maliste= new ArrayList();
                      String[] parseurTeam = msg.split(",");


                          for (int i = 0; i < 4; i++) 
                          {
                             String a = parseurTeam[2+i*16+tailleMap];
                             String b = parseurTeam[3+i*16+tailleMap];
                             String c = parseurTeam[4+i*16+tailleMap];

                             String[] aa = a.split(":");
                             String[] bb = b.split(":");
                             String[] cc = c.split(":");

                             String aaa = aa[1];
                             String bbb = aa[2];
                             String ccc =  aa[3];

                             String ddd = bb[1];
                             String eee = bb[2];
                             String fff =  bb[3];

                             String ggg = cc[1];
                             String hhh = cc[2];
                             String iii = cc[3];




                             maliste.add(aaa);
                             maliste.add(bbb);
                             maliste.add(ccc);

                             maliste.add(ddd);
                             maliste.add(eee);
                             maliste.add(fff);

                             maliste.add(ggg);
                             maliste.add(hhh);
                             maliste.add(iii);


                          }
                           m.clean();
                        for(int numLigne=0;numLigne<tailleMap;numLigne++){
                            System.out.println("taille :" + tailleMap);
                            for(int numColonne=0;numColonne<tailleMap;numColonne++){
   
                                char lettre=map_pleine[numLigne][numColonne];
                                //creation de la case
                                Case nouvelleCase=null;
                                Coordonnees coord = new Coordonnees(numLigne, numColonne);
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
                                m.getGraphe().afficheMatriceAdjacence();
                                //gestion des entites
                                Coordonnees coordq = new Coordonnees(new Integer(maliste.get(0)).intValue(),new Integer(maliste.get(1)).intValue());
                                Coordonnees coordl1 =new Coordonnees(new Integer(maliste.get(3)).intValue(),new Integer(maliste.get(4)).intValue());
                                Coordonnees coordl2 = new Coordonnees(new Integer(maliste.get(6)).intValue(),new Integer(maliste.get(7)).intValue());
                                Lanceur q = new Lanceur(m.getHashCase().get(coordq), m, maliste.get(2));
                                Lanceur l1=new Lanceur(m.getHashCase().get(coordl1), m, maliste.get(5));
                                Lanceur l2=new Lanceur(m.getHashCase().get(coordl2), m, maliste.get(8));
                                m.addJoueur(q);
                                m.addJoueur(l1);
                                m.addJoueur(l2);
                                //gestion du tour (IA)
                                System.out.println(m.getListeJoueur().size());
                                msg+=m.getListeJoueur().get(0).getAction();
                                msg+="-";
                                msg+=m.getListeJoueur().get(1).getAction();
                                msg+="-";
                                msg+=m.getListeJoueur().get(2).getAction();
                                msg+="\n";
                                System.out.println("---------");
                                System.out.println(msg);
                          
                    }
                    System.out.println("Serveur déconecté");
                    out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Thread envoyer = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        out.println(msg);
                        out.flush();
                    }
            }
        });
        envoyer.start();
            }
        });
        recevoir.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}