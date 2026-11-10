package cours.exemple1;

public final class Singleton {
    private static Singleton instance = null;
    // D'autres attributs, classiques et non "static".
    private String attribut1;
    private int attribut2;

    // Constructeur de l'objet.
    private Singleton() {
        // La presence d'un constructeur prive supprime le constructeur public par defaut.
        super();
    }

    // Methode renvoyant une instance de la classe Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // D'autres methodes classiques et non "static".
    public void op1(int x, int y, int z) {
        this.attribut1 = "bonjour";
        this.attribut2 = x + y + z;
        System.out.println("op1 : attribut1=" + attribut1 + ", attribut2=" + attribut2);
    }

    public void op2(int x, int y, int z) {
        System.out.println("op2 : meme instance ? attribut1=" + attribut1);
    }
}
