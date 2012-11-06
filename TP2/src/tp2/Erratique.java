/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.awt.Color;
import java.awt.Graphics;

public class Erratique extends Neuneu {

        public Erratique(int x, int y, Loft l) {
                super(x, y, l);

        }

        @Override
        public void dessinerObjet(Graphics g) {
                super.dessinerObjet(g);
                g.setColor(Color.green);
        }

        @Override
        public void bouger() {
                super.bouger();
        }
}