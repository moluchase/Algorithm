public class NKmatch {
    public static boolean match(char[] str, char[] pattern) {
        if(str.length==0&&pattern.length==0)return true;
        if(pattern.length==0)return false;
        if(str.length==0){
            if(pattern.length>=2&&pattern[1]=='*')return match(str,new String(pattern).substring(2).toCharArray());
            return false;
        }else {
            if(pattern.length==1){
                if(!(str[0]==pattern[0]||pattern[0]=='.')) return false;
                if(str.length==1)return true;
                return false;
            }else {
                if(pattern[1]!='*'){
                    if(!(str[0]==pattern[0]||pattern[0]=='.'))return false;
                    return match(new String(str).substring(1).toCharArray(),new String(pattern).substring(1).toCharArray());
                }else {
                    if(!(str[0]==pattern[0]||pattern[0]=='.'))return match(str,new String(pattern).substring(2).toCharArray());
                    return match(str,new String(pattern).substring(2).toCharArray())||
                            match(new String(str).substring(1).toCharArray(),pattern);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s="abcdefg";
        System.out.println(match("aaa".toCharArray(),"a".toCharArray()));
        //System.out.println(s.substring(0,0).toCharArray().length);
        //System.out.println(new String("aaa").matches("aaa"));

    }
}
