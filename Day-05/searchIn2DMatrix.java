// Problem: Search a 2D MAtrix
// link: https://leetcode.com/problems/search-a-2d-matrix/description/


/*
Brute Forch Approach:

- use linear search  to get the answer by checking all the elements of the given matrix. So, we will traverse the matrix and check every element if it is equal to the given ‘target’.
    - We will use a loop(say i) to select a particular row at a time.
    - Next, for every row, we will use another loop(say j) to traverse each column.
    - Inside the loops, we will check if the element i.e. matrix[i][j] is equal to the ‘target’. If we find any matching element, we will return true.
    - Otherwise, after completing the traversal, we will return false.

Time Complexity: O(m*n)
Space Complexity: O(1)
*/

class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}

/*
Better Approach:

- reduce search space by iterating over rows.
    - use loop over row.
    - check ( mat[row][0] <= target && mat[row][colLen-1]>= target ) 
    - if found true, use binary search over that row.

Time Complexity: O(m*log(n))
Space Complexity: O(1)
*/

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row=0;row< matrix.length;row++){
            if(matrix[row][0] <= target && matrix[row][matrix[row].length-1] >= target){
                return search(matrix,row,target);
            }
        }
        return false;
    }
    public boolean search(int[][] matrix, int row, int target){
        int left=0;
        int right= matrix[row].length-1;
        while(left <= right){
            int mid= left+(right-left)/2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
}

/*
Better Approach:

- use two pointer rowSt=0 and colEnd= row.length-1.
- iterate over matrix while rowSt > matrix.length && colEnd >= 0. 
- check colElem is equal to target?
    - if(mat[rowSt][colEnd] == target) return true
    - if(mat[rowSt][colEnd] > target) colEnd--
    - if(mat[rowSt][colEnd] < target) rowSt++

Time Complexity: O(n) // n is column length;
Space Complixity: O(1)
*/

class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
       int rowSt= 0;
       int colEnd= matrix[0].length-1;
       while(rowSt < matrix.length && colEnd >=0){
            if(matrix[rowSt][colEnd] == target) return true;
            else if(matrix[rowSt][colEnd] > target) colEnd--;
            else rowSt++;
       }
       return false;
    }
}


/*
Optimal Approach:

- use two pointer rowSt=0 and rowEnd= n-1.
- while the rowSt<= rowEnd
    - find middle between the two pointer.
    - check 
        -  if (mat[mid][0] <= target && mat[mid][n-1]>= target)
               - use binary search over that mid index row.
        -  if (mat[mid][0] > target) rowEnd= mid-1.
        -  if (matrix[mid][n-1] < target) rowSt= mid+1.

Time Complexity: O(log(m*n))
Space Complexity: O(1)
*/

class Solution4 {
    public boolean searchMatrix(int[][] matrix, int target) {
       int rowSt= 0;
       int colEnd= matrix[0].length-1;
       while(rowSt < matrix.length && colEnd >=0){
            if(matrix[rowSt][colEnd] == target) return true;
            else if(matrix[rowSt][colEnd] > target) colEnd--;
            else rowSt++;
       }
       return false;
    }
}