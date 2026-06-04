// Problem: Find the repeating and missing number
// link: https://takeuforward.org/plus/dsa/problems/find-the-repeating-and-missing-number?source=strivers-sde-sheet

/*
Approach:
- use cyclic sort to sort the array.
- again use it to check all elements are it's correct position or not.
    - if it's at correct index then move
    - else return new int[] {currElem , currIndx+1}.

Time Complexity: O(n).
Space Complexity: O(1).
*/

class Solution {
    public static int[] findMissingRepeatingNumbers(int[] nums) {
    int i = 0;

    while(i < nums.length) {
        int correctIndex = nums[i] - 1;

        if(nums[i] != nums[correctIndex]) {
            int temp = nums[i];
            nums[i] = nums[correctIndex];
            nums[correctIndex] = temp;
        } 
        else {
            i++;
        }
    }

    for(int j = 0; j < nums.length; j++) {
        if(nums[j] != j + 1) {
            return new int[]{nums[j], j + 1};
        }
    }

    return new int[]{-1, -1};
}
}