// 2020/12/24

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cur = 0, val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && val == nums[i]) {
                i++;
            }
            if (i == nums.length) {
                return cur + 1;
            }
            val = nums[i];
            nums[++cur] = val;
        }
        return cur + 1;
    }
}
