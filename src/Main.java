import java.util.Random;

public class Main {
    private final static Random RANDOM = new Random();
    private final static String[] NAMES =
            {"Николай", "Иван", "Пётр", "Павел", "Родион"};
    private final static String[] SURNAMES =
            {"Николаев", "Иванов", "Петров", "Павлов", "Родионов"};
    private final static String[] PATRONYMYC_NAMES =
            {"Николаевич", "Иванович", "Петрович", "Павлович", "Родионович"};
    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMYC_NAMES[RANDOM.nextInt(0, PATRONYMYC_NAMES.length)];
            EMPLOYEES[i] = new Employee(
                    fullName,
                    RANDOM.nextInt(1, 6),
                    RANDOM.nextInt(50_000, 100_000));
        }

    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма з/п сотрудников: " + calculateSumOfSalaries());
        System.out.println("Минимальная з/п сотрудника: " + findEmployeeWithMinSalary());
        System.out.println("Максимальная з/п сотрудника: " + findEmployeeWithMaxSalary());
        System.out.println("Средняя з/п: " + calculateAverageOfSalaries());
        printFullNames();

    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static double calculateAverageOfSalaries() {
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;
    }

    private static void printFullNames() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
}
