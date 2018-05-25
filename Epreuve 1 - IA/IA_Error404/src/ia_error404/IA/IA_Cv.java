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
public class IA_Cv extends IA{

    public IA_Cv(Lanceur _joueur) {
        super(_joueur);
    }

    @Override
    public String action() {
        Case cC = this.getJoueur().getCase();
        String retour = "X";
        int X = cC.getX();
        int Y = cC.getY();
        if (X==0){
            if (Y==0){
                return "E";
            }else{
                return "O";
            }
            
        }else{
            if (Y==0){
                return "E";
            }else{
                return "O";
            }
        }
    }

    
    
}
