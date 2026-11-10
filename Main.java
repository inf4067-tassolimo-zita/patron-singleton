package cours.exemple1;

public class Main {
    public static void main(String[] args) {
        //----------------utilisation possible----------------
        Singleton.getInstance().op1(1, 2, 3);
        Singleton.getInstance().op2(3, 4, 5);
        //autre facon
        Singleton singl = Singleton.getInstance();
        singl.op1(1, 2, 3);
        singl.op2(3, 4, 5);
        System.out.println("Meme instance : " + (singl == Singleton.getInstance()));
    }
}
