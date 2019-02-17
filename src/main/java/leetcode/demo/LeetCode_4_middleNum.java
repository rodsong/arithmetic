package leetcode.demo;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * <p>LeetCode_4_middleNum</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月13日
 */
public class LeetCode_4_middleNum {

    /**
     * 如果两个数组的中位数 mid1 < mid2, 则说明合并后的中位数位于 num1.right + num2之间
     * 否则合并后的中位数位于 nums2.right + nums1 之间 (right 是相对于 mid 而言的)
     * getKth 函数负责找到两个数组合并(假设)后有序的数组中的第 k 个元素, k 从 1 开始计算
     **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        // l: 合并后数组的左半部分的最后一个数 r: 合并后数组的右半部分的第一个数
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;

        // 如果 m+n 是奇数 getKth 的返回值是相同的, 是偶数则是合并后数组的中间两个数
        if (l == r) {
            return getKth(nums1, 0, nums2, 0, l);
        } else {
            return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
        }
    }

    /**
     * 获取两个数组中的第k个元素
     *
     * @param num1Pos 数组一种的开始位置
     * @param num2Pos 数组二种的开始位置
     */
    private double getKth(int[] nums1, int num1Pos, int[] nums2, int num2Pos, int k) {
        // 边界情况, 如果 nums1数组已经穷尽了, 则只能返回 nums2 中的第 k 个元素
        if (num1Pos > nums1.length - 1) {
            return nums2[num2Pos + k - 1];
        }

        if (num2Pos > nums2.length - 1) {
            return nums1[num1Pos + k - 1];
        }
        // 边界情况, k = 1 则返回两个数组中最小的那个
        if (k == 1) {
            return Math.min(nums1[num1Pos], nums2[num2Pos]);
        }
        // 在 nums1 和 nums2 当前范围内找出 mid1 和 mid2 判断舍弃哪半部分
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (num1Pos + k / 2 - 1 < nums1.length) {
            mid1 = nums1[num1Pos + k / 2 - 1];
        }
        if (num2Pos + k / 2 - 1 < nums2.length) {
            mid2 = nums2[num2Pos + k / 2 - 1];
        }
        // mid1 < mid2 在 nums1.right 和 nums2 之间搜索, 丢掉 k/2 个数.
        if (mid1 < mid2) {
            return getKth(nums1, num1Pos + k / 2, nums2, num2Pos, k - k / 2);
        } else {
            return getKth(nums1, num1Pos, nums2, num2Pos + k / 2, k - k / 2);
        }
    }


    private double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        // l: 合并后数组的左半部分的最后一个数 r: 合并后数组的右半部分的第一个数
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        // 奇数
        if (l == r) {
            return getTempK(nums1, nums2, l);
        } else {
            return (double) (getTempK(nums1, nums2, l) + getTempK(nums1, nums2, r)) / 2;
        }
    }

    private int getTempK(int[] nums1, int[] nums2, int k) {
        int step1 = 0;
        int step2 = 0;
        int result = 0;
        while (k > 0) {
            if (step1 > nums1.length - 1) {
                result = nums2[step2];
                step2++;
            } else if (step2 > nums2.length - 1) {
                result = nums1[step1];
                step1++;
            } else if (nums1[step1] > nums2[step2]) {
                result = nums2[step2];
                step2++;
            } else {
                result = nums1[step1];
                step1++;
            }
            k--;
        }
        return result;
    }


    public static void main(String[] args) {
        LeetCode_4_middleNum test = new LeetCode_4_middleNum();
        double rel = test.findMedianSortedArrays2(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(rel);
    }
}
