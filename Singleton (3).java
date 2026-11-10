package cours.exemple2;

public final class Singleton {
    private static Singleton instance = null;
    public int x;
    public int y;

    private Singleton() {
        super();
    }

    private Singleton(int x2, int y2) {
        this.x = x2;
        this.y = y2;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton getInstance(int x, int y) {
        if (instance == null) {
            instance = new Singleton(x, y);
        }
        return instance;
    }

    public int Somme(int x, int y) {
        return x + y;
    }

    public float moyenne(int x, int y) {
        return Somme(x, y) / 2;
    }

    public int Produit(int x, int y) {
        return x * y;
    }

    public void affiche() {
        System.out.println("\n je suis une instance et mes valeurs sont: x= " + this.x + " et y= " + this.y);
    }

    //redefinir la methode clone pour empecher son utilisation
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
