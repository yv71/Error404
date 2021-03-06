/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Graphe;

import ia_error404.Cases.Case;
import java.util.HashMap;

import java.util.ArrayList;
/**
 *
 * @author yv066840
 */
public class Graphe {
    private final HashMap<Case,Vertex> Vertices;
    private final HashMap<VertexCouple,Integer> Labels;
    
    
    public Graphe() {
    Vertices = new HashMap<>();
    Labels = new HashMap<>();
    }
    
    public HashMap<Case, Vertex> getVertices() {
        return Vertices;
    }
    
    public HashMap<VertexCouple, Integer> getLabels() {
        return Labels;
    }
    
    public HashMap<Case,Vertex> getHashMap(){
      return  this.Vertices;
}
    public void addVertex(Case _case){
           Vertices.put(_case, new Vertex(this, _case));
    }
    
    public void addEdge(Case _case1, Case _case2){
            getVertex(_case1).addNeighbour(getVertex(_case2));
           //System.out.println(_case1.getColonne() + " " + _case1.getLigne()+ " " + getVertex(_case1));
    }
    
    public Vertex getVertex(Case _case){
       return  Vertices.get(_case);
    }
    
    public Integer getLabel(Case _case1, Case _case2){
        return Labels.get(new VertexCouple(Vertices.get(_case1),Vertices.get(_case2)));
    }
    
    public void setLabel(Case _case1, Case _case2, Integer label){
        Labels.put(new VertexCouple(Vertices.get(_case1),Vertices.get(_case2)), label);
    }
    
    public void afficheMatriceAdjacence(){
        System.out.println(Labels.values());
        for (Case c : Vertices.keySet()){
            System.out.println();
            for (Case c2 : Vertices.keySet()){
                if (this.getLabel(c, c2)!=null){
                    System.out.print(this.getLabel(c, c2));
                }
                else {
                    System.out.print("0");
                }
                
            }
            
        }
        System.out.println();
        System.out.println("test");
    }
   
    

}
