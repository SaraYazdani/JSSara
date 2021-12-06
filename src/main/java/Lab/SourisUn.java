package Lab;

/**
 * Intelligence comportementale de Souris 1
 * */

public class SourisUn extends Labyrinthe {

    private int[][] tableauDeSolution;
    private int tailleDeLab;
    private ReglesSingleton rs;
    private int[] pos = new int[2];

    public SourisUn(int[][] tableauDeLab) {
        super(tableauDeLab);
        this.tailleDeLab = tableauDeLab.length;
        this.tableauDeSolution = new int[tailleDeLab][tailleDeLab];

    }

    @Override
    public String résoudre() {
        if(résoudreLab(0,0)) {
            return résultats(tableauDeSolution, tailleDeLab);
        } else {
            return "Pas de solution pour Souris Un :(";
        }
    }

    @Override
    boolean résoudreLab(int x, int y) {
        if (estFini(x,y, tailleDeLab, tableauDeSolution)) {
            return true;
        }
        if (estValid(x,y, tailleDeLab)) {
            tableauDeSolution[x][y] = 1;
            if (résoudreLab(x+1, y)) {
                return true;
            }

            if (résoudreLab(x, y+1)) {
                return true;
            }

            tableauDeSolution[x][y] = 0;
        }
        return false;
    }
}
