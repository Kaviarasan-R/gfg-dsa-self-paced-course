/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.heap;

import java.util.Arrays;

public class A_BinaryHeap {

    int size;
    int capacity;
    int[] arr;

    public A_BinaryHeap(int size, int capacity, int[] arr) {
        this.size = size;
        this.capacity = capacity;
        this.arr = new int[capacity];
        // copying
        if (size >= 0) System.arraycopy(arr, 0, this.arr, 0, size);
        System.out.println("constructor : " + Arrays.toString(this.arr));
    }

    public static void main(String[] args) {
        /**
         * Operations on Binary Heap:
         * 1) insert(): We add a new key at the end of the tree. If new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
         * 2) minHeapify() : A recursive method to heapify a subtree with the root at given index This method assumes that the subtrees are already heapified.
         * 3) extractMin(): Removes the minimum element from MinHeap.
         * 4) decreaseKey(): Decreases value of key. If the decreases key value of a node is greater than the parent of the node, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
         * 5) delete(): We replace the key to be deleted with minus infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin() to remove the key.
         * */
        int[] arr = {3,2,15,5,4,45};
        int size = arr.length;
        int capacity = 10;
        A_BinaryHeap binaryHeap = new A_BinaryHeap(size,capacity,arr);
        System.out.println("min heapify : " + Arrays.toString(binaryHeap.minHeapify(2)));
        System.out.println("max heapify : " + Arrays.toString(binaryHeap.maxHeapify(2)));
        binaryHeap.insert(22);
        binaryHeap.insert(26);
        binaryHeap.insert(17);
        binaryHeap.insert(9);
        // before extracting min, it should be in min heapify.
        System.out.println("min heapify : " + Arrays.toString(binaryHeap.minHeapify(0)));
        System.out.println("extracted min : " + binaryHeap.extractMin(true));
        binaryHeap.decreasekey(3,95, true); // replaces 5 with 95.
        binaryHeap.deleteKey(3); // it will delete 95.
    }

    // Get the Parent index for the given index
    public int Parent(int key) {
        return (key - 1) / 2;
    }

    // Get the Left Child index for the given index
    public int Left(int key) {
        return 2 * key + 1;
    }

    // Get the Right Child index for the given index
    public int Right(int key) {
        return 2 * key + 2;
    }
    // swapping
    public void swap(int i, int j) {
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

    // Inserts a new key
    public boolean insert(int x) {
        if (this.size == this.capacity) {
            return false; // heap is full
        }
        // First insert the new key at the end
        int index = size;
        this.arr[index] = x;
        size++;

        for (int i = size-1; i != 0 && this.arr[Parent(i)] > this.arr[i];) {
            swap(i,Parent(i));
            i = Parent(i);
        }
        System.out.println("insert : " + Arrays.toString(this.arr));
        return true;
    }

    // Heapify the array minimum
    public int[] minHeapify(int i) {
        int smallest = i; // Initialize largest as root
        int l = Left(i); // left = 2*i + 1
        int r = Right(i); // right = 2*i + 2

        // If left child is smaller than root
        if (l < size && arr[l] < arr[smallest])
            smallest = l;

        // If right child is smaller than smallest so far
        if (r < size && arr[r] < arr[smallest])
            smallest = r;

        // If smallest is not root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursively heapify the affected sub-tree
            minHeapify(smallest);
        }
        return this.arr;
    }

    // Heapify the array maximum
    public int[] maxHeapify(int i) {
        int largest = i; // Initialize largest as root
        int l = Left(i); // left = 2*i + 1
        int r = Right(i); // right = 2*i + 2

        // If left child is larger than root
        if (l < size && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < size && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            maxHeapify(largest);
        }
        return this.arr;
    }

    // Method to remove minimum element (or root) from min heap
    public int extractMin(boolean print) {
        if(size <= 0) {
            return Integer.MAX_VALUE;
        }
        if(size == 1) {
            size--;
            return arr[0];
        }
        int root = arr[0];
        arr[0] = arr[size - 1];
        size--;
        minHeapify(0);
        if(print) System.out.println("after extract min : " + Arrays.toString(this.arr));
        return root;
    }

    // Decreases value of given key to new_val.
    public void decreasekey(int i, int x, boolean print) {
        arr[i] = x; //replace index with new value
        while(i != 0 && arr[Parent(i)] > arr[i]) {
            swap(i,Parent(i));
            i = Parent(i);
        }
        if(print) System.out.println("decrease key : " + Arrays.toString(arr));
    }

    // This function deletes key at the given index.
    public void deleteKey(int i) {
        decreasekey(i,Integer.MIN_VALUE,false); // it will replace the given key with minimum value.
        extractMin(false); // it will extract the minimum value
        System.out.println("after deletion : " + Arrays.toString(arr));
    }
}
