import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/12/21 上午8:24
 */
/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
/*
层次遍历的经典写法
 */
public class LC199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helper(list,root,1);
        return list;
    }

    private void helper(List<Integer> list, TreeNode root, int i) {
        if(root!=null){
            if(list.size()<i)list.add(root.val);
            helper(list,root.right,i+1);
            helper(list,root.left,i+1);
        }
    }
}
