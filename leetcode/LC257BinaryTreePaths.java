import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 18/1/4 上午9:42
 */
/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class LC257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        binaryTreePaths(list, root, "");
        return list;
    }

    private void binaryTreePaths(List<String> list, TreeNode node, String curr) {
        if (node == null) return;
        if (node.right == null && node.left == null) {
            list.add(curr.equals("") == true ? curr + node.val : curr + "->" + node.val);
        } else {
            binaryTreePaths(list, node.left, curr.equals("") == true ? curr + node.val : curr + "->" + node.val);
            binaryTreePaths(list, node.right, curr.equals("") == true ? curr + node.val : curr + "->" + node.val);
        }
    }
}
