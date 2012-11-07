/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.awt.Color;
import java.awt.Graphics;

public class Vorace extends Neuneu {

        public Vorace(int x, int y, Loft l) {
                super(x, y, l);
        }

        @Override
        public void bouger() {

                int a = 0, b = 0;
                boolean trouve = false;
                for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {

                                if ((x + i) > -1 && (y + j) > -1 && (x + i) < loft.getW() && (y + j) < loft.getH() && !loft.damier[x + i][y + j].contenuCase.isEmpty() && loft.damier[x + i][y + j].contenuCase.get(0) instanceof Nourriture) {
                                        a = i;
                                        b = j;
                                        trouve = true;
                                }

                        }
                }
                if (trouve) {
                        this.x += a;
                        this.y += b;
                } else {
                        super.bouger();

                }
        }

        @Override
        public void dessinerObjet(Graphics g) {
                super.dessinerObjet(g);
                g.setColor(Color.yellow);
        }
}
