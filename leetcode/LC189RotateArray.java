/**
 * @author pengsong
 * @date 17/12/20 上午8:39
 */
/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II
 */
/*
如果要是不浪费空间复杂度的话，就只能使用字符串了，不然交换就比较麻烦
 */
public class LC189RotateArray {
    /*
    这个方法竟然能够超时，。。。33/33 最后一个没通过
     */
    public static void rotate(int[] nums, int k) {
        if(k>=nums.length)k=k%nums.length;
        String temp1,temp2;
        temp1=temp2="";
        for(int i=0;i<nums.length-k;i++)temp1+=nums[i]+"#";
        for(int i=nums.length-k;i<nums.length;i++)temp2+=nums[i]+"#";
        if(temp1.length()==0)return;
        temp1=temp1.substring(0,temp1.length()-1);
        temp1=temp2+temp1;
        int i=0;
        for(String s:temp1.split("#")){
            nums[i]=Integer.parseInt(s);
            i++;
        }
    }
    /*
    这个倒是通过了，只是浪费了空间复杂度
     */
    public static void rotate2(int[] nums, int k) {
        k=k%nums.length;
        int []temp=new int[k];
        for(int i=nums.length-k,j=0;i<nums.length;i++,j++)temp[j]=nums[i];
        for(int i=nums.length-1;i-k>=0;i--)nums[i]=nums[i-k];
        for(int i=0;i<k;i++)nums[i]=temp[i];
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
