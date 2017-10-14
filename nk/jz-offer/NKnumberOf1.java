import java.util.ArrayList;

public class NKnumberOf1 {

    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n<10)return n>=1?1:0;
        int times=(int)(Math.pow(10,String.valueOf(n).length()-1));
        int a=Integer.parseInt(String.valueOf(n).substring(0,1));
        int b=Integer.parseInt(String.valueOf(n).substring(1,String.valueOf(n).length()));
        return a>1?times+a*NumberOf1Between1AndN_Solution(times-1)+NumberOf1Between1AndN_Solution(b):
                b+1+NumberOf1Between1AndN_Solution(times-1)+NumberOf1Between1AndN_Solution(b);
    }

    public static void main(String[] args) {
        for(int n=0;n<=120;n++){
            if(n%10==0){
                System.out.println();
            }
            System.out.print(NumberOf1Between1AndN_Solution(n)+",");

        }

        //System.out.println(Integer.parseInt(String.valueOf(10001).substring(1,String.valueOf(10001).length())));
    }
}
