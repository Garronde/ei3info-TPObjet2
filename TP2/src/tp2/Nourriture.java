/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author garrondeau
 */
public class Nourriture implements ObjetDessinable {

        protected int energie;
        protected Loft loft;
        protected int x;
        protected int y;

        public Nourriture(int x, int y, Loft l) {
                energie = 55;
                loft = l;
                this.x = x;
                this.y = y;
        }

        @Override
        public void dessinerObjet(Graphics g) {
                g.fillOval(x * loft.TAILLE_CASE_X, y * loft.TAILLE_CASE_Y, loft.TAILLE_CASE_X, loft.TAILLE_CASE_Y);
                g.setColor(Color.black);
        }
}
