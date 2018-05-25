/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Cases;

import ia_error404.Map;
import ia_error404.Objet.Fruit;

/**
 *
 * @author Beelzed
 */
public class Case_Sol extends Case{
    private Fruit inventaire;

    public Case_Sol(Fruit inventaire, Map m, int x, int y) {
        super(m, x, y);
        this.inventaire=inventaire;
    }

    @Override
    public Type_Case getType() {
        return Type_Case.Sol;
    }

    @Override
    public boolean franchissable() {
        return true;
    }
    
}
