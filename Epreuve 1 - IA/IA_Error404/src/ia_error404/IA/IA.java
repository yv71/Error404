/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.IA;

import ia_error404.Cases.Case;
import ia_error404.Graphe.Algorithmes.Dijkstra;
import ia_error404.Map;
import ia_error404.Objet.Fruit;
import ia_error404.Team.Lanceur;
import java.util.HashMap;

/**
 *
 * @author Beelzed
 */
public abstract class IA {
    private Lanceur joueur;
    protected Dijkstra algo;
    protected int turn;
    protected HashMap<Fruit, Boolean> visited;
    
    public IA(Lanceur _joueur){
        this.joueur = _joueur;
        this.algo = new Dijkstra(this.joueur.getMap().getGraphe());
        this.turn =0;
        this.visited = new HashMap<>();
        for (Fruit f : this.getMap().getListeFruitsOK()){
            visited.put(f,false);
        }
        System.out.println(visited.values());
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
