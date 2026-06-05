// Problem: Majority Element
// link: https://leetcode.com/problems/majority-element/description/

/*
Brute Force: 

- Iterate through the array to select each element one by one.
- For each selected element, run another loop to count its occurrences in the given array.
- If the occurrence of any element is greater than the floor of (N/2), return that element immediately as the majority element.

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

import java.util.HashMap;

class Solution1 {
    public int majorityElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]== nums[j]){
                    count++;
                }
            }
            if(count > nums.length/2) return nums[i];
        }
        return -1;
    }
}


/*
Better Approach: 

- Use a hashmap to store elements as (key, value) pairs, where the key is the element of the array and the value is the number of times it occurs.
- Traverse the array and update the value of the corresponding key in the hashmap.
- Simultaneously check if the value (the count) of any key is greater than the floor of (N/2).
- If the value is greater than the floor of (N/2), return the key immediately as the majority element.
- If no majority element is found, continue iterating through the array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution2 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])> nums.length/2 ) return nums[i];
        }
        return -1;
    }
}

/*
Optimal Approach:

- Initialize two variables: count to track the count of elements, and element to keep track of the element being counted.
- Traverse through the given array. If count is 0, store the current value of the array as element.
- If the current element in the array is the same as element, increment the count by 1.
- If the current element is different from element, decrement the count by 1.
- At the end of the traversal, the integer stored in element will be the expected result (the majority element).

Time Complexity: O(n)
Space Complexity: O(1)

 */

class Solution3 {
    public int majorityElement(int[] nums) {
        int count=0;
        int elem=0;
        for(int i=0;i < nums.length;i++){
            if(count==0){
                 elem=nums[i];
                 count++;
            }
            else if(nums[i]== elem) count++;
            else count--;
        }
        return elem;
    }
}
