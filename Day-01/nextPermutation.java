// Problem: Next Permutation
// Link: https://leetcode.com/problems/next-permutation/

/*
Approach:
- Traverse from the back and find the first index where nums[i] < nums[i+1].
  This is the breakpoint.
- Again traverse from the end and find the next greater element than nums[i].
- Swap both elements.
- Reverse the remaining part after index i to get the next lexicographical permutation.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}