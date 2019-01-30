package lc.demo.link;

/**
 * <p>SwapPair_24</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年01月17日
 */
public class SwapPair_24_2 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 新头部
        ListNode pre_head = new ListNode(-1);
        pre_head.next = (head);

        swap(pre_head, pre_head.next);

        return pre_head.next;
    }

    // 每次从局部头部后两个node 交换
    private void swap(ListNode tem_head, ListNode node1) {

        if (node1 == null || node1.next == null) {
            return;
        }


        ListNode node2 = node1.next;
        ListNode temp = node2.next;

        tem_head.next = (node2);

        node1.next = (temp);
        node2.next = (node1);

        swap(node1, node1.next);
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.append(head, new ListNode(4));
        head.append(head, new ListNode(3));
        head.append(head, new ListNode(7));
        head.append(head, new ListNode(5));
        head.append(head, new ListNode(6));
        head.append(head, new ListNode(1));

        ListNode new_head = head.next;

        // 交换
        new SwapPair_24_2().swapPairs(head);
        do {
            System.out.println(new_head.val);
            new_head = new_head.next;
        } while (new_head != null);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode append(ListNode head, ListNode next) {

            boolean flag = true;
            do {
                if (head.next == null) {
                    head.next = next;
                    flag = false;
                } else {
                    head = head.next;
                }
            } while (flag);

            return next;
        }
    }

}
