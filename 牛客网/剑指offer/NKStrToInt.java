public class NKStrToInt {
    public static int StrToInt(String str) {
        int index=0;
        int flag=0;
        int sum=0;
        while (index<str.length()){
            if(index==0&&(str.charAt(index)=='-'||str.charAt(index)=='+')){
                if(str.charAt(index)=='-'){
                    flag=1;
                }
                index++;
            }else {
                if(!(str.charAt(index)>='0'&&str.charAt(index)<='9')){
                    break;
                }
                sum*=10;
                sum+=str.charAt(index)-'0';
                index++;
            }

        }
        if(index<str.length()) return 0;
        return flag==1?-sum:sum;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("+"));
    }
}
