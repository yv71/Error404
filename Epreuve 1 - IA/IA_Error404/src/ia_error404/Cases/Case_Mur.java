/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Cases;

import ia_error404.Map;

/**
 *
 * @author Beelzed
 */
public class Case_Mur extends Case{
    

    @Override
    public Type_Case getType() {
        return Type_Case.Mur;
    }

    @Override
    public boolean franchissable() {
        return false;
    }

    public Case_Mur(Fruit inventaire, Map m, int x, int y) {
        super(m, x, y);
    }
    
    
    
}
