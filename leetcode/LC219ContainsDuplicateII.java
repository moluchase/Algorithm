import java.util.HashSet;
import java.util.Set;

/**
 * @author pengsong
 * @date 17/12/29 上午9:34
 */
/*
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class LC219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k)set.remove(nums[i-k-1]);
            if(!set.add(nums[i]))return true;
        }
        return false;
    }
}
