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
                double i = Math.random();

                if (i < 0.45 && x != 0) {
                        x--;
                }
                if (i > 0.55 && x != loft.getW() - 1) {
                        x++;
                }
                double j = Math.random();
                if (j < 0.45 && y != 0) {
                        y--;

                }
                if (j > 0.55 && y != loft.getH() - 1) {
                        y++;
                }
        }

        public void manger(Nourriture n) {
                energie = n.energie + energie;
                if (energie > 100) {
                        energie = 100;
                }
                System.out.println(this + " vient de manger " + n);
                n.detruire();
        }

        public void seReproduire(Neuneu partenaire) {

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
                System.out.println(this + " et " + partenaire + " viennent de se reproduire.");
                loft.addParticipant(fils);
                System.out.println(fils + "est né.");

                if (this.energie <= 0) {
                        /* tuer le neueneu
                         */
                        loft.removeParticipant(this);
                        System.out.println(this + " vient de mourir !");
                }
                if (partenaire.energie <= 0) {
                        /* tuer le partenaire
                         */
                        loft.removeParticipant(partenaire);
                        System.out.println(partenaire + " vient de mourir !");
                }
        }

        @Override
        public void dessinerObjet(Graphics g) {
                System.out.println("dessiner neuneu");
                g.fillRect(x * loft.TAILLE_CASE_X, y * loft.TAILLE_CASE_Y, loft.TAILLE_CASE_X, loft.TAILLE_CASE_Y);
        }
}
