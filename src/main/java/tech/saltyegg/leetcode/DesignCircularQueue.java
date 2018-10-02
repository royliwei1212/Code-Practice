package tech.saltyegg.leetcode;

public class DesignCircularQueue {
    private int[] list;
    private int size;
    private int front;
    private int end;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public DesignCircularQueue(int k) {
        list = new int[k];
        size = k;
        front = -1;
        end = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        end = (end + 1) % size;
        list[end] = value;
        if (front == -1) front++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (front == end) front = end = -1;
        else front = (front + 1) % size;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) return -1;
        return list[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) return -1;
        return list[end];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == -1 && end == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (end + 1) % size == front;
    }
}
