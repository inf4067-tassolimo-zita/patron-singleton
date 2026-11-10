package modifie.singleton;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestSingleton {
    public static void main(String[] args) throws InterruptedException {
        // 10 threads demandent l'instance en meme temps
        Set<Singleton> instances = ConcurrentHashMap.newKeySet();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int v = i;
            threads[i] = new Thread(() -> instances.add(Singleton.getInstance(v, v * 10)));
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Instances distinctes obtenues : " + instances.size());
        System.out.println("Nombre de creations : " + Singleton.getNbCreations());

        Singleton s = Singleton.getInstance();
        s.affiche();
        System.out.println("somme(2,5) = " + s.somme(2, 5));
        System.out.println("moyenne(2,5) = " + s.moyenne(2, 5));
        System.out.println("produit(2,5) = " + s.produit(2, 5));
        try {
            s.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("clone() refuse : " + e.getMessage());
        }
    }
}
