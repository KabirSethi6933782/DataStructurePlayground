import java.util.Scanner;
import stack.Stack;

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

            switch (choice) {
                case 1:
                    System.out.println("Stack selected.");
                    Stack myStack = new Stack(5); // fixed-size stack
                    int stackChoice;
                    do {
                        System.out.println("\n--- Stack Menu ---");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Peek");
                        System.out.println("4. Print Stack");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Choose an operation: ");
                        stackChoice = scanner.nextInt();

                        switch (stackChoice) {
                            case 1:
                                System.out.print("Enter value to push: ");
                                int value = scanner.nextInt();
                                myStack.push(value);
                                break;
                            case 2:
                                myStack.pop();
                                break;
                            case 3:
                                int peek = myStack.peek();
                                if (peek != -1) System.out.println("Top of stack: " + peek);
                                break;
                            case 4:
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
                    System.out.println("Queue selected (coming soon)");
                    break;
                case 3:
                    System.out.println("Linked List selected (coming soon)");
                    break;
                case 4:
                    System.out.println("BST selected (coming soon)");
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
