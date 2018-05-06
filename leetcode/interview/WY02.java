package interview;

import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/27 下午8:20
 */
public class WY02 {

    public static int getNum(int l,int r){
        String s="";
        int num=0;
        int res=0;
        for(int i=1;i<=r;i++){
            num=(num+i)%3;
            if(i>=l&&num==0)res++;
//            char[]chars=Integer.toString(i).toCharArray();
//            for(char c:chars){
//                num+=c-'0';
//            }
//            if(i>=l){
//                if(num%3==0)res++;
//            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int l,r;
        l=scanner.nextInt();
        r=scanner.nextInt();
        scanner.close();
        System.out.println(getNum(l,r));
    }
}
