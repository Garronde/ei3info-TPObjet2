package tp2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tony MARTIN
 */
public abstract class Neuneu {

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
        }

        public void manger(Nourriture n) {
        }

        public Neuneu seReproduire(Neuneu partenaire) {
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
                return fils;
        }
}
