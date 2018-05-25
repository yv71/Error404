/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Cases;

import ia_error404.Coordonnees;
import ia_error404.Map;
import ia_error404.Objet.Fruit;
import ia_error404.Team.Lanceur;
import java.util.Objects;

/**
 *
 * @author Beelzed
 */
public abstract class Case {
    private Map m;
    private Lanceur joueur;
    


    private int x;
    private int y;
    private Coordonnees coord;
    public abstract Type_Case getType();
    public abstract boolean franchissable();
       private Fruit inventaire;
    public Case(Map m, int x, int y) {
        this.m = m;
        this.x = x;
        this.y = y;
        this.joueur=null;
        this.coord = new Coordonnees(x,y);
        m.addCase(this);
        m.addHashCase(coord, this);
        this.inventaire = null;
    }

    public Coordonnees getCoord() {
        return this.coord;
    }

        public Fruit getInventaire(){
        return this.inventaire;
    }

    public void setInventaire(Fruit inventaire) {
        this.inventaire = inventaire;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.m);
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Case other = (Case) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (!Objects.equals(this.m, other.m)) {
            return false;
        }
        return true;
    }
    
    
}
