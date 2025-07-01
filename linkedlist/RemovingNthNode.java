//Problem: Removing the nth digit from the end
//link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//Source: LeetCode (19)
//Topics: Linked List
//Diff: Med

public class RemovingNthNode {
    public static ListNode optimised(ListNode head, int n) {
        //Time: 0ms best, beats 100
        //Space: 41.38 MB, beats 97.98
        ListNode last = head;
        int size  = 1;
        while (last.next != null) {
            size++;
            last = last.next;
        }
        //invalid case
        if (n > size) {
            System.out.println("Invalid");
            return new ListNode();
        }
        //if only 1 node is there
        if (size - n == 0) {
            return head.next;
        }
        ListNode curr = head;
        ListNode prev = head;
        for (int i = 1; i <= size - n; i++) {
            prev = curr;
            if (i == size){//for the last node
                //curr.next ko null kr diya, phir loop ke bahar prev.next usko curr.next(null) se jod raha hai
                curr.next = null;
                break;
            }else {
                curr = curr.next;
            }
        }
        prev.next = curr.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode new_nod = new ListNode(1);
        new_nod.next = new ListNode(2);
//        new_nod.next.next = new ListNode(3);
//        new_nod.next.next.next = new ListNode(4);
//        new_nod.next.next.next.next = new ListNode(5);

        ListNode ex = new_nod;
        while (ex != null){
            System.out.print(ex.val);
            System.out.print("->");
            ex = ex.next;
        }
        System.out.print("null");
        System.out.println();

        ListNode siz = optimised(new_nod, 1);
        while (siz != null){
            System.out.print(siz.val);
            System.out.print("->");
            siz = siz.next;
        }
        System.out.print("null");
    }
}
