package animals;

public class Dog extends Animal {

    private final int CANRUN = 500;
    private final int CANSWIM = 10;

    public Dog(String name) {
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
        int swimDistance = CANSWIM - distance;
        String result = this.name + " проплыл: ";

        if (swimDistance >= 0) {
            return result + distance + "м. Дистанция пройдена.";
        } else {
            return result + CANSWIM + "м. Дистанция не пройдена.";
        }
    }

}
