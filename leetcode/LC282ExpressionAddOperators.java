import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 18/1/5 下午11:11
 */
/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples:
"123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */
/*
很常规的一道dfs的题目，不过用stringBuilder还是比较好的
记下来
 */
public class LC282ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> list=new ArrayList<>();
        if(num==null||num.length()==0)return list;
        helper(list,"",num,target,0,0,0);
        return list;
    }

    private static void helper(List<String> list, String path, String s,int target, int index, long value, long pre) {
        if(index==s.length()){
           // System.out.println(path);
            if(value==target){
                list.add(path);
                System.out.println(path);
            }
        }else {
            for (int i=index;i<s.length();i++){
                if(i!=index&&s.charAt(index)=='0')break;//不能出现数字第一个为0的情况
                long cur=Long.parseLong(s.substring(index,i+1));
                if(index==0){
                    helper(list,path+cur,s,target,i+1,cur,cur);//要记录出现*的时候，前一个数
                }else {
                    helper(list,path+"+"+cur,s,target,i+1,value+cur,cur);
                    helper(list,path+"-"+cur,s,target,i+1,value-cur,-cur);
                    helper(list,path+"*"+cur,s,target,i+1,value-pre+pre*cur,pre*cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        addOperators("123",6);
    }
}
