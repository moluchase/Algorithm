
/*重建二叉树*/
//Definition for binary tree

import apple.laf.JRSUIUtils;

//二叉树结构
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class NKcjecs {

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
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
        root.right=reConstructBinaryTree2(pre,in,i+1,in.length-1,i+1);
        return root;
    }

    private static TreeNode reConstructBinaryTree2(int[] pre, int[] in, int start,int end,int index) {
        int i=start-1;
        TreeNode node;
        if(end-start>=0){
            node=new TreeNode(pre[index]);
        }else {
            return null;
        }
        //System.out.println(i);
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

    public static void printEndTree(TreeNode root){
        if(root!=null){
            printEndTree(root.left);
            printEndTree(root.right);
            System.out.print(root.val);
        }
    }

    public static void printStartTree(TreeNode root){
        System.out.print(root.val);
        printStartTree(root.left);
        printStartTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root;
        root=reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        printEndTree(root);
    }
}
