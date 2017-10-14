
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NKTreeLinkNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode p;
        if(pNode==null)return null;
        if(pNode.right!=null){
            p=pNode.right;
            while (p.left!=null)p=p.left;
            return p;
        }
        p=pNode;
        while (p.next!=null){
            if(p==p.next.left)return p.next;
            p=p.next;
        }
        return null;
    }
}
