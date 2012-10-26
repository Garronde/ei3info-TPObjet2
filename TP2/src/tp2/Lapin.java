/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

public class Lapin extends Neuneu {

    public Lapin(int x, int y, Loft l) {
        super(x, y, l);
    }

    @Override
    public void bouger() {
      
            int a, b;
            boolean trouve = false;
            for (i = -1; i++; i <= 1) {
                for (j = -1; j++; j <= 1) {
                    if ((0 <= this.x + i) && (this.x + i <= loft.getW()) && (0 <= this.x + i) && (this.x + i <= 99)) {
                        if (damier[x + i][y + j].contenuCase.get(0) instanceof Neuneu) {
                            a = i;
                            b = j;
                            trouve = true;
                        }
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
}
        
}
