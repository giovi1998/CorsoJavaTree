package giorni.EserciziLeetcode.Mappe;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 */
class Solution {
    public static void main(String[] args) {
        int [] nums={2,1,6,4,11,15,3};
        int target=9;
        int []twosum=twoSum(nums,target);
        for (int j : twosum) {
            System.out.println(j);
        }

    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }
}
