/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author garrondeau
 */
public class TP2 {
        public static int TAILLE_FENETRE_X = 600;
        public static int TAILLE_FENETRE_Y = 600;
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                Loft loft = new Loft(20, 20, 8);
                ZoneGraphique fenetre = new ZoneGraphique("Le loft des neuneus");
                
                
                while (!loft.getParticipants().isEmpty()) {
                        loft.tourDeJeu();
                        loft.afficheLoft(fenetre);
                        try {
                                Thread.sleep(500);
                        } catch (InterruptedException ex) {
                                Logger.getLogger(TP2.class.getName()).log(Level.SEVERE, null, ex);
                        }

                }
        }
}
