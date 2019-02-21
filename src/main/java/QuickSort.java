import java.util.Arrays;

/**
 * <p>QuickSort</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月17日
 */
public class QuickSort {

    private static int partition(int[] arr, int l, int h) {
        int pivod = arr[h];
        for (int i = l; i <= h; i++) {
            if (i == h) {
                swap(arr, l, i);
                return l;
            }

            if (arr[i] < pivod) {
                swap(arr, l, i);
                l++;
            }
        }
        return l;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        // 分区函数
        int middle = partition(arr, p, r);
        //递归
        quickSort(arr, p, middle - 1);
        quickSort(arr, middle + 1, r);
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 6, 4, 3, 1,3};

        quickSort(x, 0, x.length - 1);

        System.out.println(Arrays.toString(x));
    }
}
