/**
 * @author pengsong
 * @date 17/10/19 上午11:14
 */

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

/*
这种类型的题，看起来都是O(n^2)可以轻松解决，但是题往往要求O(n)来解决
通常就是用两个指针来满足条件，一个指针遍历

用一个数组当字典将字符串t映射，然后用另外一个字典来记录字符串s
先找到一个满足条件的窗口，当刚好右边满足时，对前面进行删除，直到不能删除，此时为一个满足条件的窗口
这个窗口中的最前面的字符和最后面的字符都一定在字符串t中，我们现在删除最前面的字符，这样就不满足条件了，继续遍历，重复
找到全部满足条件的窗口，比较，将最小的窗口的start和end记录下来

详细参见https://segmentfault.com/a/1190000003707313

 */

public class LC076MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] sMap=new int[256];
        int[] tMap=new int[256];
        int index,start,end;
        int j,count;
        for(int i=0;i<t.length();i++){
            if(tMap[t.charAt(i)]==0)tMap[t.charAt(i)]=1;
            else tMap[t.charAt(i)]++;
        }
        j=count=0;
        index=0;
        start=-1;
        end=s.length()-1;
        while (j<s.length()){
            sMap[s.charAt(j)]++;
            if(sMap[s.charAt(j)]<=tMap[s.charAt(j)])count++;
            if(count==t.length()){
                while (index<=j&&sMap[s.charAt(index)]>tMap[s.charAt(index)]){
                    sMap[s.charAt(index)]--;
                    index++;
                }
                if(j-index<end-start){
                    start=index;
                    end=j;
                }
                sMap[s.charAt(index)]--;
                index++;
                count--;
            }
            j++;
        }
        return start==-1?"":s.substring(start,end+1);
    }
}
