public class Main {

    public static void main(String[] args) {

        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Peter", "Director", "p.jackson@gmail.com", 77865464, 40);
        employeesArray[1] = new Employee("John", "Developer", "j.sally@gmail.com", 77865432, 29);
        employeesArray[2] = new Employee("Jakob", "QA Engineer", "j.moris@gmail.com", 77865445, 26);
        employeesArray[3] = new Employee("Anna", "Developer", "a.ferk@gmail.com", 77865456, 28);
        employeesArray[4] = new Employee("Kate", "Manager", "k.amali@gmail.com", 77865487, 32);

        //проверка метода info()
        for (Employee person : employeesArray) {
            person.info();
            System.out.println();
        }

        //создание объекта Attraction
        Park.Attraction rollerCoaster = new Park().new Attraction("Roller Coaster", "Mo-Fr 9-20", 40);
    }
}
