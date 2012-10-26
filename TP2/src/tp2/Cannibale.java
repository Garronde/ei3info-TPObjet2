/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

public class Cannibale extends Neuneu {

    public Cannibale(int x, int y, Loft l) {
        super(x, y, l);
    }

    @Override
    public void bouger() {
    }

    public void manger(Neuneu v) {
        energie = v.energie + energie;
        if (energie > 100) {
            energie = 100;
            /* il faut tuer le Neuneu victime v*/
        }

    }
}
