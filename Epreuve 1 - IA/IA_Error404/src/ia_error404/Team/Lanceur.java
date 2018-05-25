/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Team;

import ia_error404.Cases.Case;
import ia_error404.Cases.Case_Sol;
import ia_error404.Map;
import ia_error404.Objet.Fruit;

/**
 *
 * @author Azelat
 */
public class Lanceur {
    
    private Fruit inventaire; // Import la classe fruit
    private Case position;
    private Equipe eq;
    private TypeJoueur type;
    private Map map;
    //private IA ia;
  
    public Lanceur(Case cas, Map map){
        inventaire = null;
        position = cas;
        this.map = map;
}
    public Map getMap(){
        return this.getMap();
    }
    public String deplacer(int dir){ // Paramètre à définir
        String res = "";
        switch(dir){
            case  0: res = "N"; break;
            case 1: res = "S"; break;
            case 2:res = "O"; break;
            case 3: res = "E"; break;
            case 4: res = "X"; break;
        }
        return res;
    } 
    
    public String action(){
        return "P";
    }
    
    public String lancer(int l){ // Paramètre à définir
        String res="";
        switch(l){
            case 0 : res="LN"; break;
            case 1: res="LS"; break;
            case 2: res="LE"; break;
            case 3: res="LO"; break;
        }
        return res;
    }
    
    public Case getCase(){
        return this.position;
    }
    
    public Fruit getInventaire(){
        return this.inventaire;
    }
}
