package animals;

public class Dog extends Animal {

    private static int dogCounter = 0;
    private final int CANRUN = 200;
    private final int CANSWIM = 0;

    public Dog(String name) {
        super(name);
        dogCounter++;
    }

    public static int getDogCounter() {
        return dogCounter;
    }

    @Override
    public void run(int distance) {

    }

    @Override
    public void swim(int distance) {

    }
}
