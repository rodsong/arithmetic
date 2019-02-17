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
public class Leadcode_MergeTwoLists_23_2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.setNext(mergeTwoLists(l1.getNext(),l2));
        } else {
            head = l2;
            head.setNext(mergeTwoLists(l1,l2.getNext()));
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode temp = list1.append(list1, new ListNode(2));
        temp.append(temp, new ListNode(4));


        ListNode list2 = new ListNode(1);
        ListNode temp2 = list2.append(list2, new ListNode(3));
        temp2.append(temp2, new ListNode(4));
        temp2.append(temp2, new ListNode(5));

        Leadcode_MergeTwoLists_23_2 mergeTwoLists = new Leadcode_MergeTwoLists_23_2();
        ListNode node = mergeTwoLists.mergeTwoLists(list1, list2);

        do {
            System.out.print(node.val +"-->");
            node = node.getNext();
        } while (node != null);
    }

}
