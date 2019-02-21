import java.util.Arrays;
import java.util.Stack;

/**
 * <p>QuickSort</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月17日
 */
public class QuickSort_TopK_2 {

    private static Stack<Integer> topK(int[] arr, int k) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() < k) {
                stack.add(i);
            } else {
                if (stack.peek() < arr[i]) {
                    stack.pop();
                    stack.push(arr[i]);
                }
            }
        }

        return stack;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(x));

        Stack stack = topK(x, 4);

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
