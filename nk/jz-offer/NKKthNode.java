public class NKKthNode {
    int index=0;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode node=null;
        if(pRoot!=null){
            node=KthNode(pRoot.left,k);
            if(node!=null)return node;
            index++;
            if(index==k)return pRoot;
            node=KthNode(pRoot.right,k);
            if(node!=null)return node;
        }
        return node;
    }


}
