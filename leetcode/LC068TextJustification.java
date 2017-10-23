import java.util.ArrayList;
import java.util.List;

public class LC068TextJustification {
    /*
    单词比maxWidth长度小
    最后一行比较特殊，每个单词之间空一个空格即可，将空格全部放到后面
    对最后一行的考虑，补充"#"
    对其他行中如果只有一个单词的处理，后面补" "
    提交错误：
    ""，2   ： "  "
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList<>();
        String temp=words[0];
        for(int i=1;i<words.length;i++){
            if(temp.length()+words[i].length()<maxWidth) temp+="#"+words[i];
            else {
                list.add(temp);
                temp=words[i];
            }
        }
        while (temp.length()<maxWidth)temp+="#";//最后一行补充#
        list.add(temp);
        for(int i=0;i<list.size();i++){
            temp=list.get(i);
            temp=i<list.size()-1?getJustif(temp,maxWidth):temp.replace("#"," ");
            list.remove(i);
            list.add(i,temp);
        }
        return list;
    }

    private static String getJustif(String temp, int maxWidth) {
        String[] strs=temp.split("#");
        if (strs.length==1){
            while (temp.length()<maxWidth)temp+=" ";
            return temp;
        }
        int spit=(maxWidth-(temp.length()-strs.length+1))/(strs.length-1);
        int last=(maxWidth-(temp.length()-strs.length+1))%(strs.length-1);
        int count;
        temp=strs[0];
        for(int i=1;i<strs.length;i++){
            if(last-->0)temp+=" ";
            count=spit;
            while (count-->0)temp+=" ";
            temp+=strs[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        List<String>list=fullJustify(new String[]{"to","a","few."},6);
        for(String s:list){
            System.out.println(s);
        }
    }
}
