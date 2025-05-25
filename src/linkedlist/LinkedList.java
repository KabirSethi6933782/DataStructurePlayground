package linkedlist;

public class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            System.out.println(value + " inserted as head.");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        System.out.println(value + " inserted at the end.");
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted from the list.");
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println(value + " not found in the list.");
        } else {
            current.next = current.next.next;
            System.out.println(value + " deleted from the list.");
        }
    }

    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
