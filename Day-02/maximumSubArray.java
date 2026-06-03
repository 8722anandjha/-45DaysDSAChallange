// Problem: Maximum Subarray
//link: https://leetcode.com/problems/maximum-subarray/


/*
# Kadane's Algorithm

Approach:
Maintain a running sum and reset it when it becomes negative.

Time Complixity: O(n)
Space Complixity: O(1)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=0;
        int maxSum= Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            currSum+= nums[i];
            maxSum= Math.max(maxSum,currSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}