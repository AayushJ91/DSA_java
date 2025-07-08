import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap {
    private static ArrayList<Integer> heap;
    //constructor
    public MinHeap(){
        heap = new ArrayList<>();
    }
    //returns the index of parent of i
    private int getParent(int i) {
        return (i - 1) / 2;
    }
    //returns the left child of the given index
    private int leftChild(int i) {
        return 2*i + 1;
    }
    //returns the right child of the given index
    private int rightChild(int i) {
        return 2*i + 2;
    }
    //swap
    public static void swap(ArrayList<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int num) {
        heap.add(num);
        int pos = heap.size() - 1;
        while (pos >= 0 && heap.get(getParent(pos)) < heap.get(pos)) {
            swap(heap, pos, getParent(pos));
            pos = getParent(pos);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void maxHeapify(int[] heap, int n, int i) {
        //heap is the root of the array to be heapified;
        //n is the size of the array
        //i is the root of the heap;
        int largest = i;
        int lastNonLeaf = (n/2) - 1;
        while (lastNonLeaf != largest) {
            int rightChild = 2*lastNonLeaf + 2;
            int leftChild = 2*lastNonLeaf + 1;
            if (heap[lastNonLeaf] < heap[rightChild]) {
                swap(heap, lastNonLeaf, rightChild);
            }
        }
    }
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(1);
        System.out.println(heap);
    }
}
