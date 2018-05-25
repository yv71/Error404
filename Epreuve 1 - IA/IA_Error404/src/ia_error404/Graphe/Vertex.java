/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Graphe;

import ia_error404.Cases.Case;
import java.util.ArrayList;

/**
 *
 * @author Beelzed
 */
public class Vertex {
    private Graphe graph;
    private ArrayList<Vertex> voisins;
    private Case c;
    
    public Vertex (Graphe graph, Case c){
        this.graph = graph;
        voisins = new ArrayList<Vertex>();
        this.c = c;
    }
    
    public ArrayList<Vertex> getNeighbours(){
        return this.voisins;
    }
    
    public void addNeighbour(Vertex v){
        voisins.add(v);
    }
    
    public Case getCase(){
        return this.c;
    }
    
    public String toString(){
        return "x : " + c.getX() + " y : " + c.getY();
    }

    
    
 
}
