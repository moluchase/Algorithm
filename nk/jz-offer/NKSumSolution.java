public class NKSumSolution {
    public static int Sum_Solution(int n) {
        int res=0;
        boolean b=n>0&&(res=Sum_Solution(n-1)+n)>0;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(3));
    }
}
