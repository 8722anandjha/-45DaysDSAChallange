// Problem: Find the Duplicate Number
// link: https://leetcode.com/problems/find-the-duplicate-number/description/

/*
Approach: 
- Create a frequency array of size N+1 and initialize all elements to 0. This will keep track of the occurrences of each element in the array.
- Traverse through the given array.
- For each element, check its frequency in the frequency array:
    - If the frequency is 0, increase it by 1, indicating that the element has been encountered for the first time.
    - If the frequency is not 0, this means the element has appeared before, and it is the required answer.
Return or print the element as the first repeating element.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int findDuplicate(int[] nums) {
       int[] freq= new int[nums.length-1];
       for(int i=0;i<nums.length;i++){
        int num= nums[i];
        if(freq[num-1]!=0) return num;
        else{
            freq[num-1]=1; 
        }
       }
       return -1;
    }
}
