import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengsong
 * @date 18/4/4 下午10:10
 */
public class LC015Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])continue;//去除重复情况
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                }else if(sum>0)k--;
                else j++;
                //去除重复情况
                while(j>i+1&&j<k&&nums[j]==nums[j-1])j++;
                while(k<nums.length-1&&j<k&&nums[k]==nums[k+1])k--;
            }
        }
        return list;
    }
}
