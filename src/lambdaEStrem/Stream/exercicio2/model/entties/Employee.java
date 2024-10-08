package lambdaEStrem.Stream.exercicio2.model.entties;

public class Employee {

    private String name;
    private String email;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + ", " + email + ", " + String.format("%.2f", salary);
    }
}
