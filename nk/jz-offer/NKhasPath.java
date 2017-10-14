public class NKhasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag=new int[matrix.length];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(helper(matrix,rows,cols,str,i,j,flag,0))return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, char[] str, int i, int j, int[] flag,int si) {
        if(si==str.length)return true;
        if(!((i>=0&&i<rows)&&(j>=0&&j<cols)))return false;
        int index=i*cols+j;
        if(flag[index]==1)return false;
        if(str[si]!=matrix[index])return false;
        flag[index]=1;
        if(helper(matrix,rows,cols,str,i-1,j,flag,si+1)
                ||helper(matrix,rows,cols,str,i+1,j,flag,si+1)
                ||helper(matrix,rows,cols,str,i,j-1,flag,si+1)
                ||helper(matrix,rows,cols,str,i,j+1,flag,si+1))return true;
        flag[index]=0;
        return false;
    }
}
