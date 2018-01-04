/**
 * @author pengsong
 * @date 17/12/15 上午8:47
 */
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */
/*
超过半数，牛客网上见到过
 */
public class LC169MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        int res,num;
        res=nums[0];
        num=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=res){
                num--;
                if(num<=0){
                    res=nums[i];
                    num=1;
                }
            }else num++;
        }
        return res;
    }
}
