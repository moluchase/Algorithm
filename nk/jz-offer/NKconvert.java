public class NKconvert {
    /*
    二叉搜索树转排序的双向链表
    实质就是中序遍历，只是将中序遍历中打印部分修改位指针指向部分
     */

    TreeNode index=null;
    TreeNode head=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ZXBL(pRootOfTree);
        return head;
    }

    private void ZXBL(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ZXBL(pRootOfTree.left);
        if(head==null){
            head=pRootOfTree;
            index=pRootOfTree;
        }else {
            index.right=pRootOfTree;
            pRootOfTree.left=index;
            index=pRootOfTree;
        }
        ZXBL(pRootOfTree.right);
    }
}
