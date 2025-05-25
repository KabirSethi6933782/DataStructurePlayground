package bst;

import java.util.*;

public class BinarySearchTree {
    private Node root;

    private static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    public void insert(int value) {
        root = insertRec(root, value);
        System.out.println(value + " inserted into BST.");
    }

    private Node insertRec(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);

        return root;
    }

    public void bulkInsert(String csv) {
        String[] parts = csv.split(",");
        for (String s : parts) {
            try {
                int val = Integer.parseInt(s.trim());
                insert(val);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input skipped: " + s);
            }
        }
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) return false;
        if (value == root.data) return true;
        return value < root.data ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    public void inOrderTraversal() {
        List<Integer> sorted = new ArrayList<>();
        inOrderRec(root, sorted);
        System.out.println("In-Order: " + sorted);
        rebuildAndPrintFromList(sorted);
    }

    private void inOrderRec(Node node, List<Integer> list) {
        if (node != null) {
            inOrderRec(node.left, list);
            list.add(node.data);
            inOrderRec(node.right, list);
        }
    }

    public void preOrderTraversal() {
        List<Integer> order = new ArrayList<>();
        preOrderRec(root, order);
        System.out.println("Pre-Order: " + order);
        rebuildAndPrintFromList(order);
    }

    private void preOrderRec(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.data);
            preOrderRec(node.left, list);
            preOrderRec(node.right, list);
        }
    }

    public void postOrderTraversal() {
        List<Integer> order = new ArrayList<>();
        postOrderRec(root, order);
        System.out.println("Post-Order: " + order);
        rebuildAndPrintFromList(order);
    }

    private void postOrderRec(Node node, List<Integer> list) {
        if (node != null) {
            postOrderRec(node.left, list);
            postOrderRec(node.right, list);
            list.add(node.data);
        }
    }

    public void rebuildAndPrintFromList(List<Integer> values) {
        BinarySearchTree newTree = new BinarySearchTree();
        for (int val : values) {
            newTree.insert(val);
        }
        System.out.println("Tree rebuilt based on traversal order:");
        newTree.printVerticalTree();
    }

    public void printVerticalTree() {
        int maxLevel = maxDepth(root);
        printTreeLevel(Collections.singletonList(root), 1, maxLevel);
    }

    private void printTreeLevel(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);
        List<Node> newNodes = new ArrayList<>();

        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printTreeLevel(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    private int maxDepth(Node node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private boolean isAllElementsNull(List<Node> list) {
        for (Node node : list) if (node != null) return false;
        return true;
    }
}
