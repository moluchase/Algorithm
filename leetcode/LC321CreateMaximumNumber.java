import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pengsong
 * @date 18/1/20 上午9:17
 */
/*
Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]
 */
/*
wait...
问题的本质是如何对一个数组按顺序选取k个数，使得这k个数组成的数字最大，好像在哪里见到过
 */
public class LC321CreateMaximumNumber {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1=nums1.length,n2=nums2.length;
        int []res=new int[k];
        for(int i=Math.max(k-n2,0);i<=n1&&i<=k;i++){
            System.out.println("i="+i+",n1="+n1);
            int[] ans=merge(maxNumber(nums1,i),maxNumber(nums2,k-i),k);
            if(greater(res,ans))res=ans;
        }
        return res;
    }

    private static boolean greater(int[] res, int[] ans) {
        for(int i=0;i<res.length;i++){
            if(res[i]==ans[i])continue;
            else if(res[i]>ans[i])return false;
            else return true;
        }
        return false;
    }

    private static int[] merge(int[] nums1, int[] nums2,int k) {
        int[] res=new int[k];
        int i=0,j=0,q=0;
        System.out.println("nums1="+nums1.length+",nums2="+nums2.length+",k="+k);
        for(;i<nums1.length&&j<nums2.length;q++){
            if(nums1[i]>nums2[j]) res[q]=nums1[i++];
            else if(nums1[i]<nums2[j]) res[q]=nums2[j++];
            else {
                int temp1=i,temp2=j;
                while (temp1<nums1.length&&temp2<nums2.length&&nums1[temp1]==nums2[temp2]){temp1++;temp2++;};
                if(temp2==nums2.length||nums1[--temp1]>nums2[--temp2])res[q]=nums1[++i];
                else res[q]=nums2[j++];
            }
        }
        if(j==nums2.length)while (i<nums1.length)res[q++]=nums1[i++];
        else while (j<nums2.length)res[q++]=nums2[j++];
        for(int ii=0;ii<res.length;ii++) System.out.print(res[ii]+",");
        System.out.println(",------");
        return res;
    }

    private static int[] merge2(int[] nums1, int[] nums2,int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater2(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    private static boolean greater2(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    //核心是这个程序
    private static int[] maxNumber(int[] nums, int k) {
        int n=nums.length;
        int j=0;
        int []res=new int[k];
        for(int i=0;i<n;i++){
            while (n-i+j>k&&j>0&&nums[i]>res[j-1])j--;
            if(j<k)res[j++]=nums[i];
        }
        //for(int i=0;i<res.length;i++) System.out.print(res[i]+",");
        //System.out.println();
        return res;
    }

    public static void main(String[] args) {
        int[]res=maxNumber(new int[]{2,8,0,4,5,1,4,8,9,9,0,8,2,9},new int[]{5,9,6,6,4,1,0,7},22);
        for(int i=0;i<res.length;i++) System.out.print(res[i]+",");
    }
}
