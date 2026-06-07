// Problem: Reverse Pairs
// link: https://leetcode.com/problems/reverse-pairs/description/

 /*
 Approach:

- The steps are basically the same as they are in the case of the merge sort algorithm. The change will be just in the mergeSort() function:

    - In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the mergeSort().
    - We will add the numbers returned by the previous mergeSort() calls.
    - Before the merge step, we will count the number of pairs using a function, named countPairs().
    - We need to remember that the left half starts from low and ends at mid, and the right half starts from mid+1 and ends at high.
- The steps of the countPairs() function will be as follows:

    - We will declare a variable, cnt, initialized with 0.
    - We will run a loop from low to mid, to select an element at a time from the left half.
    - Inside that loop, we will use another loop to check how many elements from the right half can make a pair.
    - Lastly, we will add the total number of elements i.e. (right-(mid+1)) (where right = current index), to the cnt and return it.

Time Complexity: O(2N*logN)
Space Complexity: O(N)

 */

class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        // count reverse pairs
        count += countPairs(nums, low, mid, high);

        // merge arrays
        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {

        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (right <= high &&
                   nums[i] > 2L * nums[right]) {

                right++;
            }

            count += (right - (mid + 1));
        }

        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}