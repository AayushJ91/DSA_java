//Problem: Determining whether the linked list is cyclic or not.
//        meaning the tail is reached again while dong tail.next.
//link: https://leetcode.com/problems/linked-list-cycle/
//Source: LeetCode (141)
//Topics: Linked List
//Diff: Easy

import javax.swing.*;
import java.util.ArrayList;

public class    LinkedListCycle {
    public static boolean naive(ListNode head) {
        //this approach I did with hollow method
        //if the list will contain any node with duplicate value which is not linked then also it will return true
        //1->2->3->2->null and 1->2->3->2->2nd_node, 1 shouldn't give true but 2 should
        //but by this method both will give true
        ArrayList<Integer> list = new ArrayList<>();
        ListNode pos = head;
        int i = 0;
        while (pos != null) {
            System.out.println("iter:"+i);
            System.out.println("curr:"+pos.val);
            System.out.println("next:"+pos.next.val);
            if (list.contains(pos.next.val)) {
                return true;
            }else {
                list.add(pos.val);
            }
            pos = pos.next;
            i++;
            System.out.println();
        }
        return false;
    }
    public static boolean naive2(ListNode head) {
        //this is exceeding the time limit
        ListNode pos = head;
        while (pos != null){
            ListNode curr = pos;
            while (curr != null) {
                if (curr.next == pos){
                    return true;
                }
                curr = curr.next;
            }
            pos = pos.next;
        }
        return false;
    }

    static boolean optimistic(ListNode head) {
        //Time: 0ms best, beats 100;
        //Space: 44.77 MB, beats 27.85;
        //by solution
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode pos = new ListNode();
        ListNode head = pos = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = pos;
//        head.next.next = pos;
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = pos;

//        ListNode ex = head;
//        while (ex != null) {
//            System.out.print(ex.val);
//            System.out.print("->");
//            ex = ex.next;
//        }
//        System.out.println("null");

        boolean val = optimistic(head);
        System.out.println(val);
    }
}
