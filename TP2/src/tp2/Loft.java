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
                //On remplit le damier avec de la nourriture
                for (int i = 0; i < h; i++) {
                        for (int j = 0; j < w; j++) {
                                damier[i][j] = new Case();
                                if (Math.random() < 0.05) {
                                        damier[i][j].contenuCase.add(new Nourriture());
                                } else if (Math.random() < 0.01) {
                                        damier[i][j].contenuCase.add(new Alcool());
                                }
                        }
                }
                //On place ensuite les participants sur le damier en vérifiant qu'ils soient sur une case vide
                for (int i = 0; i < nbParticipants; i++) {
                        int random = (int) (Math.random() * 4) + 1;
                        int x = (int) (Math.random() * (w));
                        int y = (int) (Math.random() * (h));
                        while (!damier[x][y].contenuCase.isEmpty()) {
                                x = (int) (Math.random() * (w));
                                y = (int) (Math.random() * (h));
                        }
                        Neuneu fils = null;
                        switch (random) {
                                case 1:
                                        fils = new Vorace(x, y, this);
                                        break;
                                case 2:
                                        fils = new Erratique(x, y, this);
                                        break;
                                case 3:
                                        fils = new Cannibale(x, y, this);
                                        break;
                                case 4:
                                        fils = new Lapin(x, y, this);
                                        break;
                        }
                        participants.add(fils);
                }
        }

        public void afficheLoft() {
        }

        public void tourDeJeu() {
                for (int i = 0; i < participants.size(); i++) {
                        Neuneu lofteur = participants.get(i);
                        lofteur.bouger();
                        int x = lofteur.getX();
                        int y = lofteur.getY();
                        Case caseCourante = damier[x][y];
                        if (caseCourante.contenuCase.get(0) instanceof Nourriture) {
                                caseCourante.contenuCase.remove(0);
                                caseCourante.contenuCase.add(lofteur);
                                lofteur.manger((Nourriture) caseCourante.contenuCase.get(0));
                        }
                }
        }

        public void addParticipant(Neuneu nveauParticipant) {
        }

        int getW() {
                return w;
        }

        int getH() {
                return h;
        }
}
