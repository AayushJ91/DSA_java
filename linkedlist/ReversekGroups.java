//Problem: Given the head of a singly linked list and a int k, reverse every grp having k element from starting
//link: https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
//Source: GFG
//Topics: Linked List
//Diff:

public class ReversekGroups {
    static class Node {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
        Node () {}
    }

    static Node naive(Node head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        int size = 0;
        Node l = head;
        while (l != null) {
            size ++;
            l = l.next;
        }
        Node nul = null;
        Node temp = head.next;
        for (int i = 0; i < size/k; i++){
            for (int j = 0; j < k; j++){
                System.out.printf("\ni:%d, j:%s", i,j);
                head.next = nul;
                System.out.println("h.nxt = nul");
                nul = head;
                System.out.println("nul = h");
                head = temp;
                System.out.println("h = t");
                if (head.next == null) {
                    head.next = nul;
                }
                temp = temp.next;
                System.out.println("t = t.nxt");

            }
            System.out.println();
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        Node l = head;
        while (l != null) {
            System.out.print(l.data);
            System.out.print("->");
            l = l.next;
        }
        System.out.println("null");
        System.out.println();

        System.out.println();
        Node res = naive(head, 3);
        int k = 0;
        while (res != null) {
            System.out.print(res.data);
            System.out.print("->");
            res = res.next;
            k++;
        }
        System.out.println("null");
    }
}
