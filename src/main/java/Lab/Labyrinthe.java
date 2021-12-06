package Lab;

import java.util.Map;
import java.util.Stack;

abstract class Labyrinthe {

    private int[][] tableauDeLab;
    protected int posX, posY;

    public Labyrinthe(int[][] tableauDeLab) {
        this.tableauDeLab = tableauDeLab;
    }

    abstract String résoudre();

    abstract boolean résoudreLab(int x, int y);

    protected boolean estValid(int x, int y, int tailleDeLab) {
        if (x < 0 || x >= tailleDeLab) return false;
        if (x < 0 || y >= tailleDeLab) return false;
        if ( tableauDeLab[x][y] != 1 ) return false;

        return true;
    }

    protected boolean estFini(int x, int y, int tailleDeLab, int[][] tableauDeSolution) {
        if ( x == tailleDeLab - 1 && y == tailleDeLab -1 ) {
            tableauDeSolution[x][y] = 1;
            return true;
        }

        return false;
    }

    protected String résultats(int[][] tableauDeSolution, int tailleDeLab) {
        String results = "";
        for(int i = 0; i < tailleDeLab; i++) {
            results += "\n";
            for(int j = 0; j < tailleDeLab; j++) {
                if (tableauDeSolution[i][j] == 1) {
                    results += " X ";

                } else {
                    results += " - ";
                }
            }
        }
        System.out.println(results);
        return results;
    }
}
