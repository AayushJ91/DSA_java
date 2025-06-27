//Problem: Given the head of a singly linked list, reverse the list, and return the reversed list
//link: https://leetcode.com/problems/reverse-linked-list/
//Source: LeetCode (206)
//Topics: Linked List
//Diff: Easy - by soln

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class ListNode {
    //these are the things the class need
    int val;
    ListNode next;
    ListNode prev;
    //default constructor - let me use "new ListNode"
    ListNode() {}
    //constructor - this initializes the variable val
    ListNode(int val) { this.val = val; }
    //constructor - set the value and select which node should be next
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReversedLinkedList {
    public static ListNode naive(ListNode head) {
        //Time: 29ms worst, beats 0.81%;
        //Memory: 44.83 MB worst, beats 5.81
        if (head == null) {
            return head;
        }
        int size = 0;
        ListNode siz = head;
        while (siz != null) {
            size++;
            siz = siz.next;
        }
        ListNode nul = null;
        ListNode temp = head.next;
        int i = 1;
        while (temp != null){
            System.out.println("i:"+i);
            head.next = nul;
            nul = head;
            head = temp;
            temp = temp.next;
            System.out.println("head in iter:"+head.val);
//            System.out.println("head.nxt:"+head.next.val);
            System.out.println("nul in iter:"+nul.val);
            System.out.println("temp in iter:"+temp);
            if (temp == null) {
                head.next = nul;
            }
            i++;
            System.out.println();
        }
        return head;
    }
    static ListNode optimised(ListNode head) {
        //Time: 0ms best, beats 100;
        //Memory: 42.68 MB, beats 40.26;
        if (head == null) {
            return head;
        }
        //just removed the debugging statements from the naive approach
        //   1->2->3->null
        //n  h  t
        //n<-1  2->3->null
        //   n  h  t
        ListNode nul = null;
        ListNode temp = head.next;
        while (temp != null){
            head.next = nul;
            nul = head;
            head = temp;
            temp = temp.next;
            if (temp == null) {
                head.next = nul;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode n = head;
        while (n != null) {
            System.out.print(n.val);
            System.out.print("->");
            n = n.next;
        }
        System.out.print("null");
        System.out.println();

        ListNode res = optimised(head);
        while (res != null) {
            System.out.print(res.val);
            System.out.print("->");
            res = res.next;
        }
        System.out.print("inull");
    }
}


