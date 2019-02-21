import java.util.Arrays;

/**
 * <p>QuickSort</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月17日
 */
public class QuickSort_TopK {

    /**
     * 从大到小排列
     */
    private static int partition(int[] arr, int l, int h) {
        int pivod = arr[h];
        for (int i = l; i <= h-1; i++) {
            //从大到小排列8u
            if (arr[i] > pivod) {
                swap(arr, l, i);
                l++;
            }
        }
        // 交换基准点
        swap(arr, l, h);
        return l;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    private static int[] topK(int[] arr, int p, int r, int k) {
        if (p >= r) {
            return arr;
        }

        // 分区函数
        int middle = partition(arr, p, r);
        if (middle == k - 1) {
            return arr;
        } else if (middle < k - 1) {
            topK(arr, middle + 1, r, k);
        } else {
            topK(arr, p, middle - 1, k);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        int k = 3;
        int[] result = Arrays.copyOfRange(topK(x, 0, x.length - 1, k), 0, k );
        System.out.println(Arrays.toString(result));
    }
}
