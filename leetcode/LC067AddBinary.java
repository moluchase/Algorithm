public class LC067AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1","111"));
    }
    public static String addBinary(String a, String b) {
        String s="";
        int flag=0;
        int len1=a.length()-1;
        int len2=b.length()-1;
        while (len1>=0&&len2>=0){
            if(a.charAt(len1)=='1'&&b.charAt(len2)=='1'){
                if(flag==0)s='0'+s;
                else s='1'+s;
                flag=1;
            }else if(a.charAt(len1)=='0'&&b.charAt(len2)=='0'){
                if(flag==1){
                    s='1'+s;
                    flag=0;
                }else s='0'+s;
            }else{
                if(flag==1){
                    s='0'+s;
                }else {
                    s='1'+s;
                    flag=0;
                }
            }
            len1--;
            len2--;
        }
        if(len1>=0){
            while (len1>=0){
                if(a.charAt(len1)=='0'){
                    if(flag==0)s='0'+s;
                    else {
                        flag=0;
                        s='1'+s;
                    }
                }else {
                    if(flag==0)s='1'+s;
                    else {
                        flag=1;
                        s='0'+s;
                    }
                }
                len1--;
            }
        }
        if(len2>=0){
            while (len2>=0){
                if(b.charAt(len2)=='0'){
                    if(flag==0)s='0'+s;
                    else {
                        flag=0;
                        s='1'+s;
                    }
                }else {
                    if(flag==0)s='1'+s;
                    else {
                        flag=1;
                        s='0'+s;
                    }
                }
                len2--;
            }
        }
        if(flag==1)s='1'+s;
        return s;
    }
}
