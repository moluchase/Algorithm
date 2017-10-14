public class NKLeftRotateString {
    public static String LeftRotateString(String str,int n) {
        if(str.length()==0)return "";
        n=n%str.length();
        str=str.substring(n,str.length())+str.substring(0,n);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef",3));
    }
}
