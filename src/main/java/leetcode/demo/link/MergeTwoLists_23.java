package leetcode.demo.link;

import leetcode.pojo.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author songyanfei
 * @date 2019年01月14日
 */
public class MergeTwoLists_23 {

    /**
     * 递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode temp = null;
        ListNode head = null;

        if (l1.val <= l2.val) {
            temp = head = new ListNode(l1.val);
            p1 = l1.getNext();
            p2 = l2;
        } else {
            temp = head = new ListNode(l2.val);
            p1 = l1;
            p2 = l2.getNext();
        }

        ListNode next = handleNext(p1, p2, temp);

        return head;
    }

    private ListNode handleNext(ListNode p1, ListNode p2, ListNode tail) {
        if (p1 == null && p2 == null) {
            return tail;
        }

        if (p1 != null && p2 == null) {
            tail.setNext(new ListNode(p1.val)) ;
            p1 = p1.getNext();
        }

        if (p1 == null && p2 != null) {
            tail.setNext(new ListNode(p2.val));
            p2 = p2.getNext();
        }

        if (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.setNext( new ListNode(p1.val));
                p1 = p1.getNext();
            } else {
                tail.setNext( new ListNode(p2.val)) ;
                p2 = p2.getNext();
            }
        }

        // 递归
        tail = tail.getNext();
        handleNext(p1, p2, tail);

        return tail.getNext();
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode temp = list1.append(list1, new ListNode(2));
        temp.append(temp, new ListNode(4));


        ListNode list2 = new ListNode(1);
        ListNode temp2 = list2.append(list2, new ListNode(3));
        temp2.append(temp2, new ListNode(4));

        MergeTwoLists_23 mergeTwoLists = new MergeTwoLists_23();
        ListNode node = mergeTwoLists.mergeTwoLists(list1, list2);

        do {
            System.out.println(node.val);
            node = node.getNext();
        } while (node != null);
    }

}
