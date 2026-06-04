// Problem: merge Intervals
// link: https://leetcode.com/problems/merge-intervals/

/*
Approach:
- Sort the intervals based on their starting points. This ensures overlapping intervals come together.
- Initialize an empty list to store the final merged intervals.
- If the list is empty or the current interval starts after the last one ends, it means there is no overlap, so just add it to the list.
- If the current interval starts before or exactly at the end of the last one, it means there is overlap. So, combine both by extending the end of the last one to the further end of the two.
- Keep doing this until all intervals have been checked. The final list will now contain only non-overlapping, merged intervals.

Time Compilexity: O(n)
Space Compilexity: O(n)
*/

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        ArrayList<int[]> list= new ArrayList<>();
        int[] prev= intervals[0];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<= prev[1]){
                prev[1]= Math.max(prev[1],intervals[i][1]);
            }
            else{
                list.add(prev);
                prev= intervals[i];
            }
        }
        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
}