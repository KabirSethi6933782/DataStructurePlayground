import java.util.Scanner;

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
                    System.out.println("Stack selected (coming soon)");
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
