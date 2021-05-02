package com.company;

public class Main {

    public static void main(String[] args) {

        // Example:
        MyMinHeap<Integer> minHeap = new MyMinHeap(8);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);

        minHeap.display();
        System.out.println();
        System.out.println("Is empty? " + minHeap.empty());
        System.out.println("Size: " + minHeap.size());

        System.out.println("Extruct minimum: " + minHeap.extractMin());
        minHeap.display();
        System.out.println();
        System.out.println("Get minimum: " + minHeap.getMin());

    }
}
