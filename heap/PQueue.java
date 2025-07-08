import java.util.*;

public class PQueue {
    public static void main(String[] args) {
        int[] n = {3,2,3,1,2,4,5,5,6};
        ArrayList<Integer> f = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(5);
        pq.add(1);
        pq.add(6);
        pq.add(3);
        pq.add(4);
        pq.add(2);
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println(pq.comparator());
    }
}
