import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }
}

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, String description) {
        Task task = new Task(title, description);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        System.out.println("Task List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getTitle() + " - " + task.getDescription() +
                    " (Completed: " + task.isCompleted() + ")");
        }
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Task task = tasks.get(taskIndex - 1);
            task.markAsCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void deleteTask(int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            tasks.remove(taskIndex - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(title, description);
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task index to mark as completed: ");
                    int markIndex = scanner.nextInt();
                    taskManager.markTaskAsCompleted(markIndex);
                    break;
                case 4:
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    taskManager.deleteTask(deleteIndex);
                    break;
                case 5:
                    System.out.println("Task Manager application closed. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
