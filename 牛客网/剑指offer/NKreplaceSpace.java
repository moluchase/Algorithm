public class NKreplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int i=0;
        while(i<str.length()){
            if(str.charAt(i)==' '){
                str.deleteCharAt(i);
                str.insert(i,"%20");
                i+=3;
            }else{
                i++;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer("sdsdsdsdsd");
        replaceSpace(stringBuffer);
    }
}
