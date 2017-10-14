public class LCrotateImage {
    //先转置，然后反转
    public static void rotate(int[][] matrix) {
        int temp;
        //转置
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //反转
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix[0].length-j-1];
                matrix[i][matrix[0].length-j-1]=temp;
            }
        }
        /*
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
        */
    }

    public static void main(String[] args) {
        rotate(new int[][]{{1},{4},{7}});
    }
}
