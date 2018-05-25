/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.IA;

import ia_error404.Team.Lanceur;

/**
 *
 * @author Beelzed
 */
public abstract class IA {
    private Lanceur joueur;
    
    public IA(Lanceur _joueur){
        this.joueur = _joueur;
    }
    
}
