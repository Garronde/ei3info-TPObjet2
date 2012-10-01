/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.List;

/**
 *
 * @author garrondeau
 */
public class Loft {

        private Case[][] damier;
        private int w;
        private int h;
        private List<Neuneu> participants;

        public Loft(int width, int height, int nbParticipants) {
                this.w = width;
                this.h = height;

                for (int i = 0; i < h; i++) {
                        for (int j = 0; j < w; j++) {
                                damier[i][j] = new Case();
                                if (Math.random() < 0.05) {
                                        damier[i][j].contenuCase.add(new Nourriture());
                                } else if(Math.random() < 0.01) {
                                        damier[i][j].contenuCase.add(new Alcool());
                                }
                        }
                }
                
                for (int i = 0; i < nbParticipants; i++) {
                        
                        participants.add(null);
                }
        }

        public void afficheLoft() {
        }

        public void tourDeJeu() {
        }

        public void addParticipant(Neuneu nveauParticipant) {
        }
}
