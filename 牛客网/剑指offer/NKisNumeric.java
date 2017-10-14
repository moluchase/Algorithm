public class NKisNumeric {
    //e或E后面不能是小数
    //-.123满足条件
    //.不能出现多次，按上面的说法只能出现一次
    public static boolean isNumeric(char[] str) {
        int flag=0;
        for(int i=0;i<str.length;){
            if(i==0&&(str[i]=='-'||str[i]=='+')){
                i++;
            }else if(str[i]>='0'&&str[i]<='9'){
                i++;
            }else if(str[i]=='.'){
                if(i<str.length-1&&str[i+1]>='0'&&str[i+1]<='9'&&flag<1){
                    i++;
                    flag+=1;
                }else return false;
            } else if(str[i]=='e'||str[i]=='E'){
                if(i+1>=str.length)return false;
                i++;
                if(str[i]=='-'||str[i]=='+')i++;
                while (i<str.length&&((str[i]>='0'&&str[i]<='9')))i++;
                if(i==str.length&&str[i-1]>='0'&&str[i-1]<='9')return true;
                return false;
            }else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("-1.12.3".toCharArray()));
        //System.out.println('a'>='0'&&'a'<='9');
    }
}
