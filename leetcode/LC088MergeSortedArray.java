/**
 * @author pengsong
 * @date 17/11/4 下午4:16
 */

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
/*
满足空间复杂度为O(1)，且时间复杂度尽可能的低
每次比较nums1的第i个元素和nums2的第0个元素，如果nums1的第i个元素大于nums2的第0个元素，则将nums2的第0个元素替换nums1的第i个元素，
而nums1的第i个元素则插到nums2的数组中
 */
/*
测试样例：
[1,8,15,20,0,0,0,0]
4
[1,3,20,39]
4
 */
public class LC088MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null||n==0)return;
        for(int i=0;i<m;i++){
            if(nums2[0]<nums1[i]){
                int temp=nums1[i];
                nums1[i]=nums2[0];
                int k=1;
                while (k<n&&temp>nums2[k])nums2[k-1]=nums2[k++];
                nums2[k-1]=temp;
            }
        }
        for(int j=0;j<n;j++)nums1[m+j]=nums2[j];
    }

    public static void main(String[] args) {
        merge(new int[]{1,9,20},3,new int[]{-1,0,15},3);
    }
}
