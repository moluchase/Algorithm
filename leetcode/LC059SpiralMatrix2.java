public class LC059SpiralMatrix2 {
    public static int[][] generateMatrix(int n) {
        int[][] arr=new int[n][n];
        if(n<=0)return arr;
        int num=0;
        int i,j;
        int left,right,on,under;
        i=j=0;
        left=on=0;
        right=under=n-1;
        while (true) {
            if (i <=right) {
                while (i <= right) {
                    arr[j][i] = ++num;
                    i++;
                }
                i--;
                j++;
                on++;
            }else return arr;
            if (j <= under) {
                while (j<=under){
                    arr[j][i]=++num;
                    j++;
                }
                j--;
                i--;
                right--;
            }else return arr;
            if(i>=left){
                while (i>=left){
                    arr[j][i]=++num;
                    i--;
                }
                i++;
                j--;
                under--;
            }else return arr;
            if(j>=on){
                while (j>=on){
                    arr[j][i]=++num;
                    j--;
                }
                j++;
                i++;
                left++;
            }else return arr;
        }
    }

    public static void main(String[] args) {
        int[][] a=generateMatrix(3);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+",");
            }
            System.out.println();
        }
    }
}
