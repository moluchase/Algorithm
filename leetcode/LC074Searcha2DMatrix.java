/**
 * @author pengsong
 * @date 17/10/19 上午10:34
 */

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */

/*
这道题在剑指offer上有，主要是找出子问题，从右下角开始找
 */
public class LC074Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)return false;
        int n=matrix.length;
        int m=matrix[0].length;
        int index1,index2;
        index1=n-1;
        index2=0;
        while (index1>=0&&index2<m){
            if(target>matrix[index1][index2])index2++;
            else if(target<matrix[index1][index2])index1--;
            else return true;
        }
        return false;
    }
}
