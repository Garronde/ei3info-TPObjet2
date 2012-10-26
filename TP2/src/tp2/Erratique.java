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

    public void dessinerObjet(Graphics g) {
        g.setColor(Color.green);
    }
}
