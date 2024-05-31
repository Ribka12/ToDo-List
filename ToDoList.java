package DSAAssignment1;
// Task Class
class Task {
    // Attributes:
    // title: String - The title of the task.
    // description: String - The description of the task.
    // completed: boolean - Indicates whether the task is completed or not.
    private String title;
    private String description;
    private boolean completed;

    // Constructor to initialize a task with a title and description.
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getter method to retrieve the title of the task.
    public String getTitle() {
        return title;
    }

    // Getter method to retrieve the description of the task.
    public String getDescription() {
        return description;
    }

    // Getter method to check if the task is completed.
    public boolean isCompleted() {
        return completed;
    }

    // Method to mark the task as completed.
    public void markCompleted() {
        this.completed = true;
    }
}

// Node Class
 class Node {
    // Attributes:
    // task: Task - Reference to a task.
    // next: Node - Reference to the next node in the linked list.

     Task task;
     Node next;

    // Constructor to initialize a node with a task.
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// ToDoList Class
public class ToDoList {
    // Attributes:
    // head: Node - Reference to the head of the linked list.

    private Node head;

    // Constructor to initialize an empty to-do list.
    public ToDoList() {
        this.head = null;
    }

    // Method to add a new task to the end of the linked list.
    public void addToDo(Task task) {
        if (head == null) {
            head = new Node(task);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(task);
        }
    }

    // Method to mark a task as completed based on its title.
    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                break;
            }
            current = current.next;
        }
    }

    // Method to display the list of tasks in the to-do list.
    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            if (current.task.isCompleted()) {
                System.out.println( current.task.getTitle() + " - Completed");
            } else {
                System.out.println( current.task.getTitle() + " - Not Completed");
            }
            current = current.next;
        }
    }
}

// Main class
class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Task 1", "Finishing Assignment.");
        Task task2 = new Task("Task 2", "Presentation.");
        Task task3 = new Task("Task 3", "Study for Final exam.");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        System.out.println("To-Do List:");
        toDoList.viewToDoList();

        System.out.println("\nMarking 'Task 2' as completed...");
        toDoList.markToDoAsCompleted("Task 2");

        System.out.println("\nUpdated To-Do List:");
        toDoList.viewToDoList();
        System.out.println(task1.getDescription());
    }
}