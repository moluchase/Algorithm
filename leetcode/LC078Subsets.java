import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/10/22 下午11:22
 */

/*
077.Subsets
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

/*
和77题一样
这种类型的题目和子串问题也比较像
 */
public class LC078Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            subsetsDfs(lists,list,nums,i,0);
        }
        return lists;
    }

    private void subsetsDfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int k, int i) {
        if(list.size()==k)lists.add(new ArrayList<>(list));
        else {
            for(int j=i;j<nums.length;j++){
                list.add(nums[j]);
                subsetsDfs(lists,list,nums,k,j+1);
                list.remove(list.size()-1);
            }
        }
    }
}
