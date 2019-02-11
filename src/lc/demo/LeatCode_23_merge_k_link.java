package lc.demo;

import lc.demo.link.Leadcode_MergeTwoLists_23_2;
import leetcode.pojo.ListNode;

import java.util.Collections;

/**
 * <p>LeatCode_23_merge_k_link</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月10日
 */
public class LeatCode_23_merge_k_link extends ListNode {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int i = 0;
        ListNode temp = lists[0];
        do {
            i++;
            temp = mergeTwo(temp, lists[i]);
        } while (i < lists.length - 1);

        return temp;
    }


    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode tempHead = null;

        if (l1.val < l2.val) {
            tempHead = l1;
            tempHead.next = mergeTwo(l1.next, l2);
        } else {
            tempHead = l2;
            tempHead.next = mergeTwo(l1, l2.next);
        }

        return tempHead;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode temp = list1.append(list1, new ListNode(2));
        temp.append(temp, new ListNode(4));


        ListNode list2 = new ListNode(1);
        ListNode temp2 = list2.append(list2, new ListNode(3));
        temp2.append(temp2, new ListNode(4));
        temp2.append(temp2, new ListNode(5));

        ListNode list3 = new ListNode(1);
        ListNode temp3 = list3.append(list2, new ListNode(3));
        temp3.append(temp3, new ListNode(4));
        temp3.append(temp3, new ListNode(5));

        ListNode[] target = {list1, list2, list3};
        LeatCode_23_merge_k_link mergeTwoLists = new LeatCode_23_merge_k_link();
        //  ListNode node = mergeTwoLists.mergeKLists(target);

//        do {
//            System.out.print(node.val + "-->");
//            node = node.getNext();
//        } while (node != null);
//

         mergeTwoLists.mergeKLists(null);

    }
}
