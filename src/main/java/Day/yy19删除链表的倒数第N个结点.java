package Day;

import common.ListNode;

public class yy19删除链表的倒数第N个结点 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     */


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
/*        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*/
        ListNode listNode = removeNthFromEnd(head, 1);
        System.out.println("aaaaaaaaaaa " + listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p2;
        return head;
    }
}
