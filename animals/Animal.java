package animals;

public abstract class Animal implements AnimalActions {
    private static int animalCounter = 0;

    private String name;

    public Animal(String name) {
        this.name = name;
        animalCounter++;
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }
}
