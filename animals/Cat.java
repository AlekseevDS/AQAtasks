package animals;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String run(int distance) {
        int canRun = 200;
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
        return this.name + " не умеет плавать.";
    }
}
