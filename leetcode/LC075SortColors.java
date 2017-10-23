/**
 * @author pengsong
 * @date 17/10/19 上午10:48
 */
/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */

/*
这是计数排序，但是由于数字很少，这里只用遍历一遍即可
一个left指针，一个i指针，一个right指针
left从0开始，i从0开始，right从n-1开始
如果下标为i的元素等于0，与下标为left的元素交换，i++,left++
如果下标为i的元素等于1，i++
如果下标为i的元素等于2，与下标为right的元素交换，right--

参见http://www.cnblogs.com/ganganloveu/p/3703746.html
 */

public class LC075SortColors {
    public void sortColors(int[] nums) {
        int left,right;
        int i=0;
        int temp;
        left=0;
        right=nums.length-1;
        while (i<=right){
            if(nums[i]==0){
                temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                left++;
                i++;
            }
            else if(nums[i]==2){
                temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                right--;
            }else i++;
        }
    }
}
