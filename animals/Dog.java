package animals;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
   public String run(int distance) {
        int canRun = 500;
        int runDistance = canRun - distance;
        String result = name + " пробежал: ";

        if (runDistance >= 0) {
            return result + distance + "м. Дистанция пройдена.";
        } else {
            return result + canRun + "м. Дистанция не пройдена.";
        }
    }

    @Override
    public String swim(int distance) {
        int canSwim = 10;
        int swimDistance = canSwim - distance;
        String result = this.name + " проплыл: ";

        if (swimDistance >= 0) {
            return result + distance + "м. Дистанция пройдена.";
        } else {
            return result + canSwim + "м. Дистанция не пройдена.";
        }
    }

}
