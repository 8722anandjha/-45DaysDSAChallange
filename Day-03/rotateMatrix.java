// Problem: Rotate Matrix
// link: https://leetcode.com/problems/rotate-image/description/

/*
Approach: 
- first transpose it then revrse each row element.

Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

class Solution {
    public void rotate(int[][] matrix) {

        // Transpose
         for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
         }
        // Reverse each row elem
        for(int i=0;i<matrix.length;i++){
            int start=0;
            int end= matrix[i].length-1;
            while(start<end){
                int temp= matrix[i][start];
                 matrix[i][start++]=  matrix[i][end];
                  matrix[i][end--]= temp;
            }
        }
    }
}