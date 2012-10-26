/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;


public class Vorace extends Neuneu {

        public Vorace(int x, int y, Loft l) {
                super(x, y,l);
        }
        
            @Override
    public void bouger() {

        int a = 0, b = 0;
        boolean trouve = false;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (loft.damier[x + i][y + j].contenuCase.get(0) instanceof Nourriture) {
                    a = i;
                    b = j;
                    trouve = true;
                }

            }
        }
        if (!trouve) {
            super.bouger();
        } else {
            this.x += a;
            this.y += b;
        }
    }
}
