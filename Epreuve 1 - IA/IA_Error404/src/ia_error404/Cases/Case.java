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
public abstract class Case {
    private Map m;

    public Case(Map m, int x, int y) {
        this.m = m;
        this.x = x;
        this.y = y;
    }
    private int x;
    private int y;
    
    public abstract Type_Case getType();
    public abstract boolean franchissable();
    
}
