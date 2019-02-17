package leetcode.demo.link;

import leetcode.pojo.ListNode;

/**
 * <p>SwapPair_24</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年01月17日
 */
public class SwapPair_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        // 新头部
        ListNode pre_head = new ListNode(-1);
        pre_head.setNext(head);

        swap(pre_head, pre_head.getNext());

        return pre_head.getNext();
    }

    // 每次从局部头部后两个node 交换
    private void swap(ListNode tem_head, ListNode node1) {

        if (node1 == null || node1.getNext() == null) {
            return;
        }


        ListNode node2 = node1.getNext();
        ListNode temp = node2.getNext();

        tem_head.setNext(node2);

        node1.setNext(temp);
        node2.setNext(node1);

        swap(node1, node1.getNext());
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.append(head, new ListNode(4));
        head.append(head, new ListNode(3));
        head.append(head, new ListNode(7));
        head.append(head, new ListNode(5));
        head.append(head, new ListNode(6));
        head.append(head, new ListNode(1));

        ListNode new_head = head.getNext();

        // 交换
        new SwapPair_24().swapPairs(head);
        do {
            System.out.println(new_head.val);
            new_head = new_head.getNext();
        } while (new_head != null);
    }

}
