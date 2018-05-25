/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.IA;

import ia_error404.Cases.Case;
import ia_error404.Cases.Case_Base;
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
        int suivX = CaseSuivante.getX();
        int suivY = CaseSuivante.getY();
        if (CaseSuivante.getJoueur() == null){
            if (X!=suivX){
                    if (suivX == X-1){
                        retour = "N";
                    }
                    if (suivX == X+1){
                        retour = "S";
                    }
                }
                if (Y!=suivY){
                    if (suivY == Y-1){
                        retour = "O";
                    }
                    if (suivY == Y+1){
                        retour = "E";
                    }
                }
                this.getJoueur().getCase().removeLanceur();
                CaseSuivante.addLanceur(this.getJoueur());
                
        }
        return retour;
    }
    
    @Override
    public String action() {
        String retour = "X";
        
        if (this.turn ==0){
            this.algo.calcul(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()), this.getMap().getGraphe().getVertex(this.minFruit().getPosition()));
        }
        // Action lorsque le joueur n'a rien dans son inventaire = début || vient de poser/lancer un fruit
        if (this.algo.getPath().isEmpty()&& this.getJoueur().getInventaire()==null){
            retour = "P";
            this.algo.calcul(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()), this.getMap().getGraphe().getVertex(this.minFruit().getPosition()));
        }
        // Action lorsque le joueur vient de ramasser son fruit;
        else if (this.algo.getPath().isEmpty() && this.getJoueur().getInventaire()!=null){
            retour = "P";
            this.algo.calcul(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()), this.getMap().getGraphe().getVertex(this.baseProche()));
        } 
        else {
            retour = noeudToAction(this.algo.getPath().get(0).getCase());
        }
        return retour;
    }
    
    public Fruit minFruit(){
        

        Fruit minFruit = this.getMap().getListeFruitsOK().get(0);
        int shortest = this.algo.getShortest(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()),this.getMap().getGraphe().getVertex(minFruit.getPosition()));
        for (Fruit f : this.getMap().getListeFruits()){
            if (this.visited.get(f)!=true){
            int shortestF = this.algo.getShortest(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()),this.getMap().getGraphe().getVertex(f.getPosition()));
                if (shortestF < shortest){
                     shortest = shortestF;
                     minFruit = f;
                     this.visited.put(f, true);
                }    
            }
                
        }
        return minFruit;
    }
    
    public Case_Base baseProche(){
        Case_Base minBase = this.getMap().getBase().get(0);
        int shortest = this.algo.getShortest(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()),this.getMap().getGraphe().getVertex(minBase));
        for (Case_Base c : this.getMap().getBase()){
            int shortestF = this.algo.getShortest(this.getMap().getGraphe().getVertex(this.getJoueur().getCase()),this.getMap().getGraphe().getVertex(c));
            if (shortestF<shortest){
                shortest = shortestF;
                minBase =c;
            }
        }
        return minBase;
    }
    
}
