public class Employee extends Person{
    private int months_worked;
    private double salary;

    public Employee(String name, int age, int months_worked, double salary) {
        super(name, age);
        this.months_worked = months_worked;
        this.salary = salary;
    }

    public class thirteenthMonth {
        double thM = salary/(12/months_worked);
    }
    public int getMonths_worked() {
        return months_worked;
    }

    public double getSalary() {
        return salary;
    }

}
