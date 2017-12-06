import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/14 下午11:14
 */

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

/*
201 / 202 test cases passed.
这是下面这个使用ArrayList的方法放到leetcode的结果，还是我刷牛客网的代码通过了
 */
public class LC105ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)return null;
        List<Integer> pre=new ArrayList<>();
        List<Integer> ino=new ArrayList<>();
        for(int i=0;i<preorder.length;i++)pre.add(preorder[i]);
        for(int i=0;i<inorder.length;i++)ino.add(inorder[i]);
        return buildTree(pre,ino);
    }

    private TreeNode buildTree(List<Integer> pre, List<Integer> ino) {
        if(pre.isEmpty())return null;
        int temp=pre.get(0);
        TreeNode node=new TreeNode(temp);
        List<Integer>preLeft=new ArrayList<>();
        List<Integer>preRight=new ArrayList<>();
        List<Integer>inoLeft=new ArrayList<>();
        List<Integer>inoRight=new ArrayList<>();
        int k=0;
        for(int i=0;i<ino.size();i++)if(ino.get(i)==temp)k=i;
        for(int i=0;i<k;i++){
            preLeft.add(pre.get(i+1));
            inoLeft.add(ino.get(i));
        }
        for(int i=k+1;i<ino.size();i++){
            preRight.add(pre.get(i));
            inoRight.add(ino.get(i));
        }
        node.left=buildTree(preLeft,inoLeft);
        node.right=buildTree(preRight,inoRight);
        return node;
    }

    /*
    public TreeNode buildTree(int[] pre, int[] in) {
        int i=-1;
        TreeNode root;
        if(pre.length>0){
            root=new TreeNode(pre[0]);
        }else {
            return null;
        }
        while(i<in.length-1){
            i++;
            if(in[i]==pre[0]) {
                break;
            }
        }
        root.left=reConstructBinaryTree2(pre,in,0,i-1,1);
        root.right=reConstructBinaryTree2(pre,in,i+1,in.length-1,i-0+1);
        return root;
    }
    public TreeNode reConstructBinaryTree2(int[] pre, int[] in, int start,int end,int index) {
        int i=start-1;
        TreeNode node;
        if(end-start>=0){
            node=new TreeNode(pre[index]);
        }else {
            return null;
        }
        while(i<end){
            i++;
            if(in[i]==pre[index]) {
                break;
            }
        }
        node.left=reConstructBinaryTree2(pre,in,start,i-1,index+1);
        node.right=reConstructBinaryTree2(pre,in,i+1,end,index+(i-start)+1);
        return node;
    }
     */
}
