/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Parseur;

import ia_error404.Cases.Case;
import ia_error404.Cases.Type_Case;
import ia_error404.Coordonnees;
import ia_error404.Map;
import ia_error404.Objet.Fruit;
import ia_error404.Objet.Type_Fruit;

/**
 *
 * @author Damien
 */
public class GenerationMap {
    //Singleton
    private static GenerationMap instance;
    
    private GenerationMap() {
    }
    
    public static GenerationMap get() {
        if(instance == null) {
            instance = new GenerationMap();
        }
        return instance;
    }
    
    public static void generation(Map m,int tailleMap,char[][] tabMap){
        Fabrique fab=Fabrique.get();
        m.clean();
        for(int numLigne=0;numLigne<tailleMap;numLigne++){
            System.out.println("taille :" + tailleMap);
            for(int numColonne=0;numColonne<tailleMap;numColonne++){

                char lettre=tabMap[numLigne][numColonne];
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
    }
}
