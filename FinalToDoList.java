import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    String time;
    boolean isCompleted;

    public Task(String description, String time) {
        this.description = description;
        this.time = time;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return description + " [Time: " + time + "]" + (isCompleted ? " ✔️ (Completed)" : "");
    }
}

public class FinalToDoList {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addTask() {
        System.out.print("Enter task description: ");
        String desc = sc.nextLine();
        System.out.print("Enter time for the task (e.g., 24-07-2025 15:00): ");
        String time = sc.nextLine();
        tasks.add(new Task(desc, time));
        System.out.println("✅ Task added.\n");
    }

    public static void deleteTask() {
        displayTasks();
        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("🗑️ Task deleted.\n");
        } else {
            System.out.println("❌ Invalid task number.\n");
        }
    }

    public static void displayTasks() {
        System.out.println("\n📋 --- To-Do List ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.\n");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println();
        }
    }

    public static void markTaskComplete() {
        displayTasks();
        System.out.print("Enter task number to mark as complete: ");
        int index = sc.nextInt();
        sc.nextLine();

        
        if (index > 0 && index <= tasks.size()) {
            tasks.get(index - 1).isCompleted = true;
            System.out.println("✅ Task marked as complete.\n");
        } else {
            System.out.println("❌ Invalid task number.\n");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("📌 To-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addTask(); break;
                case 2: deleteTask(); break;
                case 3: displayTasks(); break;
                case 4: markTaskComplete(); break;
                case 5: System.out.println("👋 Goodbye!"); break;
                default: System.out.println("❗ Invalid choice.\n");
            }
        } while (choice != 5);
    }
}


