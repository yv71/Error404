/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_error404.Team;

/**
 *
 * @author Azelat
 */
public class Equipe {
    
    private String nom;
    private String id;
    //private int score;

    public Equipe(String nom, String id) {
        this.nom = nom;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
/*
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
  */  
}
