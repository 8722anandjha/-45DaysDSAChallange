// Problem: Set Matrix Zeroes
// Link: https://leetcode.com/problems/set-matrix-zeroes/

/*
Approach:
- Create two boolean arrays: row[] and col[].
- Traverse the matrix and mark rows and columns that contain 0.
- Traverse the matrix again.
- If the current cell's row or column is marked,
  set the cell value to 0.

Time Complexity: O(m × n)
Space Complexity: O(m + n)
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row= new boolean[matrix.length];
        boolean[] col= new boolean[matrix[0].length];
// mark rows and  columns that contain 0.
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j< matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row[i]= true;
                    col[j]= true;
                }
            }
        }
//  set the cell value to 0.
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[i].length;j++){
                if(row[i] || col[j]) {
                    matrix[i][j]= 0;
                }
            }
        }
    }
}
