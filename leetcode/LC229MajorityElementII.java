import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/12/15 上午9:03
 */
/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
The algorithm should run in linear time and in O(1) space.
 */
/*
题目出的非常好，写的也非常好啊（哈哈）
 */
public class LC229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if(nums==null||nums.length==0)return list;
        int temp1,temp2,num1,num2;
        temp1=temp2=nums[0];
        num1=num2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==temp1)num1++;
            else if(nums[i]==temp2)num2++;
            else if(num1==0){
                temp1=nums[i];
                num1=1;
            }else if(num2==0){
                temp2=nums[i];
                num2=1;
            }else {
                num1--;
                num2--;
            }
        }
        num1=num2=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==temp1)num1++;
            else if(nums[i]==temp2)num2++;
        }
        if(num1>nums.length/3)list.add(temp1);
        if(num2>nums.length/3)list.add(temp2);
        return list;
    }
}
