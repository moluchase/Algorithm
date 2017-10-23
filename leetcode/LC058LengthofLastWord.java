public class LC058LengthofLastWord {
    /*
    找出最后一个单词的长度，其中如果最后一个为空格，返回空格前面一个单词的长度
    比如
    "123 " 返回3
    "12 3456" 返回4
    " " 返回0
    "" 返回0
    我下面用的方法是通过查找下一个空格，直到找不到空格，返回前一个空格的下标
     */
    public static int lengthOfLastWord(String s) {
        int pre=0,pre2=0;
        s=s.trim();
        while ((pre=s.indexOf(" ",pre)+1)>0)pre2=pre;
        if(pre2<=0)pre2=0;
        return s.substring(pre2,s.length()).length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("123 "));
    }
}
