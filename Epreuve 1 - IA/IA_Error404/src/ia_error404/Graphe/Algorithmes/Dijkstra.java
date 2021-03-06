/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Graphe.Algorithmes;

import ia_error404.Graphe.Graphe;
import ia_error404.Graphe.Vertex;
import ia_error404.Graphe.VertexCouple;
import java.util.ArrayList;
import java.util.HashMap;
    
/**
 *
 * @author yv066840
 */
public class Dijkstra {
    private Graphe graph;
    private Vertex debut;
    private Vertex fin;
    private HashMap<Vertex,Integer> distance;
    private HashMap<Vertex,Boolean> visited;
    private HashMap<Vertex,Vertex> predecessor;
    private ArrayList<Vertex> path;
    private Integer infini;
    
    public Dijkstra (Graphe graph){
    this.graph = graph;
    this.distance = new HashMap<Vertex,Integer>();
    this.visited = new HashMap<Vertex,Boolean>();
    this.predecessor = new HashMap<Vertex,Vertex>();
    this.path = new ArrayList<Vertex>();
    this.infini = null;
    this.debut = null;
    this.fin = null;
    }
    
    public void initialisation(){
        this.path = new ArrayList<Vertex>();
        int max = getInfini();
        for (Vertex v : graph.getVertices().values()){
            distance.put(v,max);
            visited.put(v,false);
            predecessor.put(v,null);
        }
        distance.put(debut,0);
    }
    
    public Vertex closestVertex(){
      int min = getInfini()+1;
      Vertex plusProche = null;
        for (Vertex v : distance.keySet()){
            if (visited.get(v)==false){
                if (distance.get(v)<min){
                    plusProche = v;
                    min = distance.get(v);
                }
            }
        }
        return plusProche;
    }
            
    public int getShortest(Vertex _debug, Vertex _fin){
        ArrayList<Vertex> chemin = new ArrayList<Vertex>();
        this.debut = _debug;
        this.fin = _fin;
        this.initialisation();
        for (int i = 0; i< visited.keySet().size(); i++){
            Vertex a = closestVertex();
            visited.put(a,true);
            for (Vertex b : visited.keySet()){
                relaxing(a,b);
            }
        }
        Vertex v = fin;
        while (v !=null){ 
            chemin.add(0,v);
            v = predecessor.get(v);
            //System.out.println(v);
        }
        chemin.remove(0);
        
        return chemin.size();
 
    }      
    
    public void calcul(Vertex _debug, Vertex _fin){
        this.debut = _debug;
        this.fin = _fin;
        this.initialisation();
        for (int i = 0; i< visited.size(); i++){
            Vertex a = closestVertex();
            visited.put(a,true);
            for (Vertex b : visited.keySet()){
                relaxing(a,b);
            }
        }
        Vertex v = fin;
        while (v !=null){
            path.add(0,v);
            v = predecessor.get(v);
        }
        path.remove(0);
        System.out.println(path);
        
        
    }
            
    public void relaxing(Vertex a, Vertex b){
        //System.out.println(this.graph.getLabels().get(new VertexCouple(a,b)));
        if(this.graph.getLabels().get(new VertexCouple(a,b)) != null) {
            if (distance.get(b)> (distance.get(a)+ this.graph.getLabels().get(new VertexCouple(a,b)))){
                distance.put(b, (distance.get(a)+ this.graph.getLabels().get(new VertexCouple(a,b))));
                predecessor.put(b, a);

            }
        }
    }
    public int getInfini(){
        if(infini == null){
            infini = 0;
            for (Integer vLabel : graph.getLabels().values()){
                infini += vLabel;
            }
            infini++;
        }
        return infini;
    }

    public ArrayList<Vertex> getPath() {
        return path;
    }
    
    public void destroyFirst(){
        this.path.remove(0);
    }
    
}


