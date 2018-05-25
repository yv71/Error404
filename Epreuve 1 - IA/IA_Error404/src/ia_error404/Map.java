/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404;

import ia_error404.Cases.Case;
import ia_error404.Cases.Case_Base;
import ia_error404.Graphe.Graphe;
import ia_error404.Objet.Fruit;
import ia_error404.Objet.Type_Fruit;
import ia_error404.Team.Lanceur;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Beelzed
 */
public class Map {
    
    private final ArrayList<Case> listeCase;
    private final ArrayList<Fruit> listeFruits;
    private final ArrayList<Fruit> listeFruitsOK;
    private final ArrayList<Case_Base> listeBase;
    private final ArrayList<Lanceur> listeJoueur;
    private final HashMap<Coordonnees,Case> hashCase;

    private Graphe graphe;
    
    // ----- Constructeurs ------
    
    public Map(){
        this.graphe = new Graphe();
        this.listeCase = new ArrayList<Case>();
        this.listeFruits = new ArrayList<Fruit>();
        this.listeFruitsOK = new ArrayList<Fruit>();
        this.listeBase = new ArrayList<Case_Base>();
        this.listeJoueur = new ArrayList<Lanceur>();
        this.hashCase = new HashMap<>();
    }
    
    public HashMap<Coordonnees,Case> getHash(){
        return this.hashCase;
    }
    
    public void genererGrapheSimple(){
        // generation des vertices
        System.out.println("SALUT");
        for(Case c : listeCase) {
            this.graphe.addVertex(c);
        }
        // generation des neighbours
        for (Case c  : listeCase){
            for (Case c2 : listeCase){
                    int c2Ligne = c2.getX();
                    int c2Col = c2.getY();
                    int cLigne = c.getX();
                    int cCol = c.getY();
                    int ligne = Math.abs(c2Ligne-cLigne);
                    int col = Math.abs(c2Col-cCol);
                    // ajout des labels
                    if ((ligne + col)==1){
                    switch(c2.getType()){
                        case Base : this.graphe.addEdge(c, c2);
                        this.graphe.setLabel(c, c2, 1);
                        break;
                        case Sol : this.graphe.addEdge(c, c2);
                        this.graphe.setLabel(c, c2, 1);
                        break;
                        default : System.out.println("oops");
                    }
                    }
               
                        
                        
                    }
                }
               // this.graphe_simple.afficheMatriceAdjacence();             
           
        }

    
    // --- Getter / Setter ---

    public Graphe getGraphe() {
        return graphe;
    }

    public void setGraphe(Graphe graphe) {
        this.graphe = graphe;
    }
    
    public ArrayList<Case> getListeCase(){
        return this.listeCase;
    }
    
    public ArrayList<Fruit> getListeFruits(){
        return this.listeFruits;
    }

    public void setFruitsOK(){
        for(Fruit f: this.listeFruits){
            if (f.getType()!= Type_Fruit.chataigne){
                this.listeFruitsOK.add(f);
            }
        }
    }

    public void addFruit(Fruit f){
        this.listeFruits.add(f);
    }
    
    public ArrayList<Fruit> getListeFruitsOK() {
        return this.listeFruitsOK;
    }
    
    public void addCase(Case c){
        this.listeCase.add(c);
        this.hashCase.put(c.getCoord(),c);
    }
    
    public void addBase(Case_Base c){
        this.listeBase.add(c);
    }
   
    public ArrayList<Case_Base> getBase(){
        return this.listeBase;
    }

    public ArrayList<Case_Base> getListeBase() {
        return listeBase;
    }

    public ArrayList<Lanceur> getListeJoueur() {
        return listeJoueur;
    }
    
    public void addJoueur(Lanceur e){
        this.listeJoueur.add(e);
    }

    public HashMap<Coordonnees, Case> getHashCase() {
        return hashCase;
    }
    
    
}
