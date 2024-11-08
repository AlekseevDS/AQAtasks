public class Employee {
    String name;
    String position;
    String email;
    int phone;
    int age;

    public Employee(String name, String position, String email, int phone, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public void info() {
        System.out.println(name + "\n" + position + "\n" + email + "\n" + phone + "\n" + age);
    }
}
