/**
 * @author pengsong
 * @date 18/1/3 下午11:11
 */
/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
 */
public class LC238ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[]res=new int[nums.length];
        int temp=1;
        for(int i=0;i<nums.length;i++){
            res[i]=temp;
            temp*=nums[i];
        }
        System.out.println(res[0]+","+res[1]);
        temp=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=temp;
            temp*=nums[i];
        }
        System.out.println(res[0]+","+res[1]);
        return res;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{0,0});
    }
}
