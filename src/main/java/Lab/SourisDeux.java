package Lab;

/**
 * Intelligence comportementale de Souris 2
 * */

public class SourisDeux extends Labyrinthe{

    private int[][] tableauDeSolution;
    private int tailleDeLab;

    public SourisDeux(int[][] tableauDeLab) {
        super(tableauDeLab);
        this.tailleDeLab = tableauDeLab.length;
        this.tableauDeSolution = new int[tailleDeLab][tailleDeLab];
    }

    @Override
    public String résoudre() {
        if(résoudreLab(0, 0)) {
            return résultats(tableauDeSolution, tailleDeLab);
        } else {
            return  "Souris 2 n'a ba réussit :(";
        }
    }

    @Override
    boolean résoudreLab(int x, int y) {
        if (estFini(x,y, tailleDeLab, tableauDeSolution)) {
            return true;
        }
        if (estValid(x,y, tailleDeLab)) {
            tableauDeSolution[x][y] = 1;
            if (résoudreLab(x, y+1)) {
                return true;
            }

            if (résoudreLab(x+1, y)) {
                return true;
            }

            tableauDeSolution[x][y] = 0;
        }
        return false;
    }
}