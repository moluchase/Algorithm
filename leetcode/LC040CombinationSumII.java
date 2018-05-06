import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengsong
 * @date 18/3/11 下午4:17
 */
/*
这个要注意重复元素的处理
 */
public class LC040CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> arr=new ArrayList<>();
        getList(list,arr,candidates,0,0,target);
        return list;
    }
    public static void getList(List<List<Integer>> list, List<Integer> arr, int[] candidates, int cur, int i, int target){
        if(cur==target){
            list.add(new ArrayList<Integer>(arr));
        }else if(cur<target){
            for(int j=i;j<candidates.length&&cur+candidates[j]<=target;j++){
                if(j>i&&candidates[j]==candidates[j-1])continue;//这句话很经典
                arr.add(candidates[j]);
                getList(list,arr,candidates,cur+candidates[j],j+1,target);
                arr.remove(arr.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        //combinationSum2(new int[]{10,1,2,7,6,1,5},8);
        System.out.println('1'-'0');
    }
}
