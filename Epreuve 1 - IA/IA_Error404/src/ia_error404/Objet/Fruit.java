/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Objet;

import ia_error404.Cases.Case;

/**
 *
 * @author JGSTAR
 */
public class Fruit {
    private Type_Fruit type;
    private Case position;
    private Lanceur joueur;

    public Fruit(Type_Fruit type, Case position) {
        this.type = type;
        this.position = position;
        this.joueur = null;
    }

    public Type_Fruit getType() {
        return type;
    }

    public void setType(Type_Fruit type) {
        this.type = type;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public Lanceur getJoueur() {
        return joueur;
    }

    public void setJoueur(Lanceur joueur) {
        this.joueur = joueur;
    }
    
}
