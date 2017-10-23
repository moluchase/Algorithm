/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */

/*
这里可以用两个一维数组来做，空间复杂度为O(n+m)
也可以使得空间复杂度为O(1)
遍历全部的元素，如果该元素为0，将元素对应的行的第一个下标置为0，对应列的第一个下标置为0
重新对第一行和第一列遍历，如果有0，将该行/列置为0
这里有个问题需要知道，如果第0行或者第0列的元素为0，需要使用两个标志位来记录，最后再判断是否将第0行或第0列置为0
 */

public class LC073SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix==null)return;
        int n=matrix.length;
        int m=matrix[0].length;
        boolean row,col;
        row=col=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    if(i==0)row=true;
                    if(j==0)col=true;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<m;j++)matrix[i][j]=0;
            }
        }
        for(int j=1;j<m;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<n;i++)matrix[i][j]=0;
            }
        }
        if(row||col){
            if(col)for(int i=0;i<n;i++)matrix[i][0]=0;
            if(row)for(int j=1;j<m;j++)matrix[0][j]=0;
        }
    }
}
