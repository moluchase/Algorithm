import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengsong
 * @date 18/1/15 上午8:59
 */
/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
 */
public class LC315CountofSmallerNumbersAfterSelf {
    class BSTNode{
        int lSum,dup=1,val;//java中不能在全局变量中赋值
        BSTNode left,right;
        public BSTNode(int lSum,int val){
            this.lSum=lSum;
            this.val=val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer res[]=new Integer[nums.length];
        BSTNode root=null;//=new BSTNode(0,1);
        for(int i=nums.length-1;i>=0;i--){
            root=insert(root,nums[i],res,i,0);
        }
        return Arrays.asList(res);//对象数组转list
    }

    private BSTNode insert(BSTNode root, int num, Integer[] res, int i, int preSum) {
        if(root==null){
            root=new BSTNode(0,num);
            res[i]=preSum;
        }else if(root.val==num){
            root.dup++;
            res[i]=preSum+root.lSum;
        }else if(root.val<num){
            root.right=insert(root.right,num,res,i,preSum+root.lSum+root.dup);
        }else {
            root.lSum++;
            root.left=insert(root.left,num,res,i,preSum);
        }
        return root;
    }
}
