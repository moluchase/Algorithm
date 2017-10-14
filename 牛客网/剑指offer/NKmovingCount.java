public class NKmovingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        if(rows==0||cols==0)return 0;
        int[][]flag=new int[rows][cols];
        return isArrival(0,0,threshold,flag);
    }

    //子问题，判断该格子是否可走，可以则返回下一步的4个方位的格子
    private static int isArrival(int i, int j,int threshold, int[][] flag) {
        if(isSatisfy(i,j,threshold,flag)){
            flag[i][j]=1;
            return isArrival(i-1,j,threshold,flag)+isArrival(i+1,j,threshold,flag)+
                    isArrival(i,j-1,threshold,flag)+isArrival(i,j+1,threshold,flag)+1;
        }
        return 0;
    }

    //判断该格子是否可走
    private static boolean isSatisfy(int i, int j,int threshold,int[][]flag) {
        if(!((i>=0&&i<flag.length)&&(j>=0&&j<flag[0].length)))return false;
        if(flag[i][j]==1)return false;
        String s1=String.valueOf(i);
        String s2=String.valueOf(j);
        int temp=0;
        for(int k=0;k<s1.length();k++)temp+=s1.charAt(k)-'0';
        for (int k=0;k<s2.length();k++)temp+=s2.charAt(k)-'0';
        if(temp>threshold)return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(18,40,40));
    }
}
