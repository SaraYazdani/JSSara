package Lab;

public class ReglesSingleton {

    private int physique1 = 10;
    private int psychologique1 = 10;

    private int nombreDeMov1;
    private int posX1;
    private int posY1;

    private int physique2 = 10;
    private int psychologique2 = 10;

    private int nombreDeMov2;
    private int posX2;
    private int posY2;

    private static volatile ReglesSingleton innerInstance = null;
    private ReglesSingleton() {
    }

    public void updateRèglesSingleton(int posX1, int posY1, int nombreDeMov1, int posX2, int posY2, int nombreDeMov2) {
        this.posX1 = posX1;
        this.posY1 = posY1;
        this.nombreDeMov1 = nombreDeMov1;

        this.posX2 = posX2;
        this.nombreDeMov2 = nombreDeMov2;
    }

    public void étatPhy(boolean fromage) {
        if (nombreDeMov1 == 10 && fromage) {
            this.physique1 -= 1;
        }

        if (fromage) {
            this.physique1 += 3;
        }

        if (nombreDeMov2 == 10 && fromage) {
            this.physique2 -= 1;
        }

        if (fromage) {
            this.physique2 += 3;
        }
    }

    public void étatPsy(int posXS1, int posXS2, int posYS1, int posYS2) {
    int distanceX = Math.abs(posXS1 - posXS2);
    int distanceY = Math.abs(posYS1 - posYS2);

    if ((distanceY > 5 && distanceX > 5) &&
            this.nombreDeMov1 % 5 == 0){
        this.psychologique1 -= 1;
        this.psychologique2 -= 1;
    }

    if(distanceY <= 3 && distanceX <= 3) {
        this.psychologique1 = 10;
        this.psychologique2 = 10;
    }
}

    public String report() {
        return "Etat physique de s1: " + physique1
                + "\nEtat physique de s2: " + physique2
                + "\nEtat sycholoqiue de s1: " + psychologique1
                +  "\nEtat sycholoqiue de s1: " + psychologique2;
    }

    public static ReglesSingleton getInstance() {
        if (innerInstance == null ) {
            synchronized(ReglesSingleton.class) {
                if (innerInstance == null){
                    innerInstance = new ReglesSingleton();
                }
            }
        }
        return innerInstance;
    }
}
