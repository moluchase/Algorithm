import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author pengsong
 * @date 17/12/28 上午9:25
 */
/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 */

/*
这种类型的题目太常见了，结构都是固定的，dfs里面套for循环+出口语句
而且这道题比想象的还要简单
 */
public class LC216CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        dfs(lists,list,0,0,k,n);
        return lists;
    }

    private static void dfs(List<List<Integer>> lists, ArrayList<Integer> list, int sum, int num,int k, int n) {
        if(sum==n&&num==k)lists.add(new ArrayList<>(list));
        else if(sum<n&&num<k){
            for(int i=list.size()==0?1:list.get(list.size()-1)+1;i<=9;i++){
                list.add(i);
                dfs(lists,list,sum+i,num+1,k,n);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum3(3,7);
    }
}
