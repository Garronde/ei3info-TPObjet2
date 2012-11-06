package tp2;

import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tony MARTIN
 */
public abstract class Neuneu implements ObjetDessinable {

        protected int energie;
        protected int x;
        protected int y;
        protected Loft loft;

        public int getEnergie() {
                return energie;
        }

        public int getX() {
                return x;
        }

        public int getY() {
                return y;
        }

        public Neuneu(int x, int y, Loft l) {
                energie = 100;
                this.x = x;
                this.y = y;
                loft = l;
        }

        public void bouger() {
                int i = (int) (Math.random() * 2 + 1);
                if (i == 1 && x != 0) {
                        x--;
                }
                if (i == 3 && x != loft.getW() - 1) {
                        x++;
                }
                int j = (int) (Math.random() * 2 + 1);
                if (j == 1 && y != 0) {
                        y--;

                }
                if (j == 3 && y != loft.getH() - 1) {
                        y++;
                }
        }

        public void manger(Nourriture n) {
                energie = n.energie + energie;
                if (energie > 100) {
                        energie = 100;
                }
        }

        public void seReproduire(Neuneu partenaire) {
                if (this.energie > 45 && partenaire.energie > 45) /*S'il ont assez d'energie (>45) ils font un fils
                 * */ {
                        int random = (int) (Math.random() * 4) + 1;
                        Neuneu fils = null;
                        switch (random) {
                                case 1:
                                        fils = new Vorace(x, y, loft);
                                        break;
                                case 2:
                                        fils = new Erratique(x, y, loft);
                                        break;
                                case 3:
                                        fils = new Cannibale(x, y, loft);
                                        break;
                                case 4:
                                        fils = new Lapin(x, y, loft);
                                        break;
                        }
                        energie -= 45;
                        partenaire.energie -= 45;
                        loft.addParticipant(fils);
                }
                if (this.energie <= 45) {
                        /* tuer le neueneu
                         */
                        loft.removeParticipant(this);
                }
                if (partenaire.energie <= 45) {
                        /* tuer le partenaire
                         */
                        loft.removeParticipant(partenaire);
                }
        }

        @Override
        public void dessinerObjet(Graphics g) {
                g.fillRect(x * loft.TAILLE_CASE_X, y * loft.TAILLE_CASE_Y, loft.TAILLE_CASE_X, loft.TAILLE_CASE_Y);
        }
}
