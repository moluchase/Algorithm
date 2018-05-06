package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/23 上午11:15
 */
public class MT02a {
    //返回有k+1个i组成的数字
    public static int getNum(int i,int k){
        String si=String.valueOf(i);
        String res="";
        for(int j=0;j<k;j++){
            res+=si;
        }
        return Integer.parseInt(res+si);
    }

    public static int getMinNumber(char[]chars){
        int [] nums=new int[10];//统计各个数字出现的次数
        for(int i=0;i<chars.length;i++){
            nums[chars[i]-'0']++;
        }
        int i=1;
        int k=0;
        while(true){
            if(i==10){
                i=0;
                k++;
            }
            nums[i]--;
            if(nums[i]<0)return getNum(i,k);
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s;
        while (true){
            s=scanner.next();
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            System.out.println(getMinNumber(chars));}
    }
}
