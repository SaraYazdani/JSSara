package Lab;

import java.io.Serializable;

public class Pos implements Serializable {
    private int posX, posY;

    public Pos(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String toString() {
        return "Pos de Souris: ( " + posX + ", " + posY + ")" ;
    }
}
