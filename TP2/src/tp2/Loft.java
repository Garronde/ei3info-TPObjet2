/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author garrondeau
 */
public class Loft {

        public Case[][] damier;
        private int w;
        private int h;
        private LinkedList<Neuneu> participants;
        public int TAILLE_CASE_X;
        public int TAILLE_CASE_Y;

        public Loft(int width, int height, int nbParticipants) {
                this.w = width;
                this.h = height;
                damier = new Case[w][h];
                participants = new LinkedList<Neuneu>();
                TAILLE_CASE_X = TP2.TAILLE_FENETRE_X / w;
                TAILLE_CASE_Y = TP2.TAILLE_FENETRE_Y / h;
                //On remplit le damier avec de la nourriture
                for (int i = 0; i < h; i++) {
                        for (int j = 0; j < w; j++) {
                                damier[i][j] = new Case();
                                if (Math.random() < 0.05) {
                                        damier[i][j].contenuCase.add(new Nourriture(i, j, this));
                                } else if (Math.random() < 0.01) {
                                        damier[i][j].contenuCase.add(new Alcool(i, j, this));
                                }
                        }
                }
                //On place ensuite les participants sur le damier en vérifiant qu'ils soient sur une case vide
                for (int i = 0; i < nbParticipants; i++) {
                        int random = (int) (Math.random() * 4) + 1;
                        int x = (int) (Math.random() * (w));
                        int y = (int) (Math.random() * (h));
                        while (!damier[x][y].contenuCase.isEmpty()) {
                                x = (int) (Math.random() * (w));
                                y = (int) (Math.random() * (h));
                        }
                        Neuneu fils = null;
                        switch (random) {
                                case 1:
                                        fils = new Vorace(x, y, this);
                                        break;
                                case 2:
                                        fils = new Erratique(x, y, this);
                                        break;
                                case 3:
                                        fils = new Cannibale(x, y, this);
                                        break;
                                case 4:
                                        fils = new Lapin(x, y, this);
                                        break;
                        }
                        participants.add(fils);
                }
        }

        public void afficheLoft(ZoneGraphique fenetre) {
                LinkedList<ObjetDessinable> listeObjets = new LinkedList<ObjetDessinable>();
                for (int i = 0; i < h; i++) {
                        for (int j = 0; j < w; j++) {
                                if (!(damier[i][j].contenuCase.isEmpty())) {
                                        fenetre.ajouterObjet(damier[i][j].contenuCase.get(0));
                                }
                        }
                }
                fenetre.repaint();
        }

        public void tourDeJeu() {
                for (int i = 0; i < participants.size(); i++) {
                        Neuneu lofteur = participants.get(i);
                        lofteur.bouger();
                        int x = lofteur.getX();
                        int y = lofteur.getY();
                        Case caseCourante = damier[x][y];
                        if (!caseCourante.contenuCase.contains(lofteur)) {
                                caseCourante.contenuCase.add(lofteur);
                        }
                        //Si on tombe sur de la nourriture, on la mange
                        if (caseCourante.contenuCase.get(0) instanceof Nourriture /*|| caseCourante.contenuCase.get(0) instanceof Alcool*/) {
                                lofteur.manger((Nourriture) caseCourante.contenuCase.get(0));
                                caseCourante.contenuCase.remove(0);
                        } else //Si on tombe sur un lofteur, on se reproduit avec
                        if (caseCourante.contenuCase.get(0) instanceof Neuneu) {
                                if (lofteur instanceof Cannibale && caseCourante.contenuCase.get(0) != lofteur) {
                                        int random = (int) Math.random();
                                        if (random < 0.5) {
                                                ((Cannibale) lofteur).mangerLofteur((Neuneu) caseCourante.contenuCase.get(0));
                                        } else {
                                                lofteur.seReproduire((Neuneu) caseCourante.contenuCase.get(0));
                                        }
                                } else if (caseCourante.contenuCase.get(0) != lofteur) {
                                        lofteur.seReproduire((Neuneu) caseCourante.contenuCase.get(0));
                                }
                        }
                }
        }

        public void addParticipant(Neuneu nveauParticipant) {
                participants.add(nveauParticipant);
                int x = nveauParticipant.getX();
                int y = nveauParticipant.getY();
                damier[x][y].contenuCase.add(nveauParticipant);
        }

        public void removeParticipant(Neuneu participantMort) {
                int x = participantMort.getX();
                int y = participantMort.getY();
                participants.remove(participantMort);
                damier[x][y].contenuCase.remove(participantMort);
                System.out.println("Contenu case " + x + " " + y + damier[x][y].contenuCase);
        }

        int getW() {
                return w;
        }

        int getH() {
                return h;
        }

        public List<Neuneu> getParticipants() {
                return participants;
        }
}
