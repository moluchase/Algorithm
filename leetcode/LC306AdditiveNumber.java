import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 18/1/10 上午9:15
 */
/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?

Credits:
Special thanks to @jeantimex for adding this problem and creating all test cases.
 */
/*
怪不得那么多人点反对呢，条件可真多...
 */
public class LC306AdditiveNumber {
    static boolean flag=false;
    public static boolean isAdditiveNumber(String num) {
        List<Long> list=new ArrayList<>();
        helper(list,num);
        return flag;
    }

    private static void helper(List<Long> list, String num) {
        if(num.equals("")&&list.size()>2){
            for(long temp:list) System.out.print(temp+",");
            System.out.println();
            flag=true;
        }
        else {
            for(int i=0;i<num.length()&&flag==false&&i<10;i++){
                if(num.charAt(0)=='0'){
                    if(list.size()<2||list.get(list.size()-1)+list.get(list.size()-2)==0){
                        list.add(new Long(0));
                        helper(list,num.substring(i+1));
                        list.remove(list.size()-1);
                    }
                    break;
                } else if(list.size()<2){
                    list.add(Long.parseLong(num.substring(0,i+1)));
                    helper(list,num.substring(i+1));
                    list.remove(list.size()-1);
                }else {
                    long temp=Long.parseLong(num.substring(0,i+1));
                    if(temp==list.get(list.size()-1)+list.get(list.size()-2)){
                        list.add(temp);
                        helper(list,num.substring(i+1));
                        list.remove(list.size()-1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("000000"));
    }
}
