import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengsong
 * @date 18/3/11 下午3:12
 */
public class LC039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        List<Integer> arr=new ArrayList<>();
        Arrays.sort(candidates);
        getList(list,candidates,arr,0,0,target);
        return list;
    }
    public void getList(List<List<Integer>> list, int[] candidates, List<Integer> arr, int curr, int i, int target){
        if(curr==target){
            list.add(new ArrayList<Integer>(arr));
        }else{
            if(curr<target){
                for(int j=i;j<candidates.length&&curr+candidates[j]<=target;j++){
                    arr.add(candidates[j]);
                    getList(list,candidates,arr,curr+candidates[j],j,target);
                    arr.remove(arr.size()-1);
                }
            }
        }
    }
}
