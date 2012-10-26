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
public class Nourriture {

    protected int energie;

    public Nourriture() {
        energie = 55;
    }

    public void dessinerObjet(Graphics g) {
        g.setColor(Color.black);
    }
}
