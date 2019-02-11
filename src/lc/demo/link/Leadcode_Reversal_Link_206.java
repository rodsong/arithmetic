package lc.demo.link;

import leetcode.pojo.ListNode;

/**
 * 反转单链表
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4
 * 输出：4->2->1
 *
 * @author songyanfei
 * @date 2019年01月14日
 */
public class Leadcode_Reversal_Link_206 {

    /**
     * 非递归
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if(head ==null ||head.next==null){
            return head;
        }
        ListNode preNode =null;
        ListNode cur = head;
        while(cur !=null){
            ListNode tempNext = cur.next;
            cur.next=preNode;
            preNode = cur;

            cur = tempNext;
        }
        return preNode;
    }

    /**
     * 递归
     *
     * 每次递归压入操作栈的head都是末尾待处理节点，末尾节点处理逻辑就是 末尾next向前指，前边一个节点的next设置为null
     * @param head
     * @return
     */
    public ListNode reverse_recursion(ListNode head) {
        if(head ==null ||head.next==null){
            return head;
        }
        ListNode newHead = reverse_recursion(head.next);
        //末尾节点之前前驱节点
        head.next.next = head;
        //必须设置为null否则递归栈无法正常退出
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head.append(head, new ListNode(2));
        temp.append(temp, new ListNode(4));

        Leadcode_Reversal_Link_206 test = new Leadcode_Reversal_Link_206();
        ListNode newHead = test.reverse_recursion(head);
        newHead.printString();
    }

}
