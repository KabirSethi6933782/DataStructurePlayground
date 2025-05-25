package queue;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[size];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        size++;
        System.out.println(value + " enqueued to queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int value = queueArray[front];
        front = (front + 1) % maxSize;
        size--;
        System.out.println(value + " dequeued from queue.");
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == maxSize);
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue contents (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }
}
