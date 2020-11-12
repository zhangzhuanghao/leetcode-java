// code by 小豪, 2020/11/12

public class Solution {

    public void nextPermutation(int[] nums) {
        int n = nums.length, k, l;
        for (k = n-2; k >= 0; k--)
            if (nums[k] < nums[k + 1])
                break;
        if (k < 0)
            reverse(nums, 0, n-1);
        else {
            for (l = n-1; l > k; l--)
                if (nums[l] > nums[k])
                    break;
            {
                int other = nums[k];
                nums[k] = nums[l];
                nums[l] = other;
            }
            reverse(nums, k+1, n-1);
        }
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int other = arr[start];
            arr[start++] = arr[end];
            arr[end--] = other;
        }
    }
}
