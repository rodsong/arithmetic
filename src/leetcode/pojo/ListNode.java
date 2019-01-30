package leetcode.pojo;

/**
 * <p>leetcode.pojo.ListNode</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年01月14日
 */
public class ListNode {
    public int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    public ListNode append(ListNode head, ListNode next) {

        boolean flag = true;
        do {
            if (head.next == null) {
                head.next = next;
                flag = false;
            }else {
                head = head.next;
            }
        } while (flag);

        return next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListNode{");
        sb.append("val=").append(val);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}