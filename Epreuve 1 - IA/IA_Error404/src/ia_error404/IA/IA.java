/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.IA;

import ia_error404.Cases.Case;
import ia_error404.Graphe.Algorithmes.Dijkstra;
import ia_error404.Map;
import ia_error404.Team.Lanceur;

/**
 *
 * @author Beelzed
 */
public abstract class IA {
    protected Lanceur joueur;
    protected Dijkstra algo;
    protected int turn;
    
    public IA(Lanceur _joueur){
        this.joueur = _joueur;
        this.algo = new Dijkstra(this.joueur.getMap().getGraphe());
        this.turn =0;
    }
    
    public Map getMap(){
        return this.joueur.getMap();
    }
    
    public Case getCase(){
        return this.joueur.getCase();
    }
    
    public Lanceur getJoueur(){
        return this.joueur;
    }
    
    public abstract String action();
}
