// Problem: Pascal's Triangle
// Link: https://leetcode.com/problems/pascals-triangle/

/*
Approach:
- Generate each row iteratively.
- First and last elements of every row are always 1.
- Middle elements are calculated using the previous row.

Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

import java.util.ArrayList;

class Solution {

    public ArrayList<ArrayList<Integer>> generate(int n) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            ans.add(new ArrayList<>());

            for (int j = 0; j <= i; j++) {

                // First and last element of row
                if (j == 0 || j == i) {
                    ans.get(i).add(1);
                }

                // Middle elements
                else {
                    int prevSum =
                        ans.get(i - 1).get(j) +
                        ans.get(i - 1).get(j - 1);

                    ans.get(i).add(prevSum);
                }
            }
        }

        return ans;
    }
}