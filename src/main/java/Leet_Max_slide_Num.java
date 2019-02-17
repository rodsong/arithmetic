
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>main.java.Leet_Max_slide_Num</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月14日
 *
 *
 *  有一个长度为n的整型数组arr 和一个大小为w 的窗口从数组的最左边滑到最右边，窗口每次向右滑动一个位置，求每个窗口所含arr元素的最大值。
 */
public class Leet_Max_slide_Num {

    private int[] maxSlide(int[] arr, int w) {
        int[] res = new int[arr.length - w + 1];

        LinkedList<Integer> maxQueue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            //队列的末尾索引对应的数组元素<= 当前遍历的数组元素
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[i]) {
                maxQueue.pollLast();//弹出队列末尾的索引
            }

            maxQueue.addLast(i);//将当前遍历数组索引存入队列

            //因为索引是递增的0~n-1，如果队首索引与当前遍历的索引差值==w，说明这个索引过期了
            if (maxQueue.peekFirst() == i - w) {
                maxQueue.pollFirst();//将队首索引移除
            }

            if (i + 1 >= w) {//若遍历的索引加1大于等于3，那就可以才是获取队首索引对应的元素作为结果集之一存入res数组
                res[index++] = arr[maxQueue.peekFirst()];
            }
        }
        return res;
    }


    private int[] maxSlide2(int[] arr, int w) {
        int[] res = new int[arr.length - w + 1];

        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            //队列的末尾索引对应的数组元素<= 当前遍历的数组元素
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[i]) {
                maxQueue.pollLast();//弹出队列末尾的索引
            }

            maxQueue.addLast(i);//将当前遍历数组索引存入队列

            //因为索引是递增的0~n-1，如果队首索引与当前遍历的索引差值==w，说明这个索引过期了
            if (maxQueue.peekFirst() == i - w) {
                maxQueue.pollFirst();//将队首索引移除
            }

            if (i + 1 >= w) {//若遍历的索引加1大于等于3，那就可以才是获取队首索引对应的元素作为结果集之一存入res数组
                res[index++] = arr[maxQueue.peekFirst()];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 2, 7, 8};
        int w = 3;

        System.out.println(Arrays.toString(arr));
    }

}
