/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Parseur;

import ia_error404.Cases.Case;
import ia_error404.Cases.Case_Base;
import ia_error404.Cases.Case_Sol;
import ia_error404.Cases.Type_Case;
import ia_error404.Map;
import ia_error404.Objet.Fruit;
import ia_error404.Team.Equipe;

/**
 *
 * @author Joanny
 */
public class Fabrique {

    //Singleton
    private static Fabrique instance;
    
    private Fabrique() {
    }
    
    public static Fabrique get() {
        if(instance == null) {
            instance = new Fabrique();
        }
        return instance;
    }
    
    public static Case construireCase(Type_Case type,int X,int Y,Map map) {
        Case nouvelleCase = null;
        switch(type) {
            case Sol: nouvelleCase = new Case_Sol(map,X,Y);
                break;
            case Mur: nouvelleCase = new Case_Mur(map,X,Y);
                break;
            case Base: nouvelleCase = new Case_Base(map,X,Y);
                break;
        }
        return nouvelleCase;
    }
}
