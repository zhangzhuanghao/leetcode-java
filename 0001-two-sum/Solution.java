// 2020/12/19

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (memo.containsKey(target-nums[i])) {
                return new int[] {i, memo.get(target-nums[i])};
            }
            memo.put(nums[i], i);
        }
        return new int[0];
    }
}
