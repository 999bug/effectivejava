package effectivejava.chapter4.item25;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] ints = new Solution().sortColors(new int[]{2, 0, 2,0, 1, 1, 0});
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortColors(int[] nums) {
        int[] retNums = new int[nums.length];
        // deep clone
        System.arraycopy(nums, 0, retNums, 0, retNums.length);
        Stack<Integer> stack = new Stack<>();
        int left = 0, right = nums.length - 1, tmpNums = 0;

        for (int num : retNums) {
            if (num == 0) {
                nums[left++] = num;
            } else if (num == 2) {
                nums[right--] = num;
            } else {
                stack.push(num);
            }
        }

        for (int i = left; i <= right; i++) {
            nums[i] = stack.pop();
        }
        return nums;
    }
}