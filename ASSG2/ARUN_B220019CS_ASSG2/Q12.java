import java.util.*;

public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("Select the operation:");
            System.out.println("1: Add a new task");
            System.out.println("2: Process the highest priority task");
            System.out.println("3: Display all tasks");
            System.out.println("4: Exit");

            int operation = sc.nextInt();
            sc.nextLine();

            switch (operation) {
                case 1:
                    System.out.println("Enter task priority and description:");
                    int priority = sc.nextInt();
                    sc.nextLine(); 
                    String description = sc.nextLine();
                    manager.addTask(new Task(priority, description));
                    break;
                case 2:
                    Task processedTask = manager.processTask();
                    if (processedTask != null) {
                        System.out.println("Processed Task: " + processedTask);
                    } else {
                        System.out.println("No tasks to process.");
                    }
                    break;
                case 3:
                    manager.displayTasks();
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

class TaskManager {
    private PriorityQueue<Task> taskQueue = new PriorityQueue<>();

    public void addTask(Task task) {
        taskQueue.add(task);
        System.out.println("Task added successfully.");
    }

    public Task processTask() {
        return taskQueue.poll(); 
    }

    public void displayTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Current tasks in the queue:");
            for (Task task : taskQueue) {
                System.out.println(task);
            }
        }
    }
}

class Task implements Comparable<Task> {
    private int priority;
    private String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "Priority: " + priority + ", Description: " + description;
    }
}
