/**
 * @author pengsong
 * @date 18/4/4 下午4:49
 */
public class LC031NextPermutation {

    public static void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void reOrder(int[]nums,int i,int j){
        for(int k=i;k<(i+j+1)/2;k++)swap(nums,k,j-k+i);
    }
    public static void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1)return;
        int i=nums.length-2,j;
        while (i>=0&&nums[i]>=nums[i+1])i--;
        if(i==-1){
            reOrder(nums,0,nums.length-1);
            return;
        }
        reOrder(nums,i+1,nums.length-1);
        for(int m=0;m<nums.length;m++) System.out.print(nums[m]+",");
        System.out.println();
        j=i+1;
        while(nums[i]>=nums[j])j++;
        swap(nums,i,j);
        for(int m=0;m<nums.length;m++) System.out.print(nums[m]+",");
        System.out.println();
    }

    public static void main(String[] args) {
        //nextPermutation(new int[]{5,4,7,5,3,2});
        int [] nums=new int[]{7,5,3,2};
        reOrder(nums,0,nums.length-1);
        for(int m=0;m<nums.length;m++) System.out.print(nums[m]+",");
        System.out.println();
    }
}
