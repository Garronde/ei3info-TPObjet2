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

        private int energie;
        private int x;
        private int y;

        public int getEnergie() {
                return energie;
        }

        public int getX() {
                return x;
        }

        public int getY() {
                return y;
        }

        public Neuneu(int x, int y) {
                energie = 100;
                this.x = x;
                this.y = y;
        }

        public void bouger() {
        }

        public void (Nourriture n) {
        }

        public Neuneu seReproduire(Neuneu partenaire) {
                int lower = 1;
                int higher = 5;
                int random = (int) (Math.random() * (higher - lower)) + lower;
                switch (random) {
                        case 1:
                                Vorace fils = new Vorace(x, y);
                                break;
                        case 2:
                                Erratique fils = new Erratique(x, y);
                                break;
                        case 3:
                                Cannibale fils = new Cannibale(x, y);
                                break;
                        case 4:
                                Lapin fils = new Lapin(x, y);
                                break;
                }
                return fils;
        }
}
