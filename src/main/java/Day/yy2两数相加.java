package Day;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class yy2两数相加 {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * <p>
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     * <p>
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(9);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(head, head1);
        System.out.printf("aaaaaaa  " + listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list1.add(l2.val);
            l2 = l2.next;
        }

        List<Integer> result = new ArrayList<>();

        if (list.size() != list1.size()) {
            Integer num = Math.abs(list.size() - list1.size());
            if (list.size() > list1.size()) {
                for (int i = 0; i < num; i++) {
                    list1.add(0);
                }
            } else {
                for (int i = 0; i < num; i++) {
                    list.add(0);
                }
            }

        }

        int add = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = add > 0 ? list.get(i) + list1.get(i) + add : list.get(i) + list1.get(i);
            add = 0;
            if (sum >= 10) {
                result.add(sum % 10);
                add++;
                if (i == list.size() - 1) {
                    result.add(add);
                }
            } else {
                result.add(sum);
            }
        }

        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < result.size(); i++) {
            if (head == null){
                head = tail = new ListNode(result.get(i));
            }else {
                tail.next = new ListNode(result.get(i));
                tail = tail.next;
            }
        }
        return head;
    }


    public static ListNode listNode(ListNode l1, ListNode l2){
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;

    }
}
