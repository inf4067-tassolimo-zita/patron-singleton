package modifie.singleton;

/**
 * Exemple modifie : Singleton thread-safe (double verification + volatile),
 * avec une valeur initialisee une seule fois et une moyenne corrigee.
 */
public final class Singleton {
    // volatile : garantit que tous les threads voient l'instance completement construite
    private static volatile Singleton instance = null;
    private static int nbCreations = 0;
    private final int x;
    private final int y;

    private Singleton(int x, int y) {
        this.x = x;
        this.y = y;
        nbCreations++;
    }

    public static Singleton getInstance() {
        return getInstance(0, 0);
    }

    public static Singleton getInstance(int x, int y) {
        if (instance == null) {                    // 1re verification (sans verrou)
            synchronized (Singleton.class) {
                if (instance == null) {            // 2e verification (avec verrou)
                    instance = new Singleton(x, y);
                }
            }
        }
        return instance;
    }

    public static int getNbCreations() {
        return nbCreations;
    }

    public int somme(int a, int b) {
        return a + b;
    }

    public float moyenne(int a, int b) {
        return somme(a, b) / 2.0f;   // division reelle (corrige la division entiere)
    }

    public int produit(int a, int b) {
        return a * b;
    }

    public void affiche() {
        System.out.println("instance@" + Integer.toHexString(System.identityHashCode(this))
                + " : x= " + x + " et y= " + y);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Le Singleton ne peut pas etre clone");
    }
}
