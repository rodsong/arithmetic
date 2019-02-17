package leetcode.demo;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @date 2019年01月21日
 */
public class search_in_rotated_sorted_array_33 {

    public int search(int[] nums, int target) {
        return temp_search(nums, 0, nums.length - 1, target);
    }

    // 先分2段，有一段是有序的用二分查找，一段是无序的再次分2段，依次迭代
    private int temp_search(int[] nums, int low, int height, int target) {
        if (low > height) {
            return -1;
        }

        int result = -1;
        int middle = (low + height) / 2;
        if (nums[low] <= nums[middle]) {
            result = bsearch(nums, low, middle, target);
            if (result == -1) {
                result = temp_search(nums, middle + 1, height, target);
            }
        } else {
            result = bsearch(nums, middle, height, target);
            if (result == -1) {
                result = temp_search(nums, low, middle - 1, target);
            }
        }
        return result;
    }

    // 二分查找
    private int bsearch(int[] nums, int low, int height, int target) {
        if (low > height) {
            return -1;
        }
        int middle = (low + height) / 2;

        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return bsearch(nums, low, middle - 1, target);
        } else if (nums[middle] < target) {
            return bsearch(nums, middle + 1, height, target);
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        search_in_rotated_sorted_array_33 test = new search_in_rotated_sorted_array_33();
        int[] x = new int[]{1};
        //System.out.println(test.search(x, 1));
        System.out.println(test.bsearch(x, 0,x.length-1,1));
    }
}
