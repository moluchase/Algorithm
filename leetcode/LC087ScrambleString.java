/**
 * @author pengsong
 * @date 17/10/31 下午8:16
 */

/*

Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

/*
题意就是对字符串分割，每一次分割都可以分为两部分，直到不能再分割，组成一棵二叉树，
其中二叉树的每个节点的左右子节点都可以交换，那么将其还原为字符串时，便可以产生新的字符串
问，给定s2是否为s1这样的新字符串？
显然dfs可解，不过超时，那么只能用DP解决了
 */
public class LC087ScrambleString {
    /*
    dfs
    分割字符串，相当于比较前半部分和后半部分是否满足要求，或者比较后半部分，前半部分是否匹配（交换）
     */
    public static boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))return true;//如果相等，返回true
        if(s1.length()==1)return false;//如果不相等，且长度为1，返回false
        boolean result=false;
        for(int i=1;i<s1.length();i++){
            result=isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i),s2.substring(i));
            if(result==true)return true;
            result=isScramble(s1.substring(i),s2.substring(0,s2.length()-i))&&isScramble(s1.substring(0,i),s2.substring(s2.length()-i));
            if(result==true)return true;
        }
        return result;
    }
    //DP
    /*
    找了半天，只找到了这个我感觉非常复杂的DP构造
    需要一个三维数组 dp[i][j][len]，表示从s1的第i个字符开始长度为len的子串，和从s2的第j个字符开始长度为len的子串，是否互为scramble。
    初始化为dp[i][j][1] = s1.charAt(i) == s2.charAt(j)，即长度为1的子串是否互为scramble。
    三维数组就要三层循环，最终结果为dp[0][0][s1.length()]，即从s1的第0个字符开始长度为s1.length()的子串，
    即s1本身和s2本身是否互为scramble。
    要判断dp[i][j][len]的值，就要把s1从i开始长度为len的串分别从k=1, 2 ... len-1处切开，
    判断切成的两半和s2同样切成的两半是否互为scramble，只要有一种切法满足条件，那么dp[i][j][len]就为true，否则为false。
    参考：http://blog.csdn.net/ljiabin/article/details/44537523
    http://blog.csdn.net/linhuanmars
     */
    public static boolean isScramble2(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        if(s1.equals(s2))return true;
        boolean[][][]dp=new boolean[s1.length()][s2.length()][s1.length()+1];
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                dp[i][j][1]=s1.charAt(i)==s2.charAt(j);
            }
        }
        for(int len=2;len<=s1.length();len++){
            for(int i=0;i<s1.length()-len+1;i++){
                for(int j=0;j<s2.length()-len+1;j++){
                    for(int k=1;k<len;k++){
                        dp[i][j][len]|=(dp[i][j][k]&&dp[i+k][j+k][len-k])||(dp[i][j+len-k][k]&&dp[i+k][j][len-k]);
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }

    /*
    这是leetcode上的一种解法，和我最前面的递归的区别在于，此处用了剪枝
    先判断是否s1有的元素，s2全有，而且s2有的元素，s1全有
    见：https://leetcode.com/problems/scramble-string/discuss/
     */
    public boolean isScramble3(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;

        for (int i=1; i<s1.length(); i++) {
            if (isScramble3(s1.substring(0,i), s2.substring(0,i))
                    && isScramble3(s1.substring(i), s2.substring(i))) return true;
            if (isScramble3(s1.substring(0,i), s2.substring(s2.length()-i))
                    && isScramble3(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great","taerg"));
        //System.out.println(false|true);
    }
}
