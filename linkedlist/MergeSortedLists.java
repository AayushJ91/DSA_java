import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
    private static ListNode naive(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode curr = res;
//        System.out.println(list1.val);
        while (list1 != null || list2 != null) {
            System.out.println("list1.val:"+list1.val);
            System.out.println("list2.val:"+list2.val);
            if (list1.val > list2.val) {
                curr.val = list2.val;
                list2 = list2.next;
            }else {
                curr.val = list1.val;
                list1 = list1.next;
            }
            System.out.println("curr:"+curr.val);
            curr.next = new ListNode();
            curr = curr.next;
            System.out.println();
        }
        curr.next = (list1 != null) ? list1 : list2;
        return res;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode h = list1;

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode head = naive(list1, list2);
        ListNode j = list2;
        while (h != null) {
            System.out.print(h.val+"->");
            h = h.next;
        }
        System.out.println();
        while (j != null) {
            System.out.print(j.val+"->");
            j = j.next;
        }
        System.out.println();
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
    }

}
