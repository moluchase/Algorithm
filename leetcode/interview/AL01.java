package interview;

import java.util.ArrayList;

/**
 * @author pengsong
 * @date 18/3/22 下午10:02
 */
public class AL01 {
    static int minValue=Integer.MAX_VALUE;
    public static int addAllNumber(ArrayList<Integer> res){
        int sum=0;
        for(int i=0;i<res.size()-1;i+=2){
            sum+=res.get(i)+res.get(i+1);
        }
        return sum;
    }
    public static void getMinMUL(ArrayList<Integer> res,int[]a,int[]b,int ai,int bi){
        if(ai==a.length||bi==b.length){
            if(ai==a.length){
                while (bi<b.length)res.add(b[bi]);
            }else{
                while (ai<a.length)res.add(a[ai]);
            }
            int val=addAllNumber(res);
            if(val<minValue)minValue=val;
        }else {
            res.add(a[ai]);
            getMinMUL(res, a, b, ai + 1, bi);
            res.remove(res.size() - 1);
            res.add(b[bi]);
            getMinMUL(res, a, b, ai, bi + 1);
            res.remove(res.size() - 1);
        }

    }
    public static void main(String[] args) {

    }
}
