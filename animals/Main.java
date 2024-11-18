package animals;

public class Main {

    public static void main(String[] args) {

        Animal[] animalsArray = {
                new Cat("Cat Tom"),
                new Cat("Cat Tom"),
                new Cat("Cat Max"),
                new Cat("Cat Mo"),
                new Dog("Dog Stan"),
                new Dog("Dog Lee"),
                new Dog("Dog Fin"),
                new Dog("Dog Luck")
        };

        System.out.println("Животных: " + Animal.getAnimalCounter());
        System.out.println("Котов: " + Cat.getCatCounter());
        System.out.println("Собак: " + Dog.getDogCounter());

        //Проверка животных на дистанции 100м
        for (Animal animal : animalsArray) {
            System.out.println(animal.run(100));
            System.out.println(animal.swim(100));
        }

        //Проверка животных на дистанции 1000м
        for (Animal animal : animalsArray) {
            System.out.println(animal.run(1000));
            System.out.println(animal.swim(1000));
        }

        //Кормление котов
        Bowl bowlForCat = new Bowl(40);

        for (Animal animal : animalsArray) {
            if (animal instanceof Cat) {
                ((Cat) animal).eat(bowlForCat);
                System.out.println(animal.name + " satiety status: " + ((Cat) animal).isSatiety());
                System.out.println("Осталось в миске: " + bowlForCat.getFoodAmount());
            }
        }

        //Пополнения миски
        bowlForCat.changeBowlAmount(100);
        System.out.println("Осталось в миске: " + bowlForCat.getFoodAmount());
    }
}