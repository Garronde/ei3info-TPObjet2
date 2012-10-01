/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

public class Erratique extends Neuneu {


        public Erratique(int x, int y, Loft l) {
                super(x, y, l);

    }

    @Override
    public void bouger() {
        int i = (int) (Math.random() * 3 + 1);
        if (i == 1 && x != 0) {
            x = x - 1;
        }
        if (i == 3 && x != Loft.w - 1) {
            x = x + 1;
        }
        int j = (int) (Math.random() * 3 + 1);
        if (j == 1 && y != 0) {
            y = y - 1;

        }
        if (j == 3 && y != Loft.h - 1) {
            y = y + 1;
        }
    }
}
