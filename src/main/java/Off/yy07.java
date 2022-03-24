package Off;

import common.ListNode;

public class yy07 {
    /**
     * 反转链表
     * */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head = test(head);
        System.out.println(head);
    }


    public static ListNode test(ListNode head){
        ListNode root = new ListNode();
        root.next = null;
        ListNode next;
        while (head != null){
            next = head.next;
            head.next = root.next;
            root.next = head;
            head = next;
        }
        return root.next;
    }


    /**
     * 判断链表是否有环
     *
     * 快慢双指针
     * */
    public static Boolean test1(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
