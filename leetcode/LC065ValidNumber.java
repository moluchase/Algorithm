public class LC065ValidNumber {
    /*
    错误案例：
    "e6" false
    " " false
    ".1" true
    "01" true
    "3." true
    "." false
    "2e0" true
    ".1." false
    "-1." true
    "+.8" true
    "-." false
    "46.e3" true
    ".e1" false
    "6e6.5" false
    "-e58" false
    "92e17440e91" false
    "005047e+6" true
    "56e+" true
     */
    public static boolean isNumber(String s) {
        int i=0;
        int flag=0;
        int flag2=0;
        int flag3=0;
        s=s.trim();
        if(s.length()==0)return false;
        while (i<s.length()){
            char c=s.charAt(i);
            if(c>='0'&&c<='9')i++;
            else if((i==0||(i>0&&s.charAt(i-1)=='e'))&&(c=='-'||c=='+')&&i+1<s.length()) {i++;flag2=1;}
            else if(c=='e'&&flag3==0&&i-flag-flag2>0&&i+1<s.length()){i+=1;flag3=1;}
            else if(c=='.'&&flag==0&&flag3==0&&((i+1==s.length()&&(i-flag2>0))||(i+1<s.length()))){i+=1;flag=1;}
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("005047e+6"));
    }
}
