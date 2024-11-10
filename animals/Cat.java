package animals;

public class Cat extends Animal {

    private static int catCounter = 0;
    private final int CANRUN = 200;
    private final int CANSWIM = 0;


    public Cat(String name) {
        super(name);
        catCounter++;
    }

    public static int getCatCounter() {
        return catCounter;
    }

    @Override
    public void run(int distance) {

    }

    @Override
    public void swim(int distance) {

    }
}
