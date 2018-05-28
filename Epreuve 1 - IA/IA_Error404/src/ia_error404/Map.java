package ia_error404;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ia_error404.Cases.Case;
import ia_error404.Cases.Case_Base;
import ia_error404.Graphe.Graphe;
import ia_error404.Objet.Fruit;
import ia_error404.Objet.Type_Fruit;
import ia_error404.Team.Equipe;
import ia_error404.Team.Lanceur;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Beelzed
 */
public class Map {
    
    private ArrayList<Case> listeCase;
    private  ArrayList<Fruit> listeFruits;
    private ArrayList<Fruit> listeFruitsOK;
    private  ArrayList<Case> listeBase;
    private  ArrayList<Lanceur> listeJoueur;
    private  HashMap<Coordonnees,Case> hashCase;
    private ArrayList<Equipe> listeEquipe;

    private Graphe graphe;
    
    // ----- Constructeurs ------
    
    public Map(){
        this.graphe = new Graphe();
        this.listeCase = new ArrayList<Case>();
        this.listeFruits = new ArrayList<Fruit>();
        this.listeFruitsOK = new ArrayList<Fruit>();
        this.listeBase = new ArrayList<Case>();
        this.listeJoueur = new ArrayList<Lanceur>();
        this.hashCase = new HashMap<>();
        this.listeEquipe= new ArrayList<Equipe>();
    }
    public void clean(){
        this.graphe = new Graphe();
        this.listeCase = new ArrayList<Case>();
        this.listeFruits = new ArrayList<Fruit>();
        this.listeFruitsOK = new ArrayList<Fruit>();
 
        this.listeJoueur = new ArrayList<Lanceur>();
        this.hashCase = new HashMap<>();
        this.listeEquipe= new ArrayList<Equipe>();
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
                        default : this.graphe.addEdge(c, c2);
                        this.graphe.setLabel(c, c2, 1);
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
    
    public void addBase(Case c){
        this.listeBase.add(c);
    }
   
    public ArrayList<Case> getBase(){
        return this.listeBase;
    }

    public ArrayList<Case> getListeBase() {
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
    
    public void addHashCase(Coordonnees c, Case cc){
        this.hashCase.put(c,cc);
    }
    
    public void addEquipe(Equipe e){
        this.listeEquipe.add(e);
    }
    
    
}
