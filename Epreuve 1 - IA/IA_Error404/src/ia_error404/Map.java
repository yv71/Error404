/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404;

import ia_error404.Cases.Case;
import ia_error404.Graphe.Graphe;
import ia_error404.Objet.Fruit;
import java.util.ArrayList;

/**
 *
 * @author Beelzed
 */
public class Map {
    
    
    private final ArrayList<Case> listeCase;
    private final ArrayList<Fruit> listeFruits;
    
    private Graphe graphe;
    
    public Map(){
        this.graphe = new Graphe();
        this.listeCase = new ArrayList<Case>();
        this.listeFruits = new ArrayList<Fruit>();
    }

}
