/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Cases;

import ia_error404.Map;
import ia_error404.Team.Lanceur;

/**
 *
 * @author Beelzed
 */
public abstract class Case {
    private Map m;
    private Lanceur joueur;
    


    private int x;
    private int y;
    
    public abstract Type_Case getType();
    public abstract boolean franchissable();
   
    public Case(Map m, int x, int y) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.joueur=null;
    }


     public void addLanceur(Lanceur joueur){
         if (this.joueur==null){
             this.joueur=joueur;
         }
     }
     
     public void removeLanceur(){
         this.joueur =null;
     }
     
     public Lanceur getJoueur(){
        return this.joueur;
        
    }
    public Map getM() {
        return m;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
