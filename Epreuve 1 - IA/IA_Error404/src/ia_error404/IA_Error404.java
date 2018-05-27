package ia_error404;

import ia_error404.Parseur.ParseurDamien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Beelzed
 */
public class IA_Error404 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String in=  "0_4_13:13,XXXXXXXXXXXXX,X......01...X,X...XX.XX...X,X.X......4X.X,X1X.......X1X,X.....3....\n" +
                    ".X,X...0...2...X,X0....3....0X,X1X.......X.X,X.X4.....4X.X,X...XX.XX...X,X...10.0....X,XXXX\n" +
                    "XXXXXXXXX_Equipe0,P,P0:3:5:4,P1:5:1:x,P2:4:6:2,Z,Z0:2:1,Z1:1:1,Z2:1:2,G,2,F,F0:1,F1:1,F2:0,\n" +
                    "F3:0,F4:0_Equipe1,P,P0:8:11:x,P1:9:8:x,P2:11:8:x,Z,Z0:11:10,Z1:11:11,Z2:10:11,G,2,F,F0:0,F1\n" +
                    ":2,F2:0,F3:0,F4:1_Equipe2,P,P0:1:11:x,P1:4:11:x,P2:3:8:x,Z,Z0:2:11,Z1:1:10,Z2:1:11,G,-3,F,F\n" +
                    "0:0,F1:0,F2:0,F3:0,F4:2_Equipe3,P,P0:11:5:0,P1:7:5:x,P2:10:1:x,Z,Z0:11:1,Z1:10:1,Z2:11:2,G,\n" +
                    "0,F,F0:0,F1:0,F2:0,F3:0,F4:0";
        ParseurDamien parseur=ParseurDamien.get();
        int numeroTeam=ParseurDamien.tailleMap(in);
        System.out.println(numeroTeam);
        
    }
    
}
