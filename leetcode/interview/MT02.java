package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/22 下午8:30
 */
public class MT02 {

    public static boolean getTheNumber(char[] chars,char[] cs){
        int k=0;
        for(int j=0;j<cs.length;j++){
            while (k<chars.length&&chars[k]<cs[j])k++;
            if((k<chars.length&&chars[k]!=cs[j])||k==chars.length)return false;
            k++;
        }
        return true;
    }

    public static int getMinNumber(char[]chars){
        int i=1;
        while (true){
            char[] cs=Integer.toString(i).toCharArray();
            Arrays.sort(cs);
            if(getTheNumber(chars,cs))i++;
            else return i;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s;
        s=scanner.next();
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        System.out.println(getMinNumber(chars));
    }
}
