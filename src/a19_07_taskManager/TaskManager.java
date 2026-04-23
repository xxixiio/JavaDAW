package a19_07_taskManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        String[] values = {
                "Buy groceries",
                "Finish Java homework",
                "Send email to client",
                "Clean the house",
                "Prepare presentation",
                "Go to the gym",
                "Read a book",
                "Fix bug #231",
                "Update documentation",
                "Plan weekend trip",
        };

        List<String> tasks = new ArrayList<>(Arrays.asList(values));

        System.out.println("1. Show all tasks");
        System.out.println("2. Add task at the end");
        System.out.println("3. Add task at position");
        System.out.println("4. Remove task by name");
        System.out.println("5. Remove task by index");
        System.out.println("0. Exit");
        System.out.println("Choose option:");

        int option = sc.nextInt();
        sc.nextLine();
        if (option == 1) {
            System.out.println(tasks);
        } else if (option == 2) {
            System.out.println("Enter task name:");
            String task = sc.nextLine();

            System.out.println(
                    taskManager.addTask(tasks, task)
                            ? "Task added"
                            : "Task not added"
            );
        } else if (option == 3) {
            System.out.println("Enter task name:");
            String task = sc.nextLine();

            System.out.println("Enter position:");
            int index = sc.nextInt();

            System.out.println(
                    taskManager.addTaskAtPosition(tasks, task, index)
                            ? "Task added"
                            : "Task not added"
            );
        } else if (option == 4) {
            System.out.println("Enter task name:");
            String task = sc.nextLine();

            System.out.println(
                    taskManager.removeTaskByName(tasks, task)
                            ? "Task removed"
                            : "Task not found"
            );
        } else if (option == 5) {
            System.out.println("Enter task index:");
            int index = sc.nextInt();

            String output = taskManager.removeTaskByIndex(tasks, index);
            if (output == null) {
                System.out.println("Task not removed");
            } else {
                System.out.println("Task removed: " + output);
            }
        }
    }

    private int indexOf(List<String> tasks, String task) {
        task = task.trim().toLowerCase();
        for (int i = 0; i < tasks.size(); i++) {
            String t = tasks.get(i);
            t = t.trim().toLowerCase();
            if (t.contains(task)) return i;
        }
        return -1;
    }

    public boolean addTask(List<String> tasks, String task) {
        if (indexOf(tasks, task) >= 0) return false;
        tasks.add(task);
        return true;
    }

    public boolean addTaskAtPosition(List<String> tasks, String task, int index) {
        if (indexOf(tasks, task) >= 0 || index > tasks.size()) return false;
        tasks.add(index, task);
        return true;
    }

    public boolean removeTaskByName(List<String> tasks, String task) {
        int index = indexOf(tasks, task);
        if (index < 0) return false;

        tasks.remove(index);
        return true;
    }

    public String removeTaskByIndex(List<String> tasks, int index) {
        if (index > tasks.size()) return null;
        return tasks.remove(index);
    }

}
