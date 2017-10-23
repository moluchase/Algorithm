/**
 * @author pengsong
 * @date 17/10/23 上午9:26
 */

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
It doesn't matter what you leave beyond the new length.
 */


/*
这道题目实在是没啥意思
返回满足要求的长度，然后系统会输出数组中指定长度的元素进行测试
 */
public class LC080RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int num,index;
        num=0;
        index=0;
        for(int i=0;i<nums.length;i++){
            nums[num]=nums[i];
            if(i==0){
                num++;
                index++;
            }else {
                if(nums[num]!=nums[num-1]){
                    num++;
                    index=1;
                }else {
                    if(index<2){
                        index++;
                        num++;
                    }
                }
            }
        }
        return num;
    }
}
