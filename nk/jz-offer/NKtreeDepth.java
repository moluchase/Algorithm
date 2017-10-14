public class NKtreeDepth {
    public int TreeDepth(TreeNode root) {
        return getTreeDepth(root,0);
    }

    private int getTreeDepth(TreeNode root, int i) {
        if(root==null)return i;
        int len1,len2;
        len1=getTreeDepth(root.left,i+1);
        len2=getTreeDepth(root.right,i+1);
        return len1>len2?len1:len2;
    }
    private int getTreeDepth(TreeNode node){
        if(node==null)return 0;
        int len1=getTreeDepth(node.left)+1;
        int len2=getTreeDepth(node.right)+1;
        return len1>len2?len1:len2;
    }
}
