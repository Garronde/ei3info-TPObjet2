/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.awt.Color;
import java.awt.Graphics;

public class Alcool extends Nourriture {

        public Alcool(int x, int y, Loft loft) {
                super(x, y, loft);
                energie = 25;
        }

        @Override
        public void dessinerObjet(Graphics g) {
                super.dessinerObjet(g);
                g.setColor(Color.orange);
        }
}
