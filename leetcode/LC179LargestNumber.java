import java.util.Arrays;
import java.util.Comparator;

/**
 * @author pengsong
 * @date 17/12/19 上午8:39
 */
/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */

/*
重要的是找到两个数字的比较方法，将两个数字连起来，
 */
public class LC179LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0)return "";
        String[] strs=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=nums[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }
        });
        String res="";
        for(int i=0;i<strs.length;i++){
            res+=strs[i];
        }
        while (res.length()>=2&&res.charAt(0)=='0')res=res.substring(1);//主要是防止00出现的情况
        return res;
    }
}
