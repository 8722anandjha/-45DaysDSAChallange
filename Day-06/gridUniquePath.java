// Problem: Grid Unique Path
// link: https://leetcode.com/problems/unique-paths/description/

/*
Approach:

- Create a 2D array dp[m][n] where:
    - dp[i][j] = number of unique paths to reach cell (i, j)
- Initialize Base Cases
- Traverse the matrix:
    - If the cell belongs to: first row (i == 0) OR first column (j == 0)
        - then set: dp[i][j] = 1
        - because there is only one possible path.
- Fill Remaining Cells
    For every other cell: dp[i][j]=dp[i−1][j]+dp[i][j−1]
        Explanation:
        dp[i-1][j] → paths coming from top  
        dp[i][j-1] → paths coming from left
- Return: dp[m-1][n-1]

Time Complexity: O(m x n)
Space Complexity: O(m x n)
*/

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    matrix[i][j]=1;
                }
                else{
                    matrix[i][j]= matrix[i][j-1] + matrix[i-1][j];
                }
            }
        }
        return matrix[m-1][n-1];
    }
}

/*
optimal Approach:

- Create array dp[n]
- Fill dp with 1
- for i = 1 to m-1
      - for j = 1 to n-1
           - dp[j] = dp[j-1] + dp[j]
- return dp[n-1]

Time Complexity: O(m x n)
Space Complexity: O(n)
*/

class Solution2 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
}