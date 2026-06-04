// Provlem: Count inversions in an array
// link: https://takeuforward.org/plus/dsa/problems/count-inversions?source=strivers-sde-sheet

/*
Approach:
- Apply merge sort recursively to divide the array into two halves.
- During the merge step:
    - If arr[left] <= arr[right], place arr[left] into the temp array and move left++.
    - Otherwise, place arr[right] into the temp array. Since arr[left] > arr[right], all elements from arr[left] to arr[mid] form inversions with arr[right]. So add (mid - left + 1) to the inversion count.
- Copy the merged elements back into the original array.
- The total inversion count is the sum of:
    - Inversions in the left half
    - Inversions in the right half
    - Inversions across the halves (counted during merge)

Time Comliexity: O(nlogn)
Space Complexity: O(n)
*/

import java.util.ArrayList;

class Solution {
    public long numberOfInversions(int[] nums) {
         return mergeSort(nums, 0, nums.length - 1);
    }
    static int mergeSort(int[] arr, int low, int high) {

        if(low >= high) return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        count += merge(arr, low, mid, high);

        return count;
    }

    static int merge(int[] arr, int low, int mid, int high) {

        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        int count = 0;

        while(left <= mid && right <= high) {

            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else {

                // inversion found
                count += (mid - left + 1);

                temp.add(arr[right]);
                right++;
            }
        }

        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }
}
