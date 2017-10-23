import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/10/22 下午9:07
 */
/*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
/*
求组合的问题
 */
public class LC077Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combinedDfs(lists,list,n,k,1);
        return lists;
    }

    private void combinedDfs(List<List<Integer>> lists, List<Integer> list, int n, int k, int i) {
        if(list.size()==k)lists.add(new ArrayList<>(list));
        else {
            while (i<=n){
                list.add(i);
                combinedDfs(lists,list,n,k,i+1);
                list.remove(list.size()-1);
                i++;
            }
        }
    }
}
