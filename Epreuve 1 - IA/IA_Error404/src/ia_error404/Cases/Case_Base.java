/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Cases;

import ia_error404.Map;

/**
 *
 * @author JGSTAR
 */
public class Case_Base extends Case{
    private Equipe e;

    public Case_Base(Equipe e, Map m, int x, int y) {
        super(m, x, y);
        this.e = e;
    }

    

    @Override
    public Type_Case getType() {
        return Type_Case.Base;
    }

    @Override
    public boolean franchissable() {
        return true;
    }
    
    
}
