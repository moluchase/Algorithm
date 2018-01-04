/**
 * @author pengsong
 * @date 18/1/4 上午8:15
 */
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
public class LC240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)return false;
        int n,m,i,j;
        n=matrix.length;
        m=matrix[0].length;
        i=n-1;
        j=0;
        while (i>=0&&j<m){
            if(matrix[i][j]>target)i--;
            else if(matrix[i][j]<target)j++;
            else return true;
        }
        return false;
    }
}
