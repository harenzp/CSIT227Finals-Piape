public class Clerk extends Employee{
    public Clerk(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        System.out.println("How may I help you?");
        return super.toString();
    }
}
