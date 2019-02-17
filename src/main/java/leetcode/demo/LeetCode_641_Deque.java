package leetcode.demo;

import java.util.ArrayDeque;

/**
 * 设计实现双端队列。
 */
public class LeetCode_641_Deque {


    public static class MyCircularDeque {

        private static final int max_limit = 1000;

        private Object[] elements;

        private int head = 0;

        private int tail = 0;

        private static final int MIN_INITIAL_CAPACITY = 8;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {

            int initialCapacity = MIN_INITIAL_CAPACITY;
            if (k > max_limit) {
                k = max_limit;
            }

            elements = new Object[initialCapacity];
            tail = 0;
            head = elements.length;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) throws Exception {
            if (isFull()) {
                return false;
            }
            // head 是length
            head = (head - 1) & (elements.length - 1);
            elements[head] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) throws Exception {
            if (isFull()) {
                return false;
            }
            elements[tail] = value;

            //tail 指针移动
            tail = (tail + 1) & (elements.length - 1);
            if ((tail) == head) {
                return false;
            }
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            int h = head;
            Object result = elements[h];
            // Element is null if deque empty
            if (result == null) {
                return false;
            }
            // Must null out slot
            elements[h] = null;
            head = (h + 1) & (elements.length - 1);
            return false;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            // tail的前驱节点
            int t = (tail - 1) & (elements.length - 1);
            Object result = elements[t];
            if (result == null) {
                return false;
            }

            // 设置为null& tail指针指向弹出值后的slot
            elements[t] = null;
            tail = t;
            return false;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            Object result = elements[head];
            if (result == null) {
                return -1;
            }
            return (int) result;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            Object result = elements[(tail - 1) & (elements.length - 1)];
            if (result == null) {
                return 0;
            }

            return (int) result;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return !isFull();
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return elements[tail] != null && tail > 0 && tail == head;
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayDeque x = new ArrayDeque(3);
        x.addLast(1);
        x.addLast(2);
        x.addLast(3);
        x.addLast(4);
        x.addLast(5);
        x.addLast(6);
        x.addLast(7);
        x.addLast(8);

        System.out.println(x.size());

        MyCircularDeque circularDeque = new MyCircularDeque(5); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        // 已经满了，返回 false
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());
    }
}
