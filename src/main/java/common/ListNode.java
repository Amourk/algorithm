package common;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode() {
    }
    public ListNode(int data){
        this.val = data;
    }

    @Override
    public String toString() {
        return val +"";
    }

    public void print() {
        String arrow = next != null ? "->" : "";
        System.out.print(val + arrow);
        if (next != null) {
            next.print();
        }
    }

    /**
     *
     *         ListNode head = new ListNode(1);
     *         head.next = new ListNode(2);
     *         head.next.next = new ListNode(3);
     *         head.next.next.next = new ListNode(4);
     *         head.next.next.next.next = new ListNode(5);
     * */
}

