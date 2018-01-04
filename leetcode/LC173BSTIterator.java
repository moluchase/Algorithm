import java.util.HashMap;
import java.util.Map;

/**
 * @author pengsong
 * @date 17/12/16 上午8:55
 */
/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */
/*
二叉搜索树的一大特点就是先序遍历为有序序列
 */
public class LC173BSTIterator {
    Map<Integer,Integer> map;
    int i=0;
    int index=0;
    public LC173BSTIterator(TreeNode root) {
        map=new HashMap<>();
        pushMap(map,root);
    }

    private void pushMap(Map<Integer, Integer> map, TreeNode node) {
        if(node!=null){
            pushMap(map,node.left);
            map.put(i,node.val);
            i++;
            pushMap(map,node.right);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index>=i)return false;
        else return true;
    }

    /** @return the next smallest number */
    public int next() {
        return map.get(index++);
    }
}
