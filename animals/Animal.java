package animals;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements AnimalActions {

    protected String name;
    private static List<Animal> animalList = new ArrayList<>();

    public enum AnimalsType {CAT, DOG}

    public static List<Animal> getAnimalList() {
        return animalList;
    }

    protected Animal(String name) {
        this.name = name;
        animalList.add(this);
    }

    public static int getAnimalCounter() {
        return animalList.size();
    }

    public static int getAnimalCounter(AnimalsType animalType) {
        int animalCounter = 0;

        switch (animalType) {
            case CAT:
                for (Animal animal : animalList) {
                    if (animal instanceof Cat) {
                        animalCounter++;
                    }
                }
                break;
            case DOG:
                for (Animal animal : animalList) {
                    if (animal instanceof Dog) {
                        animalCounter++;
                    }
                }
                break;
            default:
        }
        return animalCounter;
    }
}