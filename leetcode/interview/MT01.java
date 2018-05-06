package interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/22 下午8:08
 */
public class MT01 {

    public  static int distance(String s,String t){
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i))res++;
        }
        return res;
    }

    public static int theAllDistance(String s,String t){
        int res=0;
        int ls=s.length();
        int lt=t.length();
        for(int i=0;i<=ls-lt;i++){
            res+=distance(s.substring(i,lt+i),t);
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s,t;
        s=scanner.next();
        t=scanner.next();
        scanner.close();
        System.out.println(theAllDistance(s,t));

    }
}
