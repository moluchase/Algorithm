public class NKisSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;
        return isSy2(pRoot.left,pRoot.right);
    }

    private boolean isSy2(TreeNode left, TreeNode right) {
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val!=right.val)return false;
        return isSy2(left.left,right.right)&&isSy2(left.right,right.left);
    }
}
