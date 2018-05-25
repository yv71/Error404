/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.IA;

import ia_error404.Cases.Case;
import ia_error404.Team.Lanceur;

/**
 *
 * @author JGSTAR
 */
public class IA_simple extends IA{
    
    public IA_simple(Lanceur _joueur) {
        super(_joueur);
    }

    public String noeudToAction(Case CaseSuivante){
        Case cC = this.getJoueur().getCase();
        String retour = "X";
        int X = cC.getX();
        int Y = cC.getY();
        int suivX = CaseSuivante.getX();
        int suivY = CaseSuivante.getY();
        
        return retour;
    }
    
    @Override
    public String action() {
        String retour = "X";
        // Action lorsque le joueur n'a rien dans son inventaire = début || vient de poser/lancer un fruit
        if (this.algo.getPath().isEmpty()&& this.getJoueur().getInventaire()==null){
            
        }
        // Action lorsque le joueur vient de ramasser son fruit;
        else if (this.algo.getPath().isEmpty() && this.getJoueur().getInventaire()!=null){
            
        }
        else {
            retour = noeudToAction(this.algo.getPath().get(0).getCase());
        }
        return retour;
    }
    
}
