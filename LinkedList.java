package DSAAssignment2;

// Node class for the LinkedList
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class
class LinkedList {
    Node head;

    // Method to insert a node at a specified position in the LinkedList
    public void insertAtPos(int data, int pos) {
        Node newNode = new Node(data);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node curr = head;
            int i = 1;
            while (i < pos - 1 && curr != null) {
                curr = curr.next;
                i++;
            }
            if (curr != null) {
                newNode.next = curr.next;
                curr.next = newNode;
            }
        }
    }

    // Method to delete a node at a specified position in the LinkedList
    public void deleteAtPosition(int pos) {
        if (pos == 1) {
            head = head.next;
        } else {
            Node curr = head;
            int i = 1;
            while (i < pos - 1 && curr != null) {
                curr = curr.next;
                i++;
            }
            if (curr != null && curr.next != null) {
                curr.next = curr.next.next;
            }
        }
    }

    // Method to delete a node after a given node in the LinkedList
    public void deleteAfterNode(int data) {
        Node curr = head;
        while (curr != null && curr.data != data) {
            curr = curr.next;
        }
        if (curr != null && curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    // Method to search for a node with a specific value in the LinkedList
    public boolean searchNode(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // Method to print the LinkedList
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

// Stack class using LinkedList
class Stack {
    LinkedList list;

    public Stack() {
        list = new LinkedList();
    }

    // Method to push an element onto the stack
    public void push(int data) {
        list.insertAtPos(data, 1);
    }

    // Method to pop an element from the stack
    public int pop() {
        int data = list.head.data;
        list.head = list.head.next;
        return data;
    }

    // Method to peek the top element of the stack
    public int peek() {
        return list.head.data;
    }
}

// Main class for testing
 class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtPos(10, 1);
        linkedList.insertAtPos(20, 2);
        linkedList.insertAtPos(30, 3);
        System.out.print("The inserted nodes are:");
        linkedList.printList();

        linkedList.deleteAtPosition(2);
        System.out.print("The remaining nodes after deleting node at position 2 is:");
        linkedList.printList();

        linkedList.deleteAfterNode(10);
        System.out.print("The remaining nodes after deleting a node next to the 1st position is: ");
        linkedList.printList();


        System.out.println("Searching node 10: " + linkedList.searchNode(10));
        System.out.println("Searching node 20: " + linkedList.searchNode(20));
        System.out.println("Searching node 30: " + linkedList.searchNode(30));


        Stack stack = new Stack();
        stack.push(20);
        stack.push(30);
        stack.push(40);


        System.out.println("Peek: " + stack.peek());

        System.out.println("Pop: " + stack.pop());


    }
}