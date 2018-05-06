/**
 * @author pengsong
 * @date 18/1/10 上午8:37
 */
/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 */
public class LC304RangeSumQuery2DImmutable {

    int [][] matrix;
    public LC304RangeSumQuery2DImmutable(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        this.matrix=matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        if(col1==0){for(int i=row1;i<=row2;i++)res+=matrix[i][col2];}
        else for(int i=row1;i<=row2;i++)res+=matrix[i][col2]-matrix[i][col1-1];
        return res;
    }
}
