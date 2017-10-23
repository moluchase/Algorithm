import java.util.Arrays;

public class LC060PermutationSequence {

    public static String getPermutation(int n, int k) {
        String s="";
        for (int i=1;i<=n;i++)s+=String.valueOf(i);
        if(k==1)return s;
        /*
        for(int i=2;i<k;i++){
            s=NextDictOrder(s);
        }
        return NextDictOrder(s);
        */
        return theKthString("",s,k);
    }

    /**
     *
     * @param s 要求字符串
     * @param s1 分解字符串
     * @param k 第k个字符串
     * @return
     */
    private static String theKthString(String s, String s1, int k) {
        if(k==1) return s+s1;//k=1表明不用再分解s1了
        int n1=Factorial(s1.length());//求s1长度的阶乘
        int n2=n1/s1.length();//求在s1中选取一个字符后，剩下的字符串的阶乘
        int num=0;
        //找出应该选择哪个字符添加到s后面
        for(int i=0;i<s1.length();i++){
            num=(i+1)*n2;
            if(num>=k){
                s+=s1.charAt(i);
                s1=s1.substring(0,i)+s1.substring(i+1,s1.length());
                return theKthString(s,s1,k-i*n2);
            }
        }
        return null;
    }

    //求阶乘
    private static int Factorial(int length) {
        if(length==1)return 1;
        return length*Factorial(length-1);
    }

    private static String NextDictOrder(String str) {
        int i=str.length()-2;//必须满足字符串长度大于1
        int j;
        char minChar=' ';//不可能为空
        int index=0;
        char[] chars;
        while (i>=0){
            if(str.charAt(i)<str.charAt(i+1)){
                j=i+1;
                minChar=str.charAt(j);
                index=j;
                while(j<str.length()){
                    if(str.charAt(j)>str.charAt(i)&&str.charAt(j)<minChar){
                        index=j;
                        minChar=str.charAt(j);
                    }
                    j++;
                }
                break;
            }
            i--;
        }
        chars=(str.substring(i,index)+str.substring(index+1,str.length())).toCharArray();
        Arrays.sort(chars);
        str=str.substring(0,i)+minChar+String.valueOf(chars);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(1,1));
    }
}
