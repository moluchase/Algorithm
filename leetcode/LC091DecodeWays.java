/**
 * @author pengsong
 * @date 17/11/8 上午9:04
 */

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */

/*
dfs，一次选择一个或者两个
当然dfs肯定是通过不leetcode的，因为会重复计算，需要用dp

最后发现忘记考虑0的情况了,题目出的不好
100 返回0
001 返回0
 */

public class LC091DecodeWays {
    //dfs,会有重复，超时
    public static int numDecodings(String s) {
        if(s==null||s.length()==0||Integer.parseInt(s.substring(0))==0)return 0;
        if(s.length()==1) return 1;
        if(s.length()==2){
            if(Integer.parseInt(s)<=26&&Integer.parseInt(s.substring(1))>0)return 2;
            else return 1;
        }
        if(Integer.parseInt(s.substring(0,2))<=26){
            return numDecodings(s.substring(1))+numDecodings(s.substring(2));
        }else {
            return numDecodings(s.substring(1));
        }
    }

    /*
    dp
    a[1]=1
    a[2]=2 if s<=26 else 1
    a[k]=a[k-1]+a[k-2] if s.substring(0,2)<=26 else a[k-1]
     */
    public static int numDecodingsDP(String s) {
        if(s==null||s.length()==0)return 0;
        int n=s.length();
        int []a=new int[n];
        a[n-1]=s.charAt(n-1)!='0'?1:0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0')a[i]=0;
            else if(s.substring(i).length()==2){
                if(Integer.parseInt(s)<=26&&s.charAt(1)>'0')a[i]=2;
                else a[i]=1;
            }
            else {
                if(Integer.parseInt(s.substring(i,i+2))<=26)a[i]=a[i+1]+a[i+2];
                else a[i]=a[i+1];
            }
        }
        return a[0];
    }

    //这道题也是醉了，上面的方法和下面基本一样，就在for循环中多了个else判断，没有合并，就报超时
    public static int numDecodingsDP2(String s) {
        if(s==null||s.length()==0)return 0;
        int n=s.length();
        int []a=new int[n+1];
        a[n]=1;
        a[n-1]=s.charAt(n-1)!='0'?1:0;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='0')continue;
            else {
                if(Integer.parseInt(s.substring(i,i+2))<=26)a[i]=a[i+1]+a[i+2];
                else a[i]=a[i+1];
            }
        }
        return a[0];
    }


    public static void main(String[] args) {
        System.out.println(numDecodingsDP("20"));
    }
}
