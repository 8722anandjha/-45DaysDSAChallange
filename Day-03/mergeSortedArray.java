// Problem: Merge Sorted Array
// link: https://leetcode.com/problems/merge-sorted-array/description/

/*
Approach: 
- Initialize three pointers: One points at the last valid index (excluding zeros) of nums1, one points at the last valid index of nums2 andd the last pointer points to last index of nums1.
- Compare the elements pointed by the first two pointers and whichever is larger, place it at the third pointer's index.
- Move the respective pointer one step back and also move the third pointer one step back.
- If there are any remaining elements in nums2, then copy them in nums1. If any elements remain in nums1, they’re already in place
- The result is a fully merged and sorted array stored in nums1 itself.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j= n-1;
        int k= m+n-1;
        while(j>=0 && i>=0){
            if(nums1[i]> nums2[j]){
                nums1[k--]= nums1[i--];
            }
            else {
                nums1[k--]=nums2[j--];
            }
        }
        while(j>=0){
          nums1[k--]=nums2[j--];   
        }
    }
}