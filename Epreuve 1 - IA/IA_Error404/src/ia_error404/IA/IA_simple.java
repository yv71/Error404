/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.IA;

import ia_error404.Cases.Case;
import ia_error404.Cases.Case_Base;
import ia_error404.Coordonnees;
import ia_error404.Objet.Fruit;
import ia_error404.Team.Lanceur;

/**
 *
 * @author JGSTAR
 */
public class IA_simple extends IA{
    
    public IA_simple(Lanceur _joueur) {
        super(_joueur);
    }

    public String noeudToAction(Case CaseSuivante){
        Case cC = this.getJoueur().getCase();
        String retour = "X";
        int X = cC.getX();
        
        int Y = cC.getY();
        System.out.println("X : " + X + " Y "+ Y);
        int suivX = CaseSuivante.getX();
        int suivY = CaseSuivante.getY();
        System.out.println("X : " + suivX + " Y "+ suivY);
            if (X!=suivX){
                    if (suivX == X-1){
                        retour = "N";
                        Coordonnees nCoord = new Coordonnees(X-1,Y);
                        this.getJoueur().setCase(this.getMap().getHash().get(nCoord));
                    }
                    if (suivX == X+1){
                        retour = "S";
                        Coordonnees nCoord = new Coordonnees(X+1,Y);
                        this.getJoueur().setCase(this.getMap().getHash().get(nCoord));
                    }
                }
                if (Y!=suivY){
                    if (suivY == Y-1){
                        retour = "E";
                        Coordonnees nCoord = new Coordonnees(X,Y-1);
                        this.getJoueur().setCase(this.getMap().getHash().get(nCoord));
                    }
                    if (suivY == Y+1){
                        retour = "O";
                        Coordonnees nCoord = new Coordonnees(X,Y+1);
                        this.getJoueur().setCase(this.getMap().getHash().get(nCoord));
                    }
                     }
                this.algo.destroyFirst();
                this.getJoueur().getCase().removeLanceur();
                CaseSuivante.addLanceur(this.getJoueur());
                
        
        return retour;
    }
    
    @Override
    public String action() {
        System.out.println(this.algo.getPath());
        String retour = "X";
        // Action lorsque le joueur n'a rien dans son inventaire = début || vient de poser/lancer un fruit
        if (this.turn == 0){
            turn ++;
            this.algo.calcul(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()), this.getMap().getGraphe().getVertex(this.minFruit().getPosition()));
        }
        if (this.algo.getPath().isEmpty()&& this.getJoueur().getInventaire()!=null){
            System.out.println("inventaire = null");
            retour = "P";
            this.algo.calcul(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()), this.getMap().getGraphe().getVertex(this.minFruit().getPosition()));
        }
        // Action lorsque le joueur vient de ramasser son fruit;
        else if (this.algo.getPath().isEmpty() && this.getJoueur().getInventaire()==null){
            System.out.println("inventaire rempli");
            retour = "P";
            this.algo.calcul(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()), this.getMap().getGraphe().getVertex(this.baseProche()));
        } 
        else {
            System.out.println("on avance");
            retour = noeudToAction(this.algo.getPath().get(0).getCase());
        }
        turn++;
        return retour;
    }
    
    public Fruit minFruit(){
        

        Fruit minFruit = this.getMap().getListeFruitsOK().get(0);
        System.out.println(this.getMap().getGraphe().getHashMap().size());
        int shortest = this.algo.getShortest(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()),this.getMap().getGraphe().getVertex(minFruit.getPosition()));
        for (Fruit f : this.getMap().getListeFruitsOK()){
            if (this.visited.get(f) !=null){
            if (this.visited.get(f)==false){
            int shortestF = this.algo.getShortest(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()),this.getMap().getGraphe().getVertex(f.getPosition()));
                if (shortestF < shortest){
                     shortest = shortestF;
                     minFruit = f;
                     this.visited.put(f, true);
                }    
            }
            }
        }
        return minFruit;
    }
    
    public Case baseProche(){
        Case minBase = this.getJoueur().getMap().getBase().get(this.getJoueur());
        return minBase;
    }
    
}
