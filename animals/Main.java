package animals;

public class Main {

    public static void main(String[] args) {


        Cat cat1 = new Cat("Cat Tom");
        Cat cat2 = new Cat("Cat Max");
        Dog dog1 = new Dog("Dog Stan");
        Dog dog2 = new Dog("Dog Lee");
        Dog dog3 = new Dog("Dog Fin");

        System.out.println("All: " + Animal.getAnimalCounter());
        System.out.println("CAT: " + Animal.getAnimalCounter(Animal.AnimalsType.CAT));
        System.out.println("DOG: " + Animal.getAnimalCounter(Animal.AnimalsType.DOG));

        //Проверка животных на дистанции 100м
        for (Animal animal : Animal.getAnimalList()) {
            System.out.println(animal.run(100));
            System.out.println(animal.swim(100));
        }

        //Проверка животных на дистанции 1000м
        for (Animal animal : Animal.getAnimalList()) {
            System.out.println(animal.run(1000));
            System.out.println(animal.swim(1000));
        }






    }









}
