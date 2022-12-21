public class Employee extends Person{

    int months_worked;
    double salary;

    public Employee(String name, int age, int months_worked, double salary) {
        super(name, age);
        this.months_worked = months_worked;
        this.salary = salary;
    }

    public class thirteenthMonth {
        double thM = salary/(12/months_worked);

    }
}
