public class LC053MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int maxsum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>0){
                sum+=nums[i];
                if(maxsum<sum)maxsum=sum;
            }
            else sum=0;
        }
        int i=0;
        while (i<nums.length&&nums[i]<0)i++;
        if(i==nums.length){
            maxsum=nums[0];
            for(int j=1;j<nums.length;j++){
                if(nums[j]>maxsum)maxsum=nums[j];
            }
        }
        return maxsum;
    }
}
