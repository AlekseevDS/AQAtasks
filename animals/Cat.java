package animals;

public class Cat extends Animal {

    private final int CANRUN = 200;
    private final int CANSWIM = 0;

    public Cat(String name) {
        super(name);
    }

    @Override
    public String run(int distance) {
        int runDistance = CANRUN - distance;
        String result = name + " пробежал: ";

        if (runDistance >= 0) {
            return result + distance + "м. Дистанция пройдена.";
        } else {
            return result + CANRUN + "м. Дистанция не пройдена.";
        }
    }

    @Override
    public String swim(int distance) {
        return this.name + " не умеет плавать.";
    }
}
