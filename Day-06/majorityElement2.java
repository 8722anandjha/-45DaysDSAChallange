// Problem: Majority Element-II
// link: https://leetcode.com/problems/majority-element-ii/description/


/*
Better Approach:

- Use a hashmap (or a frequency array if the array size is small) to store the elements as key-value pairs, where the key is the element and the value is the number of times it occurs in the array.
- Traverse the entire array, updating the occurrences of each element in the hashmap.
- After the traversal, check the hashmap to see if any element's value (frequency) is greater than the floor of N/3. If it is, include the element in the answer array.
- If the size of the answer array reaches 2, break out of the loop, as there cannot be more than two majority elements.
- Finally, return the answer array containing the majority elements. If no such elements are found, return -1.

Time Complexity: O(N*logN)
Space Complexity: O(N)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) > nums.length/3) {
                if(!list.contains(nums[i])) list.add(nums[i]);
                if(list.size()==2) break;
            };
        }
        return list;
    }
}

/*
Optimal Approach:

- Initialize four variables: cnt1 and cnt2 for tracking the counts of elements, and el1 and el2 for storing the potential majority elements.
- Traverse through the given array:
    - If cnt1 is 0 and the current element is not equal to el2, set el1 to the current element and increment cnt1 by 1.
    - If cnt2 is 0 and the current element is not equal to el1, set el2 to the current element and increment cnt2 by 1.
    - If the current element is equal to el1, increment cnt1 by 1.
    - If the current element is equal to el2, increment cnt2 by 1.
    - In all other cases, decrease cnt1 and cnt2 by 1.
- After processing all elements, el1 and el2 should be the candidate elements for majority. To confirm:
    - Use another loop to manually check the counts of el1 and el2 in the array.
    - If either el1 or el2's count is greater than floor(N/3), it is considered a valid majority element.

Time Complexity: O(N)
Space Complexity: O(1)
*/

public class majorityElement2 {
     public List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i]; 
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i]; 
            } else if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++; 
            } else {
                cnt1--; 
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0; 
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++; 
            if (nums[i] == el2) cnt2++;
        }

        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>(); 
        if (cnt1 >= mini) result.add(el1);
        if (cnt2 >= mini && el1 != el2) result.add(el2);

        return result;
    }
}