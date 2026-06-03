// Problem: Sort Colors
// Link: https://leetcode.com/problems/sort-colors/

/*
Approach:
- Use the Dutch National Flag Algorithm with three pointers:
  start, middle, and end.
- If nums[middle] == 0:
  swap with start and move both pointers forward.
- If nums[middle] == 2:
  swap with end and move end backward.
- If nums[middle] == 1:
  simply move middle forward.
- This sorts the array in a single traversal without extra space.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void sortColors(int[] nums) {
        int start=0;
        int middle=0;
        int end= nums.length-1;
        while(middle <= end){
            if(nums[middle] ==0){
                int temp= nums[middle];
                nums[middle++]= nums[start];
                nums[start++]= temp;
            }
            else if(nums[middle] == 2){
                int temp= nums[middle];
                nums[middle]= nums[end];
                nums[end--]= temp;
            }
            else{
                middle++;
            }
        }  
    }
}