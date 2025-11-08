package fundamentals;

import java.util.ArrayList;
import java.util.Scanner;

// Employee1 class to store employee details
class Employee1 {
    int id;
    String name;
    String department;
    double salary;

    Employee1(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("---------------------------------");
        System.out.println("Employee ID      : " + id);
        System.out.println("Name             : " + name);
        System.out.println("Department       : " + department);
        System.out.println("Salary           : ₹" + salary);
    }
}

// Main system class
public class EmployeeManagementSystem {

    static ArrayList<Employee1> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========= EMPLOYEE MANAGEMENT SYSTEM =========");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> System.out.println("✅ Exiting System... Goodbye!");
                default -> System.out.println("❌ Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    // 1️⃣ Add Employee
    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee1 emp = new Employee1(id, name, dept, salary);
        employees.add(emp);
        System.out.println("✅ Employee added successfully!");
    }

    // 2️⃣ View All Employees
    public static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("⚠️ No employees to display.");
        } else {
            System.out.println("\n----- Employee List -----");
            for (Employee1 e : employees) {
                e.display();
            }
        }
    }

    // 3️⃣ Search Employee
    public static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Employee1 e : employees) {
            if (e.id == id) {
                e.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Employee not found!");
        }
    }

    // 4️⃣ Update Employee
    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Employee1 e : employees) {
            if (e.id == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new Name: ");
                e.name = sc.nextLine();

                System.out.print("Enter new Department: ");
                e.department = sc.nextLine();

                System.out.print("Enter new Salary: ");
                e.salary = sc.nextDouble();

                System.out.println("✅ Employee details updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Employee not found!");
        }
    }

    // 5️⃣ Delete Employee
    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Employee1 e : employees) {
            if (e.id == id) {
                employees.remove(e);
                System.out.println("🗑️ Employee deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Employee not found!");
        }
    }
}