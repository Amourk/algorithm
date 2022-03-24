package Off;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * */
public class yy03 {
    /**
     *    public class ListNode {
     *        int val;
     *        ListNode next = null;
     *
     *        ListNode(int val) {
     *            this.val = val;
     *        }
     *    }
     *
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        test1(head);
    }

    /**
     * 递归
     * 顺序输入 倒序输出
     * */
    public static void test1(ListNode node){
        List<Integer> list = new ArrayList<Integer>();
        if (node == null){
            return;
        }

        test1(node.next);

        System.out.print(node.val + " ");
    }

}
