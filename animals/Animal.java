package animals;

public abstract class Animal implements AnimalActions {

    protected String name;
    private static int animalCounter;

    protected Animal(String name) {
        this.name = name;
        animalCounter++;
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }
}