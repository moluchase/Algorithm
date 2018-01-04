/**
 * @author pengsong
 * @date 18/1/3 上午8:19
 */
/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */
public class LC230KthSmallestElementinaBST {
    int num=0,value=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root!=null){
            kthSmallest(root.left,k);
            num++;
            if(num==k)value=root.val;
            kthSmallest(root.right,k);
        }
        return value;
    }
}
