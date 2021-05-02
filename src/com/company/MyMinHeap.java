package com.company;

public class MyMinHeap<T extends Comparable<T>> {
    private Object[] array;
    private int size = 0;
    private int capacity;

    public MyMinHeap(int capacity){
        this.capacity = capacity;
        array = new Object[this.capacity];
    }

    //     Homework implementations:   //

    //empty() – Returns whether the heap is empty
    public boolean empty(){
        return size == 0;
    }

    //size() – Returns the size of the heap
    public int size(){
        return this.size;
    }

    //getMin() – Returns a reference to the root element of the hea
    public T getMin(){
        return (T) array[0];
    }

    //extractMin() – Retrieves and deletes the root element of the heap
    public T extractMin(){
        T min = (T) array[0];
        array[0] = array[size-1];
        array[size-1] = 0;
        size--;
        heapifyDown();
        return min;
    }

    //insert(T) – Adds the element to the heap
    public void insert(T element){
        if(size==capacity){
            System.out.println("heap is full");
            return;
        }
        array[size++] = element;
        heapifyUp(size-1);
    }



    //  Additional methods:

    public void display(){
        for(int i = 0; i < size;i++){
            System.out.print(array[i] + " ");
        }
    }

    public void heapifyUp(int index){
        int parentIdx = (index-1)/2;
        int currentIdx = index;
        T parentElement = (T) array[parentIdx];
        T currentElement = (T) array[currentIdx];

        while (currentIdx > 0 && (parentElement.compareTo(currentElement) > 0)){
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = (parentIdx-1)/2;
            parentElement = (T) array[parentIdx];
            currentElement = (T) array[currentIdx];
        }
    }



    public void heapifyDown(){
        int index = 0;
        while(leftChildInd(index)<size) {
            int smallerChildIndex = leftChildInd(index);
            if(rightChildInd(index) < size && rightChildInd(index) < leftChildInd(index))
                smallerChildIndex = rightChildInd(index);
            T currentElement = (T) array[index];
            T smallChildElement = (T) array[smallerChildIndex];

            if(currentElement.compareTo(smallChildElement) < 0){
                break;
            }else
                swap(index , smallerChildIndex);
            index = smallerChildIndex;
        }
    }



    private void swap(int first, int second){
        T temp = (T) array[first];
        array[first] = array[second];
        array[second] = temp;
    }


    private int leftChildInd(int index){
        return 2 * index + 1;
    }

    private int rightChildInd(int index){
        return 2 * index + 2;
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

}

