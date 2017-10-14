import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//重复数的全排列重点在于相同的元素，组合后顺序不能乱，即第一个1必须在第二个1的前面，如果前面没有第一个1，后面的1不能添加
public class LCpermutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        if(nums==null||nums.length==0) return lists;//如果为空，返回
        boolean []used=new boolean[nums.length];//用来判断元素是否已近使用
        List<Integer> arr=new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,lists,arr,used);
        return lists;
    }

    private static void dfs(int[] nums, List<List<Integer>> lists, List<Integer> arr, boolean[] used) {
        if(nums.length==arr.size()){
            lists.add(new ArrayList<>(arr));//如果长度已近达到了，则将其添加
        }else {
            for(int i=0;i<nums.length;i++){
                if(used[i])continue;//表示已经选过了
                if(i>0&&nums[i-1]==nums[i]&&!used[i-1])continue;//如果该元素前面的元素与之相等，且前面的元素没有被选取，则不能选取该元素
                used[i]=true;
                arr.add(nums[i]);
                dfs(nums,lists,arr,used);//前两行和后两行对称，保证遍历时一样
                used[i]=false;
                arr.remove(arr.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        permuteUnique(new int[]{1,2,3,4});
    }
}
