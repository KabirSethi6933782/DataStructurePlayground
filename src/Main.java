import java.util.Scanner;
import stack.Stack;
import queue.Queue;
import linkedlist.LinkedList;
import bst.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Data Structure Playground ====");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Linked List");
            System.out.println("4. Binary Search Tree");
            System.out.println("0. Exit");
            System.out.print("Choose a data structure to explore: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Stack selected.");
                    Stack myStack = new Stack(10);
                    int stackChoice;
                    do {
                        System.out.println("\n--- Stack Menu ---");
                        System.out.println("1. Push (single)");
                        System.out.println("2. Push (bulk, comma-separated)");
                        System.out.println("3. Pop");
                        System.out.println("4. Peek");
                        System.out.println("5. Print Stack");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Choose an operation: ");
                        stackChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (stackChoice) {
                            case 1:
                                System.out.print("Enter value to push: ");
                                int value = scanner.nextInt();
                                myStack.push(value);
                                break;
                            case 2:
                                System.out.print("Enter values to push (comma-separated): ");
                                String stackCsv = scanner.nextLine();
                                for (String s : stackCsv.split(",")) {
                                    try {
                                        int val = Integer.parseInt(s.trim());
                                        myStack.push(val);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid: " + s);
                                    }
                                }
                                break;
                            case 3:
                                myStack.pop();
                                break;
                            case 4:
                                int peek = myStack.peek();
                                if (peek != -1) System.out.println("Top of stack: " + peek);
                                break;
                            case 5:
                                myStack.printStack();
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (stackChoice != 0);
                    break;

                case 2:
                    System.out.println("Queue selected.");
                    Queue myQueue = new Queue(10);
                    int queueChoice;
                    do {
                        System.out.println("\n--- Queue Menu ---");
                        System.out.println("1. Enqueue (single)");
                        System.out.println("2. Enqueue (bulk, comma-separated)");
                        System.out.println("3. Dequeue");
                        System.out.println("4. Peek");
                        System.out.println("5. Print Queue");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Choose an operation: ");
                        queueChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (queueChoice) {
                            case 1:
                                System.out.print("Enter value to enqueue: ");
                                int value = scanner.nextInt();
                                myQueue.enqueue(value);
                                break;
                            case 2:
                                System.out.print("Enter values to enqueue (comma-separated): ");
                                String queueCsv = scanner.nextLine();
                                for (String s : queueCsv.split(",")) {
                                    try {
                                        int val = Integer.parseInt(s.trim());
                                        myQueue.enqueue(val);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid: " + s);
                                    }
                                }
                                break;
                            case 3:
                                myQueue.dequeue();
                                break;
                            case 4:
                                int peek = myQueue.peek();
                                if (peek != -1) System.out.println("Front of queue: " + peek);
                                break;
                            case 5:
                                myQueue.printQueue();
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (queueChoice != 0);
                    break;

                case 3:
                    System.out.println("Linked List selected.");
                    LinkedList myList = new LinkedList();
                    int listChoice;
                    do {
                        System.out.println("\n--- Linked List Menu ---");
                        System.out.println("1. Insert (single)");
                        System.out.println("2. Insert (bulk, comma-separated)");
                        System.out.println("3. Delete");
                        System.out.println("4. Search");
                        System.out.println("5. Print List");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Choose an operation: ");
                        listChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (listChoice) {
                            case 1:
                                System.out.print("Enter value to insert: ");
                                int insertVal = scanner.nextInt();
                                myList.insert(insertVal);
                                break;
                            case 2:
                                System.out.print("Enter values to insert (comma-separated): ");
                                String listCsv = scanner.nextLine();
                                for (String s : listCsv.split(",")) {
                                    try {
                                        int val = Integer.parseInt(s.trim());
                                        myList.insert(val);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid: " + s);
                                    }
                                }
                                break;
                            case 3:
                                System.out.print("Enter value to delete: ");
                                int deleteVal = scanner.nextInt();
                                myList.delete(deleteVal);
                                break;
                            case 4:
                                System.out.print("Enter value to search: ");
                                int searchVal = scanner.nextInt();
                                boolean found = myList.search(searchVal);
                                System.out.println(found ? "Found in list." : "Not found in list.");
                                break;
                            case 5:
                                myList.printList();
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (listChoice != 0);
                    break;

                case 4:
                    System.out.println("BST selected.");
                    BinarySearchTree bst = new BinarySearchTree();
                    int bstChoice;
                    do {
                        System.out.println("\n--- BST Menu ---");
                        System.out.println("1. Bulk Insert (comma-separated)");
                        System.out.println("2. Search");
                        System.out.println("3. In-Order Traversal");
                        System.out.println("4. Pre-Order Traversal");
                        System.out.println("5. Post-Order Traversal");
                        System.out.println("6. Print Tree (Vertical)");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Choose an operation: ");
                        bstChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (bstChoice) {
                            case 1:
                                System.out.print("Enter values (comma-separated): ");
                                String csv = scanner.nextLine();
                                bst.bulkInsert(csv);
                                break;
                            case 2:
                                System.out.print("Enter value to search: ");
                                int sVal = scanner.nextInt();
                                System.out.println(bst.search(sVal) ? "Found in BST." : "Not found in BST.");
                                break;
                            case 3:
                                bst.inOrderTraversal();
                                break;
                            case 4:
                                bst.preOrderTraversal();
                                break;
                            case 5:
                                bst.postOrderTraversal();
                                break;
                            case 6:
                                bst.printVerticalTree();
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (bstChoice != 0);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 0);
    }
}
