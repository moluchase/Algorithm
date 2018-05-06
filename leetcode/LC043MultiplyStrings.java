/**
 * @author pengsong
 * @date 18/3/12 上午9:40
 */
public class LC043MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))return "0";
        String res="";
        int b=0;
        for(int i=num1.length()-1;i>=0;i--){
            res=add(res,mul(num2,num1.charAt(i),b));
            b++;
        }
        return res;
    }
    public static String mul(String s1,char c,int b){
        int flag=0;
        String res="";
        for(int i=s1.length()-1;i>=0;i--){
            int a=(s1.charAt(i)-'0')*(c-'0')+flag;
            res=((char)(a%10+'0'))+res;
            flag=a/10;
        }
        if(flag!=0)res=(char)(flag+'0')+res;
        for(int i=0;i<b;i++)res+='0';
        return res;
    }
    public static String add(String s1,String s2){
        int flag=0;
        String res="";
        for(int i=s1.length()-1,j=s2.length()-1;i>=0||j>=0;i--,j--){
            int a=((i>=0?s1.charAt(i):'0')-'0')+((j>=0?s2.charAt(j):'0')-'0')+flag;
            res=(char)(a%10+'0')+res;
            flag=a/10;
        }
        if(flag!=0)res=(char)(flag+'0')+res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(multiply("232","200"));
    }
}
