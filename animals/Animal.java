package animals;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements AnimalActions {

    protected String name;
    protected int CANRUN;
    protected int CANSWIM;
    private static List<Animal> animalList = new ArrayList<>();
    public enum AnimalsType {CAT, DOG;}

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

    public static int getCatCounter() {
        int catCounter = 0;

        for (Animal animal : animalList) {
            if (animal instanceof Cat) {
                catCounter++;
            }
        }
        return catCounter;
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

    public String run(int distance) {
        int runDistance = this.CANRUN - distance;
        String result = this.name + " пробежал: ";

        if (runDistance >= 0) {
            return result + distance;
        } else {
            return result + this.CANRUN;
        }
    }

    public String swim(int distance) {
            if (this instanceof Dog) {
                int swimDistance = CANSWIM - distance;
                String result = this.name + " проплыл: ";

                if (swimDistance >= 0) {
                    return result + distance;
                } else {
                    return result + CANSWIM;
                }
            } else return this.name + " can't swim.";
    }


}
