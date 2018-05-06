/**
 * @author pengsong
 * @date 18/3/11 下午2:18
 */
public class LC034Searchforarange {
    public static int[] searchRange(int[] nums, int target) {
        int left,mid,right;
        int [] res=new int[]{-1,-1};
        left=0;
        right=nums.length-1;
        while(left<right){
            mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                int temp=mid-1;
                while(temp>=0&&nums[temp]==nums[mid])temp--;
                res[0]=temp+1;
                temp=mid+1;
                while(temp<nums.length&&nums[temp]==nums[mid])temp++;
                res[1]=temp-1;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
