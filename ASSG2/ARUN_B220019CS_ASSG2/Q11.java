import java.util.*;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            System.out.println("Select the operation:");
            System.out.println("1: Add a new employee ID");
            System.out.println("2: Remove an employee ID");
            System.out.println("3: Display all employee IDs");
            System.out.println("4: Exit");

            int operation = sc.nextInt();
            sc.nextLine(); 
            
            switch (operation) {
                case 1:
                    System.out.println("Enter the employee ID:");
                    int idToAdd = sc.nextInt();
                    if (manager.addEmployeeId(idToAdd)) {
                        System.out.println("Employee ID added successfully.");
                    } else {
                        System.out.println("Employee ID already exists.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the employee ID:");
                    int idToRemove = sc.nextInt();
                    if (manager.removeEmployeeId(idToRemove)) {
                        System.out.println("Employee ID removed successfully.");
                    } else {
                        System.out.println("Employee ID not found.");
                    }
                    break;
                case 3:
                    manager.displayEmployeeIds();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        }
    }
}

class EmployeeManager {
    private Set<Integer> employeeIds = new HashSet<>();

    public boolean addEmployeeId(int id) {
        return employeeIds.add(id);
    }

    public boolean removeEmployeeId(int id) {
        return employeeIds.remove(id);
    }

    public void displayEmployeeIds() {
        if (employeeIds.isEmpty()) {
            System.out.println("No employee IDs available.");
        } else {
            System.out.println("List of employee IDs:");
            for (int id : employeeIds) {
                System.out.println(id);
            }
        }
    }
}


