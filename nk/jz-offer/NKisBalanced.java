public class NKisBalanced {
    /*
    平衡二叉树满足一下性质：
    （一棵空树）或（它的左右两个子树高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树）
    平衡二叉树一定是二叉搜索数
     */
    //避免重复的方法是：在外面定义一个boolean类型，在求解高度中比较来判断boolean的值；或者是使用-1来判断是否是平衡树

    Boolean isBalan=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        TreeDepth(root);
        return isBalan;
    }

    private int TreeDepth(TreeNode node) {
        if(node==null) return 0;
        int len1=TreeDepth(node.right)+1;
        int len2=TreeDepth(node.left)+1;

        //判断是否满足左右子树深度差小于等于1
        if(Math.abs(len1-len2)>1)isBalan=false;

        /*
        //判断该节点为根节点下的树是否满足二叉搜索树
        if(node.left!=null&&node.right!=null){
            if(!(node.val>node.left.val)&&(node.val<node.right.val)) isBalan=false;
        }else if(node.left!=null){
            if(!(node.val>node.left.val)) isBalan=false;
        }else if(node.right!=null){
            if(!(node.right.val>node.val)) isBalan=false;
        }
        */

        return len1>len2?len1:len2;
    }
}
