import java.util.ArrayList;
import java.util.Arrays;

public class NKpermutation {

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> arr=new ArrayList<>();
        if(str.length()==0) return arr;
        if(str.length()==1){
            arr.add(str);
            return arr;
        }
        //排序
        char[]chars=str.toCharArray();
        Arrays.sort(chars);
        str=String.valueOf(chars);
        //反转字符串，作为边界条件
        StringBuffer stringBuffer=new StringBuffer(str);
        String str2=stringBuffer.reverse().toString();
        arr.add(str);//添加第一个字典序
        while (!(str.equals(str2))){
            str=NextDictOrder(str);
            arr.add(str);
        }

        return arr;
    }

    private static String NextDictOrder(String str) {
        int i=str.length()-2;
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
        String s="123";
        String s1="123";

        ArrayList<String> arrs=Permutation(s);
        for(int i=0;i<arrs.size();i++){
            System.out.println(arrs.get(i));
        }
        //System.out.println(s1!=s);
        //System.out.println(s.substring(s.length(),s.length())+"sdsdsd");
    }
}
