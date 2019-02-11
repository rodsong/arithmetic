package lc.demo;

import java.util.ArrayDeque;

/**
 * 设计实现双端队列。
 */
public class LeetCode_641 {


    class MyCircularDeque {

        private static final int MIN_INITIAL_CAPACITY = 8;

        Object[] elements;

        private int head;

        private int tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            if(k<MIN_INITIAL_CAPACITY){
                k = MIN_INITIAL_CAPACITY;
            }
            elements = new Object[k];

            head = 0;
            tail = elements.length-1;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {

            elements[head = (head - 1) & (elements.length - 1)] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            return false;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            return false;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            return false;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return 0;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return 0;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return false;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {

            return false;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> x = new ArrayDeque<>(10);

        x.addFirst(1);
   }
}
