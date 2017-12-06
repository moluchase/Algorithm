import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/4 下午10:08
 */

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
/*
77，78，90是同种类型的题目：dfs
这道题的区别在于对于重复元素的处理
先dfs，然后遇到重复元素就跳过，这个思路慢慢体会还是很好理解的
 */
public class LC090Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int k=1;k<=nums.length;k++){
            subsets2Dfs(lists,list,nums,k,0);
        }
        return lists;
    }

    private void subsets2Dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int k,int i) {
        if(list.size()==k) lists.add(new ArrayList<>(list));
        else {
            for(int j=i;j<nums.length;j++){
                list.add(nums[j]);
                subsets2Dfs(lists,list,nums,k,j+1);
                list.remove(list.size()-1);
                while (j<nums.length-1&&nums[j]==nums[j+1])j++;
            }
        }
    }
}
